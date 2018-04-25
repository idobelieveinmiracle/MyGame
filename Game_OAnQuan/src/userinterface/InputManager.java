/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import gameobject.Pointer;
import java.awt.event.KeyEvent;

/**
 *
 * @author Quoc Hung
 */
public class InputManager {
    
    private Pointer pointer;
    
    public InputManager(Pointer pointer) {
        this.pointer = pointer;
    }
    
    public void processKeyPressed( int keyCode ) {
        
        switch( keyCode ) {
            case KeyEvent.VK_LEFT:
                pointer.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                pointer.moveRight();
                break;
            case KeyEvent.VK_ENTER:
                if ( pointer.getIsPicked() ) pointer.setIsPicked(false);
                else pointer.setIsPicked(true);
                break;
        }
    }
    
}
