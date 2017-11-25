package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * The Class MenuStats.
 */
@SuppressWarnings("serial")
public class MenuStats extends JFrame {

    /** The Constant YDIST. */
    private static final int YDIST = 350;

    /** The Constant XDIST. */
    private static final int XDIST = 400;

    /** The Constant ALTOVOLVER. */
    private static final int ALTOVOLVER = 25;

    /** The Constant ANCHOVOLVER. */
    private static final int ANCHOVOLVER = 97;

    /** The Constant YVOLVER. */
    private static final int YVOLVER = 245;

    /** The Constant XVOLVER. */
    private static final int XVOLVER = 128;

    /** The Constant YENERGIAPJ. */
    private static final int YENERGIAPJ = 100;

    /** The Constant XSTATPJ. */
    private static final int XSTATPJ = 251;

    /** The Constant YEXPERIENCIAPJ. */
    private static final int YEXPERIENCIAPJ = 42;

    /** The Constant YNIVELPJ. */
    private static final int YNIVELPJ = 13;

    /** The Constant ANCHOCANTITEM. */
    private static final int ANCHOCANTITEM = 39;

    /** The Constant YCANTITEM. */
    private static final int YCANTITEM = 216;

    /** The Constant XCANTITEM. */
    private static final int XCANTITEM = 118;

    /** The Constant YINTPJ. */
    private static final int YINTPJ = 187;

    /** The Constant YDESTREZAPJ. */
    private static final int YDESTREZAPJ = 158;

    /** The Constant YFUERZAPJ. */
    private static final int YFUERZAPJ = 129;

    /** The Constant YSALUDPJ. */
    private static final int YSALUDPJ = 100;

    /** The Constant YRAZAPJ. */
    private static final int YRAZAPJ = 71;

    /** The Constant YCASTAPJ. */
    private static final int YCASTAPJ = 42;

    /** The Constant YNOMBREPJ. */
    private static final int YNOMBREPJ = 13;

    /** The Constant XPJ. */
    private static final int XPJ = 80;

    /** The Constant ALTOPJ. */
    private static final int ALTOPJ = 16;

    /** The Constant ANCHOPJ. */
    private static final int ANCHOPJ = 77;

    /** The Constant ALTOITEM. */
    private static final int ALTOITEM = 16;

    /** The Constant ANCHOITEM. */
    private static final int ANCHOITEM = 110;

    /** The Constant YITEM. */
    private static final int YITEM = 216;

    /** The Constant XITEM. */
    private static final int XITEM = 12;

    /** The Constant ALTOMAGIA. */
    private static final int ALTOMAGIA = 16;

    /** The Constant ANCHOMAGIA. */
    private static final int ANCHOMAGIA = 39;

    /** The Constant YMAGIA. */
    private static final int YMAGIA = 187;

    /** The Constant XMAGIA. */
    private static final int XMAGIA = 169;

    /** The Constant ALTODEF. */
    private static final int ALTODEF = 16;

    /** The Constant ANCHODEF. */
    private static final int ANCHODEF = 56;

    /** The Constant YDEF. */
    private static final int YDEF = 158;

    /** The Constant XDEF. */
    private static final int XDEF = 169;

    /** The Constant ALTOATK. */
    private static final int ALTOATK = 16;

    /** The Constant ANCHOATK. */
    private static final int ANCHOATK = 48;

    /** The Constant YATK. */
    private static final int YATK = 129;

    /** The Constant XATK. */
    private static final int XATK = 169;

    /** The Constant ALTOINT. */
    private static final int ALTOINT = 16;

    /** The Constant ANCHOINT. */
    private static final int ANCHOINT = 72;

    /** The Constant YINT. */
    private static final int YINT = 187;

    /** The Constant XINT. */
    private static final int XINT = 12;

    /** The Constant ALTODESTREZA. */
    private static final int ALTODESTREZA = 16;

    /** The Constant ANCHODESTREZA. */
    private static final int ANCHODESTREZA = 56;

    /** The Constant YDESTREZA. */
    private static final int YDESTREZA = 158;

    /** The Constant XDESTREZA. */
    private static final int XDESTREZA = 12;

    /** The Constant ALTOFUERZA. */
    private static final int ALTOFUERZA = 16;

