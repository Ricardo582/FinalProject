
package ViralDay.States;

import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import java.awt.Graphics;

/**
 *
 * Clase GameState
 * Contiene la clase GameState que sirve de modelo para todas las pantallas
 * 
 * @author PalaunuGames
 */
public abstract class GameState {
    protected GameStateManager gsm;
    private int score;

    /**
     * GameState
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        score = 0;
    }

    public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void handleInput();
    public abstract void Save(int slot);
    public abstract GameState Load();
    public abstract ReadWrite getRW();
    public abstract TileMap getTileMap();
    public abstract GameStateManager getGSM();
    
    /**
     * getScore
     * 
     * retorna el score actual
     * 
     * @return score -> puntaje actual (int) 
     */
    public int getScore(){
        return score;
    }
    
    /**
     * setScore
     * 
     * Modifica el score actual
     * 
     * @param sc -> numero representando el puntaje nuevo (int)
     */
    public void setScore(int sc){
        score=sc;
    }
}
