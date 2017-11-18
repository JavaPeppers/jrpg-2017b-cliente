package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import com.google.gson.Gson;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * The Class MiChat.
 */
@SuppressWarnings("serial")
public class MiChat extends JFrame {

    /** Constante ALTO_BGD. */
    private static final int ALTO_BGD = 283;

    /** Constante ANCHO_BGD. */
    private static final int ANCHO_BGD = 480;

    /** Constante POSY_BGD. */
    private static final int POSY_BGD = 0;

    /** Constante POSX_BGD. */
    private static final int POSX_BGD = -20;

    /** Constante COLTXT. */
    private static final int COLTXT = 10;

    /** Constante ALTO_TXT. */
    private static final int ALTO_TXT = 27;

    /** Constante ANCHO_TXT. */
    private static final int ANCHO_TXT = 314;

    /** Constante POSY_TXT. */
    private static final int POSY_TXT = 223;

    /** Constante POSX_TXT. */
    private static final int POSX_TXT = 10;

    /** Constante ALTO_ENV. */
    private static final int ALTO_ENV = 23;

    /** Constante ANCHO_ENV. */
    private static final int ANCHO_ENV = 81;

    /** Constante POS_Y_ENV. */
    private static final int POS_Y_ENV = 225;

    /** Constante POS_X_ENV. */
    private static final int POS_X_ENV = 334;

    /** Constante ALTO_SP. */
    private static final int ALTO_SP = 201;

    /** Constante ANCHO_SP. */
    private static final int ANCHO_SP = 414;

    /** Constante POS_Y_SP. */
    private static final int POS_Y_SP = 11;

    /** Constante POS_X_SP. */
    private static final int POS_X_SP = 10;

    /** Constante BORDER. */
    private static final int BORDER = 5;

    /** Constante ALTO_CHAT. */
    private static final int ALTO_CHAT = 300;

    /** Constante ANCHO_CHAT. */
    private static final int ANCHO_CHAT = 450;

    /** Constante POS_Y_CHAT. */
    private static final int POS_Y_CHAT = 100;

    /** Constante POS_X_CHAT. */
    private static final int POS_X_CHAT = 100;

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The texto.
     */
    private JTextField texto;

    /**
     * The chat.
     */
    private JTextArea chat;

    /**
     * The juego.
     */
    private Juego juego;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * The background.
     */
    private final JLabel background = new JLabel(
            new ImageIcon("recursos//background.jpg"));

    /**
     * The caret.
     */
    private DefaultCaret caret;

