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
    private GameState lvl;

    public Player(int x, int y, int width, int height, GameState lvl) {
        super(x, y, width, height);
        this.lvl = lvl;
    }

    @Override
    public void tick() {
        if(KeyManager.isDown(KeyManager.UP) && y >= 100){
            setY(y-10);
        }
        if(KeyManager.isDown(KeyManager.UP) && y < 100){
            lvl.getTileMap().setY(lvl.getTileMap().getY()+10);
        }
        if(KeyManager.isDown(KeyManager.DOWN) && (y + getHeight()) < 500){
            setY(y+10);
        }
        if(KeyManager.isDown(KeyManager.DOWN) && (y + getHeight()) >= 500){
            lvl.getTileMap().setY(lvl.getTileMap().getY()-10);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
    
}
