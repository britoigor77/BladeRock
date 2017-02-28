
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
import javax.swing.JTextArea;

public class TelaHistory extends JPanel{

    
    public String enderecoIMG = "punk.jpg";
    ImageIcon fundo = new ImageIcon(getClass().getResource(enderecoIMG));
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image img = fundo.getImage();
        g.drawImage(img, 0, 0, this);
    }
    


     JLabel titulo;
    
    public void TelaHistoria( final TelaPrincipal frame, final TelaHistory telaHistoria, final Book book)
    {
        frame.add(telaHistoria);
        telaHistoria.setLayout(null);
        
       JButton botaoComeca= new JButton("COMEÇAR");
       botaoComeca.setBounds(550, 370,200 ,100);
       botaoComeca.setBackground(Color.green);
       botaoComeca.setFont(new Font("Impact", Font.PLAIN, 30));
      telaHistoria.add(botaoComeca);
              
       this.titulo = new JLabel("HISTÓRIA");
       this.titulo.setBounds(200,0,500,100);
       telaHistoria.add(titulo);
       titulo.setFont(new Font("Impact", Font.PLAIN, 30));
       titulo.setForeground(Color.WHITE);
       
        JTextArea textoIntro;
        textoIntro = new JTextArea();
        textoIntro.setText("Você é o guitarrista solo e líder da banda Blade Rock."+
"Há pouco tempo sua banda entrou num concurso musical chamado Music Show Time. Hoje o rock não tem " +
"tanta mídia como antigamente e por isso seu grupo foi taxado como fraco." +
"No entanto, utilizando os incríveis riffs de guitarra, linhas perfeitas de " +
"contra- baixo, viradas de bateria extremamente incríveis e uma voz afinada que " +
"canta letras bem elaboradas, sua banda eliminou diversas outras bandas e cantores " +
"dados como  favoritos, e hoje está na final do concurso." +
"Porém, mesmo fazendo um grande sucesso, sua banda ganhou inúmeros haters, geralmente fãs de bandas eliminadas pela sua." +
"Sua missão é impedir qualquer incoveniência, vencer esse concurso e ajudar a " +
"trazer música de qualidade para esta geração musicalmente ignorante. ");
       telaHistoria.add(textoIntro);
       textoIntro.setBounds(50, 100, 600, 200);
       textoIntro.setFont(new Font("Impact", Font.PLAIN, 15));
       textoIntro.setEditable(false);
       textoIntro.setLineWrap(true);
      
       
       
       botaoComeca.addActionListener(new ActionListener() {
           
        @Override
        public void actionPerformed(ActionEvent e) {
           frame.limpaTela(telaHistoria);
           frame.telaJogo(book,frame.getNumBotoes(book) );
        }
        });
       
        
    }
}
