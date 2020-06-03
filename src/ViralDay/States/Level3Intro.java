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
 * Clase Level3Intro
 * Contiene el estado del juego que muestra la intro del nivel 3
 * 
 * @author PalaunuGames
 */
public class Level3Intro extends GameState {
    private int alpha;
    private int ticks;
    private int scene = 0;

    private final int FADE_IN = 100;
    private final int LENGTH = 100;
    private final int FADE_OUT = 100;

    /**
     * Level3Intro
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public Level3Intro(GameStateManager gsm) {
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
            scene++;
            ticks = 0;
            if (scene > 1) {
                gsm.setState(GameStateManager.LEVEL3);
            }
        }
    }

    /**
     * render
     * 
     * rendereo del objeto
     * 
     * @param g -> objeto de graficos (Graphics)
     */
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());
        g.drawImage(Assets.Lvl3[scene], 0, 0, Game.getWidth(), Game.getHeight(), null);
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
            gsm.setState(GameStateManager.LEVEL3);
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
