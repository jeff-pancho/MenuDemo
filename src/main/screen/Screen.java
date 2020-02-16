package main.screen;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.input.Keyboard;

public abstract class Screen {
    protected GraphicsContext gc;
    protected Keyboard kb;
    protected Stack<Screen> screens;
    
    public Screen(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        this.gc = gc;
        this.kb = kb;
        this.screens = screens;
    }
    
    public abstract void update();
    public abstract void render();
}
