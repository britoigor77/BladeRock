package Musica;

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
//              String endereco= "jimi2.wav";
//            music(endereco);
        }
    }
    
    
    public  void music(String endereco) {  
        System.out.println("CHEGUEI NAS MUSICAS");
        AudioPlayer MGP = AudioPlayer.player;  
        AudioStream BGM = null;  
        try {  
        BGM = new AudioStream(new FileInputStream(endereco));  
        } catch(IOException error) {  
            System.out.println("Error!!!");  
        }  
  
        MGP.start(BGM);   
    }  
}


