package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuInicioSesion.
 */
public class MenuInicioSesion extends JFrame {

	/** Indica la posicion tres del array de constantes. */
	private static final int TRES = 3;

	/** The Constant LBL_BGN_ALTO. */
	private static final int LBL_BGN_ALTO = 271;

	/** The Constant LBL_BGN_ANCH. */
	private static final int LBL_BGN_ANCH = 444;

	/** The Constant TAM_LETRA2. */
	private static final int TAM_LETRA2 = 11;

	/** The Constant COL. */
	private static final int COL = 10;

	/** The Constant TAM_LETRA. */
	private static final int TAM_LETRA = 15;

	/** The Constant LP_ALTO. */
	private static final int LP_ALTO = 271;

	/** The Constant LP_ANCH. */
	private static final int LP_ANCH = 444;

	/** The Constant BORDER. */
	private static final int BORDER = 5;

	/** The Constant TITLE. */
	private static final int[] TITLE  = {100, 100, 450, 300};

	/** The Constant LBL_PW. */
	private static final int[] LBL_PW = {111, 118, 68, 21};

	/** The Constant LBL_USER. */
	private static final int[] LBL_USER = {111, 66, 55, 23};

	/** The Constant LBL_INGRE. */
	private static final int[] LBL_INGRE = {193, 183, 68, 23};

	/** The Constant USER_FIELD. */
	private static final int[] USER_FIELD = {198, 69, 118, 20};

	/** The Constant PW_FIELD. */
	private static final int[] PW_FIELD = {198, 119, 118, 20};

	/** The Constant BTN_CONECT. */
	private static final int[] BTN_CONECT = {141, 182, 153, 23};

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The text field.
     */
    private JTextField textField;

    /**
     * The password field.
     */
    private JPasswordField passwordField;

    /**
     * Instantiates a new menu inicio sesion.
     *
     * @param cliente
     *            the cliente
     */
    public MenuInicioSesion(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            }
        });

        setTitle("WOME - Iniciar Sesion");
        setBounds(TITLE[0], TITLE[1], TITLE[2], TITLE[TRES]);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, LP_ANCH, LP_ALTO);
        contentPane.add(layeredPane);

        JLabel lblNewLabel1 = new JLabel("Password");
        lblNewLabel1.setBounds(LBL_PW[0], LBL_PW[1], LBL_PW[2], LBL_PW[TRES]);
        layeredPane.add(lblNewLabel1);
        lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA));
        lblNewLabel1.setForeground(Color.WHITE);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(LBL_USER[0], LBL_USER[1],
        		LBL_USER[2], LBL_USER[TRES]);
        layeredPane.add(lblNewLabel, new Integer(2));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA));

        JLabel lblIngresar = new JLabel("Ingresar");
        lblIngresar.setBounds(LBL_INGRE[0], LBL_INGRE[1],
        		LBL_INGRE[2], LBL_INGRE[TRES]);
        layeredPane.add(lblIngresar, new Integer(2));
        lblIngresar.setForeground(Color.WHITE);
        lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA));

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                logIn(cliente);
            }
        });
        textField.setBounds(USER_FIELD[0], USER_FIELD[1],
        		USER_FIELD[2], USER_FIELD[TRES]);
        layeredPane.add(textField, new Integer(1));
        textField.setColumns(COL);

        passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
            }
        });
        passwordField.setBounds(PW_FIELD[0], PW_FIELD[1],
        		PW_FIELD[2], PW_FIELD[TRES]);
        layeredPane.add(passwordField, new Integer(1));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, TAM_LETRA2));

        JButton btnConectar = new JButton("");
        btnConectar.setBounds(BTN_CONECT[0], BTN_CONECT[1],
        		BTN_CONECT[2], BTN_CONECT[TRES]);
        layeredPane.add(btnConectar, new Integer(1));
        btnConectar.setFocusable(false);
        btnConectar.setIcon(new ImageIcon(
                MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);

            }
        });

        JLabel labelBackground = new JLabel("");
        labelBackground.setBounds(0, 0, LBL_BGN_ANCH, LBL_BGN_ALTO);
        labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class
                .getResource("/frames/menuBackground.jpg")));
        layeredPane.add(labelBackground, new Integer(0));
    }

    /**
     * Log in.
     *
     * @param cliente
     *            the cliente
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.setAccion(Comando.INICIOSESION);
            cliente.getPaqueteUsuario().setUsername(textField.getText());
            cliente.getPaqueteUsuario()
                    .setPassword(String.valueOf(passwordField.getPassword()));
            cliente.notify();
            dispose();
        }
    }
}
