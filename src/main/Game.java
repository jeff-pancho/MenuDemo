package main;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.menu.Screen;
import main.menu.GameScreen;
import main.menu.MenuScreen;

public class Game extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    ArrayList<Screen> screens;

    @Override
    public void start(Stage stage) throws Exception {
        screens = new ArrayList<Screen>();
        
        MenuScreen menuScreen = new MenuScreen(stage, screens, WIDTH, HEIGHT);
        GameScreen gameScreen = new GameScreen(stage, screens, WIDTH, HEIGHT);
        screens.add(menuScreen);
        screens.add(gameScreen);
        
        stage.setScene(menuScreen.getScene());
        stage.setTitle("MenuDemo");
        stage.show();

    }
    
    public void run() {
        launch();
    }
}
