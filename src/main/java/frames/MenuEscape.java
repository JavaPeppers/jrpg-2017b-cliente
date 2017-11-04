package frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import cliente.Cliente;
import estados.Estado;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class MenuEscape.
 */
@SuppressWarnings("serial")
public class MenuEscape extends JFrame {

    /** marca el INDICE 3 del array de Contantes. */
    private static final int TRES = 3;

    /** The Constant BGN_ALTO. */
    private static final int BGN_ALTO = 273;

    /** The Constant BGN_ANCH. */
    private static final int BGN_ANCH = 186;

    /** The Constant IMG_ALTO. */
    private static final int IMG_ALTO = 350;

    /** The Constant IMG_ANCH. */
    private static final int IMG_ANCH = 200;

    /** The Constant BORDER. */
    private static final int BORDER = 5;

    /** The Constant EXIT. */
    private static final int[] EXIT = {100, 100, 180, 270 };

    /** The Constant VAR_STATS. */
    private static final int[] VAR_STATS = {29, 13, 125, 25 };

    /** The Constant BTN_AS_SKILL. */
    private static final int[] BTN_AS_SKILL = {29, 66, 125, 25 };

    /** The Constant BTN_INVENT. */
    private static final int[] BTN_INVENT = {29, 121, 125, 25 };

    /** The Constant BTN_DESC. */
    private static final int[] BTN_DESC = {29, 175, 125, 25 };

    /** The Constant BTN_VOLVER. */
    private static final int[] BTN_VOLVER = {29, 227, 125, 25 };
    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * Create the frame.
     *
     * @param cliente
     *            se recibe cliente.
     */
    public MenuEscape(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(EXIT[0], EXIT[1], EXIT[2], EXIT[TRES]);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton verStats = new JButton("Estadísticas");
        verStats.setIcon(new ImageIcon("recursos//stats.png"));
        verStats.setToolTipText("Presiona S para ver estadísticas");
        verStats.setBounds(VAR_STATS[0], VAR_STATS[1], VAR_STATS[2],
                VAR_STATS[TRES]);
        verStats.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Pantalla.getMenuStats() == null) {
                    Pantalla.setMenuStats(new MenuStats(cliente));
                    Pantalla.getMenuStats().setVisible(true);
                }
            }
        });
        contentPane.add(verStats);

        JButton asignarSkills = new JButton("Asignar Skills");
        asignarSkills.setIcon(new ImageIcon("recursos//asignar skills.png"));
        asignarSkills.setToolTipText("Presiona A para asignar skills");
        asignarSkills.setBounds(BTN_AS_SKILL[0], BTN_AS_SKILL[1],
                BTN_AS_SKILL[2], BTN_AS_SKILL[TRES]);
        asignarSkills.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Pantalla.getMenuAsignar() == null) {
                    Pantalla.setMenuAsignar(new MenuAsignarSkills(cliente));
                    Pantalla.getMenuAsignar().setVisible(true);
                }
            }
        });
        contentPane.add(asignarSkills);

        JButton inventario = new JButton("Inventario");
        inventario.setIcon(new ImageIcon("recursos//inventario.png"));
        inventario.setToolTipText("Presiona I para abrir inventario");
        inventario.setBounds(BTN_INVENT[0], BTN_INVENT[1], BTN_INVENT[2],
                BTN_INVENT[TRES]);
        inventario.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.setMenuEscp(null);
                if (Estado.getEstado().esEstadoDeJuego()) {
                    if (Pantalla.getMenuInventario() == null) {
                        Pantalla.setMenuInventario(new MenuInventario(cliente));
                        Pantalla.getMenuInventario().setVisible(true);
                    }
                }
            }
        });
        contentPane.add(inventario);

        JButton desconectarse = new JButton("Desconectarse");
        desconectarse.setBounds(BTN_DESC[0], BTN_DESC[1], BTN_DESC[2],
                BTN_DESC[TRES]);
        desconectarse.setIcon(new ImageIcon("recursos//desconectarse.png"));
        desconectarse.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    Paquete p = new Paquete();
                    p.setComando(Comando.DESCONECTAR);
                    p.setIp(cliente.getMiIp());
                    cliente.getSalida().writeObject(gson.toJson(p));
                    cliente.getEntrada().close();
                    cliente.getSalida().close();
                    cliente.getSocket().close();
                    System.exit(0);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error al desconectar");

                }
            }
        });
        contentPane.add(desconectarse);

        JButton volver = new JButton("Volver");
        volver.setIcon(new ImageIcon("recursos//volver.png"));
        volver.setBounds(BTN_VOLVER[0], BTN_VOLVER[1], BTN_VOLVER[2],
                BTN_VOLVER[TRES]);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                Pantalla.setMenuEscp(null);
                dispose();
            }
        });
        contentPane.add(volver);

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//fondo2.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }
        JLabel background = new JLabel(new ImageIcon(imagenFondo
                .getScaledInstance(IMG_ANCH, IMG_ALTO, Image.SCALE_DEFAULT)));
        background.setBounds(0, 0, BGN_ANCH, BGN_ALTO);
        contentPane.add(background);
    }
}
