package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

/**
 * The Class MenuCreacionPj.
 */
public class MenuCreacionPj extends JFrame {

    /**
     * The Constant COLUMNASNOMBRE.
     */
    private static final int COLUMNASNOMBRE = 10;

    /**
     * The Constant TAMANIOQUINCE.
     */
    private static final int TAMANIOQUINCE = 15;

    /**
     * The Constant TRES.
     */
    private static final int TRES = 3;

    /**
     * The Constant TAMANIOTRECE.
     */
    private static final int TAMANIOTRECE = 13;

    /**
     * The Constant WOMECREARPERSONAJE.
     */
    private static final int[] WOMECREARPERSONAJE = {100, 100, 450, 300 };

    /**
     * The Constant WOMECREARPERSONAJE2.
     */
    private static final int[] WOMECREARPERSONAJE2 = {5, 5, 5, 5 };

    /**
     * The Constant LAYAREDPANEL.
     */
    private static final int[] LAYAREDPANEL = {0, 0, 444, 271 };

    /**
     * The Constant LABELFUERZA.
     */
    private static final int[] LABELFUERZA = {33, 100, 46, 14 };

    /**
     * The Constant FUERZA.
     */
    private static final int[] FUERZA = {110, 102, 22, 14 };

    /**
     * The Constant LABELDESTREZA.
     */
    private static final int[] LABELDESTREZA = {33, 126, 60, 14 };

    /**
     * The Constant DESTREZA.
     */
    private static final int[] DESTREZA = {110, 127, 22, 14 };

    /**
     * The Constant LABELINTELIGENCIA.
     */
    private static final int[] LABELINTELIGENCIA = {33, 151, 66, 22 };

    /**
     * The Constant INTELIGENCIA.
     */
    private static final int[] INTELIGENCIA = {110, 156, 22, 14 };

    /**
     * The Constant LABELSALUD.
     */
    private static final int[] LABELSALUD = {33, 183, 46, 14 };

    /**
     * The Constant SALUD.
     */
    private static final int[] SALUD = {110, 183, 22, 14 };

    /**
     * The Constant LABELENERGIA.
     */
    private static final int[] LABELENERGIA = {33, 204, 46, 20 };

    /**
     * The Constant ENERGIA.
     */
    private static final int[] ENERGIA = {110, 208, 22, 14 };

    /**
     * The Constant LABELNOMBRE.
     */
    private static final int[] LABELNOMBRE = {207, 125, 60, 14 };

    /**
     * The Constant NOMBRE.
     */
    private static final int[] NOMBRE = {277, 122, 122, 20 };

    /**
     * The Constant LABELACEPTAR.
     */
    private static final int[] LABELACEPTAR = {280, 173, 50, 24 };

    /**
     * The Constant BOTONACEPTAR.
     */
    private static final int[] BOTONACEPTAR = {230, 174, 153, 23 };

    /**
     * The Constant LABELRAZA.
     */
    private static final int[] LABELRAZA = {33, 23, 46, 14 };

    /**
     * The Constant LABELCASTA.
     */
    private static final int[] LABELCASTA = {161, 23, 46, 14 };

    /**
     * The Constant CBXCASTA.
     */
    private static final int[] CBXCASTA = {161, 48, 76, 20 };

    /**
     * The Constant CBXRAZA.
     */
    private static final int[] CBXRAZA = {32, 48, 76, 20 };

    /**
     * The Constant LABELBACKGROUND.
     */
    private static final int[] LABELBACKGROUND = {0, 0, 444, 271 };

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The nombre.
     */
    private JTextField nombre;

    /**
     * The destreza.
     */
    private JLabel destreza;

    /**
     * The fuerza.
     */
    private JLabel fuerza;

    /**
     * The inteligencia.
     */
    private JLabel inteligencia;

    /**
     * The salud.
     */
    private JLabel salud;

    /**
     * The energia.
     */
    private JLabel energia;

    /**
     * The cbx casta.
     */
    private JComboBox<String> cbxCasta;

    /**
     * The cbx raza.
     */
    private JComboBox<String> cbxRaza;

