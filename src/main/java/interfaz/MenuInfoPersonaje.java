package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class MenuInfoPersonaje.
 */
public class MenuInfoPersonaje {

    /**
     * The Constant POSICIONVECTORPESONAJE.
     */
    private static final int POSICIONVECTORPESONAJE = 0;

    /**
     * The Constant POSICIONMAPAPERSONAJE.
     */
    private static final int POSICIONMAPAPERSONAJE = 6;

    /**
     * The Constant SUMAMOUSEY4.
     */
    private static final int SUMAMOUSEY4 = 405;

    /**
     * The Constant SUMAMOUSEY3.
     */
    private static final int SUMAMOUSEY3 = 380;

    /**
     * The Constant SUMAMOUSEX2.
     */
    private static final int SUMAMOUSEX2 = 250;

    /**
     * The Constant SUMAMOUSEX.
     */
    private static final int SUMAMOUSEX = 50;

    /**
     * The Constant SUMAMOUSEY2.
     */
    private static final int SUMAMOUSEY2 = 36;

    /**
     * The Constant SUMAMOUSEY.
     */
    private static final int SUMAMOUSEY = 12;

    /**
     * The Constant SUMAMENUANCHURA.
     */
    private static final int SUMAMENUANCHURA = 4;

    /**
     * The Constant RESTAMENUANCHURA.
     */
    private static final int RESTAMENUANCHURA = 24;

    /**
     * The Constant SUMAYPERSONAJEEXPERIENCIA.
     */
    private static final int SUMAYPERSONAJEEXPERIENCIA = 320;

    /**
     * The Constant SUMAXPERSONAJEEXPERIENCIA.
     */
    private static final int SUMAXPERSONAJEEXPERIENCIA = 150;

    /**
     * The Constant SUMAYPERSONAJECASTA.
     */
    private static final int SUMAYPERSONAJECASTA = 260;

    /**
     * The Constant SUMAYPERSONAJENIVEL.
     */
    private static final int SUMAYPERSONAJENIVEL = 290;

    /**
     * The Constant SUMAXPERSONAJENIVEL.
     */
    private static final int SUMAXPERSONAJENIVEL = 100;

    /**
     * The Constant SUMAXPERSONAJECASTA.
     */
    private static final int SUMAXPERSONAJECASTA = 100;

    /**
     * The Constant SUMAYEXPERIENCIA.
     */
    private static final int SUMAYEXPERIENCIA = 320;

    /**
     * The Constant SUMAYNIVEL.
     */
    private static final int SUMAYNIVEL = 290;

    /**
     * The Constant SUMAYCASTA.
     */
    private static final int SUMAYCASTA = 260;

    /**
     * The Constant SUMAXEXPERIENCIA.
     */
    private static final int SUMAXEXPERIENCIA = 30;

    /**
     * The Constant SUMAXNIVEL.
     */
    private static final int SUMAXNIVEL = 30;

    /**
     * The Constant SUMAXCASTA.
     */
    private static final int SUMAXCASTA = 30;

    /**
     * The Constant SUMAYRECTANGULO10.
     */
    private static final int SUMAYRECTANGULO10 = 240;

    /**
     * The Constant SUMAYRECTANGULO11.
     */
    private static final int SUMAYRECTANGULO11 = 325;

    /**
     * The Constant TAMANIO62.
     */
    private static final int TAMANIO62 = 62;

    /**
     * The Constant TAMANIODIECIOCHO.
     */
    private static final int TAMANIODIECIOCHO = 18;

    /**
     * The Constant SUMAYRECTANGULO9.
     */
    private static final int SUMAYRECTANGULO9 = 330;

    /**
     * The Constant SUMAYRECTANGULO8.
     */
    private static final int SUMAYRECTANGULO8 = 230;

    /**
     * The Constant SUMAYRECTANGULO7.
     */
    private static final int SUMAYRECTANGULO7 = 310;

    /**
     * The Constant SUMAYRECTANGULO6.
     */
    private static final int SUMAYRECTANGULO6 = 290;

