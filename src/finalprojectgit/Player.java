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
public class Player extends Item {
    private Level1 lvl1;

    public Player(int x, int y, int width, int height, Level1 lvl1) {
        super(x, y, width, height);
        this.lvl1 = lvl1;
    }

    @Override
    public void tick() {
        if(KeyManager.isDown(KeyManager.UP) && y >= 100){
            setY(y-10);
        }
        if(KeyManager.isDown(KeyManager.UP) && y < 100){
            lvl1.getTileMap().setY(lvl1.getTileMap().getY()+10);
        }
        if(KeyManager.isDown(KeyManager.DOWN) && (y + getHeight()) < 500){
            setY(y+10);
        }
        if(KeyManager.isDown(KeyManager.DOWN) && (y + getHeight()) >= 500){
            lvl1.getTileMap().setY(lvl1.getTileMap().getY()-10);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    
}
