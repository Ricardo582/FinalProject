/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.GameStateManager;
import ViralDay.Entity.Player;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level3 extends GameState {
    
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;
    
    public Level3(GameStateManager gsm) {
        super(gsm);
    }
    
    @Override
    public void init() {
        tileMap = new TileMap(0, -400, 3000, 1000, this);
        RW = new ReadWrite(this);
        tileMap.setCurrLvl(3);
        tileMap.init();
        player = new Player(200, 200, 80, 200, this, tileMap);
        
    }

    @Override
    public void tick() {
        handleInput();
        RW.tick();
        tileMap.tick();
        player.tick();
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
            //player.setAction();
        }
    }
    
    public TileMap getTileMap() {
        return tileMap;
    }
    
    public ReadWrite getRW(){
        return RW;
    }
    
}
