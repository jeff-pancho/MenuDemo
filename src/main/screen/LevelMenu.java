package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;
import main.ui.LevelTitle;
import main.ui.UI;
import main.ui.button.Button;
import main.ui.button.level.Lvl1Button;
import main.ui.button.level.Lvl2Button;
import main.ui.button.level.Lvl3Button;

public class LevelMenu extends Screen {
    private ArrayList<UI> uiElements;
    private ArrayList<Button> buttons;
    
    private int curInd;
    private Button curButton;
    private Button lvl1, lvl2, lvl3;
    
    private double dir;
    private double targetDir;

    public LevelMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        uiElements = new ArrayList<>();
        buttons = new ArrayList<>();
        
        lvl1 = new Lvl1Button(gc);
        lvl2 = new Lvl2Button(gc);
        lvl3 = new Lvl3Button(gc);
        
        curButton = lvl1;
        lvl1.setSwitching(true);
        lvl1.setSelected(true);
        
        uiElements.add(lvl1);
        uiElements.add(lvl2);
        uiElements.add(lvl3);
        
        buttons.add(lvl1);
        buttons.add(lvl2);
        buttons.add(lvl3);
        
        dir = 3 * Math.PI / 2;
        targetDir = dir;
        
        setButtonDir();
        
        uiElements.add(new LevelTitle(gc));
    }

    @Override
    public void update() {
        if (!curButton.isSwitching()) {
            if (kb.isDown("LEFT")) {
                changeButton(-1);
            } else if (kb.isDown("RIGHT")) {
                changeButton(1);
            } else if (kb.isDown("ENTER")) {
                
            } else if (kb.isDown("ESCAPE")) {
                screens.pop();
            }
        }
        
        dir -= (dir - targetDir) / 7;
        setButtonDir();
        
        for (UI curUI : uiElements)
            curUI.update();
    }

    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for (UI curUI : uiElements)
            curUI.render();
    }
    
    private void setButtonDir() {
        for(int i = 0; i < buttons.size(); i++) {
            Button b = buttons.get(i);
            b.setDir(dir + (2 * Math.PI / buttons.size()) * i);
        }
    }

    private void changeCurInd(int amount) {
        curInd += amount;
        curInd %= buttons.size();
        if (curInd < 0)
            curInd += buttons.size();
    }
    
    private void changeButton(int i) {
        curButton.setSelected(false);
        changeCurInd(i);
        switchButton();
        
        targetDir -= 2 * Math.PI / buttons.size() * i;
    }

    private void switchButton() {
        curButton = buttons.get(curInd);
        curButton.setSwitching(true);
        curButton.setSelected(true);
    }
}
