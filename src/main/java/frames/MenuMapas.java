package frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class MenuMapas.
 */
@SuppressWarnings("serial")
public class MenuMapas extends JFrame {

    /**
     * The Constant SETMAPAEODRIM.
     */
    private static final int SETMAPAEODRIM = 3;

    /**
     * The Constant TAMANIOQUINCE.
     */
    private static final int TAMANIOQUINCE = 15;

    /**
     * The Constant TRES.
     */
    private static final int TRES = 3;

    /**
     * The Constant ELEGIRMAPA.
     */
    private static final int[] ELEGIRMAPA = {100, 100, 450, 300 };

    /**
     * The Constant WOMEELEGIRMAPA.
     */
    private static final int[] WOMEELEGIRMAPA = {100, 100, 450, 300 };

    /**
     * The Constant WOMEELEGIRMAPA2.
     */
    private static final int[] WOMEELEGIRMAPA2 = {5, 5, 5, 5 };

    /**
     * The Constant LAYAREDPANEL.
     */
    private static final int[] LAYAREDPANEL = {0, 0, 444, 271 };

    /**
     * The Constant ARIS.
     */
    private static final int[] ARIS = {204, 129, 32, 23 };

    /**
     * The Constant AUBENOR.
     */
    private static final int[] AUBENOR = {191, 72, 66, 23 };

    /**
     * The Constant EODRIM.
     */
    private static final int[] EODRIM = {198, 192, 53, 23 };

    /**
     * The Constant BOTONAUBENOR.
     */
    private static final int[] BOTONAUBENOR = {148, 72, 143, 23 };

    /**
     * The Constant BOTONARIS.
     */
    private static final int[] BOTONARIS = {148, 192, 143, 23 };

    /**
     * The Constant BOTONEODRIM.
     */
    private static final int[] BOTONEODRIM = {148, 130, 143, 23 };

    /**
     * The Constant LABELBACKGROUND.
     */
    private static final int[] LABELBACKGROUND = {0, 0, 444, 271 };
    // private static final int[] = {};
    // private static final int[] = {};

    /**
     * The number map.
     */
    private static int numberMap = 0;

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * Instantiates a new menu mapas.
     *
     * @param cliente
     *            the cliente
     */
    public MenuMapas(final Cliente cliente) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    synchronized (cliente) {
                        cliente.getPaquetePersonaje().setMapa(1);
                        setNumberMap(1);
                        cliente.notify();
                    }
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

        setTitle("Elegir Mapa");
        setBounds(ELEGIRMAPA[0], ELEGIRMAPA[1], ELEGIRMAPA[2],
                ELEGIRMAPA[TRES]);

        // En caso de cerrar
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

        // Panel
        setTitle("WOME - Elegir Mapa");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(WOMEELEGIRMAPA[0], WOMEELEGIRMAPA[1], WOMEELEGIRMAPA[2],
                WOMEELEGIRMAPA[TRES]);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(WOMEELEGIRMAPA2[0],
                WOMEELEGIRMAPA2[1], WOMEELEGIRMAPA2[2], WOMEELEGIRMAPA2[TRES]));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(LAYAREDPANEL[0], LAYAREDPANEL[1], LAYAREDPANEL[2],
                LAYAREDPANEL[TRES]);
        contentPane.add(layeredPane);

        // Mapa Aris
        JLabel lblAris = new JLabel("Aris");
        lblAris.setBounds(ARIS[0], ARIS[1], ARIS[2], ARIS[TRES]);
        layeredPane.add(lblAris, new Integer(2));
        lblAris.setForeground(Color.WHITE);
        lblAris.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        // Mapa Aubenor
        JLabel lblAubenor = new JLabel("Aubenor");
        lblAubenor.setBounds(AUBENOR[0], AUBENOR[1], AUBENOR[2], AUBENOR[TRES]);
        layeredPane.add(lblAubenor, new Integer(2));
        lblAubenor.setForeground(Color.WHITE);
        lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        // Mapa Eodrim
        JLabel lblEodrim = new JLabel("Eodrim");
        lblEodrim.setBounds(EODRIM[0], EODRIM[1], EODRIM[2], EODRIM[TRES]);
        layeredPane.add(lblEodrim, new Integer(2));
        lblEodrim.setForeground(Color.WHITE);
        lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        JButton btnAubenor = new JButton("");
        btnAubenor.setBounds(BOTONAUBENOR[0], BOTONAUBENOR[1], BOTONAUBENOR[2],
                BOTONAUBENOR[TRES]);
        layeredPane.add(btnAubenor, new Integer(1));
        btnAubenor.setFocusable(false);
        btnAubenor.setIcon(new ImageIcon(
                MenuMapas.class.getResource("/frames/BotonMenu.png")));

        JButton btnEodrim = new JButton("");
        btnEodrim.setBounds(BOTONEODRIM[0], BOTONEODRIM[1], BOTONEODRIM[2],
                BOTONEODRIM[TRES]);
        layeredPane.add(btnEodrim, new Integer(1));
        btnEodrim.setFocusable(false);
        btnEodrim.setEnabled(false);
        btnEodrim.setIcon(new ImageIcon(
                MenuMapas.class.getResource("/frames/BotonMenu.png")));
        btnEodrim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa(SETMAPAEODRIM);
                    cliente.notify();
                }
                dispose();
            }
        });

        btnEodrim.setEnabled(false);

        JButton btnAris = new JButton("");
        btnAris.setBounds(BOTONARIS[0], BOTONARIS[1], BOTONARIS[2],
                BOTONARIS[TRES]);
        layeredPane.add(btnAris, new Integer(1));
        btnAris.setFocusable(false);
        btnAris.setIcon(new ImageIcon(
                MenuMapas.class.getResource("/frames/BotonMenu.png")));
        btnAris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa(2);
                    setNumberMap(2);
                    cliente.notify();
                }
                dispose();
            }
        });

        btnAris.setEnabled(true);

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(LABELBACKGROUND[0], LABELBACKGROUND[1],
                LABELBACKGROUND[2], LABELBACKGROUND[TRES]);
        layeredPane.add(lblBackground, new Integer(0));
        lblBackground.setIcon(new ImageIcon(
                MenuMapas.class.getResource("/frames/menuBackground.jpg")));
        btnAubenor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                synchronized (cliente) {
                    cliente.getPaquetePersonaje().setMapa(1);
                    setNumberMap(1);
                    cliente.notify();
                }
                dispose();
            }
        });
    }

    /**
     * @return the numberMap
     */
    public static int getNumberMap() {
        return numberMap;
    }

    /**
     * @param numberMapParam
     *            the numberMap to set
     */
    public static void setNumberMap(final int numberMapParam) {
        MenuMapas.numberMap = numberMapParam;
    }
}
