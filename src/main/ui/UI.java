package main.ui;

import javafx.scene.canvas.GraphicsContext;

public abstract class UI {
    protected GraphicsContext gc;
    
    public UI(GraphicsContext gc) {
        this.gc = gc;
    }
    
    public abstract void update();
    public abstract void render();
}
