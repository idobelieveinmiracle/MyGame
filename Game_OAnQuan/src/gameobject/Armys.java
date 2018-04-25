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

public class Armys {
    
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    
    public static final int WIN = - 1;
    public static final int HOA = 0;
    public static final int LOSE = 1;
    public static final int NOT_END = 2;
    
    public static final int MY_TURN = 0;
    public static final int COM_TURN = 1;
    
    private int turn;
    
    private int result;
    
    private int x;
    private int posX, posY;
    
    private Position[] posMyArmys;
    private Position[] posComArmys;
    
    private Position posMyGen;
    private Position posComGen;
    
    private int[] Armys;
    
    private int[] Genaral;
    
//    private boolean myMove;
    private int myScoreArm, comScoreArm;
    private int myScoreGen, comScoreGen;
    
    private int z = 20;

    public Armys(int x, int posX, int posY) {
        this.x = x;
        this.posX = posX;
        this.posY = posY;
               
        Armys = new int[12];  
        posMyArmys = new Position[6];
        Armys[5] = 0;
        posMyArmys[0] = new Position();
        posMyArmys[0].x = this.posX + 6 * this.x;
        posMyArmys[0].y = this.posY;
        for ( int i = 1; i <= 5; i ++ ) {
            Armys[i - 1] = 5;
            posMyArmys[i] = new Position();
            posMyArmys[i].x = this.x * i + this.posX;
            posMyArmys[i].y = posY + x;
        }
         
        posComArmys = new Position[6];
        Armys[11] = 0;
        posComArmys[0] = new Position();
        posComArmys[0].x = this.posX;
        posComArmys[0].y = this.posY;
        for ( int i = 1; i <= 5; i ++ ) {
            Armys[i + 5] = 5;
            posComArmys[i] = new Position();
            posComArmys[i].x = this.x * i + this.posX;
            posComArmys[i].y = posY;
        }
        
        Genaral = new int[2];
        
        Genaral[0] = 1;
        Genaral[1] = 1;
        
        posMyGen = new Position();
        posMyGen.x = posX + 6 * x;
        posMyGen.y = posY + x;
        
        posComGen = new Position();
        posComGen.x = posX + x;
        posComGen.y = posY + x;
        
        turn = COM_TURN;
        
        myScoreArm = 0;
        myScoreGen = 0;
        
        comScoreArm = 0;
        comScoreGen = 0;
        
        result = NOT_END;
        
    }
    
    public void draw(Graphics2D g2) {       
        
        for ( int i = 1; i <= 5; i ++ ) drawMyArmys(i , Armys[i-1], g2);
        for ( int i = 1; i <= 5; i ++ ) drawComArmys(i, Armys[11 - i], g2);
        drawMyGenaral(g2);
        drawComGenaral(g2);
        drawScore(g2);
        
    }
    
