package Codigos;

import java.util.ArrayList;

public class Player extends Character {

    private int life;
    private ArrayList itens;
    
    public Player(int life, int attack) {
        super(life, attack);
        this.life = life;
        this.itens = new ArrayList(); 
    }

   
    
    public int getLife() {
        return life;
    }
    
}