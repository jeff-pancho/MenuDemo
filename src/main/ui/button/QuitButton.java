package main.ui.button;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import main.Game;

public class QuitButton extends Button {

    public QuitButton(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void press() {
        Platform.exit();
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