    public void drawMyArmys( int k, int num, Graphics2D g2 ) {
        g2.setColor(Color.blue);
        g2.drawString(String.valueOf(Armys[k-1]), posMyArmys[k].x + 4 * z, posMyArmys[k].y + z - 5);
        for ( int i = 0; i < num; i ++ ) {
            
            if ( i == 0 ) g2.fillOval(posMyArmys[k].x + 2 * z, posMyArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 1 ) g2.fillOval(posMyArmys[k].x + 1 * z, posMyArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 2 ) g2.fillOval(posMyArmys[k].x + 3 * z, posMyArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 3 ) g2.fillOval(posMyArmys[k].x + 2 * z, posMyArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 4 ) g2.fillOval(posMyArmys[k].x + 2 * z, posMyArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 5 ) g2.fillOval(posMyArmys[k].x + 1 * z, posMyArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 6 ) g2.fillOval(posMyArmys[k].x + 3 * z, posMyArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 7 ) g2.fillOval(posMyArmys[k].x + 1 * z, posMyArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 8 ) g2.fillOval(posMyArmys[k].x + 3 * z, posMyArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 9 ) g2.fillOval(posMyArmys[k].x + 0 * z, posMyArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 10 ) g2.fillOval(posMyArmys[k].x + 1 * z, posMyArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 11 ) g2.fillOval(posMyArmys[k].x + 2 * z, posMyArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 12 ) g2.fillOval(posMyArmys[k].x + 3 * z, posMyArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 13 ) g2.fillOval(posMyArmys[k].x + 4 * z, posMyArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 14 ) g2.fillOval(posMyArmys[k].x + 4 * z, posMyArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 15 ) g2.fillOval(posMyArmys[k].x + 4 * z, posMyArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 16 ) g2.fillOval(posMyArmys[k].x + 4 * z, posMyArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 17 ) g2.fillOval(posMyArmys[k].x + 3 * z, posMyArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 18 ) g2.fillOval(posMyArmys[k].x + 2 * z, posMyArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 19 ) g2.fillOval(posMyArmys[k].x + 1 * z, posMyArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 20 ) g2.fillOval(posMyArmys[k].x + 0 * z, posMyArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 21 ) g2.fillOval(posMyArmys[k].x + 0 * z, posMyArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 22 ) g2.fillOval(posMyArmys[k].x + 0 * z, posMyArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 23 ) g2.fillOval(posMyArmys[k].x + 0 * z, posMyArmys[k].y + 1 * z, z-5, z-5);
                       
        }
    }
    
    public void drawComArmys( int k, int num, Graphics2D g2 ) {
        g2.setColor(Color.blue);
        g2.drawString(String.valueOf(Armys[11 - k]), posComArmys[k].x + 4 * z, posComArmys[k].y + z - 5);
        for ( int i = 0; i < num; i ++ ) {
            
            if ( i == 0 ) g2.fillOval(posComArmys[k].x + 2 * z, posComArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 1 ) g2.fillOval(posComArmys[k].x + 1 * z, posComArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 2 ) g2.fillOval(posComArmys[k].x + 3 * z, posComArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 3 ) g2.fillOval(posComArmys[k].x + 2 * z, posComArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 4 ) g2.fillOval(posComArmys[k].x + 2 * z, posComArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 5 ) g2.fillOval(posComArmys[k].x + 1 * z, posComArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 6 ) g2.fillOval(posComArmys[k].x + 3 * z, posComArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 7 ) g2.fillOval(posComArmys[k].x + 1 * z, posComArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 8 ) g2.fillOval(posComArmys[k].x + 3 * z, posComArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 9 ) g2.fillOval(posComArmys[k].x + 0 * z, posComArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 10 ) g2.fillOval(posComArmys[k].x + 1 * z, posComArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 11 ) g2.fillOval(posComArmys[k].x + 2 * z, posComArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 12 ) g2.fillOval(posComArmys[k].x + 3 * z, posComArmys[k].y + 0 * z, z-5, z-5);
            if ( i == 13 ) g2.fillOval(posComArmys[k].x + 4 * z, posComArmys[k].y + 1 * z, z-5, z-5);
            if ( i == 14 ) g2.fillOval(posComArmys[k].x + 4 * z, posComArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 15 ) g2.fillOval(posComArmys[k].x + 4 * z, posComArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 16 ) g2.fillOval(posComArmys[k].x + 4 * z, posComArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 17 ) g2.fillOval(posComArmys[k].x + 3 * z, posComArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 18 ) g2.fillOval(posComArmys[k].x + 2 * z, posComArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 19 ) g2.fillOval(posComArmys[k].x + 1 * z, posComArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 20 ) g2.fillOval(posComArmys[k].x + 0 * z, posComArmys[k].y + 4 * z, z-5, z-5);
            if ( i == 21 ) g2.fillOval(posComArmys[k].x + 0 * z, posComArmys[k].y + 3 * z, z-5, z-5);
            if ( i == 22 ) g2.fillOval(posComArmys[k].x + 0 * z, posComArmys[k].y + 2 * z, z-5, z-5);
            if ( i == 23 ) g2.fillOval(posComArmys[k].x + 0 * z, posComArmys[k].y + 1 * z, z-5, z-5);
                       
        }
    }
    
