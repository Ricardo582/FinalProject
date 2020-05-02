package videogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author RicardoGomez and HeribertoGil
 */
public class Game implements Runnable {

    private BufferStrategy bs;                          // to have several buffers when displaying
    private Graphics g;                                 // to paint objects
    private Display display;                            // to display in the game
    private MouseManager mouseManager;                  // to use the mouse
    String title;                                       // title of the window
    private int width;                                  // width of the window
    private int height;                                 // height of the window
    private Thread thread;                              // thread to create the game
    private boolean running;                            // to set the game
    private int score = 0;                              // to save the player score
    private int lives = 5;                              // to save the player lives
    private int colCount = 0;                           // to save the times that the object collide with ring
    private Ball ball;                                  // to store the ball
    private Ring ring;                                  // to store the ring

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
        mouseManager = new MouseManager();
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();

        ball = new Ball(100, 100, 100, 100, this);
        ring = new Ring(getWidth() - 200, 200, 100, 100, this);

        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        // plays the backSound
        Assets.backSound.setLooping(true);
        Assets.backSound.play();
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

            // if delta is positive we tick the game
            if (delta >= 1) {
                render();
                if (lives > 0) {
                    tick();
                }
                delta--;
            }
        }
        stop();
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public void setLives(int life) {
        this.lives = life;
    }

    public void setScore(int x) {
        this.score = x;
    }

    private void tick() {
        // avancing ball with colision
        mouseManager.tick();
        ball.tick();
        ring.tick();

        if (ball.collision(ring)) {
            ball.setX(ball.xSpawn);
            ball.setY(ball.ySpawn);
            ball.setWasHold(false);
            ball.setTime(0);
            score += 10;
            Assets.point.play();
            if (score % 50 == 0) {
                lives += 1;
            }
        }
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
            g.drawImage(Assets.background, 0, 0, width, height, null);

            //items render
            ball.render(g);
            ring.render(g);

            // Displays the score with a specific format
            g.setFont(new Font("Cooper Black", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawString("Score: " + score, getWidth() - 150, 50);

            // Displays the lives with a specific format
            g.setFont(new Font("Cooper Black", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawString("Lives: " + lives, getWidth() - 150, 80);
            // Linea limite de velocidad
            g.drawLine(256, 0, 256, 600);

            // show the Game Over screen if lives are less or equal than 0
            if (lives <= 0) {
                g.drawImage(Assets.gameover, 0, 0, width, height, null);
                Assets.backSound.stop();
            }
            bs.show();
            g.dispose();
        }
    }

    /**
     * setting the thead for the game
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

}
