package finalprojectgit;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author RicardoGomez and HeribertoGil
 */
public class Assets {

    public static BufferedImage menu;         // to store background image
    public static BufferedImage lvla;         // to store background image
    public static BufferedImage lvlb;         // to store background image
    public static BufferedImage lvlc;         // to store background image
    public static BufferedImage pause;         // to store background image
    public static BufferedImage go;         // to store background image
    public static BufferedImage ball;         // to store background image
    public static BufferedImage logo;         // to store background image

    /**
     * initializing the images of the game
     */
    public static void init() {
        menu = ImageLoader.loadImage("/images/Menu.png");
        ball = ImageLoader.loadImage("/images/ball.png");
        logo = ImageLoader.loadImage("/images/logo.png");
        lvla = ImageLoader.loadImage("/images/Lvl1.jpeg");
        lvlb = ImageLoader.loadImage("/images/Lvl2.jpeg");
        lvlc = ImageLoader.loadImage("/images/Lvl3.jpeg");
        pause = ImageLoader.loadImage("/images/Pause.jpeg");
        go = ImageLoader.loadImage("/images/GO.jpeg");
    }
}
