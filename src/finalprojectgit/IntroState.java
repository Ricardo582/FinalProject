package finalprojectgit;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class IntroState extends GameState {
    private int alpha;
    private int ticks;

    private final int FADE_IN = 60;
    private final int LENGTH = 60;
    private final int FADE_OUT = 60;

    public IntroState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
    }

    public void tick() {
        handleInput();
        ticks++;
        if (ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if (alpha < 0) {
                alpha = 0;
            }
        }
        if (ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if (alpha > 255) {
                alpha = 255;
            }
        }
        if (ticks > FADE_IN + LENGTH + FADE_OUT) {
            gsm.setState(GameStateManager.MENU);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
        g.drawImage(Assets.logo, Game.getWidth() / 2 - 157, Game.getHeight() / 2 - 186, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
    }

    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            gsm.setState(GameStateManager.MENU);
        }
    }
}
