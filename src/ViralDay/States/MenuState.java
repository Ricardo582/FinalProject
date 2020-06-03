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
 * Clase MenuState
 * Contiene el estado que representa el menu del juego
 * 
 * @author PalaunuGames
 */
public class MenuState extends GameState {
    private int currentOption = 0;

    /**
     * MenuState
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    /**
     * init
     * 
     * inicializacion de estado
     * 
     * @return Null
     */
    @Override
    public void init() {}

    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @return Null
     */
    @Override
    public void tick() {
        handleInput();
    }

    /**
     * render
     * 
     * rendereo del objeto
     * 
     * @param g -> objeto de graficos (Graphics)
     */
    @Override
    public void render(Graphics g) {
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

    /**
     * handleInput
     * 
     * Manejador de input de teclado
     * 
     * @return Null
     */
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

    /**
     * selectOption
     * 
     * Carga el estado de acuerdo a la opcion seleccionada
     * 
     * @return Null
     */
    private void selectOption() {
        switch (currentOption) {
            case 0:
                gsm.setState(GameStateManager.LEVEL1INTRO);
                break;
            case 1:
                gsm.setState(GameStateManager.LOAD);
                break;
            case 2:
                gsm.setState(GameStateManager.OPTIONS);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * getRW
     * 
     * Retorna el objeto ReadWrite para manejar archivos
     * 
     * @return Null
     */
    @Override
    public ReadWrite getRW() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getTileMap
     * 
     * Retorna el objeto TileMap desde el que se manejan todos los objetos
     * 
     * @return Null
     */
    @Override
    public TileMap getTileMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * getGSM
     * 
     * Retorna el GameStateManager
     * 
     * @return gsm -> objeto GameStateManager (GameStateManager)
     */
    @Override
    public GameStateManager getGSM() {
        return gsm;
    }

    /**
     * Save
     * 
     * Guarda la partida en un slot especifico
     * 
     * @param slot -> slot en el que se guarda la partida (int)
     */
    @Override
    public void Save(int slot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Load
     * 
     * Carga la partida de un slot especifico
     * 
     * @return gameStates[currentState].Load() -> manda a llamar a la funcion load del state actual
     */
    @Override
    public GameState Load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
