/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Entity;

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

    public Enemy(int x, int y, int width, int height, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        velY = 6;
    }

    @Override
    public void tick() {
        setX(tm.getX() + initX);
        setY(y + velY);
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                velY = 0;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.enemy, getX(), getY(), getWidth(), getHeight(), null);
    }

}
