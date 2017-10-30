package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Class Tile.
 */
public class Tile {

    /**
     * The tiles.
     */
    private static Tile[] tiles = new Tile[256];

    /**
     * The aubenor.
     */
    private static Tile[] aubenor;

    /**
     * The aris.
     */
    private static Tile[] aris;

    /**
     * es el piso de aubenor por defecto si queres llamarlo asi, es gris.
     */
    private static int arisBase = 3;

    /**
     * The aubenor base.
     */
    private static int aubenorBase = 3;

    /**
     * The Constant ANCHO.
     */
    public static final int ANCHO = 64;

    /**
     * The Constant ALTO.
     */
    public static final int ALTO = 32;

    /**
     * The textura.
     */
    private BufferedImage textura;

    /**
     * The id.
     */
    private final int id;

    /**
     * The es solido.
     */
    private boolean esSolido;

    /**
     * The ancho.
     */
    private int ancho;

    /**
     * The alto.
     */
    private int alto;

    /**
     * Instantiates a new tile.
     *
     * @param texturaParam
     *            the textura param
     * @param idParam
     *            the id param
     * @param esSolidoParam
     *            the es solido param
     */
    public Tile(final BufferedImage texturaParam, final int idParam,
            final boolean esSolidoParam) {
        this.textura = texturaParam;
        this.id = idParam;
        tiles[id] = this;
        this.esSolido = esSolidoParam;
    }

    /**
     * Instantiates a new tile.
     *
     * @param texturaParam
     *            the textura param
     * @param idParam
     *            the id param
     * @param esSolidoParam
     *            the es solido param
     * @param anchoParam
     *            the ancho param
     * @param altoParam
     *            the alto param
     */
    public Tile(final BufferedImage texturaParam, final int idParam,
            final boolean esSolidoParam, final int anchoParam,
            final int altoParam) {
        this.textura = texturaParam;
        this.id = idParam;
        tiles[id] = this;
        this.ancho = anchoParam;
        this.alto = altoParam;
        this.esSolido = esSolidoParam;
    }

    /**
     * Actualizar.
     */
    public void actualizar() {

    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void graficar(final Graphics g, final int x, final int y) {
        g.drawImage(textura, x, y, ANCHO, ALTO, null);
    }

    /**
     * Graficar.
     *
     * @param g
     *            the g
     * @param x
     *            the x
     * @param y
     *            the y
     * @param width
     *            the width
     * @param height
     *            the height
     */
    public void graficar(final Graphics g, final int x, final int y,
            final int width, final int height) {
        g.drawImage(textura, x, y, width, height, null);
    }

    /**
     * Sets the solido.
     *
     * @param solidezParam
     *            the new solido
     */
    public void setSolido(final boolean solidezParam) {
        esSolido = solidezParam;
    }

    /**
     * Es solido.
     *
     * @return true, if successful
     */
    public boolean esSolido() {
        return esSolido;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the ancho.
     *
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Gets the alto.
     *
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Getter del titulo.
     * @return the tiles
     */
    public static Tile[] getTiles() {
        return tiles;
    }

    /**
     * Setter del titulo.
     * @param tilesParam the tiles to set
     */
    public static void setTiles(final Tile[] tilesParam) {
        Tile.tiles = tilesParam;
    }

    /**
     * @return the textura
     */
    public BufferedImage getTextura() {
        return textura;
    }

    /**
     * @param texturaParam the textura to set
     */
    public void setTextura(final BufferedImage texturaParam) {
        this.textura = texturaParam;
    }

    /**
     * @return the aubenor
     */
    public static Tile[] getAubenor() {
        return aubenor;
    }

    /**
     * @param aubenorParam the aubenor to set
     */
    public static void setAubenor(final Tile[] aubenorParam) {
        Tile.aubenor = aubenorParam;
    }

    /**
     * @return the aris
     */
    public static Tile[] getAris() {
        return aris;
    }

    /**
     * @param arisParam the aris to set
     */
    public static void setAris(final Tile[] arisParam) {
        Tile.aris = arisParam;
    }

    /**
     * @return the arisBase
     */
    public static int getArisBase() {
        return arisBase;
    }

    /**
     * @param arisBaseParam the arisBase to set
     */
    public static void setArisBase(final int arisBaseParam) {
        Tile.arisBase = arisBaseParam;
    }

    /**
     * @return the aubenorBase
     */
    public static int getAubenorBase() {
        return aubenorBase;
    }

    /**
     * @param aubenorBaseParam the aubenorBase to set
     */
    public static void setAubenorBase(final int aubenorBaseParam) {
        Tile.aubenorBase = aubenorBaseParam;
    }
}
