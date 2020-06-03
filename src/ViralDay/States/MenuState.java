package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class MenuState extends GameState {
    private int currentOption = 0;
    private boolean options = false;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        Assets.menuSound.play(gsm.getVolMusic());
        Assets.menuSound.setLooping(true);
    }

    @Override
    public void tick() {
        handleInput();
    }

    @Override
    public void render(Graphics g) {
        if (!options) {
            g.drawImage(Assets.menu, 0, 0, Game.getWidth(), Game.getHeight(), null);
            g.drawImage(Assets.Jugar[0], 225, 200, 230, 91, null);
            g.drawImage(Assets.Cargar[0], 225, 295, 230, 91, null);
            g.drawImage(Assets.Opciones[0], 225, 390, 230, 91, null);
            g.drawImage(Assets.Salir[0], 225, 485, 230, 91, null);
            switch (currentOption) {
                case 0:
                    g.drawImage(Assets.Jugar[1], 225, 200, 230, 91, null);
                    break;
                case 1:
                    g.drawImage(Assets.Cargar[1], 225, 295, 230, 91, null);
                    break;
                case 2:
                    g.drawImage(Assets.Opciones[1], 225, 390, 230, 91, null);
                    break;
                case 3:
                    g.drawImage(Assets.Salir[1], 225, 485, 230, 91, null);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.DOWN) && currentOption < 3) {
            currentOption++;
        }
        if (KeyManager.isPressed(KeyManager.UP) && currentOption > 0) {
            currentOption--;
        }
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            selectOption();
        }
    }

    private void selectOption() {
        switch (currentOption) {
            case 0:
                gsm.setState(GameStateManager.LEVEL1INTRO);
                Assets.menuSound.stop();
                break;
            case 1:
                gsm.setState(GameStateManager.LOAD);
                break;
            case 2:
                gsm.setState(GameStateManager.OPTIONS);
                options = true;
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
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
