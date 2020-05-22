/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Entity;

import ViralDay.Manager.Assets;
import ViralDay.States.GameState;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Player extends Item {
    private GameState lvl;
    private int velY = 0;
    private int velTimer = 0;
    private boolean jump = false;
    private boolean fall = false;
    private TileMap tm;

    public Player(int x, int y, int width, int height, GameState lvl, TileMap tm) {
        super(x, y, width, height);
        this.lvl = lvl;
        this.tm = tm;
    }

    @Override
    public void tick() {
        if(KeyManager.isPressed(KeyManager.UP) && !fall){
            jump = true;
            velY = 6;
        }
        
        if(jump) {
            setY(y - velY);
            velTimer += 1;
            if(velTimer >= 30) {
                jump = false;
                fall = true;
                velTimer = 0;
            }
        } else {
            setY(y + velY); 
        }
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                    velY = 0;
                    fall = false;
                    setY(bloque.y - height);
                } else if(!this.collision(bloque) && y < 435 ) {
                    velY = 10;
                }
            }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    public void setVelY(int velY) {
        this.velY = velY;
    }
}
