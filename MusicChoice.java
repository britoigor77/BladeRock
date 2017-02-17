package Codigos;

import Musica.MusicaFundo;

public class MusicChoice extends Choice{

    private String enderecoMusica;
    private MusicaFundo musicFundo;
    public MusicChoice(String description, Event event, String enderecoMusica) {
        super(description, event);
        this.enderecoMusica = enderecoMusica;
        this.musicFundo = new MusicaFundo();
    }
    
    public void playMusic()
    {
        this.musicFundo.music(this.enderecoMusica);
        System.out.println("MANDEI TOCAR A MUSICA............................................");
    }
    
    public String getEnderecoMusica()
    {
        return this.enderecoMusica;
    }
    
    @Override
    public void executeChoice(Character character) {
        
    }
    
}
