
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MusicaFundo {
    
    public static class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e)
        {

        }
    }
    
    AudioPlayer MGP = AudioPlayer.player;  
    AudioStream BGM = null;  
    
    public void aciona()
    {
       try {  
        BGM = new AudioStream(new FileInputStream(endereco));  
        } catch(IOException error) {  
            System.out.println("Error!!!");  
        }   
    }
    private String endereco;
    
    public  void music(String endereco, boolean ligado) {  
        System.out.println("CHEGUEI NAS MUSICAS");
        
        this.endereco = endereco;
            
        if(ligado == true)
        {
            aciona();
            MGP.start(BGM);
        }
            
        else
        {
            MGP.stop(BGM);
        }     
    }  
    
}