    /**
     * The Constant SUMAYRECTANGULO5.
     */
    private static final int SUMAYRECTANGULO5 = 270;

    /**
     * The Constant SUMAYRECTANGULO4.
     */
    private static final int SUMAYRECTANGULO4 = 250;

    /**
     * The Constant SUMAYRECTANGULO3.
     */
    private static final int SUMAYRECTANGULO3 = 200;

    /**
     * The Constant TAMANIOCATORCE.
     */
    private static final int TAMANIOCATORCE = 14;

    /**
     * The Constant SUMAYGETPERSONAJE.
     */
    private static final int SUMAYGETPERSONAJE = 70;

    /**
     * The Constant DIVISORANCHOPERSONAJE.
     */
    private static final int DIVISORANCHOPERSONAJE = 2;

    /**
     * The Constant DIVISORXGETPERSONAJE.
     */
    private static final int DIVISORXGETPERSONAJE = 2;

    /**
     * The Constant SUMAYBOTONMENU.
     */
    private static final int SUMAYBOTONMENU = 380;

    /**
     * The Constant SUMAXBOTONMENU.
     */
    private static final int SUMAXBOTONMENU = 50;

    /**
     * The Constant ALTORECTANGULO.
     */
    private static final int ALTORECTANGULO = 25;

    /**
     * The Constant ANCHORECTANGULO.
     */
    private static final int ANCHORECTANGULO = 200;

    /**
     * The Constant SUMAYRECTANGULO2.
     */
    private static final int SUMAYRECTANGULO2 = 380;

    /**
     * The Constant SUMAXRECTANGULO.
     */
    private static final int SUMAXRECTANGULO = 50;

    /**
     * The Constant SUMAYRECTANGULO.
     */
    private static final int SUMAYRECTANGULO = 15;

    /**
     * The Constant TAMANIOVEINTE.
     */
    private static final int TAMANIOVEINTE = 20;

    /**
     * The Constant ANCHURAALTURA.
     */
    private static final int ANCHURAALTURA = 128;

    /**
     * The Constant anchoPersonaje.
     */
    private static final int ANCHOPERSONAJE = 128;

    /**
     * The Constant menu.
     */
    private static final BufferedImage MENU = Recursos.getMenuEnemigo();

    /**
     * The Constant menuBatallar.
     */
    public static final int MENUBATALLAR = 0;

    /**
     * The Constant menuInformacion.
     */
    public static final int MENUINFORMACION = 1;

    /**
     * The Constant menuSubirNivel.
     */
    public static final int MENUSUBIRNIVEL = 2;

    /**
     * The Constant menuGanarBatalla.
     */
    public static final int MENUGANARBATALLA = 3;

    /**
     * The Constant menuPerderBatalla.
     */
    public static final int MENUPERDERBATALLA = 4;

    /**
     * The Constant menuGanarItem.
     */
    public static final int MENUGANARITEM = 5;

    /**
     * The Constant menuComerciar.
     */
    public static final int MENUCOMERCIAR = 6;

    /**
     * The Constant leyendaBoton.
     */
    private static final String[] LEYENDABOTON = {"Batallar", "Volver",
            "Aceptar", "Aceptar", "Aceptar", "Aceptar", "Comerciar" };

    /**
     * The x.
     */
    private int x;

    /**
     * The y.
     */
    private int y;

    /**
     * The personaje.
     */
    private PaquetePersonaje personaje;

