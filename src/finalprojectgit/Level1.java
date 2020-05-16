package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level1 extends GameState {
    
    public Level1(GameStateManager gsm) {
        super(gsm);
    }
    
    @Override
    public void init() {}

    @Override
    public void tick() {
        handleInput();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.lvla, 0, 0, Game.getWidth(), Game.getHeight(), null);
    }

    @Override
    public void handleInput() {
        
    }
    
}
