package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import javax.swing.ImageIcon;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The Class MenuCarga.
 */
public class MenuCarga extends JFrame {

    /** The Constant ALTO_BARRA. */
    private static final int ALTO_BARRA = 27;

    /** The Constant LBL_BGD_ALTO. */
    private static final int LBL_BGD_ALTO = 271;

    /** The Constant LBL_BGD_ANC. */
    private static final int LBL_BGD_ANC = 444;

    /** The Constant LBL_LOGO_ALTO. */
    private static final int LBL_LOGO_ALTO = 90;

    /** The Constant LBL_LOGO_ANC. */
    private static final int LBL_LOGO_ANC = 216;

    /** The Constant LBL_LOGO_Y. */
    private static final int LBL_LOGO_Y = 39;

    /** The Constant LBL_LOGO_X. */
    private static final int LBL_LOGO_X = 109;

    /** The Constant LBL_LOAD_BAR_ALTO. */
    private static final int LBL_LOAD_BAR_ALTO = 40;

    /** The Constant LBL_LOAD_BAR_ANC. */
    private static final int LBL_LOAD_BAR_ANC = 355;

    /** The Constant LBL_LOAD_BAR_Y. */
    private static final int LBL_LOAD_BAR_Y = 154;

    /** The Constant LBL_LOAD_BAR_X. */
    private static final int LBL_LOAD_BAR_X = 47;

    /** The Constant LOAD_BAR_ALTO. */
    private static final int LOAD_BAR_ALTO = 27;

    /** The Constant LOAD_BAR_ANC. */
    private static final int LOAD_BAR_ANC = 0;

    /** The Constant LOAD_BAR_Y. */
    private static final int LOAD_BAR_Y = 160;

    /** The Constant LOAD_BAR_X. */
    private static final int LOAD_BAR_X = 52;

    /** The Constant ALTO_VENT_INI. */
    private static final int ALTO_VENT_INI = 300;

    /** The Constant ANC_VENT_INI. */
    private static final int ANC_VENT_INI = 450;

    /** The Constant VENT_INI_Y. */
    private static final int VENT_INI_Y = 100;

    /** The Constant VENT_INI_X. */
    private static final int VENT_INI_X = 100;

    /** The Constant BORDER. */
    private static final int BORDER = 5;

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The barra cargando.
     */
    private JLabel barraCargando;

    /**
     * Instantiates a new menu carga.
     *
     * @param cliente
     *            the cliente
     */
    public MenuCarga(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // En caso de cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                dispose();
            }
        });

        // Propiedades de la ventana
        setTitle("WOME - World Of the Middle Earth");
        setBounds(VENT_INI_X, VENT_INI_Y, ANC_VENT_INI, ALTO_VENT_INI);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        barraCargando = new JLabel("");
        barraCargando.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/Barra.png")));
        barraCargando.setBounds(LOAD_BAR_X, LOAD_BAR_Y, LOAD_BAR_ANC,
                LOAD_BAR_ALTO);
        contentPane.add(barraCargando);

        JLabel lblBarraCarga = new JLabel("");
        lblBarraCarga.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/BarraCarga.png")));
        lblBarraCarga.setBounds(LBL_LOAD_BAR_X, LBL_LOAD_BAR_Y,
                LBL_LOAD_BAR_ANC, LBL_LOAD_BAR_ALTO);
        contentPane.add(lblBarraCarga);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(
                new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        lblLogo.setBounds(LBL_LOGO_X, LBL_LOGO_Y, LBL_LOGO_ANC, LBL_LOGO_ALTO);
        contentPane.add(lblLogo);

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, 0, LBL_BGD_ANC, LBL_BGD_ALTO);
        contentPane.add(lblBackground);
        lblBackground.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Sets the barra cargando.
     *
     * @param ancho
     *            the new barra cargando
     */
    public void setBarraCargando(final int ancho) {
        barraCargando.setSize(ancho, ALTO_BARRA);
    }
}
