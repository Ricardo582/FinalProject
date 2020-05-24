package ViralDay.States;

import ViralDay.Manager.Game;
import ViralDay.Manager.ReadWrite;
import ViralDay.Manager.TileMap;
import java.awt.Graphics;

import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author ricar
 */
public class PauseState extends GameState {
    private Color color;// to store a color
    
    public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
            color = new Color(255, 102, 69);
        }
	
	public void tick() {
		handleInput();
	}
	
	public void render(Graphics g) {
		/*
		Assets.drawString(g, "paused", 40, 30);
		
		Assets.drawString(g, "arrow", 12, 76);
		Assets.drawString(g, "keys", 16, 84);
		Assets.drawString(g, ": move", 52, 80);
		
		Assets.drawString(g, "space", 12, 96);
		Assets.drawString(g, ": action", 52, 96);
		
		Assets.drawString(g, "F1:", 36, 112);
		Assets.drawString(g, "return", 68, 108);
		Assets.drawString(g, "to menu", 68, 116);
		*/
                g.setFont(new Font("Impact", Font.BOLD, 63));
                g.setColor(Color.black);
                g.drawString("Pause", Game.getWidth() / 2 - 85, Game.getHeight() / 2 - 2);
                g.setFont(new Font("Impact", Font.BOLD, 60));
                g.setColor(color);
                g.drawString("Pause", Game.getWidth() / 2 - 80, Game.getHeight() / 2);
	}
	public void handleInput() {
		if(KeyManager.isPressed(KeyManager.ESCAPE)) {
			gsm.setPaused(false);
		}
		if(KeyManager.isPressed(KeyManager.F1)) {
			gsm.setPaused(false);
			gsm.setState(GameStateManager.MENU);
		}
	}

    @Override
    public ReadWrite getRW() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TileMap getTileMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
