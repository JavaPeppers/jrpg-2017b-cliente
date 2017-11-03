package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.Enemigo;
import mensajeria.PaqueteEnemigo;
import recursos.Recursos;

/**
 * The Class EstadoEnemigo.
 */
public final class EstadoEnemigo {

    /**
     * The Constant SUMAYENEMIGO.
     */
    private static final int SUMAYENEMIGO = 70;

    /**
     * The Constant SUMAXENEMIGO.
     */
    private static final int SUMAXENEMIGO = 59;

    /**
     * The Constant SUMAYSALUDTOPE.
     */
    private static final int SUMAYSALUDTOPE = 37;

    /**
     * The Constant SUMAXSALUDTOPE.
     */
    private static final int SUMAXSALUDTOPE = 132;

    /**
     * The Constant SUMAYBARRASALUD.
     */
    private static final int SUMAYBARRASALUD = 26;

    /**
     * The Constant SUMAXBARRASALUD.
     */
    private static final int SUMAXBARRASALUD = 80;

    /**
     * The Constant TAMANIODIEZ.
     */
    private static final int TAMANIODIEZ = 10;

    /**
     * The Constant SUMAYMINIATURAENEMIGO.
     */
    private static final int SUMAYMINIATURAENEMIGO = 9;

    /**
     * The Constant SUMAXMINIATURAENEMIGO.
     */
    private static final int SUMAXMINIATURAENEMIGO = 10;

    /**
     * Instantiates a new estado enemigo.
     */
    private EstadoEnemigo() {

    }

    /**
     * The Constant ANCHOBARRA.
     */
    private static final int ANCHOBARRA = 122;

    /**
     * The Constant ALTOSALUD.
     */
    private static final int ALTOSALUD = 14;

    /**
     * The Constant ALTOMINIATURA.
     */
    private static final int ALTOMINIATURA = 64;

    /**
     * The Constant ANCHOMINIATURA.
     */
    private static final int ANCHOMINIATURA = 64;

    /**
     * Dibujar estado de enemigo.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param enemigo
     *            the enemigo
     * @param miniaturaEnemigo
     *            the miniatura enemigo
     */
    public static void dibujarEstadoDeEnemigo(final Graphics g, final int x,
            final int y, final Enemigo enemigo,
            final BufferedImage miniaturaEnemigo) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaEnemigo, x + SUMAXMINIATURAENEMIGO,
                y + SUMAYMINIATURAENEMIGO, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (enemigo.getSalud() == enemigo.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (enemigo.getSalud() * ANCHOBARRA)
                    / enemigo.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.drawImage(Recursos.getBarraSalud(), x + SUMAXBARRASALUD,
                y + SUMAYBARRASALUD, drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getSalud()) + " / "
                        + String.valueOf(enemigo.getSaludTope()),
                x + SUMAXSALUDTOPE, y + SUMAYSALUDTOPE);

        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNivel()), x + SUMAXENEMIGO,
                y + SUMAYENEMIGO);

    }

    /**
     * Dibujar estado de enemigo.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param enemigo
     *            the enemigo
     * @param miniaturaEnemigo
     *            the miniatura enemigo
     */
    public static void dibujarEstadoDeEnemigo(final Graphics g, final int x,
            final int y, final PaqueteEnemigo enemigo,
            final BufferedImage miniaturaEnemigo) {

        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaEnemigo, x + SUMAXMINIATURAENEMIGO,
                y + SUMAYMINIATURAENEMIGO, ANCHOMINIATURA, ALTOMINIATURA, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.drawImage(Recursos.getBarraSalud(), x + SUMAXBARRASALUD,
                y + SUMAYBARRASALUD, drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getSaludTope()) + " / "
                        + String.valueOf(enemigo.getSaludTope()),
                x + SUMAXSALUDTOPE, y + SUMAYSALUDTOPE);
        g.setFont(new Font("Tahoma", Font.PLAIN, TAMANIODIEZ));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNivel()), x + SUMAXENEMIGO,
                y + SUMAYENEMIGO);
    }
}
