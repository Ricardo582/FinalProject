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
 * Clase TileMap
 * Contiene funciones para generacion de niveles y maneja las entidades de los objetos (exceptuando jugador)
 * 
 * @author PalaunuGames
 */
public class TileMap extends Item {

    private GameState lvl;
    public LinkedList<Enemy> enemies;
    public LinkedList<Block> blocks;
    public LinkedList<Spray> sprays;
    public LinkedList<Virus> viruses;
    public int currlvl;

    /**
     *  TileMap
     * 
     *  Constructor de TileMap
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @param lvl -> objeto GameState (GameState)
     *  @return Null
     */
    public TileMap(int x, int y, int width, int height, GameState lvl) {
        super(x, y, width, height);
        this.lvl = lvl;
        enemies = new LinkedList();
        blocks = new LinkedList();
        viruses = new LinkedList();
        sprays = new LinkedList();

    }

    /**
     * init
     * 
     * inicializa el tilemap y manda a generar los objetos del nivel
     * 
     * @return Null
     */
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

    /**
     * generateMap
     * 
     * Genera los objetos del nivel de acuerdo a el mapa que se lee de un archivo
     * @param mat -> representa una matriz de mapa donde se indican la posicion de generacion de los objetos (int [][])
     */
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

    /**
     * tick
     * 
     * tickeo del objeto, manda a llamar los tick de las clases internas
     * 
     * @param Null
     * @return Null
     */
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

    /**
     * render
     * 
     * render del objeto, manda a llamar el render de las clases internas
     * 
     * @param g -> graficos del videojuego (Graphics)
     * @return Null
     */
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
        /*
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Puntos: 0", Game.getWidth() - 60, 40);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Vidas: 0", Game.getWidth() - 60, 20);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("CONTROLES: ", 20, 20);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Saltar: flecha arriba", 20, 40);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Atrás: flecha izquierda", 20, 60);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Adelante: flecha derecha", 20, 80);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Siguiente nivel: ESPACIO", 20, 100);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Pausa: ESC", 20, 120);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        */
        g.setColor(Color.black);
        g.drawString("Puntos = " + lvl.getScore(), Game.getWidth() - 160, 40);
        g.setFont(new Font("Arial", Font.BOLD, 12));
    }

    /**
     * setCurrLvl
     * 
     * modifica el nivel al que pertenece el tilemap
     * 
     * @param curr -> representa nivel al que se cambiara (int)
     */
    public void setCurrLvl(int curr) {
        currlvl = curr;
    }
    
    /**
     * getEnemies
     * 
     * Retorna una linkedlist con todos los objetos enemigos que estan en el tilemap
     * 
     * @return enemies -> linkedlist con todos los enemigos en tilemap (LinkedList<Enemy>)
     */
    public LinkedList getEnemies() {
        return enemies;
    }
    
    /**
     * getCurrLvlState
     * 
     * retorna el estado del nivel actual de tilemap
     * @return int -> estado del nivel actual de tilemap (int)
     */
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
