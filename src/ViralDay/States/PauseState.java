package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class PauseState extends GameState {

    private int timer;
    private int currentOption = 0;
    private int currentOptionSave = 0;
    private boolean Save = false;
    private boolean Load = false;
    private ReadWrite RW;

    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        timer = 0;
        RW = new ReadWrite(this);
        try {
            RW.readSlots();
        } catch (IOException ex) {
            Logger.getLogger(LoadState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tick() {
        timer++;
        handleInput();
    }

    public void render(Graphics g) {
        if (timer < 1) {
            g.drawImage(Assets.backPause, 0, 0, Game.getWidth(), Game.getHeight(), null);
        }
        g.drawImage(Assets.Pause, Game.getWidth() / 2 - 150, 70, 300, 58, null);
        g.drawImage(Assets.Continuar[0], Game.getWidth() / 2 - 115, 170, 230, 91, null);
        g.drawImage(Assets.Guardar[0], Game.getWidth() / 2 - 115, 270, 230, 91, null);
        g.drawImage(Assets.Cargar[0], Game.getWidth() / 2 - 115, 370, 230, 91, null);
        g.drawImage(Assets.Salir[0], Game.getWidth() / 2 - 115, 470, 230, 91, null);
        
        switch (currentOption) {
            case 0:
                g.drawImage(Assets.Continuar[1], Game.getWidth() / 2 - 115, 170, 230, 91, null);
                break;
            case 1:
                g.drawImage(Assets.Guardar[1], Game.getWidth() / 2 - 115, 270, 230, 91, null);
                break;
            case 2:
                g.drawImage(Assets.Cargar[1], Game.getWidth() / 2 - 115, 370, 230, 91, null);
                break;
            case 3:
                g.drawImage(Assets.Salir[1], Game.getWidth() / 2 - 115, 470, 230, 91, null);
                break;
            default:
                break;
        }
        if (Save || Load) {
            if (gsm.slots[0]) {
                g.drawImage(Assets.Partida1[0], Game.getWidth() / 2 - 115, 170, 230, 91, null);
            } else {
                g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 170, 230, 91, null);
            }
            if (gsm.slots[1]) {
                g.drawImage(Assets.Partida2[0], Game.getWidth() / 2 - 115, 270, 230, 91, null);
            } else {
                g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 270, 230, 91, null);
            }
            if (gsm.slots[2]) {
                g.drawImage(Assets.Partida3[0], Game.getWidth() / 2 - 115, 370, 230, 91, null);
            } else {
                g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 370, 230, 91, null);
            }
            g.drawImage(Assets.Regresar[0], Game.getWidth() / 2 - 115, 470, 230, 91, null);
            switch (currentOptionSave) {
                case 0:
                    if (gsm.slots[0]) {
                        g.drawImage(Assets.Partida1[1], Game.getWidth() / 2 - 115, 170, 230, 91, null);
                    } else {
                        g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 170, 230, 91, null);
                    }
                    break;
                case 1:
                    if (gsm.slots[1]) {
                        g.drawImage(Assets.Partida2[1], Game.getWidth() / 2 - 115, 270, 230, 91, null);
                    } else {
                        g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 270, 230, 91, null);
                    }
                    break;
                case 2:
                    if (gsm.slots[2]) {
                        g.drawImage(Assets.Partida3[1], Game.getWidth() / 2 - 115, 370, 230, 91, null);
                    } else {
                        g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 370, 230, 91, null);
                    }
                    break;
                case 3:
                    g.drawImage(Assets.Regresar[1], Game.getWidth() / 2 - 115, 470, 230, 91, null);
                default:
                    break;
            }
        }
    }

    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            if (Save) {
                Save = false;
                currentOptionSave = 0;
            } else if (Load) {
                Load = false;
                currentOptionSave = 0;
            } else {
                gsm.setPaused(false);
            }
        }
        if (KeyManager.isPressed(KeyManager.DOWN)) {
            if (Save || Load) {
                if (currentOptionSave < 3) {
                    currentOptionSave++;
                }
            } else {
                if (currentOption < 3) {
                    currentOption++;
                }
            }
        }
        if (KeyManager.isPressed(KeyManager.UP) && (currentOption > 0 || currentOptionSave > 0)) {
            if (Save || Load) {
                currentOptionSave--;
            } else {
                currentOption--;
            }
        }
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            if (Save) {
                selectOptionSave();
            } else if (Load) {
                selectOptionLoad();
            } else {
                selectOption();
            }
        }
    }

    private void selectOption() {
        switch (currentOption) {
            case 0:
                gsm.setPaused(false);
                break;
            case 1:
                Save = true;
                currentOption = 0;
                break;
            case 2:
                Load = true;
                currentOption = 0;
                break;
            case 3:
                gsm.setState(GameStateManager.MENU);
                gsm.setPaused(false);
                Assets.backSound.stop();
                break;
            default:
                break;
        }
    }
    
    private void selectOptionSave() {
        switch (currentOptionSave) {
            case 0:
                // GUARDAR SLOT 1
                gsm.Save(1);
                break;
            case 1:
                // GUARDAR SLOT 2
                gsm.Save(2);
                break;
            case 2:
                // GUARDAR SLOT 3
                gsm.Save(3);
                break;
            case 3:
                Save = false;
                currentOptionSave = 0;
                break;
            default:
                break;
        }
        try {
            RW.readSlots();
        } catch (IOException ex) {
            Logger.getLogger(LoadState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void selectOptionLoad() {
        switch (currentOptionSave) {
            case 0:
                //CARGAR SLOT 1
                RW.Load("src/saves/Save1.txt");
                break;
            case 1:
                //CARGAR SLOT 2
                RW.Load("src/saves/Save2.txt");
                break;
            case 2:
                //CARGAR SLOT 3
                RW.Load("src/saves/Save3.txt");
                break;
            case 3:
                Load = false;
                currentOptionSave = 0;
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
