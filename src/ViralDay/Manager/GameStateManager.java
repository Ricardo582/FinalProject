package ViralDay.Manager;

import ViralDay.States.GameOverState;
import ViralDay.States.GameState;
import ViralDay.States.IntroState;
import ViralDay.States.Level1;
import ViralDay.States.Level2;
import ViralDay.States.Level3;
import ViralDay.States.LoadState;
import ViralDay.States.MenuState;
import ViralDay.States.OptionsState;
import ViralDay.States.PauseState;
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

    public static final int NUM_STATES = 9;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int LOAD = 2;
    public static final int LEVEL1 = 3;
    public static final int LEVEL2 = 4;
    public static final int LEVEL3 = 5;
    public static final int GAMEOVER = 6;
    public static final int SAVE = 7;
    public static final int OPTIONS = 8;

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
        switch (state) {
            case INTRO:
                gameStates[state] = new IntroState(this);
                gameStates[state].init();
                break;
            case MENU:
                gameStates[state] = new MenuState(this);
                gameStates[state].init();
                break;
            case LOAD:
                gameStates[state] = new LoadState(this);
                gameStates[state].init();
                break;
            case LEVEL1:
                gameStates[state] = new Level1(this);
                gameStates[state].init();
                break;
            case LEVEL2:
                gameStates[state] = new Level2(this);
                gameStates[state].init();
                break;
            case LEVEL3:
                gameStates[state] = new Level3(this);
                gameStates[state].init();
                break;
            case GAMEOVER:
                gameStates[state] = new GameOverState(this);
                gameStates[state].init();
                break;
            case OPTIONS:
                gameStates[state] = new OptionsState(this);
                gameStates[state].init();
                break;
            default:
                break;
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
}
