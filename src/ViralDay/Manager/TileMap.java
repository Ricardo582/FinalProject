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

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author hgm
 */
public class TileMap extends Item {

    private GameState lvl;
    private LinkedList<Enemy> enemies;
    public LinkedList<Block> blocks;
    public int currlvl;

    public TileMap(int x, int y, int width, int height, GameState lvl) {
        super(x, y, width, height);
        this.lvl = lvl;
        enemies = new LinkedList();
        blocks = new LinkedList();

    }

    public void init() {
        int[][] tilemap = new int[10][90];
        switch (currlvl) {
            case 1:
                tilemap = lvl.getRW().tileRead("lvl1.txt");
                break;
            case 2:
                tilemap = lvl.getRW().tileRead("lvl2.txt");
                break;
            case 3:
                tilemap = lvl.getRW().tileRead("lvl3.txt");
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
            for (int j = 0; j < 90; j++) {
                if (mat[i][j] != 0) {
                    Block curr = new Block((getX() + (j * 70)), (getY() + (i * 70)), 70, 70, mat[i][j], (j * 70), (i * 70), this);
                    blocks.add(curr);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int randBlock = (int) (5 + (Math.random() * 25));
            int randX = (randBlock * 100) + 10;
            Enemy temp = new Enemy(randX, -200, 80, 100, this);
            enemies.add(temp);
        }
    }

    @Override
    public void tick() {
        if (KeyManager.isDown(KeyManager.LEFT)) {
            setX(x + 10);
        }
        if (KeyManager.isDown(KeyManager.RIGHT)) {
            setX(x - 10);
        }
        
        setX(x - 4);

        for (Block block : blocks) {
            block.tick();
        }
        for (Enemy enemigo : enemies) {
            enemigo.tick();
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
    }

    public void setCurrLvl(int curr) {
        currlvl = curr;
    }
}
