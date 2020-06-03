package ViralDay.Entity;

import ViralDay.Manager.Assets;
import java.awt.Graphics;

/**
 *
 * Clase Virus
 * Representa los virus que lanzan los enemigos
 * 
 * @author PalaunuGames
 */
public class Virus extends Item{
    public int velX;
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
     *  @return Null
     */
    public Virus(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.colisionConPlayer = false;
        this.velX = 5;
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
        setX(getX()-velX);
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
        g.drawImage(Assets.virus, getX(), getY(), getWidth(), getHeight(), null);
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
