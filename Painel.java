
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

public class Painel extends JPanel{
    
    TelaPrincipal tela = new TelaPrincipal();
    public String enderecoIMG = "studio-rock.jpg";
    private String endereco;
    
    
    ImageIcon fundo = new ImageIcon(getClass().getResource(enderecoIMG));
    
    public void mudaFundo(String novoFundo)
    {
        System.out.println("MUDEI O FUNDO");
        this.enderecoIMG = novoFundo;
        this.fundo = new ImageIcon(getClass().getResource(enderecoIMG));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image img = fundo.getImage();
        g.drawImage(img, 0, 0, this);
    }
    
     TelaIntro intro;
     public JTextArea texto;
     JLabel back;
     JButton botaoStart;
     JLabel titulo;
     TelaHistory telaHistoria;
     JTextArea vidaJogador;
     JLabel attackPlayer;
     JTextArea vidaInimigo;
     JLabel nomeEnemy;
     JLabel atkEnemy;
    
    
     public void TelaInicial( final TelaPrincipal frame, final Painel painel, final Book book, int numBotoes)
    {
        //ADICIONA O PAINEL 
 
        //this.setBounds(0, 0, 900, 800);
         
         painel.setBounds(0, 0, 700, 500);
         frame.add(painel); 
         frame.painel.setLayout(null);
         System.out.println("ME IMPORTEI COM O DESIGN");
         painel.setLayout(null);
         painel.setForeground(Color.BLACK);
         frame.setResizable(false);
                  
        //TEXTO HISTÓRIA
        this.texto = new JTextArea();
        texto.setBounds(100, 30, 500, 150);

         texto.setLineWrap(true);
         texto.setBackground(Color.WHITE);
         texto.setEditable(false);
         texto.setFont(new Font("Times New Roman", Font.BOLD, 18));
         
         painel.add(texto);
         texto.setText(Engine.createBook().showHistory());
     
         
         //LABEL VIDA JOGADOR
         this.vidaJogador = new JTextArea();
         painel.add(vidaJogador);
         vidaJogador.setBounds(790,53,70,20);
         vidaJogador.setText("" + book.getPlayer().getLive());
         
         vidaJogador.setFont(new Font("Times New Roman", Font.BOLD, 18));
         vidaJogador.setBackground(Color.BLACK);
         if(book.getPlayer().getLive() > 7)
             vidaJogador.setForeground(Color.WHITE);
         else if(book.getPlayer().getLive() > 5 && book.getPlayer().getLive() < 8)
             vidaJogador.setForeground(Color.red);
         
         //LABEL ATAQUE DO JOGADOR
          this.attackPlayer = new JLabel();
         painel.add(attackPlayer);
         attackPlayer.setBounds(800,90,100,20);
         attackPlayer.setText(""+ book.getPlayer().getAttack());
         attackPlayer.setFont(new Font("Times New Roman", Font.BOLD, 18));
         attackPlayer.setForeground(Color.WHITE);
         
         
         //BARRA DE HP DO INIMIGO
         this.vidaInimigo = new JTextArea();
         painel.add(vidaInimigo);
         vidaInimigo.setBounds(790,350,50,20);
         vidaInimigo.setText("--"); 
         vidaInimigo.setFont(new Font("Times New Roman", Font.BOLD, 18));
         vidaInimigo.setForeground(Color.WHITE);
         vidaInimigo.setBackground(Color.BLACK);
         
         //NOME DO INIMIGO (GETNOME)
         
          this.nomeEnemy = new JLabel();
         painel.add(nomeEnemy);
         nomeEnemy.setBounds(735,310,80,20);
         nomeEnemy.setText("--"); 
         nomeEnemy.setFont(new Font("Times New Roman", Font.BOLD, 18));
         nomeEnemy.setForeground(Color.WHITE);
         nomeEnemy.setBackground(Color.BLACK);
         
         //atk do inimigo
         
         this.atkEnemy = new JLabel();
         painel.add(atkEnemy);
         atkEnemy.setBounds(798, 390, 80, 20);
         atkEnemy.setText("--"); 
         nomeEnemy.setFont(new Font("Times New Roman", Font.BOLD, 18));
         atkEnemy.setForeground(Color.WHITE);
         atkEnemy.setBackground(Color.BLACK);
         
         
        //ICONES ITENS 
        
        //ICONE GUITARRA
        ImageIcon guitarra = new ImageIcon(getClass().getResource("guitarra.png"));
        
        JLabel iconeGuitarra = new JLabel();
        painel.add(iconeGuitarra);
        iconeGuitarra.setIcon(guitarra);
        iconeGuitarra.setBounds(700, 15, 400, 400);
        iconeGuitarra.setFont(new Font("Times New Roman", Font.BOLD, 30));
        iconeGuitarra.setForeground(Color.WHITE);
         
         
         frame.botao = new JButton[3];   
         int posx = 150;
         int posy =250;
         System.out.println(" TO NO DESIGN . AQUI TEM " + numBotoes+ " BOTOES");
         
         for(int i = 0; i < frame.botao.length; i++)
         {
             frame.botao[i] = new JButton();
         }
         
         for(int i = 0; i < numBotoes; i++)
         {
             frame.botao[i].setBounds(posx, posy,400 , 50);
             frame.botao[i].setBackground(Color.WHITE);
             posy+= 60;
             painel.add(frame.botao[i]);
         }
         
         //PRINTA ESCOLHAS
         
         int i = 0;
         for(Choice choice:book.nextEvents()) {
                frame.botao[i].setText(choice.getDescription());
                i++;
          }
//         
//         
        //EVENTOS COM OS BOTÕES PRESSIONADOS 
         frame.botao[0].addActionListener(new ActionListener() {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            book.nextEvent(0);
            int novoNumBotoes = frame.getNumBotoes(book);
            frame.repaint(novoNumBotoes,book, 0);
            System.out.println("BOTAO 1 PRESSIONADO");
           
        }
        });
         
        frame.botao[1].addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            book.nextEvent(1);
            int novoNumBotoes = frame.getNumBotoes(book);
            frame.repaint(novoNumBotoes,book, 1);
            System.out.println("BOTAO 2 PRESSIONADO");
           
        }
        });
        
         frame.botao[2].addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            book.nextEvent(2);
            int novoNumBotoes = frame.getNumBotoes(book);
            frame.repaint(novoNumBotoes,book, 2);
            System.out.println("BOTAO 3 PRESSIONADO");
           
        }
        });
         
    }
     
     
    public void telaGameOver(final TelaPrincipal frame, Painel painel, final Book book)
    {
         for(int i= 0; i < frame.botao.length; i++)
                frame.botao[i].setVisible(false);
            JButton botaoAgain = new JButton("RECOMEÇAR");
            painel.add(botaoAgain);
            botaoAgain.setBounds(400, 300, 200, 200);
            book.getPlayer().setLive(0);
            painel.vidaJogador.setText(""+book.getPlayer().getLive());
            painel.attackPlayer.setText("--");
            
            botaoAgain.addActionListener(new ActionListener() {
        
                @Override
                public void actionPerformed(ActionEvent e) {
                    book.resetHistory();
                    int novoNumBotoes = frame.getNumBotoes(book);
                    //repaint(novoNumBotoes,book, 0);
                }
            });
        
    }
}
