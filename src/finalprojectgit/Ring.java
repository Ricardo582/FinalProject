package finalprojectgit;

import java.awt.Graphics;

/**
 *
 * @author RicardoGomez and HeribertoGil
 */
public class Ring extends Item {

    private Game game;
    private Animation animation;

    public Ring(int x, int y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;
        this.animation = new Animation(Assets.ring, 150);
    }

    @Override
    public void tick() {
        this.animation.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
    }

}
