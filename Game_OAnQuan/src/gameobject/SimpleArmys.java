/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;



/**
 *
 * @author Quoc Hung
 */
public class SimpleArmys {    
    
    public static final int HUM_TURN = 0;
    public static final int COM_TURN = 1;   
    
    public static final int HUM_WIN = - 1;
    public static final int HOA = 0;
    public static final int COM_WIN = 1;
    public static final int NOT_END = 2;
    
    private int result;
    private int turn;
    private int beginPoint;
    private int beginDirection;
    private int deep;
    
    private int[] armys = new int[12];
    private int scoreCom;
    private int scoreHum;
    

    public SimpleArmys(int scoreCom, int scoreHum) {
        this.scoreCom = scoreCom;
        this.scoreHum = scoreHum;
        this.result = NOT_END;
    }
    
    public SimpleArmys( SimpleArmys sa, int pos, int dir ) {
        for ( int i = 0; i < 12; i ++ ) this.armys[i] = sa.getArmys(i);
        this.scoreCom = sa.getScoreCom();
        this.scoreHum = sa.getScoreHum();
        this.result = NOT_END;
        this.turn = sa.getTurn();
        this.beginDirection = sa.getBeginDirection();
        this.beginPoint = sa.getBeginPoint();
        this.move(pos, dir);
        this.deep = sa.getDeep() + 1;
    }

    public SimpleArmys( Armys armys, int beginPoint, int beginDirection ) {
        for ( int i = 0; i < 12; i ++ ) this.armys[i] = armys.getArmys(i);
        this.armys[5] = armys.getGenaral(0) * 10 ;
        this.armys[10] = armys.getGenaral(1) * 10;
        this.scoreCom = 0;
        this.scoreHum = 0;
        this.beginPoint = beginPoint;
        this.beginDirection = beginDirection;
        this.deep = 0;
        this.turn = armys.getTurn();
        this.result = NOT_END;
    }
    
    
    
    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(int beginPoint) {
        this.beginPoint = beginPoint;
    }

    public int getBeginDirection() {
        return beginDirection;
    }

    public void setBeginDirection(int beginDirection) {
        this.beginDirection = beginDirection;
    }
    
    public int delta() {
        return ( scoreCom - scoreHum );
    }
    
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getArmys( int k ) {
        return armys[k];
    }

    public void setArmys(int x, int k) {
        this.armys[k] = x;
    }

    public int getScoreCom() {
        return scoreCom;
    }

    public void setScoreCom(int scoreCom) {
        this.scoreCom = scoreCom;
    }

    public int getScoreHum() {
        return scoreHum;
    }

    public void setScoreHum(int scoreHum) {
        this.scoreHum = scoreHum;
    }
    
    public boolean cmp( SimpleArmys sa ) {
        return ( (this.getScoreCom() - this.getScoreHum()) > (sa.getScoreCom() - sa.getScoreHum()) );
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
        deep ++;
        if ( dir == Armys.RIGHT ) {
            int k = pos;
            do {
                int x = armys[k];
                armys[k] = 0;
                for ( int i = 1; i <= x; i ++ ) {
                    k = nextPosRight(k);
                    armys[k] ++;
                }
                k = nextPosRight(k);
            } while ( armys[k] != 0 && k != 5 && k != 11 );
            
            if ( armys[k] == 0 && k != 5 && k != 11 ) {
                int score = 0;
                while ( armys[nextPosRight(k)] != 0 && armys[k] == 0) {
                    score += armys[nextPosRight(k)];
                    armys[nextPosRight(k)] = 0;
                    
                    k = nextPosRight(k);
                    k = nextPosRight(k);
                    if ( k == 5 && armys[5] != 0 ) break;
                    if ( k == 11 && armys[11] != 0 ) break;
                }
                if ( turn == HUM_TURN ) scoreHum += score;
                else scoreCom += score;
            }
        }
        
        else {
            int k = pos;
            do {
                int x = armys[k];
                armys[k] = 0;
                for ( int i = 1; i <= x; i ++ ) {
                    k = nextPosLeft(k);
                    armys[k] ++;
                }
                k = nextPosLeft(k);
            } while ( armys[k] != 0 && k != 5 && k != 11 );
            
            if ( armys[k] == 0 && k != 5 && k != 11 ) {
                int score = 0;
                while ( armys[nextPosLeft(k)] != 0 && armys[k] == 0) {
                    score += armys[nextPosLeft(k)];
                    armys[nextPosLeft(k)] = 0;
                    
                    k = nextPosLeft(k);
                    k = nextPosLeft(k);
                    if ( k == 5 && armys[5] != 0 ) break;
                    if ( k == 11 && armys[11] != 0 ) break;
                }
                if ( turn == HUM_TURN ) scoreHum += score;
                else scoreCom += score;
            }
        }
        
        if ( ! isEndGame() ) {
            if ( turn == HUM_TURN ) turn = COM_TURN;
            else turn = HUM_TURN;
        }
        
    }
    
    boolean isEndGame() {
        
        if ( armys[5] == 0 && armys[11] == 0) {
            for ( int i = 1; i <= 5; i ++ ) {
                scoreHum += armys[i - 1];
                scoreCom += armys[5 + i];
            }
            if ( scoreHum > scoreCom ) result = HUM_WIN;
            else if ( scoreHum == scoreCom ) result = HOA;
            else result = COM_WIN;
            return true;
        }
        
        boolean check ;
        if ( turn == HUM_TURN ) {
            check = true;
            for ( int i = 6; i <= 10; i ++ ){
                if ( armys[i] != 0 ) {
                    check = false;
                    break;
                }
            }
            if ( check ) {
                if ( scoreCom < 5 ) {
                    result = HUM_WIN;
                    return true;                    
                } else { 
                     scoreCom -= 5;
                     for ( int i = 6; i <= 10; i ++ ) armys[i] = 1;                
                }
            }
        } else {
            check = true;
            for ( int i = 0; i <= 4; i ++ ){
                if ( armys[i] != 0 ) {
                    check = false;
                    break;
                }
            }
            if ( check ) {
                if ( scoreHum < 5 ) {
                    result = COM_WIN;
                    return true;
                    
                } else {
                     scoreHum -= 5;
                     for ( int i = 0; i <= 4; i ++ ) armys[i] = 1;
                }               
            }
        }
        
        return false;
    }
    
}
