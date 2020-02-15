package main.input;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;

/**
 * Stores the current keys that are pressed.
 * 
 * @author Jeff
 */
public class Keyboard {
    private ArrayList<String> inputs;
    
    public Keyboard() {
        inputs = new ArrayList<>();
    }
    
    public void captureInput(KeyEvent e) {
        String inputCode = e.getCode().toString();
        if(!inputs.contains(inputCode))
            inputs.add(inputCode);
    }
    
    public void releaseInput(KeyEvent e) {
        String inputCode = e.getCode().toString();
        inputs.remove(inputCode);
    }
    
    public boolean isDown(String code) {
        return inputs.contains(code);
    }
}
