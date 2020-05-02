package videogame;

import java.awt.Graphics;

/**
 *
 * @author hgm
 */
public class Ball extends Item {

    private Game game;
    private Animation animation;

    private int dx;
    private int dy;
    private int xIni;
    private int yIni;
    public int xSpawn;
    public int ySpawn;
    public double velX;
    public double velY;
    private int fail = 0;
    private int tickNum = 0;
    private int time = 0;
    private boolean wasHold = false;            // to know if the user hold and release the ball
    private final double gravity = 9.81;

    public Ball(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.animation = new Animation(Assets.ballSpin, 150);
        xSpawn = x;
        ySpawn = y;
    }

    @Override
    public void tick() {

        //movimiento con mouse
        if (game.getMouseManager().pressed && hold(game.getMouseManager().getPunto())) {
            if (game.getMouseManager().dxdyHelper) {
                dx = game.getMouseManager().x - getX();
                dy = game.getMouseManager().y - getY();
                wasHold = true;
            }

            if (x + 64 > 256) {
            }
            setX(game.getMouseManager().x - dx);
            setY(game.getMouseManager().y - dy);
            xIni = x;
            yIni = y;
        }

        // contition to know if player throws the ball
        if (!game.getMouseManager().pressed && wasHold) {
            // condition to increment the time
            if (tickNum % 4 == 0) {
                time += 1;
            }

            // conditions to declarate velocity of the ball, depending of the position thrown out
            if (xIni < 256 && xIni >= 224) {
                velX = 40 * Math.cos(45);
                velY = 40 * Math.sin(45);
            } else if (xIni < 224 && xIni >= 192) {
                velX = 45 * Math.cos(45);
                velY = 45 * Math.sin(45);
            } else if (xIni < 192 && xIni >= 160) {
                velX = 50 * Math.cos(45);
                velY = 50 * Math.sin(45);
            } else if (xIni < 160 && xIni >= 128) {
                velX = 60 * Math.cos(45);
                velY = 60 * Math.sin(45);
            } else if (xIni < 128 && xIni >= 96) {
                velX = 70 * Math.cos(45);
                velY = 70 * Math.sin(45);
            } else if (xIni < 66 && xIni >= 64) {
                velX = 80 * Math.cos(45);
                velY = 80 * Math.sin(45);
            } else if (xIni < 64 && xIni >= 32) {
                velX = 90 * Math.cos(45);
                velY = 90 * Math.sin(45);
            } else {
                velX = 100 * Math.cos(45);
                velY = 100 * Math.sin(45);
            }

            // changing the position of the ball when thrown out
            setX((int) ((xIni) + velX * time));
            setY((int) ((yIni) + (-1 * velY * time) + (gravity * (time * time)) / 2));
        }

        // condition to check if the ball gets out of the screen
        if (x > game.getWidth() || y > game.getHeight()) {
            setX(xSpawn);
            setY(ySpawn);
            wasHold = false;
            time = 0;
            fail += 1;
            if (fail % 3 == 0) {
                game.setLives(game.getLives() - 1);
            }
            Assets.crash.play();
        }

        this.animation.tick();
        tickNum += 1;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setWasHold(boolean wasHold) {
        this.wasHold = wasHold;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
    }

}
