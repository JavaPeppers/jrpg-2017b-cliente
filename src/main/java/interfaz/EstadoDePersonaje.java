package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * The Class EstadoDePersonaje.
 */
public final class EstadoDePersonaje {

    /**
     * The Constant SUMAXPERSONAJE2.
     */
    private static final int SUMAXPERSONAJE2 = 59;

    /**
     * The Constant SUMAYPERSONAJE3.
     */
    private static final int SUMAYPERSONAJE3 = 70;

    /**
     * The Constant SUMAYBARRAEXPERIENCIA.
     */
    private static final int SUMAYBARRAEXPERIENCIA = 65;

    /**
     * The Constant SUMAXBARRAEXPERIENCIA.
     */
    private static final int SUMAXBARRAEXPERIENCIA = 77;

    /**
     * The Constant SUMAYPERSONAJE2.
     */
    private static final int SUMAYPERSONAJE2 = 52;

    /**
     * The Constant SUMAYBARRAENERGIA.
     */
    private static final int SUMAYBARRAENERGIA = 42;

    /**
     * The Constant SUMAXBARRAENERGIA.
     */
    private static final int SUMAXBARRAENERGIA = 80;

    /**
     * The Constant SUMAYPERSONAJE.
     */
    private static final int SUMAYPERSONAJE = 37;

    /**
     * The Constant SUMAXPERSONAJE.
     */
    private static final int SUMAXPERSONAJE = 132;

    /**
     * The Constant SUMAYBARRASALUD.
     */
    private static final int SUMAYBARRASALUD = 26;

    /**
     * The Constant SUMAXBARRASALUD.
     */
    private static final int SUMAXBARRASALUD = 80;

    /**
     * The Constant TAMANIOFONT.
     */
    private static final int TAMANIOFONT = 10;

    /**
     * The Constant SUMAYMINIATURAPERSONAJE.
     */
    private static final int SUMAYMINIATURAPERSONAJE = 9;

    /**
     * The Constant SUMAXMINIATURAPERSONAJE.
     */
    private static final int SUMAXMINIATURAPERSONAJE = 10;

    /**
     * Instantiates a new estado de personaje.
     */
    private EstadoDePersonaje() {

    }

    /**
     * The Constant TAMANIODIEZ.
     */
    private static final int TAMANIODIEZ = 10;

    /**
     * The Constant TAMANIOOCHO.
     */
    private static final int TAMANIOOCHO = 8;

    /**
     * The Constant ANCHOBARRA.
     */
    private static final int ANCHOBARRA = 122;

    /**
     * The Constant ALTOSALUD.
     */
    private static final int ALTOSALUD = 14;

    /**
     * The Constant ALTOENERGIA.
     */
    private static final int ALTOENERGIA = 14;

    /**
     * The Constant ALTOEXPERIENCIA.
     */
    private static final int ALTOEXPERIENCIA = 6;

    /**
     * The Constant ALTOMINIATURA.
     */
    private static final int ALTOMINIATURA = 64;

    /**
     * The Constant ANCHOMINIATURA.
     */
    private static final int ANCHOMINIATURA = 64;

    /**
     * Dibujar estado de personaje.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param personaje
     *            the personaje
     * @param miniaturaPersonaje
     *            the miniatura personaje
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
            final int y, final Personaje personaje,
            final BufferedImage miniaturaPersonaje) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + SUMAXMINIATURAPERSONAJE,
                y + SUMAYMINIATURAPERSONAJE, ANCHOMINIATURA, ALTOMINIATURA,
                null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA)
                    / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOFONT));
        g.drawImage(Recursos.getBarraSalud(), x + SUMAXBARRASALUD,
                y + SUMAYBARRASALUD, drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(personaje.getSalud()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA)
                    / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.getBarraEnergia(), x + SUMAXBARRAENERGIA,
                y + SUMAYBARRAENERGIA, drawBarra, ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergia()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE2);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOOCHO));
        g.drawImage(Recursos.getBarraExperiencia(), x + SUMAXBARRAEXPERIENCIA,
                y + SUMAYBARRAEXPERIENCIA, drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE3);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + SUMAXPERSONAJE2,
                y + SUMAYPERSONAJE3);

    }

    /**
     * Dibujar estado de personaje.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param personaje
     *            the personaje
     * @param miniaturaPersonaje
     *            the miniatura personaje
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
            final int y, final PaquetePersonaje personaje,
            final BufferedImage miniaturaPersonaje) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + SUMAXMINIATURAPERSONAJE,
                y + SUMAYMINIATURAPERSONAJE, ANCHOMINIATURA, ALTOMINIATURA,
                null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.drawImage(Recursos.getBarraSalud(), x + SUMAXBARRASALUD,
                y + SUMAYBARRASALUD, ANCHOBARRA, ALTOSALUD, null);
        g.drawString(
                String.valueOf(personaje.getSaludTope()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE);

        g.drawImage(Recursos.getBarraEnergia(), x + SUMAXBARRAENERGIA,
                y + SUMAYBARRAENERGIA, ANCHOBARRA, ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergiaTope()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE2);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOOCHO));
        g.drawImage(Recursos.getBarraExperiencia(), x + SUMAXBARRAEXPERIENCIA,
                y + SUMAYBARRAEXPERIENCIA, drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + SUMAXPERSONAJE, y + SUMAYPERSONAJE3);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + SUMAXPERSONAJE2,
                y + SUMAYPERSONAJE3);
    }
}
