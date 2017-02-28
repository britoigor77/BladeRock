
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaIntro extends JPanel{
    
    public String enderecoIMG = "rock.jpg";
    ImageIcon fundo = new ImageIcon(getClass().getResource(enderecoIMG));
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image img = fundo.getImage();
        g.drawImage(img, 0, 0, this);
    }

    
     public void TelaInicial( final TelaPrincipal frame, final TelaIntro intro, final Book book)
    {
        
        frame.add(intro);
        
        intro.setLayout(null);
        
        this.titulo = new JLabel("ROCK BLADER");
        intro.add(titulo);
        this.titulo.setBounds(100, -100, 500, 300);
        this.titulo.setForeground(Color.blue);
        titulo.setFont(new Font("Impact", Font.PLAIN, 60));
        

       botaoStart = new JButton("START");
       intro.add(botaoStart);
       botaoStart.setBounds(500, 350,300 ,100);
       botaoStart.setFont(new Font("Arial", Font.PLAIN, 40));
       botaoStart.setForeground(Color.WHITE);
       botaoStart.setBackground(Color.blue);
    
         
       botaoStart.addActionListener(new ActionListener() {
           
        @Override
        public void actionPerformed(ActionEvent e) {
           frame.limpaTela(intro);
           frame.TelaHistoria(book);
        }
        });
    }
     
    private JButton botaoStart;
    private JLabel titulo;
}
