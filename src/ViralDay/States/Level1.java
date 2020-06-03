package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import ViralDay.Entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level1 extends GameState {

    // events
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;

    public Level1(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        tileMap = new TileMap(0, -150, 1000, 750, this);
        RW = new ReadWrite(this);
        tileMap.setCurrLvl(1);
        tileMap.init();
        player = new Player(200, 500, 50, 70, this, tileMap);
        RW = new ReadWrite(this);
        Assets.harps.stop();
        Assets.backSound.setLooping(true);
        Assets.backSound.play();
    }

    @Override
    public void tick() {
        handleInput();
        RW.tick();
        tileMap.tick();
        player.tick();
        if (tileMap.getX() < -7800) {
            Assets.aplausos.play();
            gsm.setState(GameStateManager.LEVEL2INTRO);
        }
        if (player.getVidas() <= 0) {
            gsm.setState(GameStateManager.GAMEOVER);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.back, 0, 0, Game.getWidth(), Game.getHeight(), null);
        tileMap.render(g);
        player.render(g);
        
        //Aquí se muestran las vidas del jugador en el respectivo nivel
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Vidas = " + player.getVidasText(), Game.getWidth() - 80, 20);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Ammo = " + player.getAmmoText(), Game.getWidth() - 160, 20);
    }

    @Override
    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(true);
        }
        if (blockInput) {
            return;
        }
        if (KeyManager.isDown(KeyManager.LEFT)) {
            //player.setLeft();
        }
        if (KeyManager.isDown(KeyManager.RIGHT)) {
            //player.setRight();
        }
        if (KeyManager.isDown(KeyManager.UP)) {
            //player.setUp();
        }
        if (KeyManager.isDown(KeyManager.DOWN)) {
            //player.setDown();
        }
        if (KeyManager.isPressed(KeyManager.SPACE)) {
            //gsm.setState(GameStateManager.LEVEL2INTRO);
        }
    }
    
    public TileMap getTileMap() {
        return tileMap;
    }
    
    public ReadWrite getRW(){
        return RW;
    }
    
    @Override
    public GameStateManager getGSM() {
        return gsm;
    }
    
    public void Save(int slot) {
        switch(slot) {
            case 1:
                RW.Save("src/saves/Save1.txt");
                break;
            case 2:
                RW.Save("src/saves/Save2.txt");
                break;
            case 3:
                RW.Save("src/saves/Save3.txt");
                break;
            default:
                break;
        }
    }
    
    public GameState Load() {
        return this;
    }
}
