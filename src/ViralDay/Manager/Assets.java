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

    public static BufferedImage menu;       // to store menu screen
    public static BufferedImage logo;       // to store logo image
    public static BufferedImage Pause;
    public static BufferedImage Store;
    public static BufferedImage Drugstore;
    public static BufferedImage Home;
    public static BufferedImage virus;

    public static BufferedImage lvla;       // to store background of level 1
    public static BufferedImage lvlb;       // to store background of level 2
    public static BufferedImage lvlc;       // to store background of level 3
    public static BufferedImage back;
    public static BufferedImage backPause;
    public static BufferedImage LS;
    public static BufferedImage Bar[];      // to store the sprites of bar

    // To store buttons images
    public static BufferedImage Cargar[];
    public static BufferedImage Continuar[];
    public static BufferedImage Guardar[];
    public static BufferedImage Jugar[];
    public static BufferedImage Opciones[];
    public static BufferedImage Partida1[];
    public static BufferedImage Partida2[];
    public static BufferedImage Partida3[];
    public static BufferedImage Salir[];
    public static BufferedImage Vacio[];
    public static BufferedImage Regresar[];
    public static BufferedImage Efects[];
    public static BufferedImage Music[];

    // To store the history animations of:
    //  LEVEL 1
    //  LEVEL 2
    //  LEVEL 3
    //  Win screen
    //  Game Over Screen
    public static BufferedImage Lvl1[];
    public static BufferedImage Lvl2[];
    public static BufferedImage Lvl3[];
    public static BufferedImage Win[];
    public static BufferedImage GO[];

    public static BufferedImage spraySprites;
    public static BufferedImage spSprites[];

    public static BufferedImage liveSprites;
    public static BufferedImage liveFrames[];

    public static BufferedImage blockSprites;
    public static BufferedImage b1;
    public static BufferedImage b2;
    public static BufferedImage b3;
    public static BufferedImage b4;
    public static BufferedImage b5;
    public static BufferedImage b6;

    public static BufferedImage playerSprites;
    public static BufferedImage playerJump[];
    public static BufferedImage playerFall[];
    public static BufferedImage playerIdle[];
    public static BufferedImage playerAttack[];
    public static BufferedImage playerRun[];

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

    public static SoundClip backSound;
    public static SoundClip sprays;
    public static SoundClip viruses;
    public static SoundClip coins;
    public static SoundClip harps;
    public static SoundClip aplausos;
    public static SoundClip damage;
    public static SoundClip gameover;
    public static SoundClip noammo;
    public static SoundClip spraycan;
    public static SoundClip menuSound;
    /**
     * initializing the images of the game
     */
    public static void init() {
        //sounds 
        backSound = new SoundClip("/sounds/Loop.wav");
        sprays = new SoundClip("/sounds/sprays.wav");
        viruses = new SoundClip("/sounds/viruses.wav");
        coins= new SoundClip("/sounds/coins.wav");
        harps = new SoundClip("/sounds/harps.wav");
        aplausos = new SoundClip("/sounds/aplausos.wav");
        damage = new SoundClip("/sounds/damage.wav");
        gameover = new SoundClip("/sounds/gameover.wav");
        noammo = new SoundClip("/sounds/noammo.wav");
        spraycan = new SoundClip("/sounds/spraycan.wav");
        menuSound = new SoundClip("/sounds/menu.wav");
        
        menu = ImageLoader.loadImage("/images/Screen/Menu.png");
        logo = ImageLoader.loadImage("/images/Screen/logo.png");
        Pause = ImageLoader.loadImage("/images/Screen/Pausa.png");
        Store = ImageLoader.loadImage("/images/Entity/Tienda.png");
        Drugstore = ImageLoader.loadImage("/images/Entity/Farmacia.png");
        Home = ImageLoader.loadImage("/images/Entity/Casa.png");
        virus = ImageLoader.loadImage("/images/Entity/Virus.png");

        lvla = ImageLoader.loadImage("/images/Screen/Bglvl1.png");
        lvlb = ImageLoader.loadImage("/images/Screen/Bglvl2.png");
        lvlc = ImageLoader.loadImage("/images/Screen/Bglvl3.png");
        back = ImageLoader.loadImage("/images/Screen/back.png");
        backPause = ImageLoader.loadImage("/images/Screen/backPause.png");
        LS = ImageLoader.loadImage("/images/Screen/Cargar.png");

        Bar = new BufferedImage[5];
        Bar[0] = ImageLoader.loadImage("/images/Buttons/Volume0.png");
        Bar[1] = ImageLoader.loadImage("/images/Buttons/Volume25.png");
        Bar[2] = ImageLoader.loadImage("/images/Buttons/Volume50.png");
        Bar[3] = ImageLoader.loadImage("/images/Buttons/Volume75.png");
        Bar[4] = ImageLoader.loadImage("/images/Buttons/Volume100.png");

        Cargar = new BufferedImage[2];
        Cargar[0] = ImageLoader.loadImage("/images/Buttons/Cargar.png");
        Cargar[1] = ImageLoader.loadImage("/images/Buttons/CargarP.png");

        Continuar = new BufferedImage[2];
        Continuar[0] = ImageLoader.loadImage("/images/Buttons/Continuar.png");
        Continuar[1] = ImageLoader.loadImage("/images/Buttons/ContinuarP.png");

        Guardar = new BufferedImage[2];
        Guardar[0] = ImageLoader.loadImage("/images/Buttons/Guardar.png");
        Guardar[1] = ImageLoader.loadImage("/images/Buttons/GuardarP.png");

        Jugar = new BufferedImage[2];
        Jugar[0] = ImageLoader.loadImage("/images/Buttons/Jugar.png");
        Jugar[1] = ImageLoader.loadImage("/images/Buttons/JugarP.png");

        Opciones = new BufferedImage[2];
        Opciones[0] = ImageLoader.loadImage("/images/Buttons/Opciones.png");
        Opciones[1] = ImageLoader.loadImage("/images/Buttons/OpcionesP.png");

        Partida1 = new BufferedImage[2];
        Partida1[0] = ImageLoader.loadImage("/images/Buttons/Partida1.png");
        Partida1[1] = ImageLoader.loadImage("/images/Buttons/Partida1P.png");

        Partida2 = new BufferedImage[2];
        Partida2[0] = ImageLoader.loadImage("/images/Buttons/Partida2.png");
        Partida2[1] = ImageLoader.loadImage("/images/Buttons/Partida2P.png");

        Partida3 = new BufferedImage[2];
        Partida3[0] = ImageLoader.loadImage("/images/Buttons/Partida3.png");
        Partida3[1] = ImageLoader.loadImage("/images/Buttons/Partida3P.png");

        Salir = new BufferedImage[2];
        Salir[0] = ImageLoader.loadImage("/images/Buttons/Salir.png");
        Salir[1] = ImageLoader.loadImage("/images/Buttons/SalirP.png");

        Vacio = new BufferedImage[2];
        Vacio[0] = ImageLoader.loadImage("/images/Buttons/Vacio.png");
        Vacio[1] = ImageLoader.loadImage("/images/Buttons/VacioP.png");

        Regresar = new BufferedImage[2];
        Regresar[0] = ImageLoader.loadImage("/images/Buttons/Regresar.png");
        Regresar[1] = ImageLoader.loadImage("/images/Buttons/RegresarP.png");

        Efects = new BufferedImage[2];
        Efects[0] = ImageLoader.loadImage("/images/Screen/Efectos.png");
        Efects[1] = ImageLoader.loadImage("/images/Screen/EfectosP.png");

        Music = new BufferedImage[2];
        Music[0] = ImageLoader.loadImage("/images/Screen/Musica.png");
        Music[1] = ImageLoader.loadImage("/images/Screen/MusicaP.png");

        Lvl1 = new BufferedImage[4];
        Lvl1[0] = ImageLoader.loadImage("/images/Screen/1a.png");
        Lvl1[1] = ImageLoader.loadImage("/images/Screen/1b.png");
        Lvl1[2] = ImageLoader.loadImage("/images/Screen/1c.png");
        Lvl1[3] = ImageLoader.loadImage("/images/Screen/1d.png");

        Lvl2 = new BufferedImage[2];
        Lvl2[0] = ImageLoader.loadImage("/images/Screen/2a.png");
        Lvl2[1] = ImageLoader.loadImage("/images/Screen/2b.png");

        Lvl3 = new BufferedImage[2];
        Lvl3[0] = ImageLoader.loadImage("/images/Screen/3a.png");
        Lvl3[1] = ImageLoader.loadImage("/images/Screen/3b.png");

        Win = new BufferedImage[3];
        Win[0] = ImageLoader.loadImage("/images/Screen/4a.png");
        Win[1] = ImageLoader.loadImage("/images/Screen/4b.png");
        Win[2] = ImageLoader.loadImage("/images/Screen/4c.png");

        GO = new BufferedImage[4];
        GO[0] = ImageLoader.loadImage("/images/Screen/GO1.png");
        GO[1] = ImageLoader.loadImage("/images/Screen/GO2.png");
        GO[2] = ImageLoader.loadImage("/images/Screen/GO3.png");
        GO[3] = ImageLoader.loadImage("/images/Screen/GO4.png");

        blockSprites = ImageLoader.loadImage("/images/Screen/block_sprites.png");
        SpriteSheet blockSS = new SpriteSheet(blockSprites);

        // getting the sprites frome the picture
        playerSprites = ImageLoader.loadImage("/images/Entity/Player.png");
        enemyB1Sprites = ImageLoader.loadImage("/images/Entity/EnemyB1.png");
        enemyB2Sprites = ImageLoader.loadImage("/images/Entity/EnemyB2.png");
        enemyB3Sprites = ImageLoader.loadImage("/images/Entity/EnemyB3.png");
        enemyG1Sprites = ImageLoader.loadImage("/images/Entity/EnemyG1.png");
        enemyG2Sprites = ImageLoader.loadImage("/images/Entity/EnemyG2.png");
        enemyG3Sprites = ImageLoader.loadImage("/images/Entity/EnemyG3.png");
        enemyO1Sprites = ImageLoader.loadImage("/images/Entity/EnemyO1.png");
        enemyO2Sprites = ImageLoader.loadImage("/images/Entity/EnemyO2.png");
        enemyO3Sprites = ImageLoader.loadImage("/images/Entity/EnemyO3.png");
        enemyP1Sprites = ImageLoader.loadImage("/images/Entity/EnemyP1.png");
        enemyP2Sprites = ImageLoader.loadImage("/images/Entity/EnemyP2.png");
        enemyP3Sprites = ImageLoader.loadImage("/images/Entity/EnemyP3.png");
        spraySprites = ImageLoader.loadImage("/images/Entity/cans.png");
        liveSprites = ImageLoader.loadImage("/images/Entity/livesSS.png");

        // creating array of images before animations
        SpriteSheet spraySS = new SpriteSheet(spraySprites);
        spSprites = new BufferedImage[6];

        SpriteSheet liveSS = new SpriteSheet(liveSprites);
        liveFrames = new BufferedImage[8];

        SpriteSheet playerSS = new SpriteSheet(playerSprites);
        playerJump = new BufferedImage[1];
        playerFall = new BufferedImage[1];
        playerIdle = new BufferedImage[3];
        playerAttack = new BufferedImage[3];
        playerRun = new BufferedImage[5];

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
        for (int i = 0; i < 8; i++) {
            liveFrames[i] = liveSS.crop(i * 493, 0, 493, 443);
        }

        for (int i = 0; i < 3; i++) {
            playerIdle[i] = playerSS.crop(i * 74, 119, 74, 119);
        }
        for (int i = 0; i < 3; i++) {
            playerAttack[i] = playerSS.crop(i * 74, 2 * 119, 74, 119);
        }
        for (int i = 0; i < 5; i++) {
            playerRun[i] = playerSS.crop(i * 74, 0, 74, 119);
        }
        playerJump[0] = playerSS.crop(0, 3 * 119, 74, 119);
        playerFall[0] = playerSS.crop(0, 4 * 119, 74, 119);

        for (int i = 0; i < 6; i++) {
            enemyB1[i] = enemySSB1.crop(i * 75, 0, 75, 100);
            enemyB2[i] = enemySSB2.crop(i * 75, 0, 75, 100);
            enemyB3[i] = enemySSB3.crop(i * 75, 0, 75, 100);
            enemyG1[i] = enemySSG1.crop(i * 75, 0, 75, 100);
            enemyG2[i] = enemySSG2.crop(i * 75, 0, 75, 100);
            enemyG3[i] = enemySSG3.crop(i * 75, 0, 75, 100);
            enemyO1[i] = enemySSO1.crop(i * 75, 0, 75, 100);
            enemyO2[i] = enemySSO2.crop(i * 75, 0, 75, 100);
            enemyO3[i] = enemySSO3.crop(i * 75, 0, 75, 100);
            enemyP1[i] = enemySSP1.crop(i * 75, 0, 75, 100);
            enemyP2[i] = enemySSP2.crop(i * 75, 0, 75, 100);
            enemyP3[i] = enemySSP3.crop(i * 75, 0, 75, 100);
            spSprites[i] = spraySS.crop(i * 96, 0, 96, 174);
        }

        b1 = blockSS.crop(0, 0, 100, 100);
        b2 = blockSS.crop(100, 0, 100, 100);
        b3 = blockSS.crop(200, 0, 100, 100);
        b4 = blockSS.crop(0, 100, 100, 100);
        b5 = blockSS.crop(100, 100, 100, 100);
        b6 = blockSS.crop(200, 100, 100, 100);
    }
}