    /** The Constant ANCHOFUERZA. */
    private static final int ANCHOFUERZA = 48;

    /** The Constant YFUERZA. */
    private static final int YFUERZA = 129;

    /** The Constant XFUERZA. */
    private static final int XFUERZA = 12;

    /** The Constant ALTOSALUD. */
    private static final int ALTOSALUD = 16;

    /** The Constant ANCHOSALUD. */
    private static final int ANCHOSALUD = 56;

    /** The Constant YSALUD. */
    private static final int YSALUD = 100;

    /** The Constant XSALUD. */
    private static final int XSALUD = 12;

    /** The Constant ALTOENERGIA. */
    private static final int ALTOENERGIA = 16;

    /** The Constant ANCHOENERGIA. */
    private static final int ANCHOENERGIA = 48;

    /** The Constant YENERGIA. */
    private static final int YENERGIA = 100;

    /** The Constant XENERGIA. */
    private static final int XENERGIA = 169;

    /** The Constant ALTOEXP. */
    private static final int ALTOEXP = 16;

    /** The Constant ANCHOEXP. */
    private static final int ANCHOEXP = 72;

    /** The Constant YEXP. */
    private static final int YEXP = 42;

    /** The Constant XEXP. */
    private static final int XEXP = 169;

    /** The Constant ALTONIVEL. */
    private static final int ALTONIVEL = 16;

    /** The Constant ANCHONIVEL. */
    private static final int ANCHONIVEL = 56;

    /** The Constant YNIVEL. */
    private static final int YNIVEL = 13;

    /** The Constant XNIVEL. */
    private static final int XNIVEL = 169;

    /** The Constant ALTORAZA. */
    private static final int ALTORAZA = 16;

    /** The Constant ANCHORAZA. */
    private static final int ANCHORAZA = 56;

    /** The Constant YRAZA. */
    private static final int YRAZA = 71;

    /** The Constant XRAZA. */
    private static final int XRAZA = 12;

    /** The Constant ALTOCASTA. */
    private static final int ALTOCASTA = 16;

    /** The Constant ANCHOCASTA. */
    private static final int ANCHOCASTA = 56;

    /** The Constant YCASTA. */
    private static final int YCASTA = 42;

    /** The Constant XCASTA. */
    private static final int XCASTA = 12;

    /** The Constant ALTONOMBRE. */
    private static final int ALTONOMBRE = 16;

    /** The Constant ANCHONOMBRE. */
    private static final int ANCHONOMBRE = 56;

    /** The Constant YNOMBRE. */
    private static final int YNOMBRE = 13;

    /** The Constant XNOMBRE. */
    private static final int XNOMBRE = 12;

    /** The Constant DIMSTAT. */
    private static final int DIMSTAT = 100;

    /** The Constant ALTOSTAT. */
    private static final int ALTOSTAT = 321;

    /** The Constant ANCHOSTAT. */
    private static final int ANCHOSTAT = 346;

    /** The Constant LIMVACIO. */
    private static final int LIMVACIO = 5;

    /**
     * The Constant ALTO.
     */
    private static final int ALTO = 312;

    /**
     * The Constant ANCHO.
     */
    private static final int ANCHO = 363;

    /**
     * The Constant EJEY.
     */
    private static final int EJEY = -11;

    /**
     * The Constant EJEX.
     */
    private static final int EJEX = -12;

    /**
     * The content pane.
     */
    private JPanel contentPane;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The mod.
     */
    private final double mod = 1.5;

