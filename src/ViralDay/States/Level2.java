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
 * @author ricar
 */
public class Level2 extends GameState {

    // events
    private boolean blockInput;
    private TileMap tileMap;
    private Player player;          // to store the ball
    private ReadWrite RW;

    public Level2(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        tileMap = new TileMap(0, -150, 1000, 750, this);
        RW = new ReadWrite(this);
        tileMap.setCurrLvl(2);
        tileMap.init();
        player = new Player(200, 500, 50, 70, this, tileMap);
        Assets.backSound.setLooping(true);
        Assets.backSound.play(gsm.getVolMusic());
    }

    @Override
    public void tick() {
        handleInput();
        tileMap.tick();
        player.tick();
        if (tileMap.getX() < -7800) {
            Assets.backSound.stop();
            Assets.aplausos.play(gsm.getVolSFX());
            gsm.setState(GameStateManager.LEVEL3INTRO);
        }
        if (player.getVidas() <= 0) {
            gsm.setState(GameStateManager.GAMEOVER);
            Assets.backSound.stop();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.back, 0, 0, Game.getWidth(), Game.getHeight(), null);
        tileMap.render(g);
        player.render(g);
        
        //Aquí se muestran las vidas del jugador en el respectivo nivel
        g.setFont(new Font("Cooper Black", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Vidas = " + player.getVidasText(), Game.getWidth() - 210, 20);
        g.setFont(new Font("Cooper Black", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString("Ammo = " + player.getAmmoText(), Game.getWidth() - 100, 20);
    }

    @Override
    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.ESCAPE)) {
            gsm.setPaused(true);
        }
        if (blockInput) {
            return;
        }
    }
    
    public TileMap getTileMap() {
        return tileMap;
    }
    
    public ReadWrite getRW(){
        return RW;
    }
    
    @Override
    public GameStateManager getGSM() {
        return gsm;
    }
    
    public void Save(int slot) {
        switch(slot) {
            case 1:
                RW.Save("src/saves/Save1.txt", slot);
                break;
            case 2:
                RW.Save("src/saves/Save2.txt", slot);
                break;
            case 3:
                RW.Save("src/saves/Save3.txt", slot);
                break;
            default:
                break;
        }
    }

    public GameState Load() {
        gsm.setPaused(false);
        return this;
    }
}
