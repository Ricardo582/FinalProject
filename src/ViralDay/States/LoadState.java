package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class LoadState extends GameState {
    private int currentOption = 0;
    private ReadWrite RW;
    
    public LoadState(GameStateManager gsm) {
        super(gsm);
    }
    
    @Override
    public void init() {
    RW = new ReadWrite(this);
        try {
            RW.readSlots();
        } catch (IOException ex) {
            Logger.getLogger(LoadState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void tick() {
        handleInput();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.LS, 0, 0, Game.getWidth(), Game.getHeight(), null);
        if (gsm.slots[0]) {
            g.drawImage(Assets.Partida1[0], Game.getWidth() / 2 - 115, 150, 230, 91, null);
        } else {
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 150, 230, 91, null);
        }
        if (gsm.slots[1]) {
            g.drawImage(Assets.Partida2[0], Game.getWidth() / 2 - 115, 250, 230, 91, null);
        } else {
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 250, 230, 91, null);
        }
        if (gsm.slots[2]) {
            g.drawImage(Assets.Partida3[0], Game.getWidth() / 2 - 115, 350, 230, 91, null);
        } else {
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 350, 230, 91, null);
        }
        g.drawImage(Assets.Regresar[0], Game.getWidth() / 2 - 115, 450, 230, 91, null);
        
        switch (currentOption) {
            case 0:
                if (gsm.slots[0]) {
                    g.drawImage(Assets.Partida1[1], Game.getWidth() / 2 - 115, 150, 230, 91, null);
                } else {
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 150, 230, 91, null);
                }
                break;
            case 1:
                if (gsm.slots[1]) {
                    g.drawImage(Assets.Partida2[1], Game.getWidth() / 2 - 115, 250, 230, 91, null);
                } else {
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 250, 230, 91, null);
                }
                break;
            case 2:
                if (gsm.slots[2]) {
                    g.drawImage(Assets.Partida3[1], Game.getWidth() / 2 - 115, 350, 230, 91, null);
                } else {
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 350, 230, 91, null);
                }
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
                RW.Load("src/saves/Save1.txt");
                Assets.menuSound.stop();
                break;
            case 1:
                //CARGAR SLOT 2
                RW.Load("src/saves/Save2.txt");
                Assets.menuSound.stop();
                break;
            case 2:
                //CARGAR SLOT 3
                RW.Load("src/saves/Save3.txt");
                Assets.menuSound.stop();
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
        return gsm.Load();
    }
}
