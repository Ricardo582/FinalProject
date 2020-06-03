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
 * Clase LoadState
 * Contiene el estado que representa la carga del juego
 * 
 * @author PalaunuGames
 */
public class LoadState extends GameState {
    private int currentOption = 0;
    private ReadWrite RW;
    
    /**
     * LoadState
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public LoadState(GameStateManager gsm) {
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
    public void init() {
    RW = new ReadWrite(this);
    }

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

    /**
     * handleInput
     * 
     * Manejador de input de teclado
     * 
     * @return Null
     */
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

    /**
     * selectOption
     * 
     * Carga el archivo de guardado de acuerdo al slot seleccionado
     * 
     * @return Null
     */
    private void selectOption() {
        switch (currentOption) {
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
                gsm.setState(GameStateManager.MENU);
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
        return gsm.Load();
    }
}
