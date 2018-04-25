/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import static gameobject.SimpleArmys.NOT_END;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Quoc Hung
 */
public class OpenAI {
    
    private final Armys armys;
    private Queue<SimpleArmys> q;
    
    public static final int HUM_SIDE = 0;
    public static final int COM_SIDE = 1;
    
    public OpenAI( Armys armys ) {
        q = new LinkedList<>();
        this.armys = armys;
    }
    
    public void justDoIt() throws InterruptedException{     
        
        int maxDelta = 0;
        int maxBeginPos = 0;
        int maxBeginDirection = 0;
        boolean isFirst = true;
        
        for ( int i = 6; i < 11; i ++  ) {
            if ( armys.getArmys(i) != 0 ) {
                SimpleArmys simpleAmrmys;
                simpleAmrmys = new SimpleArmys(armys,i, Armys.LEFT);
                q.add(simpleAmrmys);
                simpleAmrmys = new SimpleArmys(armys,i, Armys.RIGHT);    
                q.add(simpleAmrmys);
            }
                
        }
        
        while ( ! q.isEmpty() ) {
            SimpleArmys simpleArmys;
            simpleArmys = copySimpleArmys(q.remove());
            
            SimpleArmys sa;
            
            if ( simpleArmys.getTurn() == SimpleArmys.COM_TURN ) {
                if ( simpleArmys.getDeep() == 0 ) {
                    sa = copySimpleArmys(simpleArmys);
                    sa.move(sa.getBeginPoint(), sa.getBeginDirection());
                    q.add(sa);
                } else {
                    for ( int i = 6; i <= 10; i ++ ) {
                        sa = copySimpleArmys(simpleArmys);
                        if ( sa.getArmys(i) != 0 ) {
                            sa.move(i, Armys.LEFT);
                            if ( sa.getResult() != SimpleArmys.NOT_END && sa.getDeep() < 10 ) {                            
                                q.add(sa);
                            } else {
                                if ( isFirst ) {
                                    maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                    maxBeginPos = sa.getBeginPoint();
                                    maxBeginDirection = sa.getBeginDirection();
                                    isFirst = false;
                                } else {
                                    if ( maxDelta < sa.getScoreCom() - sa.getScoreHum() ) {
                                        maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                        maxBeginPos = sa.getBeginPoint();
                                        maxBeginDirection = sa.getBeginDirection();
                                    }
                                }
                            }
                            sa = copySimpleArmys(simpleArmys);
                            sa.move(i, Armys.RIGHT);
                            if ( sa.getResult() != SimpleArmys.NOT_END && sa.getDeep() < 10 ) {                            
                                q.add(sa);
                            } else {
                                if ( isFirst ) {
                                    maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                    maxBeginPos = sa.getBeginPoint();
                                    maxBeginDirection = sa.getBeginDirection();
                                    isFirst = false;
                                } else {
                                    if ( maxDelta < sa.getScoreCom() - sa.getScoreHum() ) {
                                        maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                        maxBeginPos = sa.getBeginPoint();
                                        maxBeginDirection = sa.getBeginDirection();
                                    }
                                }
                            }
                        }
                            
                    }
                }
                
            } else {
                
                for ( int i = 0; i <= 4; i ++ ) {
                    if ( simpleArmys.getArmys(i) != 0 ) {
                        sa = copySimpleArmys(simpleArmys);
                        sa.move(i, Armys.LEFT);
                        if ( sa.getResult() != SimpleArmys.NOT_END && sa.getDeep() < 10 ) {                            
                            q.add(sa);
                        } else {
                            if ( isFirst ) {
                                maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                maxBeginPos = sa.getBeginPoint();
                                maxBeginDirection = sa.getBeginDirection();
                                isFirst = false;
                            } else {
                                if ( maxDelta < sa.getScoreCom() - sa.getScoreHum() ) {
                                    maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                    maxBeginPos = sa.getBeginPoint();
                                    maxBeginDirection = sa.getBeginDirection();
                                }
                            }
                        }
                        sa = copySimpleArmys(simpleArmys);
                        sa.move(i, Armys.RIGHT);
                        if ( sa.getResult() != SimpleArmys.NOT_END && sa.getDeep() < 10 ) {                            
                            q.add(sa);
                        } else {
                            if ( isFirst ) {
                                maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                maxBeginPos = sa.getBeginPoint();
                                maxBeginDirection = sa.getBeginDirection();
                                isFirst = false;
                            } else {
                                if ( maxDelta < sa.getScoreCom() - sa.getScoreHum() ) {
                                    maxDelta = sa.getScoreCom() - sa.getScoreHum();
                                    maxBeginPos = sa.getBeginPoint();
                                    maxBeginDirection = sa.getBeginDirection();
                                }
                            }
                        }
                     }
                     
                        
                }
            }
        }
        if ( maxBeginDirection == Armys.LEFT ) System.out.println( maxBeginPos + " left" );
        else System.out.println( maxBeginPos + " right" );
        armys.move(maxBeginPos, maxBeginDirection);
    }
    
    public SimpleArmys copySimpleArmys( SimpleArmys sa ) {
        SimpleArmys copySA = new SimpleArmys(0, 0);
        for ( int i = 0; i < 12; i ++ ) copySA.setArmys(sa.getArmys(i), i); 
        copySA.setScoreCom(sa.getScoreCom());
        copySA.setScoreHum(sa.getScoreHum());
        copySA.setResult(NOT_END);
        copySA.setTurn(sa.getTurn());
        copySA.setBeginDirection(sa.getBeginDirection());
        copySA.setBeginPoint(sa.getBeginPoint());
        copySA.setDeep(sa.getDeep());
        return copySA;
    }
    
      
    
}
