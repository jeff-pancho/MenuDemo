package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;

public class PlayButton extends Button {
    private Image img;
    private double width;
    private double height;
    private double x;
    private double y;

    public PlayButton(GraphicsContext gc) {
        super(gc);
        img = new Image("file:./resources/button/play.png");
        if(img != null) {
            width = img.getWidth();
            height = img.getHeight();
        }
        x = -350;
        y = Game.CENTER_Y + height / 2;
    }


    @Override
    public void update() {
        // terrible, fix later
        if(isSwitching()) {
            x += Math.abs(x - (Game.CENTER_X - width / 2)) / 5;
            if(Math.abs(x - (Game.CENTER_X - width / 2)) <= 2) {
                x = Game.CENTER_X - width / 2;
                y = Game.CENTER_Y + height / 2;
                setSwitching(false);
            }  
        } else if(!isSelected()) {
            x = -350;
            y = Game.CENTER_Y + height / 2;
        }
    }

    @Override
    public void render() {
        gc.drawImage(img, x, y);
    }
}
