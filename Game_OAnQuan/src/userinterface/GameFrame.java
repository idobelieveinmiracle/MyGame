/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Quoc Hung
 */
public class GameFrame extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 500;    
    
    GamePanel gamePanel;
    
    public GameFrame() {
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width-SCREEN_WIDTH)/2,
                (dimension.height-SCREEN_HEIGHT)/2,
                SCREEN_WIDTH,
                SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        gamePanel = new GamePanel();
        this.add(gamePanel);
        
        this.addKeyListener(gamePanel);
    }
    
    public void startGame() {
        gamePanel.startGame();
    }
    
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startGame();
    }
    
}
