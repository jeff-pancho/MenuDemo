package main;

import java.util.Stack;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import main.input.Keyboard;
import main.screen.Screen;
import main.screen.MainMenu;

public class Game extends Application {
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    public static int CENTER_X = WIDTH / 2;
    public static int CENTER_Y = HEIGHT / 2;
    
    private Keyboard kb;

    @Override
    public void start(Stage stage) throws Exception {  
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Group root = new Group(canvas);
        Scene scene = new Scene(root);
        
        kb = new Keyboard();
        scene.setOnKeyPressed(kb::captureInput);
        scene.setOnKeyReleased(kb::releaseInput);
        
        Stack<Screen> screens = new Stack<>();
        screens.push(new MainMenu(gc, kb));
        
        stage.setTitle("HexagonClone");
        stage.setScene(scene);
        stage.show();
        
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long nanoTime) {
                if(screens.size() > 0) {
                    Screen curScreen = screens.peek();
                    curScreen.update();
                    curScreen.render();
                }
            }
        };
        
        timer.start();
    }
    
    public void run() {
        launch();
    }
}
