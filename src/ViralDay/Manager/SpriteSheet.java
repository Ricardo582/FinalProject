package ViralDay.Manager;

import java.awt.image.BufferedImage;

/**
 *
 * Clase SpriteSheet
 * Contiene funciones para el manejo de Sprites usadas para animaciones
 * 
 * @author PalaunuGames
 */
public class SpriteSheet {

    private BufferedImage sheet;    // to store the spritesheet

    /**
     * SpriteSheet
     * 
     * Create a new spritesheet
     *
     * @param sheet the <code>image</code> with the sprites
     */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Crop
     * 
     * Crop a sprite from the spritesheet
     *
     * @param x an <code>int</code> value with the x coordinate
     * @param y an <code>int</code> value with the y coordinate
     * @param width an <code>int</code> value with the width of the sprite
     * @param height an <code>int</code> value with the height of the sprite
     * @return
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
