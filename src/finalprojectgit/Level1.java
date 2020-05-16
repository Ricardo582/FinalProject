package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level1 extends GameState {

    // events
    private boolean blockInput;

    public Level1(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
    }

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
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(true);
        }
        if (blockInput) {
            return;
        }
        if (KeyManager.isDown(KeyManager.LEFT)) {
            //player.setLeft();
        }
        if (KeyManager.isDown(KeyManager.RIGHT)) {
            //player.setRight();
        }
        if (KeyManager.isDown(KeyManager.UP)) {
            //player.setUp();
        }
        if (KeyManager.isDown(KeyManager.DOWN)) {
            //player.setDown();
        }
        if (KeyManager.isPressed(KeyManager.SPACE)) {
            //player.setAction();
        }
    }

}
