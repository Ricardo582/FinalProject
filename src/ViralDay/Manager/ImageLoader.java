package ViralDay.Manager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * Clase ImageLoader
 * Contiene funcione para la importacion de imagenes
 * 
 * @author PalaunuGames
 */
public class ImageLoader {

    /**
     * 
     * loadImage
     * 
     * to get an image from the file path
     *
     * @param path it is the path of the file
     * @return the <bold>BufferedImage</bold> object
     */
    public static BufferedImage loadImage(String path) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException ioe) {
            System.out.println("Error loading image " + path + ioe.toString());
            System.exit(1);
        }
        return bi;
    }

}
