/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class OptionsState extends GameState {
    private int currentOption = 0;
    private int SFXVol = 4;
    private int MusicVol = 4;
    
    public OptionsState(GameStateManager gsm) {
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
        g.drawImage(Assets.Efects[0], 40, 150, 183, 27, null);
        g.drawImage(Assets.Music[0], 40, 250, 158, 30, null);
        g.drawImage(Assets.Bar[SFXVol], 90, 160, 800, 90, null);
        g.drawImage(Assets.Bar[MusicVol], 90, 260, 800, 90, null);
        g.drawImage(Assets.Regresar[0], Game.getWidth() / 2 - 115, 350, 230, 91, null);
        switch (currentOption) {
            case 0:
                g.drawImage(Assets.Efects[1], 40, 150, 183, 27, null);
                break;
            case 1:
                g.drawImage(Assets.Music[1], 40, 250, 158, 30, null);
                break;
            case 2:
                g.drawImage(Assets.Regresar[1], Game.getWidth() / 2 - 115, 350, 230, 91, null);
                break;
            default:
                break;
        }
    }

    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setState(GameStateManager.MENU);
        }
        if (KeyManager.isPressed(KeyManager.DOWN) && currentOption < 2) {
            currentOption++;
        }
        if (KeyManager.isPressed(KeyManager.UP) && currentOption > 0) {
            currentOption--;
        }
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            selectOption();
        }
        if (KeyManager.isPressed(KeyManager.RIGHT)) {
            switch(currentOption) {
                case 0:
                    if (SFXVol < 4) {
                        SFXVol++;
                    }
                    break;
                case 1:
                    if (MusicVol < 4) {
                        MusicVol++;
                    }
                    break;
                default:
                    break;
            }
        }
        if (KeyManager.isPressed(KeyManager.LEFT)) {
            switch(currentOption) {
                case 0:
                    if (SFXVol > 0) {
                        SFXVol--;
                    }
                    break;
                case 1:
                    if (MusicVol > 0) {
                        MusicVol--;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void selectOption() {
        switch (currentOption) {
            case 0:
                break;
            case 1:
                break;
            case 2:
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
