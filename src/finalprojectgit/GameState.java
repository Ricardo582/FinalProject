
package finalprojectgit;

import java.awt.Graphics;
/**
 *
 * @author ricar
 */
public abstract class GameState {
    protected GameStateManager gsm;
	
    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void handleInput();
    public abstract ReadWrite getRW();
    public abstract TileMap getTileMap();
}
