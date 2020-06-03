package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.KeyManager;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.GameStateManager;
import ViralDay.Entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * Clase Level3
 * Contiene el estado del juego que muestra el nivel 3
 * 
 * @author PalaunuGames
 */
public class Level3 extends GameState {

    // events
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;

    /**
     * Level3
     * 
     * constructor del estado
     * 
     * @param gsm -> objeto GameStateManager que lo llama (GameStateManager)
     */
    public Level3(GameStateManager gsm) {
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
        tileMap = new TileMap(0, -150, 1000, 750, this);
        RW = new ReadWrite(this);
        tileMap.setCurrLvl(3);
        tileMap.init();
        player = new Player(200, 500, 50, 70, this, tileMap);
    }

    /**
     * tick
     * 
     * tickeo del objeto, y llamada a tick de objetos internos
     * 
     * @return Null
     */
    @Override
    public void tick() {
        handleInput();
        RW.tick();
        tileMap.tick();
        player.tick();
        if (tileMap.getX() < -7800) {
            gsm.setState(GameStateManager.WIN);
        }
        if (player.getVidas() == 0) {
            gsm.setState(GameStateManager.GAMEOVER);
        }
    }

    /**
     * render
     * 
     * rendereo del objeto, y llamada a render de objetos internos
     * 
     * @param g -> objeto de graficos (Graphics)
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.back, 0, 0, Game.getWidth(), Game.getHeight(), null);
        tileMap.render(g);
        player.render(g);
        
        //Aquí se muestran las vidas del jugador en el respectivo nivel
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Vidas = " + player.getVidasText(), Game.getWidth() - 80, 20);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.black);
        g.drawString("Ammo = " + player.getAmmoText(), Game.getWidth() - 160, 20);
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
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(true);
        }
        if (blockInput) {
            return;
        }
        if (KeyManager.isDown(KeyManager.LEFT)) {
            //player.setLeft();
        }
        if (KeyManager.isDown(KeyManager.RIGHT)) {
            //player.setRight();
        }
        if (KeyManager.isDown(KeyManager.UP)) {
            //player.setUp();
        }
        if (KeyManager.isDown(KeyManager.DOWN)) {
            //player.setDown();
        }
        if (KeyManager.isPressed(KeyManager.SPACE)) {
            System.out.println(GameStateManager.GAMEOVER);
            gsm.setState(GameStateManager.GAMEOVER);
        }
    }
    
    /**
     * getTileMap
     * 
     * Retorna el objeto TileMap desde el que se manejan todos los objetos
     * 
     * @return tileMap -> objeto TileMap del nivel (TileMap)
     */
    public TileMap getTileMap() {
        return tileMap;
    }
    
    /**
     * getRW
     * 
     * Retorna el objeto ReadWrite para manejar archivos
     * 
     * @return RW -> objeto ReadWrite del nivel (ReadWrite)
     */
    public ReadWrite getRW(){
        return RW;
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
    public void Save(int slot) {
        switch(slot) {
            case 1:
                RW.Save("src/saves/Save1.txt");
                break;
            case 2:
                RW.Save("src/saves/Save2.txt");
                break;
            case 3:
                RW.Save("src/saves/Save3.txt");
                break;
            default:
                break;
        }
    }

    /**
     * Load
     * 
     * Carga la partida de un slot especifico
     * 
     * @return gsm.load() -> manda a llamar a load de GameStateManager
     */
    @Override
    public GameState Load() {
        return gsm.Load();
    }
}
