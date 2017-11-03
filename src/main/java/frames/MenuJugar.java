package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;

/**
 * The Class MenuJugar.
 */
public class MenuJugar extends JFrame {

    /** The Constant LBL_BGD_ALTO. */
    private static final int LBL_BGD_ALTO = 271;

    /** The Constant LBL_BGD_ANCH. */
    private static final int LBL_BGD_ANCH = 444;

    /** The Constant BTN_INISES_ALTO. */
    private static final int BTN_INISES_ALTO = 23;

    /** The Constant BTN_INISES_ANC. */
    private static final int BTN_INISES_ANC = 191;

    /** The Constant BTN_INISES_Y. */
    private static final int BTN_INISES_Y = 92;

    /** The Constant BTN_INISES_X. */
    private static final int BTN_INISES_X = 121;

    /** The Constant BTN_REG_ALTO. */
    private static final int BTN_REG_ALTO = 23;

    /** The Constant BTN_REG_ANCH. */
    private static final int BTN_REG_ANCH = 191;

    /** The Constant BTN_REG_Y. */
    private static final int BTN_REG_Y = 162;

    /** The Constant BTN_REG_X. */
    private static final int BTN_REG_X = 121;

    /** The Constant LBL_INISES_ALTO. */
    private static final int LBL_INISES_ALTO = 23;

    /** The Constant LBL_INISES_ANCH. */
    private static final int LBL_INISES_ANCH = 91;

    /** The Constant LBL_INISES_Y. */
    private static final int LBL_INISES_Y = 91;

    /** The Constant LBL_INISES_X. */
    private static final int LBL_INISES_X = 175;

    /** The Constant TAM_LET. */
    private static final int TAM_LET = 15;

    /** The Constant LBL_REG_ALTO. */
    private static final int LBL_REG_ALTO = 23;

    /** The Constant LBL_REG_ANCH. */
    private static final int LBL_REG_ANCH = 82;

    /** The Constant LBL_REG_Y. */
    private static final int LBL_REG_Y = 162;

    /** The Constant LBL_REG_X. */
    private static final int LBL_REG_X = 181;

    /** The Constant LYD_PANE_ALTO. */
    private static final int LYD_PANE_ALTO = 271;

    /** The Constant LYD_PANE_ANC. */
    private static final int LYD_PANE_ANC = 444;

    /** The Constant VENT_ALTO. */
    private static final int VENT_ALTO = 300;

    /** The Constant VENT_ANCH. */
    private static final int VENT_ANCH = 450;

    /** The Constant VENT_Y. */
    private static final int VENT_Y = 100;

    /** The Constant VENT_X. */
    private static final int VENT_X = 100;

    /** The Constant BORDER. */
    private static final int BORDER = 5;
    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * Instantiates a new menu jugar.
     *
     * @param cliente
     *            the cliente
     */
    public MenuJugar(final Cliente cliente) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    MenuInicioSesion menuInicioSesion = new MenuInicioSesion(
                            cliente);
                    menuInicioSesion.setVisible(true);
                    dispose();
                }
            }
        });
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
        setBounds(VENT_X, VENT_Y, VENT_ANCH, VENT_ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, LYD_PANE_ANC, LYD_PANE_ALTO);
        contentPane.add(layeredPane);

        // Boton Registrarse
        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setBounds(LBL_REG_X, LBL_REG_Y, LBL_REG_ANCH,
                LBL_REG_ALTO);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, TAM_LET));
        lblRegistrarse.setBackground(Color.WHITE);

        // Boton Iniciar sesion
        JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
        lblIniciarSesion.setBounds(LBL_INISES_X, LBL_INISES_Y, LBL_INISES_ANCH,
                LBL_INISES_ALTO);
        layeredPane.add(lblIniciarSesion, new Integer(2));
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, TAM_LET));

        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(BTN_REG_X, BTN_REG_Y, BTN_REG_ANCH,
                BTN_REG_ALTO);
        layeredPane.add(btnRegistrar, new Integer(1));
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuRegistro menuRegistro = new MenuRegistro(cliente);
                menuRegistro.setVisible(true);
                dispose();
            }
        });

        JButton btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setBounds(BTN_INISES_X, BTN_INISES_Y, BTN_INISES_ANC,
                BTN_INISES_ALTO);
        layeredPane.add(btnIniciarSesion, new Integer(1));
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuInicioSesion menuInicioSesion = new MenuInicioSesion(
                        cliente);
                menuInicioSesion.setVisible(true);
                dispose();
            }
        });

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, 0, LBL_BGD_ANCH, LBL_BGD_ALTO);
        lblBackground.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        layeredPane.add(lblBackground, new Integer(0));
    }
}
