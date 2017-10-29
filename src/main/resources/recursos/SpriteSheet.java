package recursos;

import java.awt.image.BufferedImage;

/**
 * The Class SpriteSheet.
 */
public class SpriteSheet {

    /**
     * The sprite.
     */
    private BufferedImage sprite;

    /**
     * Instantiates a new sprite sheet.
     *
     * @param spriteParam
     *            the sprite
     */
    public SpriteSheet(final BufferedImage spriteParam) {
        this.sprite = spriteParam;
    }

    /**
     * Gets the tile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param ancho
     *            the ancho
     * @param alto
     *            the alto
     * @return the tile
     */
    public BufferedImage getTile(final int x, final int y, final int ancho,
            final int alto) {
        return sprite.getSubimage(x, y, ancho, alto);
    }
}
