/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Entity;

import ViralDay.Manager.Assets;
import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Virus extends Item{
    public int velX;
    private boolean colisionConPlayer;
    
    public Virus(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.colisionConPlayer = false;
        this.velX = 5;
    }

    @Override
    public void tick() {
        setX(getX()-velX);
    }

    @Override
    public void render(Graphics g) {
        if(!colisionConPlayer){
        g.drawImage(Assets.virus, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    
    public void setColisionPlayer(boolean status){
        colisionConPlayer = status;
    }
    
    public boolean getColisionPlayer(){
        return colisionConPlayer;
    }
}
