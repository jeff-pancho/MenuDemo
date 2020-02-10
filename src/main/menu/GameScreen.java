package main.menu;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameScreen extends Screen {

    public GameScreen(Stage stage, ArrayList<Screen> screens, int width, int height) {
        super(stage, screens, width, height);
        
        scene.setOnKeyPressed(this::handleKeyPress);
        
        gc.fillRect(300, 300, 100, 100);
    }
    
    private void handleKeyPress(KeyEvent e) {
        switch(e.getCode()) {
        case LEFT:
            System.out.println("LEFT");
            break;
        case RIGHT:
            System.out.println("RIGHT");
            break;
        case R:
            System.out.println("R");
            stage.setScene(screens.get(0).getScene());
            break;
        default:
        }
    }
}
