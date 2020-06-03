package ViralDay.Entity;

import ViralDay.Manager.Animation;
import ViralDay.Manager.Assets;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * Clase Spray
 * Representa los objetos Spray
 * 
 * @author PalaunuGames
 */
public class Spray extends Item {

    private TileMap tm;
    private int initX, initY, velY;
    private Animation sprayidle;
    private boolean colisionConPlayer;

    /**
     *  Spray
     * 
     *  Constructor de los spray
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @param tm -> objeto tilemap (TileMap)
     *  @return Null
     */
    public Spray(int x, int y, int width, int height, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        velY = 6;
        this.sprayidle = new Animation(Assets.spSprites, 150);
        colisionConPlayer = false;
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
        this.sprayidle.tick();
        setX(tm.getX() + initX);
        setY(y + velY);
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                velY = 0;
            }
        }
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
        g.drawImage(sprayidle.getCurrentFrame(), getX(), getY(), (getWidth() * -1), getHeight(), null);
    }
    
    /**
     * setColisionPlayer
     * 
     * funcion que define la variable colisionConPlayer
     * 
     * @param status -> variable que indica la colision con player (boolean)
     * @return Null
     */
    public void setColisionPlayer(boolean status){
        colisionConPlayer = status;
    }
    
    /**
     * getColisionPlayer
     * 
     * funcion que retorna si el enemigo esta colisionando con player
     * 
     * @param Null
     * @return colisionConPlayer -> flag que indica la colision con player (boolean)
     */
    public boolean getColisionPlayer(){
        return colisionConPlayer;
    }
}