    /**
     * Create the frame.
     *
     * @param juegoParam
     *            se recibe juego.
     */
    public MiChat(final Juego juegoParam) {
        this.juego = juegoParam;
        setTitle("Mi Chat");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(POS_X_CHAT, POS_Y_CHAT, ANCHO_CHAT, ALTO_CHAT);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(POS_X_SP, POS_Y_SP, ANCHO_SP, ALTO_SP);
        contentPane.add(scrollPane);

        chat = new JTextArea();
        chat.setEditable(false);
        scrollPane.setViewportView(chat);
        caret = (DefaultCaret) chat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        texto = new JTextField();
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(final WindowEvent e) {
                texto.requestFocus();
            }

            @Override
            public void windowClosing(final WindowEvent e) {
                if (getTitle() == "Sala") {
                    if (Pantalla.getVentContac() != null) {
                        VentanaContactos.getBotonMc().setEnabled(true);
                    }
                }
                juego.getChatsActivos().remove(getTitle());
            }
        });

        // SI TOCO ENTER
        texto.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
            	String mensaje = texto.getText();
                if (!mensaje.equals("")) {
                    chat.append("Me: " + mensaje + "\n");
                    if(mensaje.equals("bigdaddy")) {
                    	juego.getPersonaje().setBigDaddy();
                    	juego.getCliente().getPaquetePersonaje().setComando(Comando.BIGDADDY);
                    	try {
							juego.getCliente().getSalida().writeObject(gson.toJson(
									juego.getCliente().getPaquetePersonaje()));
						} catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar paquetePersonaje");
						}
                    }else if(mensaje.equals("tinydaddy")) {
                    	juego.getPersonaje().setTinyDaddy();
                    	juego.getCliente().getPaquetePersonaje().setComando(Comando.TINYDADDY);
                    	try {
							juego.getCliente().getSalida().writeObject(gson.toJson(
									juego.getCliente().getPaquetePersonaje()));
						} catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar paquetePersonaje");
						}
                    }else if(mensaje.equals("noclip")) {
                    	juego.getPersonaje().setAtravesarParedes();
                    	juego.getCliente().getPaquetePersonaje().setComando(Comando.NOWALLS);
                    	try {
							juego.getCliente().getSalida().writeObject(gson.toJson(
									juego.getCliente().getPaquetePersonaje()));
						} catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar paquetePersonaje");
						}
                    }else if(mensaje.equals("iddqd")) {
                    	juego.getPersonaje().setModoDios();
                    	juego.getCliente().getPaquetePersonaje().setComando(Comando.DIOS);
                    	try {
							juego.getCliente().getSalida().writeObject(gson.toJson(
									juego.getCliente().getPaquetePersonaje()));
						} catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar paquetePersonaje");
						}
                    }else if(mensaje.equals("war aint what it used to be")) {
                    	juego.getPersonaje().setModoInvisible();
                    	juego.getCliente().getPaquetePersonaje().setComando(Comando.INVISIBLE);
                    	try {
							juego.getCliente().getSalida().writeObject(gson.toJson(
									juego.getCliente().getPaquetePersonaje()));
						} catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar paquetePersonaje");
						}
                    }
                    else {
	                    juego.getCliente().getPaqueteMensaje()
	                            .setUserEmisor(juego.getPersonaje().getNombre());
	                    juego.getCliente().getPaqueteMensaje()
	                            .setUserReceptor(getTitle());
	                    juego.getCliente().getPaqueteMensaje()
	                            .setMensaje(texto.getText());
	
	                    // MANDO EL COMANDO PARA QUE ENVIE EL MSJ
	                    juego.getCliente().getPaqueteMensaje()
	                            .setComando(Comando.TALK);
	                    // El user receptor en espacio indica que es para todos
	                    if (getTitle() == "Sala") {
	                        juego.getCliente().getPaqueteMensaje()
	                                .setUserReceptor(null);
	                    }
	
	                    try {
	                        juego.getCliente().getSalida().writeObject(gson.toJson(
	                                juego.getCliente().getPaqueteMensaje()));
	                    } catch (IOException e1) {
	                        JOptionPane.showMessageDialog(null,
	                                "Error al enviar mensaje");
	                    }
                    }
	                    texto.setText("");
	                }
	                texto.requestFocus();
	            }
        });

        // SI TOCO ENVIAR
        JButton enviar = new JButton("ENVIAR");
        enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (!texto.getText().equals("")) {
                    chat.append("Me: " + texto.getText() + "\n");

                    juego.getCliente().getPaqueteMensaje()
                            .setUserEmisor(juego.getPersonaje().getNombre());
                    juego.getCliente().getPaqueteMensaje()
                            .setUserReceptor(getTitle());
                    juego.getCliente().getPaqueteMensaje()
                            .setMensaje(texto.getText());

                    // MANDO EL COMANDO PARA QUE ENVIE EL MSJ
                    juego.getCliente().getPaqueteMensaje()
                            .setComando(Comando.TALK);
                    // El user receptor en espacio indica que es para todos
                    if (getTitle() == "Sala") {
                        juego.getCliente().getPaqueteMensaje()
                                .setUserReceptor(null);
                    }

                    try {
                        juego.getCliente().getSalida().writeObject(gson.toJson(
                                juego.getCliente().getPaqueteMensaje()));
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,
                                "Error al enviar mensaje");

                    }
                    texto.setText("");
                }
                texto.requestFocus();
            }
        });
        enviar.setBounds(POS_X_ENV, POS_Y_ENV, ANCHO_ENV, ALTO_ENV);
        contentPane.add(enviar);

        texto.setBounds(POSX_TXT, POSY_TXT, ANCHO_TXT, ALTO_TXT);
        contentPane.add(texto);
        texto.setColumns(COLTXT);
        background.setBounds(POSX_BGD, POSY_BGD, ANCHO_BGD, ALTO_BGD);
        contentPane.add(background);
    }

    /**
     * Gets the chat.
     *
     * @return the chat
     */
    public JTextArea getChat() {
        return chat;
    }

    /**
     * Gets the texto.
     *
     * @return the texto
     */
    public JTextField getTexto() {
        return texto;
    }
}
