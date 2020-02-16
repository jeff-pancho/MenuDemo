package main.screen;

import java.util.ArrayList;
import java.util.Stack;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;

import main.ui.UI;
import main.ui.MainTitle;
import main.ui.button.Button;
import main.ui.button.menu.PlayButton;
import main.ui.button.menu.QuitButton;

public class MainMenu extends Screen {
    private ArrayList<UI> uiElements;
    private ArrayList<Button> buttons;

    private int curInd;
    private Button curButton;
    private Button play, quit;
    
    private double dir;
    private double targetDir;
    
    public MainMenu(GraphicsContext gc, Keyboard kb, Stack<Screen> screens) {
        super(gc, kb, screens);
        uiElements = new ArrayList<>();
        buttons = new ArrayList<>();

        play = new PlayButton(gc);
        quit = new QuitButton(gc);

        curButton = play;
        curButton.setSwitching(true);
        curButton.setSelected(true);

        buttons.add(play);
        buttons.add(quit);

        uiElements.add(play);
        uiElements.add(quit);
        uiElements.add(new MainTitle(gc));
        
        dir = 3 * Math.PI / 2;
        targetDir = dir;
        
        setButtonDir();
    }

    @Override
    public void update() {
        if (!curButton.isSwitching()) {
            if (kb.isDown("LEFT")) {
                changeButton(-1);
            } else if (kb.isDown("RIGHT")) {
                changeButton(1);
            } else if (kb.isDown("ENTER")) {
                if (curButton == play)
                    screens.push(new LevelMenu(gc, kb, screens));
                else
                    Platform.exit();
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
