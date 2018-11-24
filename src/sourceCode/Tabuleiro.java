package sourceCode;

public class Tabuleiro
{ 
   public static void tabuleiro(Jogador jogador)
   {  
      //Variaveis, informações do jogador
        byte  pObrigatoria = jogador.getParadaObrigatoria();
        int   casa = jogador.getCasa();
       double cCorrente = jogador.getContaCorrente();
      boolean direcao = jogador.getDirecao(), pTurno = jogador.getPTurno();
      
      System.out.println("\f");
       
      if(direcao && casa > 3 && casa < 8) casa = 8; // arrumando as casas pela direita 
       if(casa < 8) // direcao TRUE = direita. direcao FALSE = esquerda
       {   if(direcao && casa < 4)// caminho da Bluth Company
           {  switch(casa)
                 {   
                   case 1:
                      System.out.println("Caminho mais curto\nVocê começou sua vida profissional na Bluth Company, parabéns.");
                     break;
                   case 2:
                      System.out.println("Dia de pagamento,receba R$800.");
                      jogador.setContaCorrente(cCorrente + 800);
                     break;
                   case 3:
                      System.out.println("Você se machucou durante a viagem, foi descontado R$1.000.");
                      jogador.setContaCorrente(cCorrente - 1000);
                     break; 
                }
           }
           else
           {   if(!direcao && casa > 7 && pObrigatoria == 0) // parada obrigatória para o jogador
               {   casa = 7;
                   jogador.setParadaObrigatoria((byte)1);
               }
               if(!direcao && casa < 8) // caminho da Milford School
               {   switch(casa)
                   {
                     case 1:
                         System.out.println("Caminho mais longo\nVocê começou sua vida acadêmica na Milford School, parabéns.");                        
                       break;
                     case 2:
                        System.out.println("Em meio a sua vida acadêmica você se perde em seus estudos. Perca 1 turno."); 
                        jogador.setPTurno(false);
                       break;
                     case 3:
                        System.out.println("Você teve sucesso em sua vida acadêmica. Avance 3 casas.");
                        jogador.setCasa(3);
                        tabuleiro(jogador);
                       break;
                     case 4:
                        System.out.println("Você passou o verão trabalhando na estação Banana. Colete R$1.000.");
                        jogador.setContaCorrente(cCorrente + 1000);
                       break; 
                     case 5:
                        System.out.println("Você teve sucesso em sua vida acadêmica. Avance 3 casas.");
                        jogador.setCasa(3);
                        tabuleiro(jogador);
                       break; 
                     case 6:
                        System.out.println("Você teve um periodo letivo cansativo e precisa descançar. Perca 1 turno.");
                        jogador.setPTurno(false);
                      break; 
                     case 7:
                        System.out.println("PARADA OBRIGATÓRIA!\nVocê concluiu sua vida acadêmica, e adquiriu idependência financeira.");
                      break; 
                   }
               }
           }
       }
       
      else if(casa > 7 && casa < 26)
      {  if(casa > 13 && casa < 19 && pObrigatoria < 2) 
         {  casa = 13;//parada obrigatória:  parada para o casamento
            jogador.setParadaObrigatoria((byte)2); 
         }
         else if(casa > 19 && casa < 25 && pObrigatoria == 2) 
         {  casa = 19;//parada obrigatória:  compra da casa modelo Bluth
            jogador.setParadaObrigatoria((byte)3);
         }
         switch(casa)
         {
             case 8:
                System.out.println("Dia de pagamento,receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 9:
                System.out.println("Você aceitou um emprego em uma loja comercial, colete R$3.000 .");
                jogador.setContaCorrente(cCorrente + 3000);
               break;
             case 10:
                System.out.println("Você tirou um dia de folga e foi em um concerto musical da Joan Baez. Perca 1 turno.");
                jogador.setPTurno(false);
               break;
             case 11:
                System.out.println("Você ficou doente. Perca 1 turno.");
                jogador.setPTurno(false);
               break;
             case 12:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 13:
                System.out.println("PARADA OBRIGATÓRIA!\nPARABÉNS !!! Você casou com uma pessoa muito especial. Perca R$20.000.");
                jogador.setContaCorrente(cCorrente - 20000);
               break;
             case 14:
                System.out.println("Você construiu uma casa com Thomas Jane. Avance 3 casas.");
                jogador.setCasa(casa + 3);
                tabuleiro(jogador);
               break;
             case 15:
                System.out.println("Você trouxe seu filho(a) para conhecer seu trabalho. Perca 1 turno.");
                jogador.setPTurno(false);
               break;
             case 16:
                System.out.println("Você comprou um iate de luxo, \"The Seaward\". Perca R$40.000.");
                jogador.setContaCorrente(cCorrente - 40000);
               break;
             case 17:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 18:
                System.out.println("Você viajou para Inglaterra. Avançou 1 casa.");
                jogador.setCasa(casa + 1);
                tabuleiro(jogador);
               break;
             case 19:
                System.out.println("Parada Obrigatória\nVocê comprou uma casa modelo Bluth. Perca R$80.000.");
                jogador.setContaCorrente(cCorrente - 80000);
               break;
             case 20:
                System.out.println("Você se tornou membro do fan club de Harry Potter. Perca R$1.000.");
                jogador.setContaCorrente(cCorrente - 1000);
               break;
             case 21:
                System.out.println("Você teve uma mudança positiva em sua vida. Avançou 1 casa.");
                jogador.setCasa(casa + 1);
                tabuleiro(jogador);
               break;
             case 22:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 23:
                System.out.println("Você participou de um evento de pesca. Perca 1 turno.");
                jogador.setPTurno(false);
               break;
             case 24:
                System.out.println("Você adotou uma menina pequena para sua família.");
               break;
             case 25:
                System.out.println("Você adotou um menino pequeno para sua família.");
               break;
         }
      }
      else if(casa < 29 && !direcao)
      {  switch(casa)
         {
             case 26:
                System.out.println("Caminho mais curto\nVocê participou de um sucesso. Colete R$300.");
                jogador.setContaCorrente(cCorrente + 300);
               break;
             case 27:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 28:
                System.out.println("Você viaja pelo México. Avance 3 casas.");
                jogador.setCasa(casa + 3);
                tabuleiro(jogador);
               break;
         } 
      }
      else if(casa < 30 && direcao)
      {  switch(casa)
         {
             case 26:
                System.out.println("Caminho mais longo\nVocê parou para um lanche. Perca R$10.");
                jogador.setContaCorrente(cCorrente - 10);
               break;
             case 27:
                System.out.println("Dia de pagamento, receba R$800");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 28:
                System.out.println("Você escreveu um bestseller \"O Homem Dentro de Mim\".");
               break;
             case 29:
                System.out.println("Você sofreu acidente com um cachorro. Perca 1 turno.");
                jogador.setPTurno(false);
               break;
         }   
      }
      else if(casa < 43)
      {  switch(casa)
         {
             case 30:
                System.out.println("Caminho mais longo\nVocê parou para um lanche. Perca R$10.");
                jogador.setContaCorrente(cCorrente - 10);
               break;
             case 31:
                System.out.println("Você resolve salvar um pouco de dinheiro. Adicione R$1.000.");
                jogador.setContaCorrente(cCorrente + 1000);
               break;
             case 32:
                System.out.println("Você segurou os gastos no fim do mês. Adicione R$1.000.");
                jogador.setContaCorrente(cCorrente + 1000);
               break;
             case 33:
                System.out.println("Você comprou uma casa em Sudden Valley. Pague R$500.000");
                jogador.setContaCorrente(cCorrente + 500000);
               break;
             case 34:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 35:
                System.out.println("Você aprendeu uma nova lingua para uma viagem ao exterior. Avance 3 casas.");
                jogador.setCasa(casa + 3);
                tabuleiro(jogador);
               break;
             case 36:
                System.out.println("Você ganhou um tour por Portugal. Avance 1 casa.");
                jogador.setCasa(casa + 1);
                tabuleiro(jogador);
               break;
             case 37:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 38:
                System.out.println("Você vendeu parte das ações de uma companhia na qual era sócio. Colete R$2.000.000.");
                jogador.setContaCorrente(cCorrente + 2000000);
               break;
             case 39:
                System.out.println("Você precisa fazer uma viagem de negócios. Avance 1 casa.");
                jogador.setCasa(casa + 1);
                tabuleiro(jogador);
               break;
             case 40:
                System.out.println("Dia de pagamento, receba R$800.");
                jogador.setContaCorrente(cCorrente + 800);
               break;
             case 41:
                System.out.println("Você comprou um bar o \"Queen Mary\". Perca R$170.000");
                jogador.setContaCorrente(cCorrente + 170000);
               break;
             case 42:
                System.out.println("Você viajou para ver os parentes no interior. Avance 1 casa.");
                jogador.setCasa(casa + 1);
                tabuleiro(jogador);
               break;
         } 
      }
      else if(casa < 46)
      {
          if(!direcao)
             switch(casa)
             {
                case 43:
                     System.out.println("Dia de pagamento, receba R$800.");
                     jogador.setContaCorrente(cCorrente + 800);
                  break;
                case 44:
                     System.out.println("Você contratou uma babá inglesa para cuidar dos seus filhos. Isso não deu muito certo, perca R$1.000");
                     jogador.setContaCorrente(cCorrente - 1000);
                  break;
                case 45:
                     System.out.println("Você descobre que seu pai possui uma amante morando com ele. Perca 1 turno.");
                     jogador.setPTurno(false);
                  break;
             }
          else
             switch(casa)
             {
                case 43:
                     System.out.println("Dia de pagamento, receba R$800.");
                     jogador.setContaCorrente(cCorrente + 800);
                  break;
                case 44:
                     System.out.println("Você começou um negócio com uma Pet Shop. Perca 1 turno.");
                     jogador.setPTurno(false);
                  break;
                case 45:
                     System.out.println("Dia de pagamento, receba R$800.");
                     jogador.setContaCorrente(cCorrente + 800);
                  break;
             }
      }
      else if(casa <= 70)
      {  switch(casa)
         {
             case 46:
                  System.out.println("Você busca investimento para seu plano de negócios. Avance 1 casa.");
                  jogador.setCasa(casa + 1);
                  tabuleiro(jogador);
               break;
             case 47:
                  System.out.println("Sua busca não deu certo, lamento. Perca 1 turno.");
                  jogador.setPTurno(false);
               break;
             case 48:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 49:
                  System.out.println("Você precisou fazer uma reforma na sua residência, a janela denovo. Perca 1 turno.");
                  jogador.setPTurno(false);
               break;
             case 50:
                  System.out.println("Você fez uma viajem pela Escócia. Avance 3 casas.");
                  jogador.setCasa(casa + 3);
                  tabuleiro(jogador);
               break;
             case 51:
                  System.out.println("Você consegui ações de uma multinacional que renderam muito no futuro. Perca R$5.000.");
                  jogador.setContaCorrente(cCorrente - 5000);
               break;
             case 52:
                  System.out.println("Você é processado por uma empresa e perde o proceso. Perca R$20.000");
                  jogador.setContaCorrente(cCorrente - 20000);
               break;
             case 53:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 54:
                  System.out.println("Você ajuda a financiar um evento de moda multinacional e isso te rende dinheiro. Adicione R$30.000");
                  jogador.setContaCorrente(cCorrente + 30.000);
               break;
             case 55:
                  System.out.println("Você começou seu próprio negócio, isso resulta em um investimento do próprio bolso. Investimento R$15.000.");
                  jogador.setContaCorrente(cCorrente + 15000);
               break;
             case 56:
                  System.out.println("Você ajudou seu filho(a) a começar seu próprio negócio de biscoitos. Investimento R$750.");
                  jogador.setContaCorrente(cCorrente + 750);
               break;
             case 57:
                  System.out.println("Você tirou um dia de folga e foi em um concerto musical da Joan Baez. Perca 1 turno.");
                  jogador.setPTurno(false);
               break;
             case 58:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 59:
                  System.out.println("Você começou um negócio com uma Pet Shop. Perca 1 turno.");
                  jogador.setPTurno(false);
               break;
             case 60:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 61:
                  System.out.println("Você mudou de religão, uma nova etapa na sua vida. Economizou R$ 1.500 .");
                  jogador.setContaCorrente(cCorrente + 1500);
               break;
             case 62:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 63:
                  System.out.println("Você comprou uma banheira de diamante. Pagou R$ 50.000 .");
                  jogador.setContaCorrente(cCorrente - 50000);
               break;
             case 64:
                  System.out.println("Você comprou um carro novo e saiu com ele para um teste. Avance 3 casas.");
                  jogador.setCasa(casa + 3);
                  tabuleiro(jogador);
               break;
             case 65:
                  System.out.println("Você se alistou no exercito e infelizmente foi chamado. Perca 1 turno.");
                  jogador.setPTurno(false);
               break;
             case 66:
                  System.out.println("Você aceitou um emprego em uma empresa, colete R$1.000 .");
                  jogador.setContaCorrente(cCorrente + 1000);
               break;
             case 67:
                  System.out.println("Você aceitou um emprego em uma loja comercial, colete R$3.000 .");
                  jogador.setContaCorrente(cCorrente + 3000);
               break;
             case 68:
                  System.out.println("Dia de pagamento, receba R$800.");
                  jogador.setContaCorrente(cCorrente + 800);
               break;
             case 69:
                  System.out.println("Você se viciou em jogos de azar e acabou apostando todo o seu dinheiro, sinto muito.\nPERDEU TUDO!!!");
                  // Jogo.perdeuTudo(jogador);
               break;
             case 70:
                  System.out.println("PARABÉNS !!! " + jogador.getNome() + " VOCÊ VENCEU O JOGO DA VIDA");
                  Jogo.vencedor(jogador);
               break;
         }
      }
   }
}
