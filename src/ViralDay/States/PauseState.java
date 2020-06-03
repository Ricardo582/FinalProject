package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;

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

    public PauseState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        timer = 0;
    }

    public void tick() {
        System.out.println(currentOptionSave);
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
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 170, 230, 91, null);
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 270, 230, 91, null);
            g.drawImage(Assets.Vacio[0], Game.getWidth() / 2 - 115, 370, 230, 91, null);
            g.drawImage(Assets.Regresar[0], Game.getWidth() / 2 - 115, 470, 230, 91, null);
            switch (currentOptionSave) {
                case 0:
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 170, 230, 91, null);
                    break;
                case 1:
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 270, 230, 91, null);
                    break;
                case 2:
                    g.drawImage(Assets.Vacio[1], Game.getWidth() / 2 - 115, 370, 230, 91, null);
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
                break;
            default:
                break;
        }
    }
    
    private void selectOptionSave() {
        switch (currentOptionSave) {
            case 0:
                // GUARDAR SLOT 1
                break;
            case 1:
                // GUARDAR SLOT 2
                break;
            case 2:
                // GUARDAR SLOT 3
                break;
            case 3:
                Save = false;
                currentOptionSave = 0;
                break;
            default:
                break;
        }
    }
    
    private void selectOptionLoad() {
        switch (currentOptionSave) {
            case 0:
                // CARGAR SLOT 1
                break;
            case 1:
                // CARGAR SLOT 2
                break;
            case 2:
                // CARGAR SLOT 3
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

}