    /**
     * Instantiates a new menu info personaje.
     *
     * @param xParam
     *            the x
     * @param yParam
     *            the y
     * @param personajeParam
     *            the personaje
     */
    public MenuInfoPersonaje(final int xParam, final int yParam,
            final PaquetePersonaje personajeParam) {
        this.x = xParam;
        this.y = yParam;
        this.personaje = personajeParam;
    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     * @param tipoMenu
     *            the tipo menu
     */
    public void graficar(final Graphics g, final int tipoMenu) {

        // dibujo el menu
        g.drawImage(MENU, x, y, null);

        // dibujo el personaje
        g.drawImage(
                Recursos.getPersonaje().get(personaje.getRaza())
                        .get(POSICIONMAPAPERSONAJE)[POSICIONVECTORPESONAJE],
                x + MENU.getWidth() / DIVISORXGETPERSONAJE
                        - ANCHOPERSONAJE / DIVISORANCHOPERSONAJE,
                y + SUMAYGETPERSONAJE, ANCHURAALTURA, ANCHURAALTURA, null);

        // muestro el nombre
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", 1, TAMANIOVEINTE));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO, MENU.getWidth(), 0),
                personaje.getNombre());

        // Grafico la leyenda segun el tipo de menu
        switch (tipoMenu) {
        case MENUBATALLAR:
            graficarMenuInformacion(g);
            break;
        case MENUINFORMACION:
            graficarMenuInformacion(g);
            break;
        case MENUSUBIRNIVEL:
            graficarMenuSubirNivel(g);
            break;
        case MENUGANARBATALLA:
            graficarMenuGanarBatalla(g);
            break;
        case MENUPERDERBATALLA:
            graficarMenuPerderBatalla(g);
            break;
        case MENUGANARITEM:
            graficarMenuItem(g);
            break;
        case MENUCOMERCIAR:
            graficarMenuComerciar(g);
            break;
        default:
        }

        // muestro los botones
        g.setFont(new Font("Book Antiqua", 1, TAMANIOVEINTE));
        g.drawImage(Recursos.getBotonMenu(), x + SUMAXBOTONMENU,
                y + SUMAYBOTONMENU, ANCHORECTANGULO, ALTORECTANGULO, null);
        g.setColor(Color.WHITE);
        Pantalla.centerString(g,
                new Rectangle(x + SUMAXRECTANGULO, y + SUMAYRECTANGULO2,
                        ANCHORECTANGULO, ALTORECTANGULO),
                LEYENDABOTON[tipoMenu]);
    }

    /**
     * Graficar menu perder batalla.
     *
     * @param g
     *            the g
     */
    private void graficarMenuPerderBatalla(final Graphics g) {

        // Informo que perdio la batalla
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                "¡Has sido derrotado!");

