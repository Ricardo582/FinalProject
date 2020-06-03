package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class LoadState extends GameState {
    private int currentOption = 0;
    
    public LoadState(GameStateManager gsm) {
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
        g.drawImage(Assets.LS, 0, 0, Game.getWidth(), Game.getHeight(), null);
        g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 150, 230, 91, null);
        g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 250, 230, 91, null);
        g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 350, 230, 91, null);
        g.drawImage(Assets.Regresar[0], Game.getWidth() / 2 - 115, 450, 230, 91, null);
        
        switch (currentOption) {
            case 0:
                g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 150, 230, 91, null);
                break;
            case 1:
                g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 250, 230, 91, null);
                break;
            case 2:
                g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 350, 230, 91, null);
                break;
            case 3:
                g.drawImage(Assets.Regresar[1], Game.getWidth() / 2 - 115, 450, 230, 91, null);
                break;
            default:
                break;
        }
    }

    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setState(GameStateManager.MENU);
        }
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
                //CARGAR SLOT 1
                break;
            case 1:
                //CARGAR SLOT 2
                break;
            case 2:
                //CARGAR SLOT 3
                break;
            case 3:
                gsm.setState(GameStateManager.MENU);
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
    
}
