package Telas;

import Codigos.BattleEvent;
import Codigos.BlankEvent;
import Codigos.Book;
import Codigos.Character;
import Codigos.Choice;
import Codigos.Engine;
import Codigos.Event;
import Codigos.MusicChoice;
import Codigos.TipoFase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame{
    
     TelaIntro intro;
     Painel painel;
     JButton [] botao;
     TelaHistory telaHistoria;
  
    public TelaPrincipal()
    {     
         final Book book = Engine.createBook();
         //////////////////////////////////////////////////////////////////////////////////////////////
 
         
        this.setBounds(150,35, 900, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    public void telaJogo(final Book book, int numBotoes)
    {
        this.painel = new Painel();
        painel.TelaInicial(this, painel, book, numBotoes);
        
    }
    
    
    public void batalha(Book book,int numEscolha){
       
        Choice c = ((BattleEvent) book.getEventActually()).findChoice(numEscolha);
        
        Character inimigo = ((BattleEvent) book.getEventActually()).getEnemy();
        Character player = ((BattleEvent) book.getEventActually()).getPlayer();
        
        String narraBatalha = "";
        
    
        
        if(inimigo.getLive() == inimigo.getTotalLife())
            painel.texto.setText(book.showHistory());
        else 
        {
               if(player.getAtualAttack() == 0 && inimigo.getAtualAttack() == 0)
                   narraBatalha = "VOCÊ ERROU O ATAQUE!!!! O INIMIGO ERROU O ATAQUE ";
     
               else if (player.getAtualAttack() != 0 && inimigo.getAtualAttack() == 0)
                  narraBatalha =  "Você atacou com " + c.getDescription() + ". O inimigo sofreu " + player.getAttack()
                + " pontos de hp. O "+ inimigo.getNome() +" ERROU O ATAQUE";
               
               else if (player.getAtualAttack() == 0 && inimigo.getAtualAttack() != 0)
                  narraBatalha =  "VOCÊ ERROU O ATAQUE!!!  Você sofreu um ataque do inimimgo de "+ inimigo.getAttack()+
                          " pontos";
               
               else
                   
             narraBatalha = "  Você atacou com " + c.getDescription() + ". O inimigo sofreu um dano de " + player.getAtualAttack()
                + " pontos. Você sofreu um ataque do "+ inimigo.getNome()+ ". Perdeu "+ inimigo.getAtualAttack()+ " pontos de vida";
               
               painel.texto.setText(narraBatalha);
//            this.texto.setText("  Você atacou com " + c.getDescription() + ". O inimigo sofreu " + player.getAttack()
//                + " pontos de hp. Você sofreu um ataque do inimimgo de "+ inimigo.getAttack()+ " pontos");
        }   //}
    }

    public void telaGameOver(final Book book)
    {
         for(int i= 0; i < botao.length; i++)
                botao[i].setVisible(false);
            JButton botaoAgain = new JButton("RECOMEÇAR");
            this.painel.add(botaoAgain);
            botaoAgain.setBounds(400, 300, 200, 200);
            book.getPlayer().setLive(0);
            painel.vidaJogador.setText(""+book.getPlayer().getLive());
            painel.attackPlayer.setText("--");
            
            botaoAgain.addActionListener(new ActionListener() {
        
                @Override
                public void actionPerformed(ActionEvent e) {
                    book.resetHistory();
                    int novoNumBotoes = getNumBotoes(book);
                    //repaint(novoNumBotoes,book, 0);
                }
            });
        
    }

    
    public void tocaMusica(Book book, int numEscolha)
    {
        Choice c =(Choice)((BlankEvent) book.getEventActually()).findChoice(numEscolha); 
        
        if(c instanceof MusicChoice)
        {
            ((MusicChoice)c).playMusic();
        }
    }
    
    public void addItens(Book book, Event evento, int numEscolha)
    {
         //VERIFICA FASE PRA ADICIONAR ITANS
        System.out.println("adicionei item");
        System.out.println("Ó o tipo aqui mlk ----->>>" +evento.getTipo());
        if(evento.getTipo() == TipoFase.MUSIC)
        {
            //Choice c =(MusicChoice)((BlankEvent) book.getEventActually()).findChoice(numEscolha); 
            
            
             MusicChoice m =(MusicChoice)((BlankEvent) book.getEventActually()).findChoice(numEscolha); 
             m.playMusic();
            System.out.println("Mandei tocar a musica TCHTCHE");
        }
        
        
        if(evento.getTipo() == TipoFase.BATTLE)
        {
            book.getPlayer().setAttack(book.getPlayer().getAttack() + evento.getTipo().getMorePonits());
            painel.attackPlayer.setText(""+ book.getPlayer().getAttack());
        }
        
         if(evento.getTipo() == TipoFase.HEAL)
        {
            book.getPlayer().setLive(book.getPlayer().getLive() + evento.getTipo().getMorePonits());
            painel.vidaJogador.setText(""+ book.getPlayer().getLive());
        }
        
         if(evento.getTipo() == TipoFase.DAMAGE)
        {
            book.getPlayer().setLive(book.getPlayer().getLive() - evento.getTipo().getMorePonits());
            painel.vidaJogador.setText(""+ book.getPlayer().getLive());
        }
         
         if(evento.getTipo() == TipoFase.TRANSITION)
         {
             telaTransicao(book);
         }
    }
    
    
    public void telaTransicao(final Book book)
    {
        for (JButton botao1 : botao) {
            botao1.setVisible(false);
        }
            JButton botaoAvancar = new JButton("AVANÇAR");
            this.painel.add(botaoAvancar);
            botaoAvancar.setBounds(400, 300, 200, 200);
            
            
            botaoAvancar.addActionListener(new ActionListener() {
        
                @Override
                public void actionPerformed(ActionEvent e) {
                    book.nextEvent(0);
                    int novoNumBotoes = getNumBotoes(book);
                    repaint(novoNumBotoes,book, 0);
                }
            });
    }
    
    
    public void restart(Book book)
    {
        
    }
    
    public void repaint(int numBotoes, final Book book, int numEscolha)
    {
                     
        //TEXTO ACONTECIMENTOS
         painel.texto.setText(book.showHistory());
         
         //VIDA DO JOGADOR
        painel.vidaJogador.setText("" + book.getPlayer().getLive());
    
         //VERIFICA SE O EVENTO É UMA BATALHA
         Event evento = book.getEventActually();
         if(evento instanceof BattleEvent)
         {
             painel.vidaInimigo.setText("" +( (BattleEvent) book.getEventActually()).getEnemy().getLive());
             painel.nomeEnemy.setText( ((BattleEvent) book.getEventActually()).getEnemy().getNome());
             painel.atkEnemy.setText(""+ ((BattleEvent) book.getEventActually()).getEnemy().getAttack());
             System.out.println( ((BattleEvent) book.getEventActually()).getEnemy().getNome());
             batalha(book, numEscolha);
         }
         else
         {
            painel.vidaInimigo.setText("--");
            painel.nomeEnemy.setText("--"); 
            painel.atkEnemy.setText("--");
         }
          
        //ADICIONA ITENS
       addItens(book, evento, numEscolha);
       
        
//       tocaMusica(book , numEscolha);
       
        //GAME OVER
        if(!(book.getPlayer().isAlive()) )
        {
            painel.texto.setText("PERDEU A LUTA OTÁRIO");
            numBotoes = 0;
            telaGameOver(book);
        }
        
        //PRINTA A TELA DE GAME OVER
        if(evento.getTipo() == TipoFase.LOSE)
        {    
           //organiza.batalha(book, numEscolha, texto);
            book.getPlayer().setLive(0);
            telaGameOver(book);
        }
        
        
        //BOTÕES
        
        //COLOCA TODOS OS BOTÕES COMO INVISÍVEIS
         for(int i= 0; i < botao.length; i++)
                botao[i].setVisible(false);
        
        int posx = 150;
        int posy =250;
         for(int i = 0; i < numBotoes; i++)
         {
             botao[i].setBounds(posx, posy,400 , 50);
             botao[i].setBackground(Color.WHITE);
             botao[i].setVisible(true);
             posy+= 60;
             painel.add(botao[i]);
         }
         

        int i = 0;
         for(Choice choice:book.nextEvents()) {
                botao[i].setText(choice.getDescription());
                i++;
          }
         
    }
    
    public int getNumBotoes(Book book)
    {  
        int numBotoes =0;
         for(Choice choice:book.nextEvents())               
         {   
             numBotoes++;
         }
         System.out.println("ME IMPORTEI COM O NUM DE BOTOÕES   :----" + numBotoes );
        return numBotoes;
    }
    
    

    public void TelaHistoria(Book book)
    {
        this.telaHistoria = new TelaHistory();
        telaHistoria.TelaHistoria(this, telaHistoria, book);
    }
    public void TelaInicial(Book book)
    {
        this.intro = new TelaIntro();
        intro.TelaInicial(this, intro, book);

    }
    
    public void limpaTela(JPanel panel)
    {
        this.remove(panel);
    }
    
}
