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

        g.drawImage(Recursos.estadoPersonaje, x, y, null);

        g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA,
                ALTOMINIATURA, null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA)
                    / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, 10));
        g.drawImage(Recursos.barraSalud, x + 80, y + 26, drawBarra, ALTOSALUD,
                null);
        g.drawString(
                String.valueOf(personaje.getSalud()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + 132, y + 37);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA)
                    / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.barraEnergia, x + 80, y + 42, drawBarra,
                ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergia()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + 132, y + 52);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, 8));
        g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra,
                ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + 132, y + 70);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);

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

        g.drawImage(Recursos.estadoPersonaje, x, y, null);

        g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA,
                ALTOMINIATURA, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.drawImage(Recursos.barraSalud, x + 80, y + 26, ANCHOBARRA, ALTOSALUD,
                null);
        g.drawString(
                String.valueOf(personaje.getSaludTope()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + 132, y + 37);

        g.drawImage(Recursos.barraEnergia, x + 80, y + 42, ANCHOBARRA,
                ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergiaTope()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + 132, y + 52);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIOOCHO));
        g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra,
                ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + 132, y + 70);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);
    }
}
