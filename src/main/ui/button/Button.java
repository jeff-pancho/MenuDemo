package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import main.ui.UI;

public abstract class Button extends UI {
    protected boolean switching = false;
    protected int count;
    
    public Button(GraphicsContext gc) {
        super(gc);
    }
    
    public abstract void press();
    
    public boolean isSwitching() {
        return switching;
    }
    
    public void setSwitching(boolean switching) {
        count = 15;
        this.switching = switching;
    }
}
