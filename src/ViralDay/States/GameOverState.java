// Congratulations for finishing the game.
// Gives you a rank based on how long it took
// you to beat the game.

// Under two minutes = Speed Demon
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Bumbling Idiot

package ViralDay.States;

import ViralDay.Manager.Assets;
import ViralDay.Manager.Game;
import ViralDay.Manager.TileMap;
import ViralDay.Manager.ReadWrite;
import java.awt.Color;
import java.awt.Graphics;

//import finalprojectgit.Data;
import ViralDay.Manager.GameStateManager;
import ViralDay.Manager.KeyManager;

public class GameOverState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(164, 198, 222);
		//ticks = Data.getTime();
		if(ticks < 3600) rank = 1;
		else if(ticks < 5400) rank = 2;
		else if(ticks < 7200) rank = 3;
		else rank = 4;
	}
	
	public void tick() {}
	
	public void render(Graphics g) {
		/*
		g.setColor(color);
		//g.fillRect(0, 0, Game.width, Game.height);
		
		Assets.drawString(g, "finish time", 20, 36);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Assets.drawString(g, "0" + minutes + ":0" + seconds, 44, 48);
			else Assets.drawString(g, "0" + minutes + ":" + seconds, 44, 48);
		}
		else {
			if(seconds < 10) Assets.drawString(g, minutes + ":0" + seconds, 44, 48);
			else Assets.drawString(g, minutes + ":" + seconds, 44, 48);
		}
		
		Assets.drawString(g, "rank", 48, 66);
		if(rank == 1) Assets.drawString(g, "speed demon", 20, 78);
		else if(rank == 2) Assets.drawString(g, "adventurer", 24, 78);
		else if(rank == 3) Assets.drawString(g, "beginner", 32, 78);
		else if(rank == 4) Assets.drawString(g, "bumbling idiot", 8, 78);
		
		Assets.drawString(g, "press any key", 12, 110);
		*/
                g.drawImage(Assets.go, 0, 0, Game.getWidth(), Game.getHeight(), null);
	}
	
	public void handleInput() {
		if(KeyManager.isPressed(KeyManager.ENTER)) {
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