package main.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;

public class Title extends UI {
    private Image img;
    private double width;
    private double height;
    private double x;
    private double y;

    public Title(GraphicsContext gc) {
        super(gc);
        img = new Image("file:./resources/title.png");
        width = img.getWidth();
        height = img.getHeight();
        x = Game.CENTER_X - width / 2;
        y = 100;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        gc.drawImage(img, x, y);
    }
}
