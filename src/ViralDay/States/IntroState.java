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
 * Clase IntroState
 * Contiene el estado del juego que muestra el intro
 * 
 * @author PalaunuGames
 */
public class IntroState extends GameState {
    private int alpha;
    private int ticks;

    private final int FADE_IN = 100;
    private final int LENGTH = 60;
    private final int FADE_OUT = 100;

    /**
     * GameOverState
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public IntroState(GameStateManager gsm) {
        super(gsm);
    }

    /**
     * init
     * 
     * inicializacion de estado
     * 
     * @return Null
     */
    public void init() {
        ticks = 0;
    }

    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @return Null
     */
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

    /**
     * tick
     * 
     * tickeo del objeto
     * 
     * @return Null
     */
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
        g.drawImage(Assets.logo, Game.getWidth() / 2 - 157, Game.getHeight() / 2 - 186, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
    }

    /**
     * handleInput
     * 
     * Manejador de input de teclado
     * 
     * @return Null
     */
    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            gsm.setState(GameStateManager.MENU);
        }
    }

    /**
     * gerRW
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
