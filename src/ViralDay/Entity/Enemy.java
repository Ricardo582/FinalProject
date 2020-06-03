/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Entity;

import ViralDay.Manager.Animation;
import ViralDay.Manager.Assets;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Enemy extends Item {

    private TileMap tm;
    private int initX, initY, velY;
    private Animation enemyB1;
    private Animation enemyB2;
    private Animation enemyB3;
    private Animation enemyG1;
    private Animation enemyG2;
    private Animation enemyG3;
    private Animation enemyO1;
    private Animation enemyO2;
    private Animation enemyO3;
    private Animation enemyP1;
    private Animation enemyP2;
    private Animation enemyP3;
    private boolean colisionConPlayer;
    public boolean stand;

    public Enemy(int x, int y, int width, int height, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        velY = 5;
        this.enemyB1 = new Animation(Assets.enemyB1, 150);
        this.enemyB2 = new Animation(Assets.enemyB2, 150);
        this.enemyB3 = new Animation(Assets.enemyB3, 150);
        this.enemyG1 = new Animation(Assets.enemyG1, 150);
        this.enemyG2 = new Animation(Assets.enemyG2, 150);
        this.enemyG3 = new Animation(Assets.enemyG3, 150);
        this.enemyO1 = new Animation(Assets.enemyO1, 150);
        this.enemyO2 = new Animation(Assets.enemyO2, 150);
        this.enemyO3 = new Animation(Assets.enemyO3, 150);
        this.enemyP1 = new Animation(Assets.enemyP1, 150);
        this.enemyP2 = new Animation(Assets.enemyP2, 150);
        this.enemyP3 = new Animation(Assets.enemyP3, 150);
        colisionConPlayer = false;
        stand = false;
    }

    @Override
    public void tick() {
        this.enemyB1.tick();
        this.enemyB2.tick();
        this.enemyB3.tick();
        this.enemyG1.tick();
        this.enemyG2.tick();
        this.enemyG3.tick();
        this.enemyO1.tick();
        this.enemyO2.tick();
        this.enemyO3.tick();
        this.enemyP1.tick();
        this.enemyP2.tick();
        this.enemyP3.tick();
        setX(tm.getX() + initX);
        setY(y + velY);
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                velY = 0;
                stand = true;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemyB1.getCurrentFrame(), getX(), getY(), (getWidth() * -1), getHeight(), null);
    }
    
    public void setColisionPlayer(boolean status){
        colisionConPlayer = status;
    }
    
    public boolean getColisionPlayer(){
        return colisionConPlayer;
    }

}
