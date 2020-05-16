package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author ricar
 */
public class MenuState extends GameState {
    private int currentOption = 0;
    private final String[] options = {
        "JUGAR",
        "CARGAR",
        "SALIR"
    };

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {}

    @Override
    public void tick() {
        handleInput();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu, 0, 0, Game.getWidth(), Game.getHeight(), null);
        switch (currentOption) {
            case 0:
                g.drawImage(Assets.ball, 165, 270, 50, 50, null);
                break;
            case 1:
                g.drawImage(Assets.ball, 165, 370, 50, 50, null);
                break;
            case 2:
                g.drawImage(Assets.ball, 165, 470, 50, 50, null);
                break;
            default:
                break;
        }
    }

    @Override
    public void handleInput() {
        if (KeyManager.isPressed(KeyManager.DOWN) && currentOption < options.length - 1) {
            currentOption++;
        }
        if (KeyManager.isPressed(KeyManager.UP) && currentOption > 0) {
            currentOption--;
        }
        if (KeyManager.isPressed(KeyManager.ENTER)) {
            selectOption();
        }
    }

    private void selectOption() {
        switch (currentOption) {
            case 0:
                gsm.setState(GameStateManager.LEVEL1);
                break;
            case 1:
                //gsm.setState(GameStateManager.LoadState);
            case 2:
                System.exit(0);
            default:
                break;
        }
    }

}
