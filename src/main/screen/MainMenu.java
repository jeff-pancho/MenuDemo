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
    }

    @Override
    public void update() {
        if (!curButton.isSwitching()) {
            if (kb.isDown("LEFT")) {
                curButton.setSelected(false);
                changeCurInd(-1);
                switchButton();
            } else if (kb.isDown("RIGHT")) {
                curButton.setSelected(false);
                changeCurInd(1);
                switchButton();
            } else if (kb.isDown("ENTER")) {
                if (curButton == play)
                    screens.push(new LevelMenu(gc, kb, screens));
                else
                    Platform.exit();
            }
        }
        for (UI curUI : uiElements)
            curUI.update();
    }

    @Override
    public void render() {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

        for (UI curUI : uiElements)
            curUI.render();
    }

    private void changeCurInd(int amount) {
        curInd += amount;
        curInd %= buttons.size();
        if (curInd < 0)
            curInd += buttons.size();
    }

    private void switchButton() {
        curButton = buttons.get(curInd);
        curButton.setSwitching(true);
        curButton.setSelected(true);
    }
}
