package inventario;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Item;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class Celda.
 */
@SuppressWarnings("serial")
public class Celda extends JPanel {

    /**
     * The Constant ancho y altura.
     */
    private static final int ANCHOALTURA = 49;

    /**
     * The Constant DIMENSION.
     */
    private static final int DIMENSION = 60;

    /**
     * The item.
     */
    private BufferedImage item;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The label.
     */
    private JLabel label;

    /**
     * The it.
     */
    private Item it;

    /**
     * Instantiates a new celda.
     *
     * @param itemParam
     *            the item param
     * @param paquetePersonajeParam
     *            the paquete personaje param
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Celda(final Item itemParam,
            final PaquetePersonaje paquetePersonajeParam) throws IOException {
        this.item = itemParam.getFoto();
        it = itemParam;
        this.paquetePersonaje = paquetePersonajeParam;
        label = new JLabel(new ImageIcon(this.item.getScaledInstance(
                ANCHOALTURA, ANCHOALTURA, Image.SCALE_DEFAULT)));
        actionListenersYLabel(itemParam);
    }

    /**
     * Instantiates a new celda.
     */
    public Celda() {
        label = new JLabel(new ImageIcon(Recursos.noItem.getScaledInstance(
                ANCHOALTURA, ANCHOALTURA, Image.SCALE_DEFAULT)));
        add(label);
    }

    /**
     * Action listeners Y label.
     *
     * @param itemParam
     *            the item
     */
    private void actionListenersYLabel(final Item itemParam) {
        StringBuilder s = new StringBuilder();

        s.append("<html>" + itemParam.getNombre() + "<br>");

        if (itemParam.getBonusSalud() != 0) {
            s.append("+" + itemParam.getBonusSalud() + " Salud " + "<br>");
        }
        if (itemParam.getBonusEnergia() != 0) {
            s.append("+" + itemParam.getBonusEnergia() + " Energia " + "<br>");
        }
        if (itemParam.getBonusFuerza() != 0) {
            s.append("+" + itemParam.getBonusFuerza() + " Fuerza " + "<br>");
        }
        if (itemParam.getBonusDestreza() != 0) {
            s.append(
                    "+" + itemParam.getBonusDestreza() + " Destreza " + "<br>");
        }
        if (itemParam.getBonusInteligencia() != 0) {
            s.append("+" + itemParam.getBonusInteligencia() + " Inteligencia");
        }
        s.append("</html>");
        label.setToolTipText(s.toString());
        label.addMouseListener(mouseListener);
        addMouseListener(mouseListener);
        add(label);
        this.validate();
        this.repaint();
    }

    /**
     * Reset label.
     */
    protected void resetLabel() {
        label.setIcon(new ImageIcon(Recursos.noItem.getScaledInstance(
                ANCHOALTURA, ANCHOALTURA, Image.SCALE_DEFAULT)));
        label.setToolTipText(null);
        paquetePersonaje.removerItem(it);
        label.removeMouseListener(mouseListener);
        removeMouseListener(mouseListener);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#getPreferredSize()
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DIMENSION, DIMENSION);
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * The mouse listener.
     */
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(final MouseEvent e) {
            Object[] options = {"Tirar", "Cancelar" };
            if (e.getClickCount() == 2) {
                int answer = JOptionPane.showOptionDialog(getParent(),
                        "¿Qué desea hacer?", "Item: " + it.getNombre(),
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                // Tirar
                if (answer == 0) {
                    paquetePersonaje.sacarBonus(it.getBonusSalud(),
                            it.getBonusEnergia(), it.getBonusFuerza(),
                            it.getBonusDestreza(), it.getBonusInteligencia());
                    resetLabel();
                }
            }
        }
    };
}
