package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import dominio.Personaje;
import juego.Pantalla;
import recursos.Recursos;

/**
 * The Class MenuBatalla.
 */
public class MenuBatalla {

    /**
     * The Constant BOTONESCUATRO.
     */
    private static final int BOTONESCUATRO = 4;

    /**
     * The Constant BOTONESTRES.
     */
    private static final int BOTONESTRES = 3;

    /**
     * The Constant BOTONESDOS.
     */
    private static final int BOTONESDOS = 2;

    /**
     * The Constant BOTONESUNO.
     */
    private static final int BOTONESUNO = 1;

    /**
     * The Constant BOTONESCERO.
     */
    private static final int BOTONESCERO = 0;

    /**
     * The Constant BOTONESCINCO.
     */
    private static final int BOTONESCINCO = 5;

    /**
     * The Constant SUMAYGETHABILIDADES2.
     */
    private static final int SUMAYGETHABILIDADES2 = 168;

    /**
     * The Constant SUMAYGETHABILIDADES.
     */
    private static final int SUMAYGETHABILIDADES = 94;

    /**
     * The Constant SUMAXHABILIDADESCASTA2.
     */
    private static final int SUMAXHABILIDADESCASTA2 = 442;

    /**
     * The Constant SUMAXHABILIDADESCASTA.
     */
    private static final int SUMAXHABILIDADESCASTA = 268;

    /**
     * The Constant SUMAXHABILIDADESRAZA.
     */
    private static final int SUMAXHABILIDADESRAZA = 95;

    /**
     * The Constant TAMANIOCATORCE.
     */
    private static final int TAMANIOCATORCE = 14;

    /**
     * The Constant SUMAYRECTANGULO.
     */
    private static final int SUMAYRECTANGULO = 5;

    /**
     * The Constant ANCHURA.
     */
    private static final int ANCHURA = 20;

    /**
     * The Constant x.
     */
    private static final int X = 100;

    /**
     * The Constant y.
     */
    private static final int Y = 380;

    /**
     * The Constant anchoBoton.
     */
    private static final int ANCHOBOTON = 40;

    /**
     * The Constant botones.
     */
    private static final int[][] BOTONES = {{X + 48, Y + 72 },
            {X + 48, Y + 146 }, {X + 221, Y + 72 }, {X + 221, Y + 146 },
            {X + 394, Y + 72 }, {X + 394, Y + 146 } };

    /**
     * The habilitado.
     */
    private boolean habilitado;

    /**
     * The personaje.
     */
    private Personaje personaje;

    /**
     * Instantiates a new menu batalla.
     *
     * @param habilitadoParam
     *            the habilitado
     * @param personajeParam
     *            the personaje
     */
    public MenuBatalla(final boolean habilitadoParam,
            final Personaje personajeParam) {
        this.habilitado = habilitadoParam;
        this.personaje = personajeParam;
    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     */
    public void graficar(final Graphics g) {

        if (habilitado) {
            g.drawImage(Recursos.getMenuBatalla(), X, Y, null);
        } else {
            g.drawImage(Recursos.getMenuBatallaDeshabilitado(), X, Y, null);
        }

        // Dibujo los boones
        g.drawImage(
                Recursos.getHabilidades()
                        .get(personaje.getHabilidadesRaza()[0]),
                BOTONES[BOTONESCERO][BOTONESCERO],
                BOTONES[BOTONESCERO][BOTONESUNO], ANCHOBOTON, ANCHOBOTON, null);
        g.drawImage(
                Recursos.getHabilidades()
                        .get(personaje.getHabilidadesRaza()[1]),
                BOTONES[BOTONESUNO][BOTONESCERO],
                BOTONES[BOTONESUNO][BOTONESUNO], ANCHOBOTON, ANCHOBOTON, null);
        g.drawImage(
                Recursos.getHabilidades()
                        .get(personaje.getHabilidadesCasta()[0]),
                BOTONES[BOTONESDOS][BOTONESCERO],
                BOTONES[BOTONESDOS][BOTONESUNO], ANCHOBOTON, ANCHOBOTON, null);
        g.drawImage(
                Recursos.getHabilidades()
                        .get(personaje.getHabilidadesCasta()[1]),
                BOTONES[BOTONESTRES][BOTONESCERO],
                BOTONES[BOTONESTRES][BOTONESUNO], ANCHOBOTON, ANCHOBOTON, null);
        g.drawImage(
                Recursos.getHabilidades()
                        .get(personaje.getHabilidadesCasta()[2]),
                BOTONES[BOTONESCUATRO][BOTONESCERO],
                BOTONES[BOTONESCUATRO][BOTONESUNO], ANCHOBOTON, ANCHOBOTON,
                null);
        g.drawImage(Recursos.getHabilidades().get("Ser Energizado"),
                BOTONES[BOTONESCINCO][BOTONESCERO],
                BOTONES[BOTONESCINCO][BOTONESUNO], ANCHOBOTON, ANCHOBOTON,
                null);

        // Dibujo las leyendas
        g.setFont(new Font("Book Antiqua", 1, TAMANIOCATORCE));
        g.drawString(personaje.getHabilidadesRaza()[0],
                X + SUMAXHABILIDADESRAZA, Y + SUMAYGETHABILIDADES);
        g.drawString(personaje.getHabilidadesRaza()[1],
                X + SUMAXHABILIDADESRAZA, Y + SUMAYGETHABILIDADES2);
        g.drawString(personaje.getHabilidadesCasta()[0],
                X + SUMAXHABILIDADESCASTA, Y + SUMAYGETHABILIDADES);
        g.drawString(personaje.getHabilidadesCasta()[1],
                X + SUMAXHABILIDADESCASTA, Y + SUMAYGETHABILIDADES2);
        g.drawString(personaje.getHabilidadesCasta()[2],
                X + SUMAXHABILIDADESCASTA2, Y + SUMAYGETHABILIDADES);
        g.drawString("Ser energizado", X + SUMAXHABILIDADESCASTA2,
                Y + SUMAYGETHABILIDADES2);

        // Dibujo el turno de quien es
        g.setColor(Color.WHITE);
        if (habilitado) {
            Pantalla.centerString(g,
                    new Rectangle(X, Y + SUMAYRECTANGULO,
                            Recursos.getMenuBatalla().getWidth(), ANCHURA),
                    "Mi Turno");
        } else {
            Pantalla.centerString(g,
                    new Rectangle(X, Y + SUMAYRECTANGULO,
                            Recursos.getMenuBatalla().getWidth(), ANCHURA),
                    "Turno Rival");
        }
    }

    /**
     * Gets the boton clickeado.
     *
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return the boton clickeado
     */
    public int getBotonClickeado(final int mouseX, final int mouseY) {
        if (!habilitado) {
            return 0;
        }
        for (int i = 0; i < BOTONES.length; i++) {
            if (mouseX >= BOTONES[i][0] && mouseX <= BOTONES[i][0] + ANCHOBOTON
                    && mouseY >= BOTONES[i][1]
                    && mouseY <= BOTONES[i][1] + ANCHOBOTON) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * Click en menu.
     *
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnMenu(final int mouseX, final int mouseY) {
        if (mouseX >= X && mouseX <= X + Recursos.getMenuBatalla().getWidth()
                && mouseY >= Y
                && mouseY <= Y + Recursos.getMenuBatalla().getHeight()) {
            return habilitado;
        }
        return false;
    }

    /**
     * Sets the habilitado.
     *
     * @param b
     *            the new habilitado
     */
    public void setHabilitado(final boolean b) {
        habilitado = b;
    }
}
