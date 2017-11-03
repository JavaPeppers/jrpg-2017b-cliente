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
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * The Class MenuRegistro.
 */
public class MenuRegistro extends JFrame {

    /**
     * Constante COLUMNASTXTUSUARIO.
     */
    private static final int COLUMNASTXTUSUARIO = 10;

    /**
     * Constante TAMANIOQUINCE.
     */
    private static final int TAMANIOQUINCE = 15;

    /**
     * Constante TRES.
     */
    private static final int TRES = 3;

    /**
     * Constante WOMEREGISTRASE.
     */
    private static final int[] WOMEREGISTRASE = {100, 100, 450, 300 };

    /**
     * Constante USUARIO.
     */
    private static final int[] USUARIO = {113, 70, 57, 19 };

    /**
     * Constante PASSWORD.
     */
    private static final int[] PASSWORD = {113, 121, 65, 17 };

    /**
     * Constante REGISTRARSE.
     */
    private static final int[] REGISTRARSE = {186, 182, 82, 23 };

    /**
     * Constante BOTONREGISTRARSE.
     */
    private static final int[] BOTONREGISTRARSE = {143, 182, 153, 23 };

    /**
     * Constante PWPASSWORD.
     */
    private static final int[] PWPASSWORD = {199, 120, 118, 20 };

    /**
     * Constante TXTUSUARIO.
     */
    private static final int[] TXTUSUARIO = {199, 69, 118, 20 };

    /**
     * Constante LAYAREDPANEL.
     */
    private static final int[] LAYAREDPANEL = {0, 0, 444, 271 };

    /**
     * Constante LABELBACKGROUND.
     */
    private static final int[] LABELBACKGROUND = {0, 0, 444, 271 };

    /**
     * The txt usuario.
     */
    private JTextField txtUsuario;

    /**
     * The pw password.
     */
    private JPasswordField pwPassword;

    /**
     * Instantiates a new menu registro.
     *
     * @param cliente
     *            the cliente
     */
    public MenuRegistro(final Cliente cliente) {
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
                dispose();
            }
        });

        setTitle("WOME - Registrarse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(WOMEREGISTRASE[0], WOMEREGISTRASE[1], WOMEREGISTRASE[2],
                WOMEREGISTRASE[TRES]);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(LAYAREDPANEL[0], LAYAREDPANEL[1], LAYAREDPANEL[2],
                LAYAREDPANEL[TRES]);
        getContentPane().add(layeredPane);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(USUARIO[0], USUARIO[1], USUARIO[2], USUARIO[TRES]);
        layeredPane.add(lblUsuario, new Integer(1));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(PASSWORD[0], PASSWORD[1], PASSWORD[2],
                PASSWORD[TRES]);
        layeredPane.add(lblPassword, new Integer(1));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setBounds(REGISTRARSE[0], REGISTRARSE[1], REGISTRARSE[2],
                REGISTRARSE[TRES]);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        JButton btnRegistrarse = new JButton("");
        btnRegistrarse.setBounds(BOTONREGISTRARSE[0], BOTONREGISTRARSE[1],
                BOTONREGISTRARSE[2], BOTONREGISTRARSE[TRES]);
        layeredPane.add(btnRegistrarse, new Integer(1));
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setIcon(new ImageIcon(
                MenuRegistro.class.getResource("/frames/BotonMenu.png")));

        pwPassword = new JPasswordField();
        pwPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        pwPassword.setBounds(PWPASSWORD[0], PWPASSWORD[1], PWPASSWORD[2],
                PWPASSWORD[TRES]);
        layeredPane.add(pwPassword, new Integer(1));

        txtUsuario = new JTextField();
        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        txtUsuario.setBounds(TXTUSUARIO[0], TXTUSUARIO[1], TXTUSUARIO[2],
                TXTUSUARIO[TRES]);
        layeredPane.add(txtUsuario, new Integer(1));
        txtUsuario.setColumns(COLUMNASTXTUSUARIO);

        JLabel labelBackground = new JLabel("");
        labelBackground.setBounds(LABELBACKGROUND[0], LABELBACKGROUND[1],
                LABELBACKGROUND[2], LABELBACKGROUND[TRES]);
        layeredPane.add(labelBackground, new Integer(0));
        labelBackground.setIcon(new ImageIcon(
                MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
    }

    /**
     * Gets the txt usuario.
     *
     * @return the txt usuario
     */
    public JTextField gettxtUsuario() {
        return txtUsuario;
    }

    /**
     * Sets the txt usuario.
     *
     * @param txtUsuarioParam
     *            the new txt usuario
     */
    public void settxtUsuario(final JTextField txtUsuarioParam) {
        this.txtUsuario = txtUsuarioParam;
    }

    /**
     * Gets the password field.
     *
     * @return the password field
     */
    public JPasswordField getPasswordField() {
        return pwPassword;
    }

    /**
     * Sets the password field.
     *
     * @param pwPasswordParam
     *            the new password field
     */
    public void setPasswordField(final JPasswordField pwPasswordParam) {
        this.pwPassword = pwPasswordParam;
    }

    /**
     * Log in.
     *
     * @param cliente
     *            the cliente
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
            cliente.getPaqueteUsuario()
                    .setPassword(String.valueOf(pwPassword.getPassword()));
            cliente.setAccion(Comando.REGISTRO);
            cliente.notify();
        }
    }
}
