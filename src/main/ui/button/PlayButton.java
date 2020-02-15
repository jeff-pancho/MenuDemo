package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import main.Game;

public class PlayButton extends Button {

    public PlayButton(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void press() {
        System.out.println("HEYO");
    }

    @Override
    public void update() {
        if(count > 0)
            count--;
        else {
            count = 0;
            switching = false;
        }
    }

    @Override
    public void render() {
        gc.fillRect(Game.CENTER_X, Game.CENTER_Y + 125, 300, 75);
    }
}
