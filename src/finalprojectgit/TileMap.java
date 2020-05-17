/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectgit;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author hgm
 */
public class TileMap extends Item{
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
    
    public void init(){
        int[][] tilemap = new int[10][30];
        tilemap = lvl.getRW().tileRead("lvl1.txt");
        generateMap(tilemap);
        //genera enemigos de acuerdo al nivel
    }
    
    public void generateMap(int[][] mat){
        System.out.println("generando mapa... ");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 30; j++){
                if(mat[i][j] != 0){
                    Block curr = new Block((getX()+(j*100)), (getY()+(i*100)), 100, 100, mat[i][j], (j*100), (i*100), this);
                    /*System.out.println("TileMap: (" + this.x + ", " + this.y + ")");
                    System.out.println("Block: (" + i + ", " + j + ")");
                    System.out.println("bloque generado en (" + (getX()+(j*100)) + ", " + (getY()+(i*100)) + ")");*/
                    blocks.add(curr);
                }
            }
        }
        for(int i = 0; i < 5; i++){
            int randBlock = (int)(5+(Math.random()*25));
            //System.out.println("randBlock: " + randBlock);
            int randX = (randBlock*100) + 10;
            //System.out.println("randX: " + randX);
            Enemy temp = new Enemy(randX, -200, 80, 200, this);
            //System.out.println("Enemigo generado en: ("+randX+", "+(-200)+")");
            enemies.add(temp);
        }
    }

    @Override
    public void tick() {
        if(KeyManager.isDown(KeyManager.LEFT)){
            setX(x+10);
        }
        if(KeyManager.isDown(KeyManager.RIGHT)){
            setX(x-10);
        }
        
        for (Block block: blocks){
            block.tick();
        }
        for(Enemy enemigo: enemies){
            enemigo.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        System.out.println(currlvl);
        switch(currlvl) {
            case 1:
                g.drawImage(Assets.background1, x, y, width, height, null);
                break;
                
            case 2:
                g.drawImage(Assets.background2, x, y, width, height, null);
                break;
                
            case 3:
                g.drawImage(Assets.background3, x, y, width, height, null);
                break;
                
            default:
                break;
        }
        
        for(Block block: blocks){
            block.render(g);
        }
        for(Enemy enemigo: enemies){
            enemigo.render(g);
        }
    }
    
    public void setCurrLvl(int curr) {
        currlvl = curr;
    }
}
