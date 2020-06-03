
package ViralDay.Entity;

import ViralDay.Manager.Animation;
import ViralDay.Manager.Assets;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Spray extends Item {

    private TileMap tm;
    private int initX, initY, velY;
    private Animation sprayidle;
    private boolean colisionConPlayer;

    public Spray(int x, int y, int width, int height, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        velY = 6;
        this.sprayidle = new Animation(Assets.spSprites, 150);
        colisionConPlayer = false;
    }

    @Override
    public void tick() {
        this.sprayidle.tick();
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
        if(!colisionConPlayer){
        g.drawImage(sprayidle.getCurrentFrame(), getX(), getY(), (getWidth() * -1), getHeight(), null);
        }
    }
    
    public void setColisionPlayer(boolean status){
        colisionConPlayer = status;
    }
    
    public boolean getColisionPlayer(){
        return colisionConPlayer;
    }

}