    /**
     * Instantiates a new menu creacion pj.
     *
     * @param cliente
     *            the cliente
     * @param personaje
     *            the personaje
     * @param gson
     *            the gson
     */
    public MenuCreacionPj(final Cliente cliente,
            final PaquetePersonaje personaje, final Gson gson) {
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));

        final String[] vecSalud = {"55", "50", "60" };
        final String[] vecEnergia = {"55", "60", "50" };
        final String[] vecFuerza = {"15", "10", "10" };
        final String[] vecDestreza = {"10", "10", "15" };
        final String[] vecInteligencia = {"10", "15", "10" };

        // En caso de cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                personaje.setNombre(nombre.getText());
                if (nombre.getText().equals("")) {
                    personaje.setNombre("nameless");
                }
                personaje.setRaza((String) cbxRaza.getSelectedItem());
                personaje.setSaludTope(
                        Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
                personaje.setEnergiaTope(Integer
                        .parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
                personaje.setCasta((String) cbxCasta.getSelectedItem());
                personaje.setFuerza(Integer
                        .parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
                personaje.setDestreza(Integer
                        .parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
                personaje.setInteligencia(Integer.parseInt(
                        vecInteligencia[cbxCasta.getSelectedIndex()]));
                synchronized (cliente) {
                    cliente.notify();
                }
                dispose();
            }
        });

        setTitle("WOME - Crear personaje");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(WOMECREARPERSONAJE[0], WOMECREARPERSONAJE[1],
                WOMECREARPERSONAJE[2], WOMECREARPERSONAJE[TRES]);
        contentPane = new JPanel();
        contentPane.setBorder(
                new EmptyBorder(WOMECREARPERSONAJE2[0], WOMECREARPERSONAJE2[1],
                        WOMECREARPERSONAJE2[2], WOMECREARPERSONAJE2[TRES]));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(LAYAREDPANEL[0], LAYAREDPANEL[1], LAYAREDPANEL[2],
                LAYAREDPANEL[TRES]);
        contentPane.add(layeredPane);

        JLabel lblNewLabel5 = new JLabel("Fuerza");
        lblNewLabel5.setBounds(LABELFUERZA[1], LABELFUERZA[1], LABELFUERZA[2],
                LABELFUERZA[TRES]);
        layeredPane.add(lblNewLabel5, new Integer(1));
        lblNewLabel5.setForeground(Color.WHITE);
        lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOTRECE));

        fuerza = new JLabel("15");
        fuerza.setBounds(FUERZA[1], FUERZA[1], FUERZA[2], FUERZA[TRES]);
        layeredPane.add(fuerza, new Integer(1));
        fuerza.setForeground(Color.GREEN);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setBounds(LABELDESTREZA[1], LABELDESTREZA[1],
                LABELDESTREZA[2], LABELDESTREZA[TRES]);
        layeredPane.add(lblDestreza, new Integer(1));
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOTRECE));

        destreza = new JLabel("10");
        destreza.setBounds(DESTREZA[1], DESTREZA[1], DESTREZA[2],
                DESTREZA[TRES]);
        layeredPane.add(destreza, new Integer(1));
        destreza.setForeground(Color.GREEN);

        JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setBounds(LABELINTELIGENCIA[1], LABELINTELIGENCIA[1],
                LABELINTELIGENCIA[2], LABELINTELIGENCIA[TRES]);
        layeredPane.add(lblInteligencia, new Integer(1));
        lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOTRECE));
        lblInteligencia.setForeground(Color.WHITE);

        inteligencia = new JLabel("10");
        inteligencia.setBounds(INTELIGENCIA[1], INTELIGENCIA[1],
                INTELIGENCIA[2], INTELIGENCIA[TRES]);
        layeredPane.add(inteligencia, new Integer(1));
        inteligencia.setForeground(Color.GREEN);

        JLabel lblSalud = new JLabel("Salud");
        lblSalud.setBounds(LABELSALUD[1], LABELSALUD[1], LABELSALUD[2],
                LABELSALUD[TRES]);
        layeredPane.add(lblSalud, new Integer(1));
        lblSalud.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOTRECE));
        lblSalud.setForeground(Color.WHITE);

        salud = new JLabel("55");
        salud.setBounds(SALUD[1], SALUD[1], SALUD[2], SALUD[TRES]);
        layeredPane.add(salud, new Integer(1));
        salud.setForeground(Color.GREEN);

        JLabel lblEnergia = new JLabel("Energia");
        lblEnergia.setBounds(LABELENERGIA[1], LABELENERGIA[1], LABELENERGIA[2],
                LABELENERGIA[TRES]);
        layeredPane.add(lblEnergia, new Integer(1));
        lblEnergia.setForeground(Color.WHITE);
        lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOTRECE));

        energia = new JLabel("55");
        energia.setBounds(ENERGIA[1], ENERGIA[1], ENERGIA[2], ENERGIA[TRES]);
        layeredPane.add(energia, new Integer(1));
        energia.setForeground(Color.GREEN);

        JLabel lblNewLabel4 = new JLabel("Nombre");
        lblNewLabel4.setBounds(LABELNOMBRE[0], LABELNOMBRE[1], LABELNOMBRE[2],
                LABELNOMBRE[TRES]);
        layeredPane.add(lblNewLabel4, new Integer(1));
        lblNewLabel4.setForeground(Color.WHITE);
        lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        nombre = new JTextField();
        nombre.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
                        vecFuerza, vecDestreza, vecInteligencia);
            }
        });
        nombre.setBounds(NOMBRE[0], NOMBRE[1], NOMBRE[2], NOMBRE[TRES]);
        layeredPane.add(nombre, new Integer(1));
        nombre.setColumns(COLUMNASNOMBRE);

        JLabel lblAceptar = new JLabel("Aceptar");
        lblAceptar.setBounds(LABELACEPTAR[0], LABELACEPTAR[1], LABELACEPTAR[2],
                LABELACEPTAR[TRES]);
        layeredPane.add(lblAceptar, new Integer(2));
        lblAceptar.setForeground(Color.WHITE);
        lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        // En caso de apretar el boton aceptar
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(BOTONACEPTAR[0], BOTONACEPTAR[1], BOTONACEPTAR[2],
                BOTONACEPTAR[TRES]);
        layeredPane.add(btnAceptar, new Integer(1));
        btnAceptar.setFocusable(false);
        btnAceptar.setIcon(new ImageIcon(
                MenuCreacionPj.class.getResource("/frames/BotonMenu.png")));

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
                        vecFuerza, vecDestreza, vecInteligencia);

            }

        });

        JLabel lblNewLabel = new JLabel("Raza");
        lblNewLabel.setBounds(LABELRAZA[0], LABELRAZA[1], LABELRAZA[2],
                LABELRAZA[TRES]);
        layeredPane.add(lblNewLabel, new Integer(1));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        JLabel lblCasta = new JLabel("Casta");
        lblCasta.setBounds(LABELCASTA[0], LABELCASTA[1], LABELCASTA[2],
                LABELCASTA[TRES]);
        layeredPane.add(lblCasta, new Integer(1));
        lblCasta.setForeground(Color.WHITE);
        lblCasta.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOQUINCE));

        cbxCasta = new JComboBox<>();
        cbxCasta.setBounds(CBXCASTA[0], CBXCASTA[1], CBXCASTA[2],
                CBXCASTA[TRES]);
        layeredPane.add(cbxCasta, new Integer(1));
        cbxCasta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
                destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
                inteligencia
                        .setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
            }
        });
        cbxCasta.addItem("Guerrero");
        cbxCasta.addItem("Hechicero");
        cbxCasta.addItem("Asesino");

        cbxRaza = new JComboBox<>();
        cbxRaza.setBounds(CBXRAZA[0], CBXRAZA[1], CBXRAZA[2], CBXRAZA[TRES]);
        layeredPane.add(cbxRaza, new Integer(1));
        cbxRaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
                energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
            }
        });
        cbxRaza.addItem("Humano");
        cbxRaza.addItem("Elfo");
        cbxRaza.addItem("Orco");

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(LABELBACKGROUND[0], LABELBACKGROUND[1],
                LABELBACKGROUND[2], LABELBACKGROUND[TRES]);
        layeredPane.add(lblBackground, new Integer(0));
        lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class
                .getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Crear pj.
     *
     * @param cliente
     *            the cliente
     * @param personaje
     *            the personaje
     * @param gson
     *            the gson
     * @param vecSalud
     *            the vec salud
     * @param vecEnergia
     *            the vec energia
     * @param vecFuerza
     *            the vec fuerza
     * @param vecDestreza
     *            the vec destreza
     * @param vecInteligencia
     *            the vec inteligencia
     */
    protected void crearPj(final Cliente cliente,
            final PaquetePersonaje personaje, final Gson gson,
            final String[] vecSalud, final String[] vecEnergia,
            final String[] vecFuerza, final String[] vecDestreza,
            final String[] vecInteligencia) {

        personaje.setNombre(nombre.getText());
        if (nombre.getText().equals("")) {
            personaje.setNombre("nameless");
        }
        personaje.setRaza((String) cbxRaza.getSelectedItem());
        personaje.setSaludTope(
                Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
        personaje.setEnergiaTope(
                Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
        personaje.setCasta((String) cbxCasta.getSelectedItem());
        personaje.setFuerza(
                Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
        personaje.setDestreza(
                Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
        personaje.setInteligencia(
                Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
        try {

            // Le envio los datos al servidor
            cliente.getPaquetePersonaje().setComando(Comando.CREACIONPJ);
            cliente.getSalida()
                    .writeObject(gson.toJson(cliente.getPaquetePersonaje()));
            dispose();
        } catch (JsonSyntaxException | IOException esd) {
            JOptionPane.showMessageDialog(null, "Error al crear personaje");

        }
    }

}
