package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import main.ui.UI;

public abstract class Button extends UI {
    private boolean switching = false;
    private boolean selected;
    
    public Button(GraphicsContext gc) {
        super(gc);
    }
    
//    public abstract void press();
    
    public boolean isSelected() {
        return this.selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public boolean isSwitching() {
        return switching;
    }
    
    public void setSwitching(boolean switching) {
        this.switching = switching;
    }
}
