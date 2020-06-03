package ViralDay.Manager;

import ViralDay.Manager.KeyManager;
import ViralDay.Manager.GameStateManager;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 *
 * @author RicardoGomez and HeribertoGil
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
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        display.getJframe().addKeyListener(this);
        Assets.init();
        gsm = new GameStateManager();
        keyManager = new KeyManager();
    }

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

    private void tick() {
        gsm.tick();
        keyManager.tick();
    }

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
     * setting the thread for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
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
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public static int getHeight() {
        return height;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyManager.keySet(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyManager.keySet(e.getKeyCode(), false);
    }
}
