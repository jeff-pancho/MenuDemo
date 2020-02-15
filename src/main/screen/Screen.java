package main.screen;

import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;

public abstract class Screen {
    protected GraphicsContext gc;
    protected Keyboard kb;
    
    public Screen(GraphicsContext gc, Keyboard kb) {
        this.gc = gc;
        this.kb = kb;
    }
    
    public abstract void update();
    public abstract void render();
}
