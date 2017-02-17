package Codigos;


public class InformChoice extends Choice {
	
	
	public InformChoice(String description){
		super(description, null);
	}
		
	@Override
	public void executeChoice(Character character){
		System.out.println();
		System.out.println("''''''''''''DADOS  do Heroi'''''''''''");
		System.out.println("''''''''''''''''''''''''''''''''''''''");
		System.out.println();
	}
}