    public void drawMyGenaral( Graphics2D g2 ) {       
        
        g2.setColor(Color.blue);
        g2.drawString(String.valueOf(Armys[5]), posMyGen.x + 100 - 15, posMyGen.y);
        
        if ( Genaral[0] == 1 ) {
            g2.setColor(Color.pink);
            g2.fillOval(posMyGen.x + 2, posMyGen.y - z + 3, z + 15 , z + 15);
            g2.setColor(Color.blue);
            for ( int i = 0; i < Armys[5]; i ++ ) {
                if ( i < 3 ) g2.fillOval(posMyGen.x + i * z, posMyGen.y - 2 * z, z - 5, z - 5);
                if ( 3 <= i && i < 5) g2.fillOval(posMyGen.x + 2 * z, posMyGen.y - 2 * z + ( i - 2 ) * z, z - 5, z - 5);
                if ( 5 <= i && i < 8) g2.fillOval(posMyGen.x + 2 * z - ( i - 5 ) * z, posMyGen.y + z, z - 5, z - 5);
                if ( 8 <= i && i < 12) g2.fillOval(posMyGen.x + (i - 8) * z , posMyGen.y - 3 * z, z - 5, z - 5);
                if ( 12 <= i && i < 16) g2.fillOval(posMyGen.x + 3 * z , posMyGen.y - 2 * z + ( i - 12 ) * z, z - 5, z - 5);
                if ( 16 <= i && i < 20) g2.fillOval(posMyGen.x + (i - 16) * z , posMyGen.y + 2 * z, z - 5, z - 5);
                if ( 20 <= i && i < 23) g2.fillOval(posMyGen.x + (i - 20) * z , posMyGen.y - 4 * z, z - 5, z - 5);
                if ( 23 <= i && i < 26) g2.fillOval(posMyGen.x + (i - 23) * z , posMyGen.y + 3 * z, z - 5, z - 5);
            }
        } else {
            g2.setColor(Color.blue);
            for ( int i = 0; i < Armys[5]; i ++ ) {
                if ( i < 2 ) g2.fillOval(posMyGen.x + i * z, posMyGen.y - z, z - 5, z - 5);
                if ( 2 <= i && i < 4) g2.fillOval(posMyGen.x + (i-2) * z, posMyGen.y , z - 5, z - 5);
                if ( 4 <= i && i < 7 ) g2.fillOval(posMyGen.x + (i - 4) * z, posMyGen.y - 2 * z, z - 5, z - 5);
                if ( 7 <= i && i < 9) g2.fillOval(posMyGen.x + 2 * z, posMyGen.y - 1 * z + ( i - 7 ) * z, z - 5, z - 5);
                if ( 9 <= i && i < 12) g2.fillOval(posMyGen.x + 2 * z - ( i - 9 ) * z, posMyGen.y + z, z - 5, z - 5);
                if ( 12 <= i && i < 16) g2.fillOval(posMyGen.x + (i - 12) * z , posMyGen.y - 3 * z, z - 5, z - 5);
                if ( 16 <= i && i < 21) g2.fillOval(posMyGen.x + 3 * z , posMyGen.y - 2 * z + ( i - 16 ) * z, z - 5, z - 5);
                if ( 21 <= i && i < 25) g2.fillOval(posMyGen.x + (i - 21) * z , posMyGen.y + 2 * z, z - 5, z - 5);
                if ( 25 <= i && i < 28) g2.fillOval(posMyGen.x + (i - 25) * z , posMyGen.y - 4 * z, z - 5, z - 5);
                if ( 28 <= i && i < 31) g2.fillOval(posMyGen.x + (i - 28) * z , posMyGen.y + 3 * z, z - 5, z - 5);
            }
        }
    }
    
