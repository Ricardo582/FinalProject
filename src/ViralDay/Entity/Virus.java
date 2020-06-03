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

    public Virus(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {
        setX(getX()-5);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.virus, getX(), getY(), getWidth(), getHeight(), null);
    }
}
