/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Quoc Hung
 */
public class Pointer {
    
    Armys armys;
    
    public static final int MY_SIDE = 0;
    public static final int COM_SIDE = 1;
    
    private int side;
    private int x;
    private int posX, posY;
    private boolean isPicked;
    private int point;

    public Pointer(int x, int posX, int posY,int side, Armys armys) {
        this.x = x;
        this.posX = posX;
        this.posY = posY;
        this.isPicked = false;
        this.point = 1;
        this.armys = armys;
        this.side = side;
    }
    
    public void draw( Graphics2D g2 ) {
        if ( isPicked ) g2.setColor(Color.RED);
        else g2.setColor(Color.DARK_GRAY);
        g2.drawRect(posX + 2 + ( point - 1 ) * x, posY + 2, x - 4, x - 4);
    }


 

    public boolean getIsPicked() {
        return isPicked;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setIsPicked(boolean isPicked) {
        this.isPicked = isPicked;
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
    
    public void moveLeft() {
        if ( armys.getTurn() == side ){
            if ( ! isPicked ) {
                if ( point == 1 ) point = 5;
                else point --;
            } else {
                if ( armys.getArmys( point - 1 ) != 0 ){
                    armys.move( point - 1 , Armys.LEFT);
                    isPicked = false;
                }
            }
        }
    }
    
    public void moveRight() {
        if ( armys.getTurn() == side ){
            if ( ! isPicked ) {
                if ( point == 5 ) point = 1;
                else point ++;
            } else {
                if ( armys.getArmys( point - 1 ) != 0 ) {
                  armys.move( point - 1 , Armys.RIGHT);
                  isPicked = false;
                }
                
                          
            }
        }
    }
}