    public void drawComGenaral( Graphics2D g2 ) {
        
        g2.setColor(Color.blue);
        g2.drawString(String.valueOf(Armys[11]), posComGen.x - 100 + 4, posComGen.y);
        
        if ( Genaral[1] == 1 ) {
            g2.setColor(Color.pink);
            g2.fillOval(posComGen.x - 2 * z + 2, posComGen.y - z + 3 , z + 15 , z + 15 );
            
            g2.setColor(Color.blue);
            for ( int i = 0; i < Armys[11]; i ++ ) {
                if ( i < 3 ) g2.fillOval(posComGen.x - i * z - z + 3 , posComGen.y - 2 * z, z - 5, z - 5);
                if ( 3 <= i && i < 5) g2.fillOval(posComGen.x - 3 * z + 3 , posComGen.y - 2 * z + ( i - 2 ) * z, z - 5, z - 5);
                if ( 5 <= i && i < 8) g2.fillOval(posComGen.x - 3 * z + ( i - 5 ) * z + 3 , posComGen.y + z, z - 5, z - 5);
                if ( 8 <= i && i < 12) g2.fillOval(posComGen.x - (i - 8) * z - z + 3 , posComGen.y - 3 * z, z - 5, z - 5);
                if ( 12 <= i && i < 16) g2.fillOval(posComGen.x - 3 * z - z + 3 , posComGen.y - 2 * z + ( i - 12 ) * z, z - 5, z - 5);
                if ( 16 <= i && i < 20) g2.fillOval(posComGen.x - (i - 16) * z - z + 3 , posComGen.y + 2 * z, z - 5, z - 5);
                if ( 20 <= i && i < 23) g2.fillOval(posComGen.x - (i - 20) * z - z + 3 , posComGen.y - 4 * z, z - 5, z - 5);
                if ( 23 <= i && i < 26) g2.fillOval(posComGen.x - (i - 23) * z - z + 3 , posComGen.y + 3 * z, z - 5, z - 5);
            }
        }else {
            g2.setColor(Color.blue);
            for ( int i = 0; i < Armys[11]; i ++ ) {
                if ( i < 2 ) g2.fillOval(posComGen.x - i * z - z + 3, posComGen.y - z, z - 5, z - 5);
                if ( 2 <= i && i < 4) g2.fillOval(posComGen.x - (i-2) * z - z + 3 , posComGen.y , z - 5, z - 5);
                if ( 4 <= i && i < 7 ) g2.fillOval(posComGen.x - (i - 4) * z - z + 3 , posComGen.y - 2 * z, z - 5, z - 5);
                if ( 7 <= i && i < 9) g2.fillOval(posComGen.x - 2 * z - z + 3 , posComGen.y - 1 * z + ( i - 7 ) * z, z - 5, z - 5);
                if ( 9 <= i && i < 12) g2.fillOval(posComGen.x - 2 * z + ( i - 9 ) * z - z + 3 , posComGen.y + z, z - 5, z - 5);
                if ( 12 <= i && i < 16) g2.fillOval(posComGen.x - (i - 12) * z - z + 3 , posComGen.y - 3 * z, z - 5, z - 5);
                if ( 16 <= i && i < 21) g2.fillOval(posComGen.x - z + 3 - 3 * z , posComGen.y - 2 * z + ( i - 16 ) * z, z - 5, z - 5);
                if ( 21 <= i && i < 25) g2.fillOval(posComGen.x - (i - 21) * z - z + 3 , posComGen.y + 2 * z, z - 5, z - 5);
                if ( 25 <= i && i < 28) g2.fillOval(posComGen.x - (i - 25) * z - z + 3 , posComGen.y - 4 * z, z - 5, z - 5);
                if ( 28 <= i && i < 31) g2.fillOval(posComGen.x - (i - 28) * z - z + 3 , posComGen.y + 3 * z, z - 5, z - 5);
            }
        }
    }
    
