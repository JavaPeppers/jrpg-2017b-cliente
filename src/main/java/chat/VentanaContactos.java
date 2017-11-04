package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * The Class VentanaContactos.
 */
@SuppressWarnings("serial")
public class VentanaContactos extends JFrame {

    /** Constante ALTO_BGND. */
    private static final int ALTO_BGND = 254;

    /** Constante ANCHO_BGND. */
    private static final int ANCHO_BGND = 352;

    /** Constante Y_BGND. */
    private static final int Y_BGND = 0;

    /** Constante X_BGND. */
    private static final int X_BGND = -16;

    /** Constante ALTO_BTNMC. */
    private static final int ALTO_BTNMC = 23;

    /** Constante ANCHO_BTNMC. */
    private static final int ANCHO_BTNMC = 89;

    /** Constante Y_BTNMC. */
    private static final int Y_BTNMC = 208;

    /** Constante X_BTNMC. */
    private static final int X_BTNMC = 119;

    /** Constante ALTO_SP. */
    private static final int ALTO_SP = 188;

    /** Constante ANCHO_SP. */
    private static final int ANCHO_SP = 299;

    /** Constante POSY_SP. */
    private static final int POSY_SP = 11;

    /** Constante POSX_SP. */
    private static final int POSX_SP = 10;

    /** Constante BORDERS. */
    private static final int BORDERS = 5;

    /** Constante ALTO_VC. */
    private static final int ALTO_VC = 273;

    /** Constante ANCHO_VC. */
    private static final int ANCHO_VC = 327;

    /** Constante POSY_VC. */
    private static final int POSY_VC = 100;

    /** Constante POSX_VC. */
    private static final int POSX_VC = 100;

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The modelo.
     */
    private DefaultListModel<String> modelo = new DefaultListModel<String>();

    /**
     * The list.
     */
    private static JList<String> list = new JList<String>();

    /**
     * The boton mc.
     */
    private static JButton botonMc;

    /**
     * The background.
     */
    private JLabel background;

    /**
     * Create de frame.
     *
     * @param juego
     *            se recibe juego
     */
    public VentanaContactos(final Juego juego) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(POSX_VC, POSY_VC, ANCHO_VC, ALTO_VC);
        setLocationRelativeTo(null);
        setTitle("Usuarios");

        contentPane = new JPanel();
        contentPane
                .setBorder(new EmptyBorder(BORDERS, BORDERS, BORDERS, BORDERS));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(POSX_SP, POSY_SP, ANCHO_SP, ALTO_SP);
        contentPane.add(scrollPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent arg0) {
                Pantalla.setVentContac(null);
                dispose();
            }
        });

        botonMc = new JButton("Multichat");
        botonMc.setIcon(new ImageIcon("recursos//multichatButton.png"));
        botonMc.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (modelo.size() != 0) {
                    if (!juego.getChatsActivos().containsKey("Sala")) {
                        MiChat chat = new MiChat(juego);
                        juego.getChatsActivos().put("Sala", chat);
                        chat.setTitle("Sala");
                        chat.setVisible(true);
                        botonMc.setEnabled(false);
                    }
                }
            }
        });
        botonMc.setBounds(X_BTNMC, Y_BTNMC, ANCHO_BTNMC, ALTO_BTNMC);
        contentPane.add(botonMc);

        // Cargo la lista de contactos
        actualizarLista(juego);
        // Pregunto si la ventana sala esta abierta y cancelo el boton multichat
        if (juego.getChatsActivos().containsKey("Sala")) {
            botonMc.setEnabled(false);
        } else {
            botonMc.setEnabled(true);
        }

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    if (list.getSelectedValue() != null) {
                        if (!juego.getChatsActivos()
                                .containsKey(list.getSelectedValue())) {
                            if (juego.getCliente() != null) {
                                MiChat chat = new MiChat(juego);
                                juego.getChatsActivos()
                                        .put(list.getSelectedValue(), chat);
                                chat.setTitle(list.getSelectedValue());
                                chat.setVisible(true);
                            }
                        }
                    }
                }
            }
        });

        list.setModel(modelo);
        scrollPane.setViewportView(list);

        background = new JLabel(new ImageIcon("recursos//background.jpg"));
        background.setBounds(X_BGND, Y_BGND, ANCHO_BGND, ALTO_BGND);
        contentPane.add(background);
    }

    /**
     * Actualizar lista.
     *
     * @param juego
     *            the juego
     */
    private void actualizarLista(final Juego juego) {
        if (juego.getCliente() != null) {
            synchronized (juego.getCliente()) {
                modelo.removeAllElements();
                if (juego.getPersonajesConectados() != null) {
                    for (Map.Entry<Integer, PaquetePersonaje> personaje : juego
                            .getPersonajesConectados().entrySet()) {
                        modelo.addElement(personaje.getValue().getNombre());
                    }
                    modelo.removeElement(juego.getPersonaje().getNombre());
                    list.setModel(modelo);
                }
            }
        }
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    public static JList<String> getList() {
        return list;
    }

    /**
     * Gets the boton mc.
     *
     * @return the boton mc
     */
    public static JButton getBotonMc() {
        return botonMc;
    }
}
