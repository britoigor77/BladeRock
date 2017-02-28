

import java.util.ArrayList;
import java.util.Random;

public class Character {

    private int life;
    private int attack;
    private int realAttack;
    private String nome;
    private final int totalLife;
    private ArrayList itens = new ArrayList<Choice>();
    private Random rand;
    
    public Character(int life, int attack) {
        this.life = life;
        this.attack = attack;
        this.totalLife = life;
        this.rand = new Random();
    }

    public void battle(Character enemy) {
       
        this.takeDamage(enemy.getRealAttack(enemy.getAttack()));
        enemy.takeDamage(this.getRealAttack(this.getAttack()));
    }

    
    public boolean isAlive() {
        if(this.life > 0)
            return true;

        return false;
    }

    public void takeDamage(int attack) {
        
        this.life -= attack;
    }
    
    public void setAttack(int attack)
    {
        this.attack = attack;
    }
    public int getAttack() {
        return this.attack;
    }
    
    public int getRealAttack(int attack)
    {   
        this.realAttack = attack;
        int evasiva = rand.nextInt(10);
         
        if(evasiva < 3)
            realAttack = 1;
        
        
        return realAttack;
    }
    
    public int getAtualAttack()
    {
        return this.realAttack;
    }
    
    
     public int getLive(){
    	return this.life;
     }
     
    public void setLive(int life)
    {
        this.life = life;
    }

    public void ganhaLive(int live){
    	this.life += live;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
           
    public int getTotalLife() {
        return totalLife;
    }
    
     public void addItem(Itens i)
    {
        this.itens.add(i);
    }

    public ArrayList getItens() {
        return itens;
    }

    public int getRealAttack() {
        return realAttack;
    }
 
     
}
