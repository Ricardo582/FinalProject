/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Enemy extends Item{
    private TileMap tm;
    private int initX, initY;

    public Enemy(int x, int y, int width, int height, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
    }

    @Override
    public void tick() {
        setX(tm.getX()+initX);
        
        Block under = null;
        for(Block bloque: tm.blocks){
            if(bloque.getX() < this.x && (bloque.getX()+bloque.getWidth()) > (this.x+this.getWidth())){
                under = bloque;
                break;
            }
        }
        
        if(this.collision(under)){
            //initY = tm.getHeight()-getY();
            //setY(tm.getY()+initY);
        }
        else{
            System.out.println(initY);
            this.setY(this.getY()+1);
        }
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.enemy, getX(), getY(), getWidth(), getHeight(), null);
    }
    
}