        g.setFont(new Font("Book Antiqua", 0, TAMANIOCATORCE));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO4, MENU.getWidth(), 0),
                "¡No te rindas! Sigue luchando");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO5, MENU.getWidth(), 0),
                "contra los demás personajes");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO6, MENU.getWidth(), 0),
                "para aumentar tu nivel y");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO7, MENU.getWidth(), 0),
                "mejorar tus atributos.");
    }

    /**
     * Graficar menu ganar batalla.
     *
     * @param g
     *            the g
     */
    private void graficarMenuGanarBatalla(final Graphics g) {

        // Informo que gano la batalla
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                "¡Has derrotado");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO8, MENU.getWidth(), 0),
                "a tu enemigo!");

        g.setFont(new Font("Book Antiqua", 0, TAMANIOCATORCE));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO5, MENU.getWidth(), 0),
                "¡Felicitaciones! Has derrotado");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO6, MENU.getWidth(), 0),
                "a tu oponente, sigue así");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO7, MENU.getWidth(), 0),
                "para lograr subir de nivel");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO9, MENU.getWidth(), 0),
                "y mejorar tus atributos.");

    }

    /**
     * Graficar menu subir nivel.
     *
     * @param g
     *            the g
     */
    private void graficarMenuSubirNivel(final Graphics g) {

        // Informo que subio de nivel
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                "¡Has subido de nivel!");

        g.setFont(new Font("Book Antiqua", 0, TAMANIODIECIOCHO));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO10, MENU.getWidth(), 0),
                "¡Felicitaciones!");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO5, MENU.getWidth(), 0),
                "Nuevo Nivel");
        g.setFont(new Font("Book Antiqua", 1, TAMANIO62));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO11, MENU.getWidth(), 0),
                String.valueOf(personaje.getNivel()));

    }

    /**
     * Graficar menu informacion.
     *
     * @param g
     *            the g
     */
    public void graficarMenuInformacion(final Graphics g) {

        // muestro los nombres de los atributos
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                personaje.getRaza());
        g.drawString("Casta: ", x + SUMAXCASTA, y + SUMAYCASTA);
        g.drawString("Nivel: ", x + SUMAXNIVEL, y + SUMAYNIVEL);
        g.drawString("Experiencia: ", x + SUMAXEXPERIENCIA,
                y + SUMAYEXPERIENCIA);

        // muestro los atributos
        g.setFont(new Font("Book Antiqua", 0, TAMANIOVEINTE));
        g.drawString(personaje.getCasta(), x + SUMAXPERSONAJECASTA,
                y + SUMAYPERSONAJECASTA);
        g.drawString(personaje.getNivel() + " ", x + SUMAXPERSONAJENIVEL,
                y + SUMAYPERSONAJENIVEL);
        g.drawString(
                personaje.getExperiencia() + " / "
                        + Personaje.getTablaDeNiveles()[personaje.getNivel()
                                + 1],
                x + SUMAXPERSONAJEEXPERIENCIA, y + SUMAYPERSONAJEEXPERIENCIA);

    }

    /**
     * Graficar menu item.
     *
     * @param g
     *            the g
     */
    private void graficarMenuItem(final Graphics g) {

        // Informo que subio de nivel
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                "¡Aca iria algo!");

        g.setFont(new Font("Book Antiqua", 0, TAMANIODIECIOCHO));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO10, MENU.getWidth(), 0),
                "¡Aca otra cosa!");
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO5, MENU.getWidth(), 0),
                "Nuevo Nivel");
        g.setFont(new Font("Book Antiqua", 1, TAMANIO62));
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO11, MENU.getWidth(), 0),
                String.valueOf(personaje.getNivel()));

    }

    /**
     * Graficar menu comerciar.
     *
     * @param g
     *            the g
     */
    private void graficarMenuComerciar(final Graphics g) {

        // muestro los nombres de los atributos
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + SUMAYRECTANGULO3, MENU.getWidth(), 0),
                personaje.getRaza());
        g.drawString("Casta: ", x + SUMAXCASTA, y + SUMAYCASTA);
        g.drawString("Nivel: ", x + SUMAXNIVEL, y + SUMAYNIVEL);
        g.drawString("Experiencia: ", x + SUMAXEXPERIENCIA,
                y + SUMAYEXPERIENCIA);

        // muestro los atributos
        g.setFont(new Font("Book Antiqua", 0, TAMANIOVEINTE));
        g.drawString(personaje.getCasta(), x + SUMAXPERSONAJECASTA,
                y + SUMAYPERSONAJECASTA);
        g.drawString(personaje.getNivel() + " ", x + SUMAXPERSONAJENIVEL,
                y + SUMAYPERSONAJENIVEL);
        g.drawString(
                personaje.getExperiencia() + " / "
                        + Personaje.getTablaDeNiveles()[personaje.getNivel()
                                + 1],
                x + SUMAXPERSONAJEEXPERIENCIA, y + SUMAYPERSONAJEEXPERIENCIA);

    }

    /**
     * Click en boton.
     *
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnBoton(final int mouseX, final int mouseY) {
        return (mouseX >= x + SUMAMOUSEX && mouseX <= x + SUMAMOUSEX2
                && mouseY >= y + SUMAMOUSEY3
                && mouseY <= y + SUMAMOUSEY4);
    }
    /**
     * Click en cerrar.
     *
     * @param mouseX
     *            the mouse X
     * @param mouseY
     *            the mouse Y
     * @return true, if successful
     */
    public boolean clickEnCerrar(final int mouseX, final int mouseY) {
        return (mouseX >= x + MENU.getWidth() - RESTAMENUANCHURA
                && mouseX <= x + MENU.getWidth() + SUMAMENUANCHURA
                && mouseY >= y + SUMAMOUSEY && mouseY <= y + SUMAMOUSEY2);
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
        return (mouseX >= x && mouseX <= x + MENU.getWidth() && mouseY >= y
                && mouseY <= y + MENU.getHeight());
    }
}
