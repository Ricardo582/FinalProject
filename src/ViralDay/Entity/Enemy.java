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
    private Animation enemy;

    public Enemy(int x, int y, int width, int height, int color, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        velY = 6;
        switch (color) {
            case 1:
                this.enemy = new Animation(Assets.enemyB1, 150);
                break;
            case 2:
                this.enemy = new Animation(Assets.enemyB2, 150);
                break;
            case 3:
                this.enemy = new Animation(Assets.enemyB3, 150);
                break;
            case 4:
                this.enemy = new Animation(Assets.enemyG1, 150);
                break;
            case 5:
                this.enemy = new Animation(Assets.enemyG2, 150);
                break;
            case 6:
                this.enemy = new Animation(Assets.enemyG3, 150);
                break;
            case 7:
                this.enemy = new Animation(Assets.enemyO1, 150);
                break;
            case 8:
                this.enemy = new Animation(Assets.enemyO2, 150);
                break;
            case 9:
                this.enemy = new Animation(Assets.enemyO3, 150);
                break;
            case 10:
                this.enemy = new Animation(Assets.enemyP1, 150);
                break;
            case 11:
                this.enemy = new Animation(Assets.enemyP2, 150);
                break;
            case 12:
                this.enemy = new Animation(Assets.enemyP3, 150);
                break;
            default:
                break;
        }
    }

    @Override
    public void tick() {
        this.enemy.tick();
        setX(tm.getX() + initX);
        setY(y + velY);
        for (Block bloque : tm.blocks) {
            if (this.collision(bloque)) {
                velY = 0;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemy.getCurrentFrame(), getX(), getY(), (getWidth() * -1), getHeight(), null);
    }

}
