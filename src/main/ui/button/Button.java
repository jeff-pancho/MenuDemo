package main.ui.button;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.ui.UI;

public abstract class Button extends UI {
    protected boolean switching = false;
    protected boolean selected;
    protected double x;
    protected double y;
    protected double dir;

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
    
    public void setDir(double dir) {
        this.dir = dir;
    }
}
