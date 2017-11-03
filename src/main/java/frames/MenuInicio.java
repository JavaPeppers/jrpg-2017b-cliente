package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


// TODO: Auto-generated Javadoc
/**
 * The Class MenuInicio.
 */
public class MenuInicio extends JFrame {

	/** Indica la posicion 3 del array de constantes. */
	private static final int TRES = 3;

	/** The Constant LBL_BGN_ALTO. */
	private static final int LBL_BGN_ALTO = 271;

	/** The Constant LBL_BGN_ANCH. */
	private static final int LBL_BGN_ANCH = 444;

	/** The Constant TAM_LETRA. */
	private static final int TAM_LETRA = 15;

	/** The Constant LP_LOGO_ALTO. */
	private static final int LP_LOGO_ALTO = 271;

	/** The Constant LP_LOGO_ANCH. */
	private static final int LP_LOGO_ANCH = 444;

	/** The Constant BORDER. */
	private static final int BORDER = 5;

	/** The Constant VENT_INI. */
	private static final int[] VENT_INI = {100, 100, 450, 300};

	/** The Constant LBL_LOGO. */
	private static final int[] LBL_LOGO  = {109, 39, 216, 90};

	/** The Constant LBL_REG. */
	private static final int[] LBL_REG  = {205, 162, 82, 23};

	/** The Constant LBL_INISES. */
	private static final int[] LBL_INISES  = {210, 202, 91, 23};

	/** The Constant BTN_REG. */
	private static final int[] BTN_REG  = {127, 162, 191, 23};

	/** The Constant BTN_INISES. */
	private static final int[] BTN_INISES  = {127, 202, 191, 23};
    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * Instantiates a new menu inicio.
     */
    public MenuInicio() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Cliente cliente = new Cliente();
                    cliente.start();
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

        // Propiedades de la ventana
        setTitle("WOME - World Of the Middle Earth");
        setBounds(VENT_INI[0], VENT_INI[1],
        		VENT_INI[2], VENT_INI[TRES]);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(
                new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        lblLogo.setBounds(LBL_LOGO[0], LBL_LOGO[1],
        		LBL_LOGO[2], LBL_LOGO[TRES]);
        contentPane.add(lblLogo);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, LP_LOGO_ANCH, LP_LOGO_ALTO);
        contentPane.add(layeredPane);

        // Boton Jugar
        JLabel lblRegistrarse = new JLabel("Jugar");
        lblRegistrarse.setBounds(LBL_REG[0], LBL_REG[1],
        		LBL_REG[2], LBL_REG[TRES]);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA));
        lblRegistrarse.setBackground(Color.WHITE);

        // Boton Salir
        JLabel lblIniciarSesion = new JLabel("Salir");
        lblIniciarSesion.setBounds(LBL_INISES[0], LBL_INISES[1],
        		LBL_INISES[2], LBL_INISES[TRES]);
        layeredPane.add(lblIniciarSesion, new Integer(2));
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA));

        JButton btnRegistrar = new JButton("Jugar");
        btnRegistrar.setBounds(BTN_REG[0], BTN_REG[1],
        		BTN_REG[2], BTN_REG[TRES]);
        layeredPane.add(btnRegistrar, new Integer(1));
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.start();
                dispose();
            }
        });

        JButton btnIniciarSesion = new JButton("Salir");
        btnIniciarSesion.setBounds(BTN_INISES[0], BTN_INISES[1],
        		BTN_INISES[2], BTN_INISES[TRES]);
        layeredPane.add(btnIniciarSesion, new Integer(1));
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
            }
        });

        JLabel lblBackground = new JLabel("");

        lblBackground.setBounds(0, 0, LBL_BGN_ANCH, LBL_BGN_ALTO);
        lblBackground.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        layeredPane.add(lblBackground, new Integer(0));
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        new MenuInicio().setVisible(true);
    }

}
