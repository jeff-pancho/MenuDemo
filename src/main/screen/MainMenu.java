package main.screen;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.input.Keyboard;

import main.ui.UI;
import main.ui.Title;
import main.ui.button.Button;
import main.ui.button.PlayButton;
import main.ui.button.QuitButton;

public class MainMenu extends Screen {
    private ArrayList<UI> uiElements;
    private ArrayList<Button> buttons;
    
    private int curInd;
    private Button curButton;
    
    public MainMenu(GraphicsContext gc, Keyboard kb) {
        super(gc, kb);
        uiElements = new ArrayList<>();
        buttons = new ArrayList<>();
        
        Button play = new PlayButton(gc), quit = new QuitButton(gc);
        curButton = play;
        curButton.setSwitching(true);
        curButton.setSelected(true);
        
        buttons.add(play);
        buttons.add(quit);
        
        uiElements.add(play);
        uiElements.add(quit);
        uiElements.add(new Title(gc));
    }

    @Override
    public void update() {
        if(!curButton.isSwitching()) {
            if(kb.isDown("LEFT")) {
                curButton.setSelected(false);
                changeCurInd(-1);
                switchButton();
            } else if(kb.isDown("RIGHT")) {
                curButton.setSelected(false);
                changeCurInd(1);
                switchButton();
            } else if(kb.isDown("ENTER"))
                curButton.press();
        }
        for(UI curUI : uiElements)
            curUI.update();
    }

    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
//        gc.fillRect(Game.CENTER_X, Game.CENTER_Y, 100, 100);
        
        for(UI curUI : uiElements)
            curUI.render();
    }
    
    private void changeCurInd(int amount) {
        curInd += amount;
        curInd %= buttons.size();
        if(curInd < 0)
            curInd += buttons.size();
    }
    
    private void switchButton() {
        curButton = buttons.get(curInd);
        curButton.setSwitching(true);
        curButton.setSelected(true);
    }
}
