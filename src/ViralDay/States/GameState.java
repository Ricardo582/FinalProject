
package ViralDay.States;

import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import java.awt.Graphics;
/**
 *
 * @author ricar
 */
public abstract class GameState {
    protected GameStateManager gsm;
    private int score;
	
    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        this.score = 0;
    }

    public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void handleInput();
    public abstract ReadWrite getRW();
    public abstract TileMap getTileMap();
    
    public int getScore(){
        return score;
    }
    public void setScore(int sc){
        score=sc;
    }
}