    public void drawScore( Graphics2D g2 ) {
        g2.setColor(Color.black);
        g2.drawString("Your Score: ", x / 2, z);
        g2.drawString("Com Score: ", x / 2, 2 * z);
        g2.drawString(String.valueOf(myScoreGen), x * 3 / 2, z);
        g2.drawString(String.valueOf(comScoreGen), x * 3 / 2, 2 * z);
        g2.drawString(String.valueOf(myScoreArm), x * 2, z);
        g2.drawString(String.valueOf(comScoreArm), x * 2, 2 * z);
        
        g2.setColor(Color.pink);        
        g2.fillOval(x * 5 / 4, z / 2  - 3, z - 5, z - 5 );
        g2.fillOval(x * 5 / 4, z / 2  - 3 + z, z - 5, z - 5 );
        
        g2.setColor(Color.blue);
        g2.fillOval(x * 7 / 4, z / 2 - 3, z - 5, z - 5);
        g2.fillOval(x * 7 / 4, z / 2 - 3 + z , z - 5, z - 5);
    }
    
    int nextPosRight(int pre) {
        if ( pre < 11 ) return pre + 1;
        return 0;
    }
    int nextPosLeft(int pre) {
        if ( pre > 0 ) return pre - 1;
        return 11;
    }
    
