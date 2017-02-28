
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Engine {
    public static void main(String[] args) throws IOException {
        Book book = Engine.createBook();
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        tela.TelaInicial(book);
        
    }

    public static Book createBook() {
        
        Event eventoFinal = new BlankEvent("PERDEU OTÁRIO.",  new ArrayList<Choice>(), TipoFase.LOSE);
        Event eventoFinalFunk = new BlankEvent("VIRAR FUNKEIRO È SUICÍDIO. GAME OVER...",  new ArrayList<Choice>(), TipoFase.LOSE);
        Event eventoMorreuCarro = new BlankEvent("NA TENTATIVA DE TOMAR O VOLANTE O CARRO CAPOTOU E "
                + "EXPLODIU. GAME OVER.", new ArrayList<Choice>(), TipoFase.LOSE);
        Event eventoFinalDormiu = new BlankEvent("ENQUANTO VOCÊ DORMIA, FUNKEIROS TE SEQUESTRARAM E TE TORTURARAM"
                + "COM SUAS MÚSICAS HORRÍVEIS ENQUANTO OS TEENPOPS QUEIMARAM O PALCO DO SHOW. GAME OVER", new ArrayList(), 
                TipoFase.LOSE);
        Event eventoMorreuExplodiu = new BlankEvent("NA TENTATIVA DE TOMAR O VOLANTE O CARRO CAPOTOU E "
                + "EXPLODIU. GAME OVER.", new ArrayList<Choice>(), TipoFase.LOSE);
        Event eventoFinalFunkeiro = new BlankEvent("PERDEU TROUXA", new ArrayList<Choice>(), TipoFase.LOSE);
        
        Character player = new Player(15, 3);
        Enemy funkeiro = new Enemy(7, 2, "Funkeiro", TipoInimigo.FUNKEIRO);
        Enemy pagodeiro = new Enemy(6, 2, "Pagodeiro", TipoInimigo.PAGODEIRO);
        Enemy emo = new Enemy(6, 2, "Emo", TipoInimigo.EMO);
        Enemy capanga1 = new Enemy(6, 3, "Capanga1", TipoInimigo.CAPANGA);
        Enemy capanga2 = new Enemy(6, 4, "Capanga2", TipoInimigo.CAPANGA);
        
        //ATQUES NA BATLHA
        Choice escolhaGuitarrada = new BattleChoice("Guitarrada");
        Choice escolhaPalhetada = new BattleChoice("Explosão Sônica");
        
        Itens palhetaFerro = new Battle_Itens("Guitarra", 5, 4, 1);
       // Itens microfoneSonico = new Itens_Permanentes("Microfone Sônico", 1, 6);
        Itens treloso = new Heal_Itens("Treloso", 7, 1);
        
        //////////////////////COMEÇA AQUI////////////////////
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //   FINAL DO JOGO - VITÓRIA
  
       
        Event eventoGanhei = new BlankEvent("YEAHHH! Cara, sua apresentação foi de arrasar. Os jurados disseram que"
                + "foi a melhor apresentação da Rock Blader! Por fim, sua performance foi muito melhor que a banda "
                + "adversária e a ROCK BLADER GANHOU A COMPETIÇÃO!! Agora as novas bandas de rock terão a sua como "
                + "inspiração e o cenário musical neste país finalmente tem esperança. PARABÉNS BROTHER!",
                new ArrayList<Choice>(), TipoFase.WON); 
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //TOCAR NA FINAL
        ArrayList escolhasVoltando = new ArrayList<Choice>();
        Choice escolhaVoltar = new BlankChoice("SE ARESENTAR E ACABAR COM TUDO!!", eventoGanhei);
        escolhasVoltando.add(escolhaVoltar);
  
       
        Event eventoVoltando = new BlankEvent("Você e seus amigos correram muito e já estão nos bastidores. A Rock Blader"
                + " se apresentará em um minuto. Apesar de todos os obstáculos, vocês continuaram firmes. Agora é hora do"
                + " rock! Let's to Rock!!!!",
                escolhasVoltando, TipoFase.NOTHING); 
        
        
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- DESATANDO AMIGOS
        ArrayList escolhasAchei = new ArrayList<Choice>();
        Choice escolhaDesatar = new BlankChoice("Desatar seus amigos e voltar pra sede.", eventoVoltando);
        escolhasAchei.add(escolhaDesatar);
  
       
        Event eventoInvadir = new BlankEvent("Você encontrou todos os membros da banda amarrados. Aqueles caras queriam"
                + "mesmo sabotar o evento. É melhor você soltá- los logo, pois faltam apenas 5 mintutos para sua "
                + "apresentação.",
                escolhasAchei, TipoFase.NOTHING); 
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //VITORIA NO CAPANGA2
         ArrayList vitoriaCapanga2 = new ArrayList<Choice>();
        Choice escolhaEntrar = new BlankChoice("Entrar no quarto.",eventoInvadir);
        vitoriaCapanga2.add(escolhaEntrar);
        
        Event eventoVitoriaCapanga2 = new BlankEvent("YEAHH!, Você derrotou o último capanga."
                + "Hora de encontrar sua banda", vitoriaCapanga2, TipoFase.BATTLE);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- DESCOBERTO- BATLHA 2
   
        ArrayList escolhaCapanga2 = new ArrayList<Choice>();
        escolhaCapanga2.add(escolhaGuitarrada);
        escolhaCapanga2.add(escolhaPalhetada);
 
        Event batalhaCapanga2 = new BattleEvent("Agora vem o segundo cara.Esse parece ser bem mais forte."
                + " Escolha seu ataque.",
                escolhaCapanga2, capanga2, eventoVitoriaCapanga2, TipoFase.NOTHING);
        
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //VITORIA NO CAPANGA1
         ArrayList vitoriaCapanga1 = new ArrayList<Choice>();
        Choice escolhaAvancarLuta2 = new BlankChoice("AVANÇAR", batalhaCapanga2);
        vitoriaCapanga1.add(escolhaAvancarLuta2);
        
        Event eventoVitoriaCapanga1 = new BlankEvent("Você derrotou o inimigo e ganhou + 3 pts de attack."
                + "Ele está desmaiado agora. Vamos em frente!", vitoriaCapanga1, TipoFase.BATTLE);
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- DESCOBERTO- BATALHA 1
   
        ArrayList escolhaCapanga1 = new ArrayList<Choice>();
        escolhaCapanga1.add(escolhaGuitarrada);
        escolhaCapanga1.add(escolhaPalhetada);
 
        Event batalhaCapanga1 = new BattleEvent("DROGA!!! Um deles te viu. Os seguranças que estavam guardando a porta agora"
                + "estão correndo em sua direção. Você deve derrotá- los para salvar seus amigos.",
                escolhaCapanga1, capanga1, eventoVitoriaCapanga1, TipoFase.NOTHING);
         
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                                    //CAMARIM 34
             
        ArrayList escolhasCamarim34 = new ArrayList<Choice>();
        
        Choice escolhaSeAproximar = new BlankChoice("Se aproximar aos poucos.", batalhaCapanga1);
        escolhasCamarim34.add(escolhaSeAproximar);
 
       
        Event eventoCamarim34 = new BlankEvent("Chegando ao camarim, você encontrou membros da sua banda adversária conversando"
                + " com outros membros de bandas eliminadas pela Blade Rock ao longo da competição do lado de fora "
                + " conversando sobre como a vitória de sua banda está garantida. Há dois seguranças monstruosos do lado de "
                + "fora. É melhor tomar cuidado.",
                escolhasCamarim34, TipoFase.NOTHING);
        
        
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                                    //ESTACIONAMENTO  - CARRO DOS AMIGOS
             
        ArrayList escolhasCarroProcura = new ArrayList<Choice>();
        Choice escolhaProcurarCamarim = new BlankChoice("Ir até o camarim nº 34.", eventoCamarim34);
        //Choice escolhaProcurarEsquerda = new BlankChoice("Ir para esquerda do estacionamento.", eventoEsquerda);
        escolhasCarroProcura.add(escolhaProcurarCamarim);
        //escolhasCarroProcura.add(escolhaProcurarEsquerda);
 
       
        Event eventoCarroProcura = new BlankEvent("Depois de andar um pouco, você encontrou o carro dos seus amigos"
                + ". Mas... As portas estão abertas e o celular do vocalista está largado no chão. É claro que eles foram"
                + "pegos. Junto ao celular você encontrou um passe com o número do camarim 34. Seus amigos podem ter sidos"
                + " levados para lá.",
                escolhasCarroProcura, TipoFase.NOTHING);
        
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- SEGUIR OS CARAS
   
        ArrayList escolhasSeguir = new ArrayList<Choice>();
        Choice escolhaContSeguindo = new BlankChoice("Continuar seguindo os caras.", batalhaCapanga1);
        Choice escolhaVoltarProcurarCarro = new BlankChoice("Voltar e procurar pelo carro dos amigos.", eventoCarroProcura);
        escolhasSeguir.add(escolhaContSeguindo);
        escolhasSeguir.add(escolhaVoltarProcurarCarro);
  
       
        Event eventoSeguir = new BlankEvent("Estes caras estão conversando sobre como a vitória de sua banda está"
                + "garantida. Finalmente um deles diz que chegou a amarrar e esconder seus amigos para não poderem "
                + "tocar. Eles se aproximam de uma quarto com seguranças. Deve ser lá que seus amigos estão.",
                escolhasSeguir, TipoFase.NOTHING);
        
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- ESQUERDA
   
        ArrayList escolhasEsquerda = new ArrayList<Choice>();
        Choice escolhaSeguir = new BlankChoice("Seguir estes caras.", eventoSeguir);
        Choice escolhaProcurarCarro = new BlankChoice("Procurar pelo carro dos amigos.", eventoCarroProcura);
        escolhasEsquerda.add(escolhaSeguir);
        escolhasEsquerda.add(escolhaProcurarCarro);
  
       
        Event eventoEsquerda = new BlankEvent("Seguindo pelo lado esquerdo do estacionamento você encontrou "
                + " membros da sua banda adversária conversando com outros membros de bandas eliminadas pela Blade Rock"
                + "ao longo da competição. Eles diziam algo sobre os seus amigos. Muito susupeito... ",
                escolhasEsquerda, TipoFase.NOTHING);
  
        

   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESTACIONAMENTO- DIREITA
        
         ArrayList escolhasDireita = new ArrayList<Choice>();
//        Choice escolhaProcurarCarro = new BlankChoice("Procurar pelo carro dos amigos.", eventoFinal);
       Choice escolhaProcurarEsquerda = new BlankChoice("Ir para esquerda do estacionamento.", eventoEsquerda);
        escolhasDireita.add(escolhaProcurarCarro);
        escolhasDireita.add(escolhaProcurarEsquerda);
       
        Event eventoDireita = new BlankEvent("Opa! Seguindo este caminho você encontrou um microfone sônico. +3pts de ATK",
                escolhasDireita, TipoFase.GANHA_MICROFONE);
        
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
                                    //ESTACIONAMENTO   
                                    
         ArrayList escolhasEstacionamento = new ArrayList<Choice>();
       // Choice escolhaProcurarCarro = new BlankChoice("Procurar pelo carro dos amigos.", eventoFinal);
        //Choice escolhaProcurarEsquerda = new BlankChoice("Ir para esquerda.", eventoFinal);
        Choice escolhaProcurarDireita = new BlankChoice("Ir para direita.", eventoDireita);
        escolhasEstacionamento.add(escolhaProcurarCarro);
        escolhasEstacionamento.add(escolhaProcurarEsquerda);
        escolhasEstacionamento.add(escolhaProcurarDireita);
       
        Event eventoEstacionamento = new BlankEvent("Cara. O estacionamento é enorme. Onde procurar?",
                escolhasEstacionamento, TipoFase.NOTHING);
       
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
                                        //VITÓRIA NO EMO
      
       ArrayList escolhaVitoriaEmo = new ArrayList<Choice>();
        Choice escolhaAvancar3 = new BlankChoice("IR PARA O ESTACIONAMENTO.", eventoEstacionamento);
        escolhaVitoriaEmo.add(escolhaAvancar3);
        
        Event eventoVitoriaEmo = new BlankEvent("Você arrancou o coro daquele emo."
                + "Paul disse que membros das bandas eliminadas se aliaram a sua banda adversária"
                + "e provavelmente devem ter pego o resto da Blade Rock também. Ele disse que seus amigos tinham "
                + "ido ao estacionamento antes de sumirem. Então eles provavelmente estão por lá.", escolhaVitoriaEmo, TipoFase.BATTLE);
        
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ACHANDO O BATERISTA
        ArrayList escolhasBastidores = new ArrayList<Choice>();
        escolhasBastidores.add(escolhaGuitarrada);
        escolhasBastidores.add(escolhaPalhetada);
 
        Event batalhaEmos = new BattleEvent("Chegando aos bastidores você encontrou Paul, o baterista, "
                + "imobilizado por Emos das Trevas, que também querem acabar com evento. Você terá de derrotar um deles "
                + "para libertar seu amigo.", escolhasBastidores, emo, eventoVitoriaEmo, TipoFase.NOTHING);
        
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //PRODUTOR2
        
        ArrayList escolhasProdutor2 = new ArrayList<Choice>();
        Choice escolhaDesiste = new BlankChoice("Desistir da competição.", eventoFinal);
        Choice escolhaBatera = new BlankChoice("Procurar o baterista. ", batalhaEmos);
        escolhasProdutor2.add(escolhaBatera);
        escolhasProdutor2.add(escolhaDesiste);
       
        Event eventoProdutor2 = new BlankEvent("Impressionado com sua determinação o produtor lhe deu um acordamento de "
                + "guitarra completo. +2 pts de ATK . O que fazer?",
                escolhasProdutor2, TipoFase.GANHA_ACORDAMENTO);
        
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                        //PRODUTOR
        ArrayList escolhasProdutor = new ArrayList<Choice>();
        Choice escolhaProsseguir = new BlankChoice("Continuar procurando.", eventoProdutor2);
       //Choice escolhaDesiste = new BlankChoice("Desistir da competição.", eventoFinal);
        escolhasProdutor.add(escolhaProsseguir);
        escolhasProdutor.add(escolhaDesiste);
        
        Event eventoProdutor = new BlankEvent("O produtor da competição disse que seus amigos afinaram os instrumentos"
                + "e não foram mais vistos, mas Paul está nos bastidores. Ele sugeriu você desistir, pois sua apresentção"
                + " irá acontecer em breve, mas Paul deve saber onde todos estão.",
                escolhasProdutor, TipoFase.NOTHING);
        
        
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //PLATEIA
        ArrayList escolhasPlateia = new ArrayList<Choice>();
//       Choice escolhaBatera = new BlankChoice("Procurar o baterista", batalhaEmos);
        Choice escolhaPerguntar = new BlankChoice("Perguntar ao produtor.", eventoProdutor);
        escolhasPlateia.add(escolhaBatera);
        escolhasPlateia.add(escolhaPerguntar);
        
        Event eventoPlateia = new BlankEvent("Na plateia você encontrou seus pais. Eles disseram que só viram Paul "
                + "indo aos bastidores. Sua mãe lhe deu um saco de balas de eucalipto. +2pts de HP. A hora do show se aproxima , você deve achar seus amigos", 
                escolhasPlateia, TipoFase.NOTHING);
        
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //PALCO
        ArrayList escolhasPalco = new ArrayList<Choice>();
//        Choice escolhaBatera = new BlankChoice("Procurar o baterista", batalhaEmos);
        Choice escolhaPlateia = new BlankChoice("Procurar na plateia", eventoPlateia);
        Choice escolhaPerguntar1 = new BlankChoice("Perguntar ao produtor.", eventoFinal);
        escolhasPalco.add(escolhaBatera);
        escolhasPalco.add(escolhaPlateia);  
        escolhasPalco.add(escolhaPerguntar);
 
        Event eventoPalco = new BlankEvent("Você já deixou tudo no esquema, todos os instrumentos estão prontos."
                + " Mas os seu amigos deram um chá de sumiço. A final já está perto de começar. Você tem que achá-los, senão sua banda será "
                + "eliminada por ausência.", 
                escolhasPalco, TipoFase.NOTHING);
        
   
        
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //SOM
        ArrayList escolhasSom = new ArrayList<Choice>();
       // Choice escolhaBatera = new BlankChoice("Procurar o baterista e ver como está a batera.", batalhaEmos);
        Choice escolhaPalco = new BlankChoice("Subir ao palco , afinar a guitarra e montar o setup.",eventoPalco);
        escolhasSom.add(escolhaBatera);
        escolhasSom.add(escolhaPalco);
        
        Event eventoSom = new BlankEvent("O som está pronto. HEY! Você encontrou um saco de biscoitos do Rock! + 2pts de HP.", 
                escolhasSom, TipoFase.HEAL);
        
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //CAMPING
        ArrayList escolhasCamping = new ArrayList<Choice>();
        Choice escolhaSom = new BlankChoice("Verificar se o som para o show está pronto.", eventoSom);
        escolhasCamping.add(escolhaBatera);
        escolhasCamping.add(escolhaPalco);
        escolhasCamping.add(escolhaSom);
 
        Event eventoCamping = new BlankEvent("Agora você finalmente chegou no local do concerto. O baterista subiu ao palco"
                + " para a montagem da sua batera e o resto da banda se adiantou, indo afinar seus instrumentos. "
                + "Seus pais e antigos amigos vieram te desejar boa sorte, e essa conversa durou um certo tempo. "
                + "Pra onde ir agora?", 
                escolhasCamping, TipoFase.NOTHING);
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //VITÓRIA NO PAGODEIRO
      
       ArrayList escolhaVitoriaPagode = new ArrayList<Choice>();
        Choice escolhaAvancar2 = new BlankChoice("AVANÇAR", eventoCamping);
        escolhaVitoriaPagode.add(escolhaAvancar2);
        
        Event eventoVitoriaPagode = new BlankEvent("Você deu uma surra nele! O pagodeiro foi chorando pra casa e deixou cair."
                + "um kit de palhetas metalizadas, que ele provavelmente iria usar par tocar um cavaquinho ferrado"
                + ". + 3pts de ATk. ... Seus amigos chegaram. O carro foi consertado. ", escolhaVitoriaPagode,
                TipoFase.GANHA_PALHETA);
                                    
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //BATALHA COM O PAGORDEIRO
        ArrayList escolhasBatalhaPagodeiro = new ArrayList<Choice>();
        escolhasBatalhaPagodeiro.add(escolhaGuitarrada);
        escolhasBatalhaPagodeiro.add(escolhaPalhetada);
        
         Event batalhaPagodeiro = new BattleEvent("Você estava seguindo pela rua quando do nada você foi acertado por "
                 + "uma pedra. Um pagodeiro fã da banda OS CACHAÇA, eliminada pela sua nas semi-finais"
                 + ", disse que vai vingar sua banda nº 1 e acabar com você.", escolhasBatalhaPagodeiro, 
                 pagodeiro,eventoVitoriaPagode, 
                 TipoFase.NOTHING);
        
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //FUGI DO UBER
        ArrayList escolhasFugi = new ArrayList<Choice>();
        Choice escolhaLigar= new BlankChoice("Ligar para os amigos e pedir que eles te busquem.", batalhaPagodeiro);
        Choice escolhaCaminhar = new BlankChoice("Caminhar até o local do show", batalhaPagodeiro);
        escolhasFugi.add(escolhaLigar);
        escolhasFugi.add(escolhaCaminhar);
        
         Event eventoFugi = new BlankEvent("Ufa! Isso foi Hard Core! Bem, após sua fuga do motorista louco"
                 + ", você está numa rua meio deserta, mas felizmente se pode avistar de longe os estúdios"
                 + "da Music Show Time. O que vai fazer agora ?", escolhasFugi, TipoFase.NOTHING);  
         
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //PULEI DO UBER
        ArrayList escolhasPulei = new ArrayList<Choice>();
       // Choice escolhaLigar= new BlankChoice("Ligar para os amigos e pedir que eles te busquem.", batalhaPagodeiro);
        //Choice escolhaCaminhar = new BlankChoice("Caminhar até o local do show", batalhaPagodeiro);
        Choice escolhaPedirAjuda = new BlankChoice("Seguir pela rua e buscar algo para comer.", batalhaPagodeiro);
        escolhasPulei.add(escolhaLigar);
        escolhasPulei.add(escolhaCaminhar);
        escolhasPulei.add(escolhaPedirAjuda);
        
         Event eventoPulei = new BlankEvent("Você se feriu levemente ao pular do carro. Agora você está no"
                 + "meio de uma rua, não muito longe do local do show.", escolhasPulei, TipoFase.DAMAGE);
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //UBER  
        ArrayList escolhasUber = new ArrayList<Choice>();
        Choice escolhaPularCarro = new BlankChoice("Pular do carro em movimento", eventoPulei);
        Choice escolhaTomarVolante = new BlankChoice("Tentar tomar o volante do motorista", eventoMorreuCarro);
        Choice escolhaDistraiMotorista = new BlankChoice("Distrair o motorista enquanto sai pelo teto solar.", eventoFugi);
        escolhasUber.add(escolhaPularCarro);
        escolhasUber.add(escolhaTomarVolante);
        escolhasUber.add(escolhaDistraiMotorista);
        
        Event eventoUber = new BlankEvent("A viagem corria muito bem, o motorista parecia um cara legal. Mas de repente "
                + "começa a tocar uma música da banda OS CALOTES, eliminada pela Rock Blader nas quartas de finais. O "
                + "motorista mal intencionado se assumiu como um grande fã desta banda e disse que se vingará por você ter"
                + "eliminado sua banda número 1."
                + "Ele está indo por um trajeto totalmente diferente da Music Show Time. O que fazer agora?", escolhasUber, TipoFase.NOTHING);
        
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //VITORIA NO FUNKEIRO
        ArrayList escolhaVitoria = new ArrayList<Choice>();
        Choice escolhaAvancar = new BlankChoice("AVANÇAR", eventoCamping);
        escolhaVitoria.add(escolhaAvancar);
        
        Event eventoVitoria = new BlankEvent("Você derrotou o inimigo e ganhou + 3 pts de attack."
                + "O funkeirozinho voltou chorando pro baile funk.", escolhaVitoria, TipoFase.BATTLE);
      
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                  //FLORESTA
        ArrayList escolhasFloresta = new ArrayList<Choice>();
        escolhasFloresta.add(escolhaGuitarrada);
        escolhasFloresta.add(escolhaPalhetada);
 
        Event lutaFloresta = new BattleEvent("Você optou por seguir por um caminho na floresta, mas no meio do trajeto você encontrou um funkeiro.Ele está disposto a acabar "
                + "com você. Hora de lutar.", escolhasFloresta, funkeiro, eventoVitoria, TipoFase.NOTHING);
         

       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                  //POSTO
        ArrayList escolhasPosto = new ArrayList<Choice>();
        Choice escolhaConsertar = new BlankChoice("Tentar consertar o carro sozinho.", eventoMorreuExplodiu);
        Choice escolhaIrFloresta = new BlankChoice("Seguir andando por um atalho na floresta", lutaFloresta);
        Choice escolhaComprar = new BlankChoice("Aproveitar e comprar umas palhetas e cordas novas.", batalhaPagodeiro);
        escolhasPosto.add(escolhaConsertar);
        escolhasPosto.add(escolhaIrFloresta);
        escolhasPosto.add(escolhaComprar);
        
        
        Event eventoPosto= new BlankEvent("Os seus amigos chegaram. A viagem estava tranquila e todos conversavam "
                + "sobre o quanto estavam anciosos pela apresentação. Mas de repente o carro teve um problema"
                + "e enguiçou próximo a um posto de gasolina. O que você vai fazer?", escolhasPosto, TipoFase.NOTHING);
        
        
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //RUA
        ArrayList escolhasRua = new ArrayList<Choice>();
        Choice escolhaFloresta = new BlankChoice("Seguir de bike por um atalho na floresta", lutaFloresta);
        Choice escolhaUber = new BlankChoice("Usa UBER", eventoUber);
        Choice escolhaCarroBanda = new BlankChoice("Esperar e ir de carro com os membros da banda", eventoPosto);
        escolhasRua.add(escolhaFloresta);
        escolhasRua.add(escolhaUber);
        escolhasRua.add(escolhaCarroBanda);
        
        
        Event eventoRua= new BlankEvent("Você está na rua e precisa chegar ao local do show o mais rápido possível"
                + ". Escolha seu trajeto.", escolhasRua, TipoFase.NOTHING);
        
        
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //CASA
        Collection escolhasCasa = new ArrayList<Choice>();
        Choice escolhaDorme = new BlankChoice("Dormir mais", eventoFinalDormiu);
        Choice escolhaRua = new BlankChoice("Ir logo para o local do show", eventoRua);
        //Choice escolhaCarro = new BlankChoice("Ficar em casa e praticar mais.", eventoFinal);
        escolhasCasa.add(escolhaDorme);
        escolhasCasa.add(escolhaRua);
        //escolhasCasa.add(escolhaCarro);
        
        Event eventoCasa = new BlankEvent("Você dormiu por uma hora. Ainda restam duas horas para a grande final "
                + "começar. O que vai fazer?", escolhasCasa, TipoFase.NOTHING);
        
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                    //ESCOLHAS INICIAIS
        
//        ArrayList escolhasSecundarias = new ArrayList<Choice>();
//        Choice escolhaInicinalSairCasa = new BlankChoice("Sair de casa e ir para o local do concerto", eventoRua);
//        Choice escolhaInicialFicarCasa = new BlankChoice("Ficar em casa e descansar um pouco.", eventoCasa);
//        escolhasSecundarias.add(escolhaInicinalSairCasa);
//        escolhasSecundarias.add(escolhaInicialFicarCasa);
//            
//        Event eventoSecundario = new BlankEvent("Hoje é o grande dia. Você está em casa. O show começará daqui a algumas horas."
//                , escolhasSecundarias, TipoFase.NOTHING);
        
        
        ArrayList escolhasIniciais = new ArrayList<Choice>();
        Choice musicaPurple = new MusicChoice("Sair de casa e ir para o local do concerto", eventoRua, "jimi2.wav");
        Choice musicaEverlong = new MusicChoice("Ficar em casa e descansar um pouco", eventoCasa, "everlong.wav");
        Choice musicaEnter = new MusicChoice("Virar funkeiro", eventoFinalFunk, "byTheWay2.wav");
        escolhasIniciais.add(musicaPurple);
        escolhasIniciais.add(musicaEverlong);
        escolhasIniciais.add(musicaEnter);
            
        Event eventoInitial = new BlankEvent("Hoje é o grande dia. Você está em casa. O show começará daqui a algumas horas"
                , escolhasIniciais, TipoFase.MUSIC);
        
        
        ArrayList escolhasComeco = new ArrayList<Choice>();
        Choice escolhaComeco = new BlankChoice("Purple Haze - Jimmy Hendrix", eventoInitial);
        Choice escolhaComeco1 = new BlankChoice("Everlong - Foo Fighters", eventoInitial);
        Choice escolhaComeco2 = new BlankChoice("By the Way - Red Hot Chili Peppers", eventoInitial);
        escolhasComeco.add(escolhaComeco);
        escolhasComeco.add(escolhaComeco1);
        escolhasComeco.add(escolhaComeco2);
            
        Event eventoComeco = new BlankEvent("Você está num ensaio da Rock Blader, a final do show será amanhã."
                + " Vocês tem que decidir qual será a música que vocês tocarão na grande final. Qual música é a "
                + "melhor opção?."
                , escolhasComeco, TipoFase.NOTHING);
        
        
        Book livro = new Book("Rock Blade", eventoComeco, player);

        return livro;
    }
}
