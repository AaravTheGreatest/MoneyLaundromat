package moneyLaundromat;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {
    private double x, y;
    private double speed = 5;
    private Image sprite;

    public Player(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.sprite = new Image(getClass().getResourceAsStream("player.png"));
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(sprite, x - sprite.getWidth() / 2, y - sprite.getHeight() / 2);
    }

    // Getters and setters if needed
    public double getX() { return x; }
    public double getY() { return y; }
}