    public void move( int pos, int dir ) {
        if ( dir == RIGHT ) {
            int k = pos;
            do {
                int x0;
                x0 = Armys[k];
                Armys[k] = 0;
                for ( int i = 1; i <= x0; i ++ ) {
                    k = nextPosRight(k);
                    Armys[k] ++;
                }
                k = nextPosRight(k);
            } while ( Armys[k] != 0 && k != 5 && k != 11 );
            
            if ( Armys[k] == 0 && k != 5 && k != 11 ) {
                int score = 0;
                while ( Armys[nextPosRight(k)] != 0 && Armys[k] == 0) {
                    score += Armys[nextPosRight(k)];
                    Armys[nextPosRight(k)] = 0;
                    
                    if ( nextPosRight(k) == 5 ) {
                        if ( turn == MY_TURN ) myScoreGen += Genaral[0];
                        else comScoreGen += Genaral[0];
                        Genaral[0] = 0;
                    }
                    if ( nextPosRight(k) == 11 ) {
                        if ( turn == MY_TURN ) myScoreGen += Genaral[1];
                        else comScoreGen += Genaral[1];
                        Genaral[1] = 0;
                    }
                    
                    
                    k = nextPosRight(k);
                    k = nextPosRight(k);
                    if ( k == 5 && (Genaral[0] != 0 || Armys[5] !=0) ) break;
                    if ( k == 11 && (Genaral[1] != 0 || Armys[11] !=0) ) break;
                }
                if ( turn == MY_TURN ) myScoreArm += score;
                else comScoreArm += score;
            }
        }
        
        else {
            int k = pos;
            do {
                int x0 = Armys[k];
                Armys[k] = 0;
                for ( int i = 1; i <= x0; i ++ ) {
                    k = nextPosLeft(k);
                    Armys[k] ++;
                }
                k = nextPosLeft(k);
            } while ( Armys[k] != 0 && k != 5 && k != 11 );
            
            if ( Armys[k] == 0 && k != 5 && k != 11 ) {
                int score = 0;
                while ( Armys[nextPosLeft(k)] != 0 && Armys[k] == 0) {
                    score += Armys[nextPosLeft(k)];
                    Armys[nextPosLeft(k)] = 0;
                    
                    if ( nextPosLeft(k) == 5 ) {
                        if ( turn == MY_TURN ) myScoreGen += Genaral[0];
                        else comScoreGen += Genaral[0];
                        Genaral[0] = 0;
                    }
                    if ( nextPosLeft(k) == 11 ) {
                        if ( turn == MY_TURN ) myScoreGen += Genaral[1];
                        else comScoreGen += Genaral[1];
                        Genaral[1] = 0;
                    }                    
                    
                    k = nextPosLeft(k);
                    k = nextPosLeft(k);
                    if ( k == 5 && (Genaral[0] != 0 || Armys[5] !=0) ) break;
                    if ( k == 11 && (Genaral[1] != 0 || Armys[11] != 0) ) break;
                }
                if ( turn == MY_TURN ) myScoreArm += score;
                else comScoreArm += score;
//                System.out.println(comScoreArm);
            }
        }
        
        if ( ! isEndGame() ) {
            if ( turn == MY_TURN ) turn = COM_TURN;
            else turn = MY_TURN;
        }
        
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    
    boolean isEndGame() {
        
        if ( Armys[5] == 0 && Armys[11] == 0 && Genaral[0] == 0 && Genaral[1] == 0 ) {
            for ( int i = 1; i <= 5; i ++ ) {
                myScoreArm += Armys[i - 1];
                comScoreArm += Armys[5 + i];
            }
            myScoreArm += myScoreGen * 10;
            comScoreArm += comScoreGen * 10;
            if ( myScoreArm > comScoreArm ) result = WIN;
            else if ( myScoreArm == comScoreArm ) result = HOA;
            else result = LOSE;
            return true;
        }
        
        boolean check ;
        if ( turn == MY_TURN ) {
            check = true;
            for ( int i = 6; i <= 10; i ++ ){
                if ( Armys[i] != 0 ) {
                    check = false;
                    break;
                }
            }
            if ( check ) {
                if ( comScoreArm < 5 ) {
                    result = WIN;
                    return true;                    
                } else { 
                     comScoreArm -= 5;
                     for ( int i = 6; i <= 10; i ++ ) Armys[i] = 1;                
                }
            }
        } else {
            check = true;
            for ( int i = 0; i <= 4; i ++ ){
                if ( Armys[i] != 0 ) {
                    check = false;
                    break;
                }
            }
            if ( check ) {
                if ( myScoreArm < 5 ) {
                    result = LOSE;
                    return true;
                    
                } else {
                     myScoreArm -= 5;
                     for ( int i = 0; i <= 4; i ++ ) Armys[i] = 1;
                }               
            }
        }
        
        return false;
    }

    public int getMyScoreArm() {
        return myScoreArm;
    }

    public void setMyScoreArm(int myScoreArm) {
        this.myScoreArm = myScoreArm;
    }

    public int getComScoreArm() {
        return comScoreArm;
    }

    public void setComScoreArm(int comScoreArm) {
        this.comScoreArm = comScoreArm;
    }

    public int getMyScoreGen() {
        return myScoreGen;
    }

    public void setMyScoreGen(int myScoreGen) {
        this.myScoreGen = myScoreGen;
    }

    public int getComScoreGen() {
        return comScoreGen;
    }

    public void setComScoreGen(int comScoreGen) {
        this.comScoreGen = comScoreGen;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
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

    public Position getPosMyArmys(int k) {
        return posMyArmys[k];
    }

    public void setPosMyArmys(Position[] posMyArmys) {
        this.posMyArmys = posMyArmys;
    }

    public Position[] getPosComArmys() {
        return posComArmys;
    }

    public void setPosComArmys(Position[] posComArmys) {
        this.posComArmys = posComArmys;
    }

    public Position getPosMyGen() {
        return posMyGen;
    }

    public void setPosMyGen(Position posMyGen) {
        this.posMyGen = posMyGen;
    }

    public Position getPosComGen() {
        return posComGen;
    }

    public void setPosComGen(Position posComGen) {
        this.posComGen = posComGen;
    }
    
    
    
    public int getArmys(int k) {
        return Armys[k];
    }

    public void setMyArmys(int k, int num) {
        this.Armys[k] = num;
    }

   
    public int getGenaral( int k) {
        return Genaral[k];
    }

    public void setGenaral(int k, int num) {
        this.Genaral[k] = num;
    }

    
}
