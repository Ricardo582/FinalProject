package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author RicardoGomez and HeribertoGil
 */
public class Assets {

    public static BufferedImage background;         // to store background image
    public static BufferedImage gameover;           // to store the gameover screen
    public static BufferedImage ballSprites;        // to store the player sprites
    public static BufferedImage ringSprites;        // to store the enemy sprites
    public static BufferedImage ballSpin[];         // pictures to go right
    public static BufferedImage ring[];             // pictures to move the enemy
    public static SoundClip backSound;              // to store the backSound
    public static SoundClip point;                  // to store the points sound
    public static SoundClip crash;                  // to store the crash sound

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.png");
        gameover = ImageLoader.loadImage("/images/gameover.png");
        backSound = new SoundClip("/sounds/backSound.wav");
        point = new SoundClip("/sounds/point.wav");
        crash = new SoundClip("/sounds/crash.wav");

        // getting the sprites frome the picture
        ballSprites = ImageLoader.loadImage("/images/pokeballsprites.png");
        ringSprites = ImageLoader.loadImage("/images/ring2sprites.png");

        // creating array of images before animations
        SpriteSheet ballspritesheet = new SpriteSheet(ballSprites);
        SpriteSheet ringspritesheet = new SpriteSheet(ringSprites);
        ballSpin = new BufferedImage[12];
        ring = new BufferedImage[8];

        // croping the pictures from the sheet into the array
        for (int i = 11; i >= 0; i--) {
            ballSpin[11 - i] = ballspritesheet.crop(i * 64, 0, 64, 64);
        }
        for (int i = 0; i < 8; i++) {
            ring[i] = ringspritesheet.crop(i * 350, 0, 350, 306);
        }

    }

}
