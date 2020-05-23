/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Entity;

import ViralDay.Manager.Animation;
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
    private boolean jumpFlag = false;
    private boolean fallFlag = false;
    private TileMap tm;
    private Animation run;
    private Animation jump;
    private Animation fall;

    public Player(int x, int y, int width, int height, GameState lvl, TileMap tm) {
        super(x, y, width, height);
        this.lvl = lvl;
        this.tm = tm;
        this.run = new Animation(Assets.playerRun, 150);
        this.jump = new Animation(Assets.playerJump, 150);
        this.fall = new Animation(Assets.playerFall, 150);
    }

    @Override
    public void tick() {
        this.run.tick();
        this.jump.tick();
        if(KeyManager.isPressed(KeyManager.UP) && !fallFlag){
            jumpFlag = true;
            velY = 3;
        }
        
        if(jumpFlag) {
            setY(y - velY);
            velTimer += 1;
            if(velTimer >= 30) {
                jumpFlag = false;
                fallFlag = true;
                velTimer = 0;
            }
        } else {
            setY(y + velY); 
        }
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                    velY = 0;
                    fallFlag = false;
                    setY(bloque.y - height);
                } else if(!this.collision(bloque) && y < 435 ) {
                    velY = 10;
                }
            }
    }

    @Override
    public void render(Graphics g) {
        if (jumpFlag) {
            g.drawImage(jump.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (fallFlag) {
            g.drawImage(fall.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(run.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    public void setVelY(int velY) {
        this.velY = velY;
    }
}