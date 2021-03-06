package main.ui.button.level;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import main.ui.button.Button;

public class Lvl1Button extends Button {
    private Image img;
    private double width;
    private double height;

    public Lvl1Button(GraphicsContext gc) {
        super(gc);
        img = new Image("file:./resources/button/level1.png");
        if (img != null) {
            width = img.getWidth();
            height = img.getHeight();
        }
        x = -350;
        y = Game.CENTER_Y + height / 2;
    }

    @Override
    public void update() {
        // terrible, fix later
//        if (switching) {
//            x += Math.abs(x - (Game.CENTER_X - width / 2)) / 5;
//            if (Math.abs(x - (Game.CENTER_X - width / 2)) <= 2) {
//                x = Game.CENTER_X - width / 2;
//                y = Game.CENTER_Y + height / 2;
//                switching = false;
//            }
//        } else if (!selected) {
//            x = -350;
//            y = Game.CENTER_Y + height / 2;
//        }
        double centerX = Game.CENTER_X - width / 2;
        double centerY = Game.HEIGHT - height / 2;
        
        x = centerX + Math.cos(dir) * 200;
        y = centerY + Math.sin(dir) * 200;
        
        if (switching
                && Math.abs(x - (centerX + Math.cos(3 * Math.PI / 2) * 200)) <= 1
                && Math.abs(y - (centerY + Math.sin(3 * Math.PI / 2) * 200)) <= 1)
            switching = false;
    }

    @Override
    public void render() {
        gc.drawImage(img, x, y);
    }
}