    /**
     * Create the frame.
     *
     * @param cliente
     *            se recibe cliente.
     */
    public MenuStats(final Cliente cliente) {
        paquetePersonaje = cliente.getPaquetePersonaje();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(DIMSTAT, DIMSTAT, ANCHOSTAT, ALTOSTAT);
        this.setLocationRelativeTo(null);
        this.setTitle("Estadísticas");

        contentPane = new JPanel();
        contentPane.setBorder(
                new EmptyBorder(LIMVACIO, LIMVACIO, LIMVACIO, LIMVACIO));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                Pantalla.setMenuStats(null);
                dispose();
            }
        });

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(XNOMBRE, YNOMBRE, ANCHONOMBRE, ALTONOMBRE);
        contentPane.add(lblNombre);

        JLabel lblCasta = new JLabel("Casta");
        lblCasta.setForeground(Color.WHITE);
        lblCasta.setBounds(XCASTA, YCASTA, ANCHOCASTA, ALTOCASTA);
        contentPane.add(lblCasta);

        JLabel lblRaza = new JLabel("Raza");
        lblRaza.setForeground(Color.WHITE);
        lblRaza.setBounds(XRAZA, YRAZA, ANCHORAZA, ALTORAZA);
        contentPane.add(lblRaza);

        JLabel lblNivel = new JLabel("Nivel");
        lblNivel.setForeground(Color.WHITE);
        lblNivel.setBounds(XNIVEL, YNIVEL, ANCHONIVEL, ALTONIVEL);
        contentPane.add(lblNivel);

        JLabel lblExperiencia = new JLabel("Experiencias");
        lblExperiencia.setForeground(Color.WHITE);
        lblExperiencia.setBounds(XEXP, YEXP, ANCHOEXP, ALTOEXP);
        contentPane.add(lblExperiencia);

        JLabel lblEnergia = new JLabel("Energia");
        lblEnergia.setForeground(Color.WHITE);
        lblEnergia.setBounds(XENERGIA, YENERGIA, ANCHOENERGIA, ALTOENERGIA);
        contentPane.add(lblEnergia);

        JLabel lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);
        lblSalud.setBounds(XSALUD, YSALUD, ANCHOSALUD, ALTOSALUD);
        contentPane.add(lblSalud);

        JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setBounds(XFUERZA, YFUERZA, ANCHOFUERZA, ALTOFUERZA);
        contentPane.add(lblFuerza);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setBounds(XDESTREZA, YDESTREZA, ANCHODESTREZA,
                ALTODESTREZA);
        contentPane.add(lblDestreza);

        JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);
        lblInteligencia.setBounds(XINT, YINT, ANCHOINT, ALTOINT);
        contentPane.add(lblInteligencia);

        JLabel lblAtaque = new JLabel("Ataque");
        lblAtaque.setForeground(Color.WHITE);
        lblAtaque.setBounds(XATK, YATK, ANCHOATK, ALTOATK);
        contentPane.add(lblAtaque);

        JLabel lblDefensa = new JLabel("Defensa");
        lblDefensa.setForeground(Color.WHITE);
        lblDefensa.setBounds(XDEF, YDEF, ANCHODEF, ALTODEF);
        contentPane.add(lblDefensa);

        JLabel lblMagia = new JLabel("Magia");
        lblMagia.setForeground(Color.WHITE);
        lblMagia.setBounds(XMAGIA, YMAGIA, ANCHOMAGIA, ALTOMAGIA);
        contentPane.add(lblMagia);

        JLabel lblCantidadDeItems = new JLabel("Cantidad de Items");
        lblCantidadDeItems.setForeground(Color.WHITE);
        lblCantidadDeItems.setBounds(XITEM, YITEM, ANCHOITEM, ALTOITEM);
        contentPane.add(lblCantidadDeItems);

        JLabel nmbPj = new JLabel(paquetePersonaje.getNombre());
        nmbPj.setForeground(Color.WHITE);
        nmbPj.setHorizontalAlignment(SwingConstants.RIGHT);
        nmbPj.setBounds(XPJ, YNOMBREPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(nmbPj);

        JLabel cstPj = new JLabel(paquetePersonaje.getCasta());
        cstPj.setForeground(Color.WHITE);
        cstPj.setHorizontalAlignment(SwingConstants.RIGHT);
        cstPj.setBounds(XPJ, YCASTAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(cstPj);

        JLabel rzPj = new JLabel(paquetePersonaje.getRaza());
        rzPj.setForeground(Color.WHITE);
        rzPj.setHorizontalAlignment(SwingConstants.RIGHT);
        rzPj.setBounds(XPJ, YRAZAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(rzPj);

        JLabel saludPj = new JLabel(
                String.valueOf(paquetePersonaje.getSaludTope()));
        saludPj.setForeground(Color.WHITE);
        saludPj.setHorizontalAlignment(SwingConstants.RIGHT);
        saludPj.setBounds(XPJ, YSALUDPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(saludPj);

        JLabel fzaPj = new JLabel(
                String.valueOf(paquetePersonaje.getFuerzaExtra()));
        fzaPj.setForeground(Color.WHITE);
        fzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        fzaPj.setBounds(XPJ, YFUERZAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(fzaPj);

        JLabel dstzaPj = new JLabel(
                String.valueOf(paquetePersonaje.getDestreza()));
        dstzaPj.setForeground(Color.WHITE);
        dstzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        dstzaPj.setBounds(XPJ, YDESTREZAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(dstzaPj);

        JLabel intPj = new JLabel(
                String.valueOf(paquetePersonaje.getInteligencia()));
        intPj.setForeground(Color.WHITE);
        intPj.setHorizontalAlignment(SwingConstants.RIGHT);
        intPj.setBounds(XPJ, YINTPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(intPj);

        JLabel cantItem = new JLabel(
                String.valueOf(paquetePersonaje.getCantItems()));
        cantItem.setForeground(Color.WHITE);
        cantItem.setHorizontalAlignment(SwingConstants.RIGHT);
        cantItem.setBounds(XCANTITEM, YCANTITEM, ANCHOCANTITEM, ALTOPJ);
        contentPane.add(cantItem);

        JLabel lvPj = new JLabel(String.valueOf(paquetePersonaje.getNivel()));
        lvPj.setForeground(Color.WHITE);
        lvPj.setHorizontalAlignment(SwingConstants.RIGHT);
        lvPj.setBounds(XSTATPJ, YNIVELPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(lvPj);

        JLabel xpPj = new JLabel(
                String.valueOf(paquetePersonaje.getExperiencia()));
        xpPj.setForeground(Color.WHITE);
        xpPj.setHorizontalAlignment(SwingConstants.RIGHT);
        xpPj.setBounds(XSTATPJ, YEXPERIENCIAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(xpPj);

        JLabel energiaPj = new JLabel(
                String.valueOf(paquetePersonaje.getEnergiaTope()));
        energiaPj.setForeground(Color.WHITE);
        energiaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        energiaPj.setBounds(XSTATPJ, YENERGIAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(energiaPj);

        int ataquePj = calcularAtaque(paquetePersonaje.getFuerzaExtra());
        JLabel ataPj = new JLabel(String.valueOf(ataquePj));
        ataPj.setForeground(Color.WHITE);
        ataPj.setHorizontalAlignment(SwingConstants.RIGHT);
        ataPj.setBounds(XSTATPJ, YFUERZAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(ataPj);

        JLabel defPj = new JLabel(
                String.valueOf(paquetePersonaje.getDestreza()));
        defPj.setForeground(Color.WHITE);
        defPj.setHorizontalAlignment(SwingConstants.RIGHT);
        defPj.setBounds(XSTATPJ, YDESTREZAPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(defPj);

        int intePj = calcularMagia(paquetePersonaje.getInteligencia());
        JLabel magicPj = new JLabel(String.valueOf(intePj));
        magicPj.setForeground(Color.WHITE);
        magicPj.setHorizontalAlignment(SwingConstants.RIGHT);
        magicPj.setBounds(XSTATPJ, YINTPJ, ANCHOPJ, ALTOPJ);
        contentPane.add(magicPj);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setIcon(new ImageIcon("recursos//volver.png"));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                Pantalla.setMenuStats(null);
                dispose();
            }
        });
        btnVolver.setBounds(XVOLVER, YVOLVER, ANCHOVOLVER, ALTOVOLVER);
        contentPane.add(btnVolver);
        JLabel background = new JLabel(new ImageIcon(imagenFondo
                .getScaledInstance(XDIST, YDIST, Image.SCALE_DEFAULT)));
        background.setBounds(EJEX, EJEY, ANCHO, ALTO);
        contentPane.add(background);
    }

    /**
     * Calcular magia.
     *
     * @param inteligencia
     *            the inteligencia
     * @return the int
     */
    private int calcularMagia(final int inteligencia) {
        return (int) (inteligencia * mod);
    }

    /**
     * Calcular ataque.
     *
     * @param fuerza
     *            the fuerza
     * @return the int
     */
    private int calcularAtaque(final int fuerza) {
        return (int) (fuerza * mod);
    }
}
