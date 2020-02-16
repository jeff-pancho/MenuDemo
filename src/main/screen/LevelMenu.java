package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;
import main.ui.LevelTitle;
import main.ui.UI;

public class LevelMenu extends Screen {
    private ArrayList<UI> uiElements;
    
    public LevelMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        
        uiElements = new ArrayList<>();
        
        uiElements.add(new LevelTitle(gc));
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        
        for(UI curUI : uiElements)
            curUI.render();
    }
}
