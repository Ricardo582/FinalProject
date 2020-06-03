package ViralDay.Entity;

import ViralDay.Manager.Assets;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * Clase Block
 * Representa los bloques que generan las estructuras y plataformas del juego
 * 
 * @author PalaunuGames
 */
public class Block extends Item{
    private int type;
    private TileMap tm;
    private int initX, initY;

    
    /**
     *  Block
     * 
     *  Constructor de bloque
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @param type -> diferenciador para mostrar diferentes tipos de bloques (int)
     *  @param initX -> posicion en la que inicia en x a partir del tilemap (int)
     *  @param initY -> posicion en la que inicia en y a partir del tilemap (int)
     *  @param tm -> objeto tilemap (TileMap)
     *  @return Null
     */
    public Block(int x, int y, int width, int height, int type, int initX, int initY, TileMap tm) {
        super(x, y, width, height);
        this.type = type;
        this.tm = tm;
        this.initX = initX;
        this.initY = initY + 70;
    }

    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @param Null
     * @return Null
     */
    @Override
    public void tick() {
        setX(tm.getX()+initX);
        setY(tm.getY()+initY);
    }

    /**
     * render
     * 
     * render del objeto
     * 
     * @param g -> graficos del videojuego (Graphics)
     * @return Null
     */
    @Override
    public void render(Graphics g) {
        //render dependiendo del sprite (lo determina el type)
        switch(type){
            case 1:
                g.drawImage(Assets.b1, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 2:
                g.drawImage(Assets.b2, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 3:
                g.drawImage(Assets.b3, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 4:
                g.drawImage(Assets.b4, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 5:
                g.drawImage(Assets.b5, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 6:
                g.drawImage(Assets.b6, getX(), getY(), getWidth(), getHeight(), null);
                break;
        }
    }
    
}
