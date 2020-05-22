package ViralDay.Manager;

import ViralDay.Manager.ImageLoader;
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
    public static BufferedImage background1;         // to store background image
    public static BufferedImage background2;         // to store background image
    public static BufferedImage background3;         // to store background image
    public static BufferedImage enemy;
    public static BufferedImage player;
    public static BufferedImage b1;
    public static BufferedImage b2;
    public static BufferedImage b3;
    public static BufferedImage b4;
    public static BufferedImage b5;
    public static BufferedImage b6;
    public static BufferedImage back;
    public static BufferedImage blockSprites;

    /**
     * initializing the images of the game
     */
    public static void init() {
        menu = ImageLoader.loadImage("/images/Menu.png");
        ball = ImageLoader.loadImage("/images/ball.png");
        logo = ImageLoader.loadImage("/images/logo.png");
        back = ImageLoader.loadImage("/images/back.png");
        lvla = ImageLoader.loadImage("/images/Bglvl1.png");
        lvlb = ImageLoader.loadImage("/images/Bglvl2.png");
        lvlc = ImageLoader.loadImage("/images/Bglvl3.png");
        pause = ImageLoader.loadImage("/images/Pause.jpeg");
        go = ImageLoader.loadImage("/images/GO.jpeg");
        
        player = ImageLoader.loadImage("/images/player.png");
        enemy = ImageLoader.loadImage("/images/enemy.png");
        
        blockSprites = ImageLoader.loadImage("/images/block_sprites.png");
        SpriteSheet blockSS = new SpriteSheet(blockSprites);
        
        b1 = blockSS.crop(0, 0, 100, 100);
        b2 = blockSS.crop(100, 0, 100, 100);
        b3 = blockSS.crop(200, 0, 100, 100);
        b4 = blockSS.crop(0, 100, 100, 100);
        b5 = blockSS.crop(100, 100, 100, 100);
        b6 = blockSS.crop(200, 100, 100, 100);
    }
}
