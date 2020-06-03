package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import ViralDay.Entity.Player;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level3 extends GameState {

    // events
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;

    public Level3(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        tileMap = new TileMap(0, -150, 1000, 750, this);
        RW = new ReadWrite(this);
        tileMap.setCurrLvl(3);
        tileMap.init();
        player = new Player(200, 500, 50, 70, this, tileMap);
    }

    @Override
    public void tick() {
        handleInput();
        RW.tick();
        tileMap.tick();
        player.tick();
        if (tileMap.getX() < -7800) {
            gsm.setState(GameStateManager.WIN);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.back, 0, 0, Game.getWidth(), Game.getHeight(), null);
        tileMap.render(g);
        player.render(g);
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
            System.out.println(GameStateManager.GAMEOVER);
            gsm.setState(GameStateManager.GAMEOVER);
        }
    }
    
    public TileMap getTileMap() {
        return tileMap;
    }
    
    public ReadWrite getRW(){
        return RW;
    }
    
}
