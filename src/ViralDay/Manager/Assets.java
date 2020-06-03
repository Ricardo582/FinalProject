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
    public static BufferedImage virus;
    public static BufferedImage bPrueba;
    public static BufferedImage b1;
    public static BufferedImage b2;
    public static BufferedImage b3;
    public static BufferedImage b4;
    public static BufferedImage b5;
    public static BufferedImage b6;
    public static BufferedImage back;
    public static BufferedImage blockSprites;
    public static BufferedImage playerSprites;
    public static BufferedImage enemyB1Sprites;
    public static BufferedImage enemyB2Sprites;
    public static BufferedImage enemyB3Sprites;
    public static BufferedImage enemyG1Sprites;
    public static BufferedImage enemyG2Sprites;
    public static BufferedImage enemyG3Sprites;
    public static BufferedImage enemyO1Sprites;
    public static BufferedImage enemyO2Sprites;
    public static BufferedImage enemyO3Sprites;
    public static BufferedImage enemyP1Sprites;
    public static BufferedImage enemyP2Sprites;
    public static BufferedImage enemyP3Sprites;
    public static BufferedImage playerJump[];
    public static BufferedImage playerFall[];
    public static BufferedImage playerIdle[];
    public static BufferedImage playerAttack[];
    public static BufferedImage playerRun[];
    public static BufferedImage enemyB1[];
    public static BufferedImage enemyB2[];
    public static BufferedImage enemyB3[];
    public static BufferedImage enemyG1[];
    public static BufferedImage enemyG2[];
    public static BufferedImage enemyG3[];
    public static BufferedImage enemyO1[];
    public static BufferedImage enemyO2[];
    public static BufferedImage enemyO3[];
    public static BufferedImage enemyP1[];
    public static BufferedImage enemyP2[];
    public static BufferedImage enemyP3[];
    

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
        enemy = ImageLoader.loadImage("/images/enemy.png");
        virus = ImageLoader.loadImage("/images/Virus.png");
        
        bPrueba = ImageLoader.loadImage("/images/BloquePrueba.png");
        
        blockSprites = ImageLoader.loadImage("/images/block_sprites.png");
        SpriteSheet blockSS = new SpriteSheet(blockSprites);
        
        // getting the sprites frome the picture
        playerSprites = ImageLoader.loadImage("/images/Player.png");
        enemyB1Sprites = ImageLoader.loadImage("/images/EnemyB1.png");
        enemyB2Sprites = ImageLoader.loadImage("/images/EnemyB2.png");
        enemyB3Sprites = ImageLoader.loadImage("/images/EnemyB3.png");
        enemyG1Sprites = ImageLoader.loadImage("/images/EnemyG1.png");
        enemyG2Sprites = ImageLoader.loadImage("/images/EnemyG2.png");
        enemyG3Sprites = ImageLoader.loadImage("/images/EnemyG3.png");
        enemyO1Sprites = ImageLoader.loadImage("/images/EnemyO1.png");
        enemyO2Sprites = ImageLoader.loadImage("/images/EnemyO2.png");
        enemyO3Sprites = ImageLoader.loadImage("/images/EnemyO3.png");
        enemyP1Sprites = ImageLoader.loadImage("/images/EnemyP1.png");
        enemyP2Sprites = ImageLoader.loadImage("/images/EnemyP2.png");
        enemyP3Sprites = ImageLoader.loadImage("/images/EnemyP3.png");
        
        // creating array of images before animations
        SpriteSheet playerSS = new SpriteSheet(playerSprites);
        SpriteSheet enemySSB1 = new SpriteSheet(enemyB1Sprites);
        SpriteSheet enemySSB2 = new SpriteSheet(enemyB2Sprites);
        SpriteSheet enemySSB3 = new SpriteSheet(enemyB3Sprites);
        SpriteSheet enemySSG1 = new SpriteSheet(enemyG1Sprites);
        SpriteSheet enemySSG2 = new SpriteSheet(enemyG2Sprites);
        SpriteSheet enemySSG3 = new SpriteSheet(enemyG3Sprites);
        SpriteSheet enemySSO1 = new SpriteSheet(enemyO1Sprites);
        SpriteSheet enemySSO2 = new SpriteSheet(enemyO2Sprites);
        SpriteSheet enemySSO3 = new SpriteSheet(enemyO3Sprites);
        SpriteSheet enemySSP1 = new SpriteSheet(enemyP1Sprites);
        SpriteSheet enemySSP2 = new SpriteSheet(enemyP2Sprites);
        SpriteSheet enemySSP3 = new SpriteSheet(enemyP3Sprites);
        playerJump = new BufferedImage[1];
        playerFall = new BufferedImage[1];
        playerIdle = new BufferedImage[3];
        playerAttack = new BufferedImage[3];
        playerRun = new BufferedImage[5];
        enemyB1 = new BufferedImage[6];
        enemyB2 = new BufferedImage[6];
        enemyB3 = new BufferedImage[6];
        enemyG1 = new BufferedImage[6];
        enemyG2 = new BufferedImage[6];
        enemyG3 = new BufferedImage[6];
        enemyO1 = new BufferedImage[6];
        enemyO2 = new BufferedImage[6];
        enemyO3 = new BufferedImage[6];
        enemyP1 = new BufferedImage[6];
        enemyP2 = new BufferedImage[6];
        enemyP3 = new BufferedImage[6];
        
        // croping the pictures from the sheet into the array
        for (int i = 0; i < 3; i++) {
            playerIdle[i] = playerSS.crop(i*74, 119, 74, 119);
        }
        for (int i = 0; i < 3; i++) {
            playerAttack[i] = playerSS.crop(i*74, 2*119, 74, 119);
        }
        for (int i = 0; i < 5; i++) {
            playerRun[i] = playerSS.crop(i*74, 0, 74, 119);
        }
        
        for (int i = 0; i < 6; i++) {
            enemyB1[i] = enemySSB1.crop(i*75, 0, 75, 100);
            enemyB2[i] = enemySSB2.crop(i*75, 0, 75, 100);
            enemyB3[i] = enemySSB3.crop(i*75, 0, 75, 100);
            enemyG1[i] = enemySSG1.crop(i*75, 0, 75, 100);
            enemyG2[i] = enemySSG2.crop(i*75, 0, 75, 100);
            enemyG3[i] = enemySSG3.crop(i*75, 0, 75, 100);
            enemyO1[i] = enemySSO1.crop(i*75, 0, 75, 100);
            enemyO2[i] = enemySSO2.crop(i*75, 0, 75, 100);
            enemyO3[i] = enemySSO3.crop(i*75, 0, 75, 100);
            enemyP1[i] = enemySSP1.crop(i*75, 0, 75, 100);
            enemyP2[i] = enemySSP2.crop(i*75, 0, 75, 100);
            enemyP3[i] = enemySSP3.crop(i*75, 0, 75, 100);
        }
        
        b1 = blockSS.crop(0, 0, 100, 100);
        b2 = blockSS.crop(100, 0, 100, 100);
        b3 = blockSS.crop(200, 0, 100, 100);
        b4 = blockSS.crop(0, 100, 100, 100);
        b5 = blockSS.crop(100, 100, 100, 100);
        b6 = blockSS.crop(200, 100, 100, 100);
        playerJump[0] = playerSS.crop(0, 3*119, 74, 119);
        playerFall[0] = playerSS.crop(0, 4*119, 74, 119);
    }
}
