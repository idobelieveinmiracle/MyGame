/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import userinterface.GameFrame;

/**
 *
 * @author Quoc Hung
 */
public class BackGroundMap {
    
    private int x;
    
    private int posX, posY;
    
    public BackGroundMap(int x, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.x = x;        
    }
    
    public void draw( Graphics2D g2 ) {
        
        g2.setColor(Color.WHITE);        
        g2.fillRect( 0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT );
                       
        g2.setColor(Color.black);
        
        g2.drawArc( posX, posY, 2 * x, 2 * x, 90, 180);
        
        for(int i = 0; i < 5; i++){
            g2.drawRect( posX + x + x * i , posY , x, x);
        }
        
        for(int i = 0; i < 5; i++){
            g2.drawRect( posX + x + x * i , posY + x , x, x);
        }
        
        g2.drawArc(posX + x + x * 4, posY, 2 * x , 2 * x , -90, 180);
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
            
}
