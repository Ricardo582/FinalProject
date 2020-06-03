package ViralDay.Manager;

import ViralDay.Manager.KeyManager;
import ViralDay.Manager.GameStateManager;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 *
 * Clase Game
 * Genera el juego
 * 
 * @author PalaunuGames
 */
public class Game implements Runnable, KeyListener {

    private BufferStrategy bs;          // to have several buffers when displaying
    private Graphics g;                 // to paint objects
    private Display display;            // to display in the game
    public static int width;                   // width of the window
    public static int height;                  // height of the window
    private Thread thread;              // thread to create the game
    String title;                       // title of the window
    private boolean running;            // to set the game
    private KeyManager keyManager;      // to manage the keyboard
    private GameStateManager gsm;

    /**
     * 
     * Game
     * 
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     * @return Null
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
    }

    /**
     * 
     * init
     * 
     * initializing the display window of the game
     * 
     * @param Null
     * @return Null
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        display.getJframe().addKeyListener(this);
        Assets.init();
        gsm = new GameStateManager();
        keyManager = new KeyManager();
    }

    /**
     * 
     * run
     * 
     * Manda a inicializar el juego y define la velocidad de este
     * 
     * @param Null
     * @return Null
     */
    @Override
    public void run() {
        init();
        
        // frames per second
        int fps = 60;
        
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        
        // initializing delta
        double delta = 0;
        
        // define now to use inside the loop
        long now;
        
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            
            // setting the time now to the actual time
            now = System.nanoTime();
            
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            
            // updating the last time
            lastTime = now;
            
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    /**
     * tick
     * 
     * manda a llamar al tick de las clases inferiores
     * 
     * @param Null
     * @return Null
     */
    private void tick() {
        gsm.tick();
        keyManager.tick();
    }

    /**
     * render
     * 
     * genera los graficos y manda a llamar al render de las clases inferiores
     * 
     * @param Null
     * @return Null
     */
    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            gsm.render(g);
            bs.show();
            g.dispose();
        }
    }

    /**
     * 
     * start
     * 
     * setting the thread for the game
     * 
     * @param Null
     * @return Null
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * 
     * stop
     * 
     * stopping the thread
     * 
     * @param Null
     * @return Null
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
    
    /**
     * 
     * getWidth
     * 
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * 
     * getHeight
     * 
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public static int getHeight() {
        return height;
    }
    
    /**
     * 
     * keyTyped
     * 
     * se acciona cuando alguna tecla es tecleada
     * 
     * @param e -> evento de teclado (KeyEvent)
     * @return Null
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * 
     * keyPressed
     * 
     * se acciona cuando alguna tecla es presionada
     * 
     * @param e -> evento de teclado (KeyEvent)
     * @return Null
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keyManager.keySet(e.getKeyCode(), true);
    }

    /**
     * 
     * keyReleased
     * 
     * se acciona cuando alguna tecla es soltada
     * 
     * @param e -> evento de teclado (KeyEvent)
     * @return Null
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyManager.keySet(e.getKeyCode(), false);
    }
}
