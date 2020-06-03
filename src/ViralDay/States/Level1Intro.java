package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level1Intro extends GameState {
    private int alpha;
    private int ticks;
    private int scene = 0;

    private final int FADE_IN = 100;
    private final int LENGTH = 100;
    private final int FADE_OUT = 100;

    public Level1Intro(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
        Assets.harps.play();
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
            scene++;
            ticks = 0;
            if (scene > 3) {
                gsm.setState(GameStateManager.LEVEL1);
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
        g.drawImage(Assets.Lvl1[scene], 0, 0, Game.getWidth(), Game.getHeight(),null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
    }

    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            gsm.setState(GameStateManager.LEVEL1);
        }
    }

    @Override
    public ReadWrite getRW() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TileMap getTileMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public GameStateManager getGSM() {
        return gsm;
    }

    @Override
    public void Save(int slot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameState Load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
