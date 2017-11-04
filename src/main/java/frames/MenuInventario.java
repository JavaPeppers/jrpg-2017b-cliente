package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import cliente.Cliente;
import inventario.Inventario;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * The Class MenuInventario.
 */
@SuppressWarnings("serial")
public class MenuInventario extends JFrame {

    /** The Constant UBIC_Y. */
    private static final int UBIC_Y = 140;

    /** The Constant UBIC_X. */
    private static final int UBIC_X = 900;

    /** The Constant DIMENS_INVENT. */
    private static final int DIMENS_INVENT = 600;
    /**
     * The cancelar.
     */
    private JButton cancelar = new JButton("Exit");

    /**
     * Instantiates a new menu inventario.
     *
     * @param cliente
     *            the cliente
     */
    public MenuInventario(final Cliente cliente) {
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Gson gson = new Gson();
                    cliente.getPaquetePersonaje()
                            .setComando(Comando.ACTUALIZARINVENTARIO);
                    cliente.getSalida().writeObject(
                            gson.toJson(cliente.getPaquetePersonaje()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar inventario");
                }
                Pantalla.setMenuInventario(null);
                dispose();
            }
        });
        this.setTitle("Inventario");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            this.setLayout(new BorderLayout());
            this.add(new Inventario(cliente.getPaquetePersonaje()));
            this.add(cancelar, BorderLayout.AFTER_LAST_LINE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falló al iniciar el inventario");

        }
        this.setBounds(DIMENS_INVENT, DIMENS_INVENT, DIMENS_INVENT,
                DIMENS_INVENT);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLocation(UBIC_X, UBIC_Y);
        this.setResizable(false);
        this.setVisible(true);
    }
}
