package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class Level1 extends GameState {

    // events
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;

    public Level1(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        tileMap = new TileMap(0, -400, 3000, 1000, this);
        RW = new ReadWrite(this);
        tileMap.init();
        player = new Player(200, 200, 80, 200, this);
        
    }

    @Override
    public void tick() {
        handleInput();
        RW.tick();
        tileMap.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.back, 0, 0, Game.getWidth(), Game.getHeight(), null);
        tileMap.render(g);
        player.render(g);
    }

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
            //player.setAction();
        }
    }
    
    public TileMap getTileMap() {
        return tileMap;
    }
    
    public ReadWrite getRW(){
        return RW;
    }
    
}
