package ViralDay.Entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * Clase Item
 * Representa los items que estan en el juego, todas las entidades heredan de esta
 * 
 * @author PalaunuGames
 */
public abstract class Item {

    protected int x;        // to store x position
    protected int y;        // to store y position
    protected int width;
    protected int height;

    /**
     *  Item
     * 
     *  Constructor de Item
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @return Null
     */
    public Item(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * getX
     * 
     * retorna la posicion x del objeto
     * 
     * @param Null
     * @return x -> Posicion x del objeto (int)
     */
    public int getX() {
        return x;
    }

    /**
     * getY
     * 
     * retorna la posicion y del objeto
     * 
     * @param Null
     * @return y -> Posicion y del objeto (int)
     */
    public int getY() {
        return y;
    }

    /**
     * getWidth
     * 
     * retorna la anchura del objeto
     * 
     * @param Null
     * @return width -> anchura del objeto (int)
     */
    public int getWidth() {
        return width;
    }

    /**
     * getHeight
     * 
     * retorna la altura del objeto
     * 
     * @param Null
     * @return height -> altura del objeto (int)
     */
    public int getHeight() {
        return height;
    }

    /**
     * setX
     * 
     * modifica la posicion x del objeto
     * 
     * @param x -> Posicion x del objeto (int)
     * @return Null
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setY
     * 
     * modifica la posicion y del objeto
     * 
     * @param y -> Posicion y del objeto (int)
     * @return Null
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * setWidth
     * 
     * modifica la anchura del objeto
     * 
     * @param width -> Anchura del objeto (int)
     * @return Null
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * setHeigth
     * 
     * modifica la altura del objeto
     * 
     * @param height -> Altura del objeto (int)
     * @return Null
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @param Null
     * @return Null
     */
    public abstract void tick();

    /**
     * render
     * 
     * render del objeto
     * 
     * @param g -> graficos del videojuego (Graphics)
     * @return Null
     */
    public abstract void render(Graphics g);

    /**
     * Collision
     * 
     * funcion que detecta la colision entre objetos
     * 
     * @param o -> Objeto con el que se detecta la colision (Object)
     * @return bStatus -> Valor que define si dos objetos estan en colision o no (boolean)
     */
    public boolean collision(Object o) {
        boolean bStatus = false;        // assuming not collision
        if (o instanceof Item) {
            Rectangle rThis = new Rectangle(getX(), getY(), getWidth(), getHeight());
            Item i = (Item) o;
            Rectangle rOther = new Rectangle(i.getX(), i.getY(), i.getWidth(), i.getHeight());

            bStatus = rThis.intersects(rOther);
        }

        return bStatus;
    }
    
    /**
     * Hold
     * 
     * funcion que detecta que un punto este dentro de un objeto
     * 
     * @param P -> Objeto que representa un punto en la pantalla (Point)
     * @return bStatus -> Valor que define si el punto esta dentro del objeto (boolean)
     */
    public boolean hold(Point p){
        boolean bStatus = false;
        Rectangle rThis = new Rectangle(getX(), getY(), getWidth(), getHeight());
        
        bStatus = rThis.contains(p);
        
        return bStatus;
    }
    
    /**
     * isInside
     * 
     * funcion que detecta que un objeto este dentro de otro
     * 
     * @param o -> Objeto con el que se detecta la contencion (Object)
     * @return bStatus -> Valor que define si el objeto esta contenido o no (boolean)
     */
    public boolean isInside(Object o) {
        boolean bStatus = true;        // assuming is outside
        if (o instanceof Item) {
            Rectangle rThis = new Rectangle(getX()+20, getY(), getWidth()+15, getHeight()+15);
            Item i = (Item) o;
            Rectangle rOther = new Rectangle(i.getX(), i.getY(), i.getWidth(), i.getHeight());

            bStatus = rThis.contains(rOther);
        }

        return bStatus;
    }
}
