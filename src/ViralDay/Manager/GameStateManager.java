package ViralDay.Manager;

import ViralDay.States.GameOverState;
import ViralDay.States.GameState;
import ViralDay.States.IntroState;
import ViralDay.States.Level1;
import ViralDay.States.Level1Intro;
import ViralDay.States.Level2;
import ViralDay.States.Level2Intro;
import ViralDay.States.Level3;
import ViralDay.States.Level3Intro;
import ViralDay.States.LoadState;
import ViralDay.States.MenuState;
import ViralDay.States.OptionsState;
import ViralDay.States.PauseState;
import ViralDay.States.WinState;
import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class GameStateManager {

    private boolean paused;
    private PauseState pauseState;
    private GameState[] gameStates;

    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 12;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int LOAD = 2;
    public static final int OPTIONS = 3;
    public static final int LEVEL1INTRO = 4;
    public static final int LEVEL1 = 5;
    public static final int LEVEL2INTRO = 6;
    public static final int LEVEL2 = 7;
    public static final int LEVEL3INTRO = 8;
    public static final int LEVEL3 = 9;
    public static final int GAMEOVER = 10;
    public static final int WIN = 11;

    public GameStateManager() {
        paused = false;
        pauseState = new PauseState(this);

        gameStates = new GameState[NUM_STATES];
        setState(INTRO);
    }

    public void setState(int state) {
        previousState = currentState;
        unloadState(previousState);
        currentState = state;
        if (state == INTRO) {
            gameStates[state] = new IntroState(this);
            gameStates[state].init();
        } else if (state == MENU) {
            gameStates[state] = new MenuState(this);
            gameStates[state].init();
        } else if (state == LOAD) {
            gameStates[state] = new LoadState(this);
            gameStates[state].init();
        } else if (state == OPTIONS) {
            gameStates[state] = new OptionsState(this);
            gameStates[state].init();
        } else if (state == LEVEL1INTRO) {
            gameStates[state] = new Level1Intro(this);
            gameStates[state].init();
        } else if (state == LEVEL1) {
            gameStates[state] = new Level1(this);
            gameStates[state].init();
        }  else if (state == LEVEL2INTRO) {
            gameStates[state] = new Level2Intro(this);
            gameStates[state].init();
        } else if (state == LEVEL2) {
            gameStates[state] = new Level2(this);
            gameStates[state].init();
        } else if (state == LEVEL3INTRO) {
            gameStates[state] = new Level3Intro(this);
            gameStates[state].init();
        } else if (state == LEVEL3) {
            gameStates[state] = new Level3(this);
            gameStates[state].init();
        } else if (state == GAMEOVER) {
            gameStates[state] = new GameOverState(this);
            gameStates[state].init();
        }  else if (state == WIN) {
            gameStates[state] = new WinState(this);
            gameStates[state].init();
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void setPaused(boolean b) {
        paused = b;
        pauseState.init();
    }

    public void tick() {
        if (paused) {
            pauseState.tick();
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].tick();
        }
    }

    public void render(Graphics g) {
        if (paused) {
            pauseState.render(g);
        } else if (gameStates[currentState] != null) {
            gameStates[currentState].render(g);
        }
    }
    
    public void Save(int slot) {
        gameStates[currentState].Save(slot);
    }
    
    public GameState Load() {
        return gameStates[currentState].Load();
    }
}
