package main.menu;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public abstract class Screen {
    protected ArrayList<Screen> screens;
    protected Stage stage;
    protected Scene scene;
    protected Group root;
    protected Canvas canvas;
    protected GraphicsContext gc;
    
    public Screen(Stage stage, ArrayList<Screen> screens, int width, int height) {
        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        
        this.screens = screens;
        this.stage = stage;
        this.root = new Group(canvas);
        this.scene = new Scene(root);
    }
    
    public Scene getScene() {
        return this.scene;
    }
}
