/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.Manager;

import ViralDay.Entity.Block;
import ViralDay.Entity.Enemy;
import ViralDay.States.GameState;
import ViralDay.Entity.Item;
import ViralDay.Entity.Spray;
import ViralDay.Entity.Virus;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author hgm
 */
public class TileMap extends Item {

    private GameState lvl;
    public LinkedList<Enemy> enemies;
    public LinkedList<Block> blocks;
    public LinkedList<Spray> sprays;
    public LinkedList<Virus> viruses;
    public int currlvl;

    public TileMap(int x, int y, int width, int height, GameState lvl) {
        super(x, y, width, height);
        this.lvl = lvl;
        enemies = new LinkedList();
        blocks = new LinkedList();
        viruses = new LinkedList();
        sprays = new LinkedList();

    }

    public void init() {
        int[][] tilemap = new int[10][128];
        switch (currlvl) {
            case 1:
                tilemap = lvl.getRW().tileRead("src/levels/lvl1.txt");
                break;
            case 2:
                tilemap = lvl.getRW().tileRead("src/levels/lvl2.txt");
                break;
            case 3:
                tilemap = lvl.getRW().tileRead("src/levels/lvl3.txt");
                break;
            default:
                break;
        }
        generateMap(tilemap);
        //genera enemigos de acuerdo al nivel
        
    }

    public void generateMap(int[][] mat) {
        System.out.println("Generando mapa... ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 128; j++) {
                if (mat[i][j] != 0) {
                    Block curr = new Block((getX() + (j * 70)), (getY() + (i * 70)), 70, 70, mat[i][j], (j * 70), (i * 70), this);
                    blocks.add(curr);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            int randBlock = (int) (5 + (Math.random() * 120));
            int randX = (randBlock * 70) + 10;
            Enemy temp = new Enemy(randX, -100, 50, 70, (int) ((Math.random() * 11) + 1), this);
            enemies.add(temp);
        }
        for (int i = 0; i < 3; i++) {
            int randBlock = (int) (5 + (Math.random() * 120));
            int randX = (randBlock * 70) + 25;
            Spray temp = new Spray(randX, -100, 20 , 35, this);
            sprays.add(temp);
        }
    }

    @Override
    public void tick() {
        if (KeyManager.isDown(KeyManager.LEFT)) {
            setX(x + 4);
        }
        if (KeyManager.isDown(KeyManager.RIGHT)) {
            setX(x - 4);
        }
        
        setX(x - 4);

        for (Block block : blocks) {
            block.tick();
        }
        for (Enemy enemigo : enemies) {
            enemigo.tick();
            if(enemigo.getX()> 0 && enemigo.getX()<1000 && enemigo.stand){
                int rand = (int) (Math.random()*80 + 1);
                if(rand == 72){
                    Virus temp = new Virus(enemigo.getX()+10,enemigo.getY()+20,25,25);
                    viruses.add(temp);
                }
            }
        }
        for (Virus bicho: viruses){
            if (KeyManager.isDown(KeyManager.RIGHT)) {
                bicho.velX = 15;
            }
            else{
                bicho.velX = 5;
            }
            bicho.tick();
        }
        
        for (Spray sprays : sprays) {
            sprays.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        switch (currlvl) {
            case 1:
                g.drawImage(Assets.lvla, x, y, width, height, null);
                g.drawImage(Assets.lvla, x + width, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 2, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 3, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 4, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 5, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 6, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 7, y, width, height, null);
                g.drawImage(Assets.lvla, x + width * 8, y, width, height, null);
                g.drawImage(Assets.Drugstore, x + width * 8, 305, 300, 250, null);
                break;
            case 2:
                g.drawImage(Assets.lvlb, x, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 2, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 3, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 4, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 5, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 6, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 7, y, width, height, null);
                g.drawImage(Assets.lvlb, x + width * 8, y, width, height, null);
                g.drawImage(Assets.Store, x + width * 8, 305, 300, 250, null);
                break;
            case 3:
                g.drawImage(Assets.lvlc, x, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 2, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 3, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 4, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 5, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 6, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 7, y, width, height, null);
                g.drawImage(Assets.lvlc, x + width * 8, y, width, height, null);
                g.drawImage(Assets.Home, x + width * 8, 305, 300, 250, null);
                break;
            default:
                break;
        }

        for (Block block : blocks) {
            block.render(g);
        }
        for (Enemy enemigo : enemies) {
            enemigo.render(g);
        }
        for (Spray sprays : sprays) {
            sprays.render(g);
        }
        for (Virus bicho : viruses) {
            bicho.render(g);
        }
        g.setFont(new Font("Cooper Black", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Puntos = " + lvl.getScore(), Game.getWidth() - 150, 50);
    }

    public void setCurrLvl(int curr) {
        currlvl = curr;
    }
    
    public LinkedList getEnemies() {
        return enemies;
    }
    
    public GameState getState() {
        return lvl;
    }
    
    public int getCurrLvlState() {
        switch(currlvl) {
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 9;
            default:
                break;
        }
        return 0;
    }
}
