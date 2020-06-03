package ViralDay.Entity;

import ViralDay.Manager.Animation;
import ViralDay.Manager.Assets;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * Clase Enemy
 * Representa los enemigos que estaran en el juego
 * 
 * @author PalaunuGames
 */
public class Enemy extends Item {

    private TileMap tm;
    private int initX, initY, velY, color;
    private Animation enemy;
    private boolean colisionConPlayer;
    public boolean stand;

    /**
     *  Enemy
     * 
     *  Constructor de enemigo
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @param color -> diferenciador para mostrar diferentes tipos de enemigos (int)
     *  @param tm -> objeto tilemap (TileMap)
     *  @return Null
     */
    public Enemy(int x, int y, int width, int height, int color, TileMap tm) {
        super(x, y, width, height);
        this.tm = tm;
        this.initX = x;
        this.initY = y;
        this.color = color;
        velY = 6;
        colisionConPlayer = false;
        stand = false;
        switch (color) {
            case 1:
                this.enemy = new Animation(Assets.enemyB1, 150);
                break;
            case 2:
                this.enemy = new Animation(Assets.enemyB2, 150);
                break;
            case 3:
                this.enemy = new Animation(Assets.enemyB3, 150);
                break;
            case 4:
                this.enemy = new Animation(Assets.enemyG1, 150);
                break;
            case 5:
                this.enemy = new Animation(Assets.enemyG2, 150);
                break;
            case 6:
                this.enemy = new Animation(Assets.enemyG3, 150);
                break;
            case 7:
                this.enemy = new Animation(Assets.enemyO1, 150);
                break;
            case 8:
                this.enemy = new Animation(Assets.enemyO2, 150);
                break;
            case 9:
                this.enemy = new Animation(Assets.enemyO3, 150);
                break;
            case 10:
                this.enemy = new Animation(Assets.enemyP1, 150);
                break;
            case 11:
                this.enemy = new Animation(Assets.enemyP2, 150);
                break;
            case 12:
                this.enemy = new Animation(Assets.enemyP3, 150);
                break;
            default:
                break;
        }
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
        this.enemy.tick();
        setX(tm.getX() + initX);
        setY(y + velY);
        for (Block bloque : tm.blocks) {
            if (this.collision(bloque)) {
                velY = 0;
                stand = true;
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
        g.drawImage(enemy.getCurrentFrame(), getX(), getY(), (getWidth() * -1), getHeight(), null);
    }

    /**
     * getColor
     * 
     * funcion que retorna el tipo de enemigo que es
     * 
     * @param Null
     * @return color -> diferenciador para mostrar diferentes tipos de enemigos (int)
     */
    public int getColor() {
        return this.color;
    }
    
    /**
     * setColor
     * 
     * funcion que define la variable color
     * 
     * @param color -> diferenciador para mostrar diferentes tipos de enemigos (int)
     * @return Null
     */
    public void setColor(int color) {
        this.color = color;
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
