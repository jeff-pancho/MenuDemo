package main.menu;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MenuScreen extends Screen {

    public MenuScreen(Stage stage, ArrayList<Screen> screens, int width, int height) {
        super(stage, screens, width, height);
        
        scene.setOnKeyPressed(this::handleKeyPress);
        
        gc.fillRect(100, 100, 100, 100);
    }
    
    private void handleKeyPress(KeyEvent e) {
        switch(e.getCode()) {
        case UP:
            System.out.println("UP");
            break;
        case DOWN:
            System.out.println("DOWN");
            break;
        case ENTER:
            System.out.println("ENTER");
            stage.setScene(screens.get(1).getScene());
            break;
        default:
        }
    }
}
