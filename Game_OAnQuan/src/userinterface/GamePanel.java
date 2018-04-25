/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import gameobject.Armys;
import gameobject.BackGroundMap;
import gameobject.OpenAI;
import gameobject.Pointer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Quoc Hung
 */

public class GamePanel extends JPanel implements Runnable, KeyListener{
    
    private Thread thread;
    
    private boolean isRunning;
    
    BackGroundMap backgroundMap;
    Pointer pointer;
    OpenAI openAI;
    Armys armys;
    
    private final InputManager inputManager;
    
    public GamePanel(){      
        System.out.println("Showed game panel");
        backgroundMap = new BackGroundMap(100, 50, 125);
        armys = new Armys(100, backgroundMap.getPosX(), backgroundMap.getPosY());
        pointer = new Pointer(100, 
                backgroundMap.getPosX() + backgroundMap.getX(), 
                backgroundMap.getPosY() + backgroundMap.getX(),
                Pointer.MY_SIDE,
                armys);
        openAI = new OpenAI(armys);
        
        inputManager = new InputManager(pointer);
        
//        pointer.setIsEnable(true);
        
//        isRunning = false;
        
//        pointer.setIsPicked(true);
//        pointer.moveLeft();
//        armys.setComGenaral(0);
//        armys.setComArmys(0, 30);
//        armys.move(0, Armys.LEFT);
        
    }
    
    @Override
    public void paint( Graphics g ) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        backgroundMap.draw(g2);        
        armys.draw(g2);
        pointer.draw(g2);
        
    }
    
    public void startGame(){
        if(thread == null){
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.processKeyPressed(e.getKeyCode());        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void run() {
        long FPS = 80;                      //Frames per Seconds
        long period = 1000*1000000/FPS;     //Tru kì
        long beginTime;
        long sleepTime;
        
        int a = 1;
        
        beginTime = System.nanoTime();      //nanoTime() là hàm lấy thời gian hệ thống        
        
        while(isRunning){            
            //System.out.println("a = "+a++);
            
            repaint();
            
            if(armys.getResult() != Armys.NOT_END) {
                if ( armys.getResult() == Armys.WIN ) {
                    JOptionPane.showMessageDialog(null, "YOU WIN" );
                }
                if ( armys.getResult() == Armys.LOSE ) {
                    JOptionPane.showMessageDialog(null, "YOU LOSE! AHIHI DO NGOX!" );
                }
                if ( armys.getResult() == Armys.HOA ) JOptionPane.showMessageDialog(null, "HOA MINZY" );
                isRunning = false;
            }
            
            while ( armys.getTurn() == Armys.COM_TURN ) {
                while ( System.nanoTime() - beginTime < 500000000 );
                while ( System.nanoTime() - beginTime < 500000000 );
                try {
                    openAI.justDoIt();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            
            try {
                if(sleepTime > 0)
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {
            
            }            
            beginTime = System.nanoTime();
            
        }
    }
}
