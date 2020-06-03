package ViralDay.Entity;

import ViralDay.Manager.Animation;
import ViralDay.Manager.Assets;
import ViralDay.States.GameState;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * Clase Player
 * Representa al jugador
 * 
 * @author PalaunuGames
 */
public class Player extends Item {
    public GameState lvl;
    private int velY = 0;
    private int velTimer = 0;
    private int velTimer2 = 0;
    private boolean jumpFlag = false;
    private boolean fallFlag = false;
    private boolean attackflag= false;
    private TileMap tm;
    private Animation run;
    private Animation jump;
    private Animation fall;
    private Animation idle;
    private Animation attack;
    private int vidas = 5;
    private int ammo = 3;
    

    /**
     *  Player
     * 
     *  Constructor de Player
     * 
     *  @param x -> posicion en x (int)
     *  @param y -> posicion en y (int)
     *  @param width -> ancho del objeto (int)
     *  @param height -> alto del objeto (int)
     *  @param lvl -> objeto GameState (GameState)
     *  @param tm -> objeto tilemap (TileMap)
     *  @return Null
     */
    public Player(int x, int y, int width, int height, GameState lvl, TileMap tm) {
        super(x, y, width, height);
        this.lvl = lvl;
        this.tm = tm;
        this.run = new Animation(Assets.playerRun, 150);
        this.jump = new Animation(Assets.playerJump, 150);
        this.fall = new Animation(Assets.playerFall, 150);
        this.idle = new Animation(Assets.playerIdle, 150);
        this.attack= new Animation(Assets.playerAttack, 150);
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
        this.run.tick();
        this.jump.tick();
        this.fall.tick();
        this.idle.tick();
        this.attack.tick();
        if(KeyManager.isPressed(KeyManager.UP) && !fallFlag){
            jumpFlag = true;
            velY = 5;
        }
        if(KeyManager.isPressed(KeyManager.DOWN)&& !attackflag){
            if(this.getAmmo()>0){
            attackflag=true;
            }
        }
        if(attackflag){
            velTimer2 += 1;
            if(velTimer2 >= 50) {
                this.setAmmo(this.getAmmo()-1);
                attackflag = false;
                velTimer2 = 0;
            }
        }
        if(jumpFlag) {
            setY(y - velY);
            velTimer += 1;
            if(velTimer >= 30) {
                jumpFlag = false;
                fallFlag = true;
                velTimer = 0;
            }
        } else {
            setY(y + velY); 
        }
        for (Block bloque : tm.blocks) {
            if(this.collision(bloque)) {
                velY = 0;
                fallFlag = false;
                setY(bloque.y - height);
            } 
            else{
                velY = 10;
            }
        }
        
        //Aquí se hace la lógica para restar vidas cuando colisione con un enemigo
        for (Enemy enemy : tm.enemies) {
            if(this.collision(enemy)) {
                //Verificamos que sea la primera vez que choca
                if(enemy.getColisionPlayer() == false){ //si no ha colisionado antes, entonces se resta una vida
                    setVidas(getVidas() - 1);
                    enemy.setColisionPlayer(true);
                }              
            }
        }
        //COLISION CON SPRAY
        for (Spray sprays : tm.sprays) {
            if(this.collision(sprays)) {
                //Verificamos que sea la primera vez que choca
                if(sprays.getColisionPlayer() == false){ //si no ha colisionado antes, entonces se resta una vida
                    setAmmo(getAmmo() + 2);
                    sprays.setColisionPlayer(true);
                }              
            }
        }
        for (Virus bichos : tm.viruses) {
            if(this.collision(bichos)) {
                //Verificamos que sea la primera vez que choca
                if(bichos.getColisionPlayer() == false){ //si no ha colisionado antes, entonces se resta una vida
                    setVidas(getVidas() - 1);
                    bichos.setColisionPlayer(true);
                }              
            }
        }
        for (Virus bichos : tm.viruses) {
            if(this.isInside(bichos)&& attackflag) {
                //Verificamos que sea la primera vez que choca
                if(bichos.getColisionPlayer() == false){ //si no ha colisionado antes, entonces se resta una vida
                    bichos.setColisionPlayer(true);
                    lvl.setScore(lvl.getScore()+10);
                }              
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
        if (jumpFlag) {
            g.drawImage(jump.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (fallFlag) {
            g.drawImage(fall.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (KeyManager.isDown(KeyManager.LEFT)){
            g.drawImage(idle.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (attackflag){
            g.drawImage(attack.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(run.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
    /**
     * setVelY
     * 
     * modifica la Velocidad en y del objeto
     * 
     * @param velY -> Velocidad en y del objeto (int)
     * @return Null
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    /**
     * setVidas
     * 
     * modifica las vidas del Player
     * 
     * @param vidas -> Vidas que tiene el jugador (int)
     * @return Null
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    /**
     * getVidas
     * 
     * retorna las vidas del jugador
     * 
     * @param Null
     * @return vidas -> Vidas que tiene el jugador (int)
     */
    public int getVidas() {
        return this.vidas;
    }
    
    /**
     * getAmmo
     * 
     * retorna la municion del jugador
     * 
     * @param Null
     * @return ammo -> municion que tiene el jugador (int)
     */
    public int getAmmo() {
        return this.ammo;
    }
    
    /**
     * setAmmo
     * 
     * modifica la municion del Player
     * 
     * @param ammo -> municion que tiene el jugador (int)
     * @return Null
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
    
    /**
     * getAmmoText
     * 
     * retorna la municion del jugador en string
     * 
     * @param Null
     * @return ammo -> municion que tiene el jugador (str)
     */
    public String getAmmoText(){
        return Integer.toString(getAmmo());
    }
    
    /**
     * getVidasText
     * 
     * retorna las vidas del jugador en string
     * 
     * @param Null
     * @return vidas -> Vidas que tiene el jugador (str)
     */
    public String getVidasText(){
        return Integer.toString(getVidas());
    }
}
