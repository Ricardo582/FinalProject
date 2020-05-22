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
public class Block extends Item{
    private int type;
    private TileMap tm;
    private int initX, initY;

    public Block(int x, int y, int width, int height, int type, int initX, int initY, TileMap tm) {
        super(x, y, width, height);
        this.type = type;
        this.tm = tm;
        this.initX = initX;
        this.initY = initY + 70;
    }

    @Override
    public void tick() {
        setX(tm.getX()+initX);
        setY(tm.getY()+initY);
    }

    @Override
    public void render(Graphics g) {
        //render dependiendo del sprite (lo determina el type)
        switch(type){
            case 1:
                g.drawImage(Assets.b1, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 2:
                g.drawImage(Assets.b2, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 3:
                g.drawImage(Assets.b3, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 4:
                g.drawImage(Assets.b4, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 5:
                g.drawImage(Assets.b5, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 6:
                g.drawImage(Assets.b6, getX(), getY(), getWidth(), getHeight(), null);
                break;
        }
    }
    
}
