package sourceCode;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class AppJogoDaVida {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Jogo jogo = new Jogo(6);

        int opcao;
        do {
            System.out.println("---- M E N U ----");
            System.out.println("1 - Cadastrar um novo jogador");
            System.out.println("2 - Iniciar o jogo");
            System.out.println("3 - Salvar o jogo");
            System.out.println("4 - Pausar o jogo");
            System.out.println("5 - Carregar um jogo salvo");
            System.out.println("0 - Sair");
            opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Jogo encerrado sem ser salvo.");
                    break;
                case 1:
                    cadastrarJogador(jogo);
                    break;
                case 2:
                    comeco(jogo);
                    break;
                case 3:
                    salvarJogo(jogo);
                    break;
                case 4:
                    pausar(jogo);
                    break;
                case 5:
                    Jogador[] recebe = leitura();
                    int j = 0;
                    for (int i = 0; i < 6; i++) {
                        if (recebe[i] != null) j++;
                    }
                    jogo.setPosicao(j);
                    jogo.setLista(recebe);
                    recomeco(jogo);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    /**
     * Método Dado.
     *
     * @return int Um número de 1 a 6 aleatório, usado para definir quantas casas o jogador andará.
     */
    public static int dado() {
        Random dado = new Random();
        return dado.nextInt(6) + 1; // 6 é o limite do número aleatório (de 0 a 5), por isso + 1 (de 1 a 6).
    }

    /**
     * Método Ordem de início.
     *
     * @return int Um número de 1 a 6 aleatório, usado para definir a ordem dos Jogadores (ordenado do maior para o menor).
     */
    private static int ordemDeInicio() { // Usado apenas para fins de compreensão humana
        return dado();
    } // Utilizado para fins didáticos.

    /**
     * Método para cadastrar um novo jogador.
     *
     * @param jogo Vetor para armazenar os jogadores que forem cadastrados.
     */
    private static void cadastrarJogador(Jogo jogo) {
        Scanner in = new Scanner(System.in);

        System.out.println("---- Cadastrar um novo jogador ----\n");
        System.out.print("Informe o nome do jogador: ");
        String nome = in.nextLine();
        boolean resultado = jogo.cadastrar(nome, ordemDeInicio());
        if (resultado) System.out.println("Cadastro realizado!");
        else System.out.println("Cadastro não realizado. O jogo já está lotado.");
    }

    /**
     * Método Começo, que inicia o jogo.
     *
     * @param jogo Vetor que contém os jogadores cadastrados.
     */
    private static void comeco(Jogo jogo) {
        System.out.println("---- INÍCIO DO JOGO ----");
        jogo.ordena(); // Coloca o primeiro colocado como 1 e o último como 6, se houver.
        jogo.jogada();
    }

    /**
     * Método Recomeço, que inicia o jogo.
     *
     * @param jogo Vetor que contém os jogadores cadastrados.
     */
    private static void recomeco(Jogo jogo) {
        System.out.println("---- REINICIO DO JOGO ----");
        jogo.jogada();
    }

    /**
     * Método Pausar.
     *
     * @param jogo Vetor que contém os dados a serem salvos // Não sei se precisa salvar quando pausa.
     */
    private static void pausar(Jogo jogo) { // Não sei ainda o que siginifica pausar (no nosso caso).

    }
    
    private static void salvarJogo(Jogo jogo) throws FileNotFoundException {
        PrintWriter arquivo = new PrintWriter("JogoSalvo.txt");
        Jogador[] salvar;
        salvar = jogo.getJogador();
        int pos = jogo.getPosicao();
        for (int i = 0; i < pos; i++) {
            arquivo.println(salvar[i].getNome());
            arquivo.println(salvar[i].getInicio());
            arquivo.println(salvar[i].getCasa());
            arquivo.println(salvar[i].getContaCorrente());
            arquivo.println(salvar[i].getDirecao());
            arquivo.println(salvar[i].getPTurno());
            arquivo.println(salvar[i].getParadaObrigatoria());
        }
        arquivo.close();
    }
   
    private static Jogador[] leitura() throws FileNotFoundException { // Talvez não funcione
        File origem = new File("JogoSalvo.txt");
        Scanner arquivo = new Scanner(origem);
        Jogador[] receptor = new Jogador[6];
        int i = 0;
        while(arquivo.hasNextLine()){
            receptor[i].setNome(arquivo.nextLine()); 
            receptor[i].setInicio(Integer.valueOf(arquivo.nextLine()));
            receptor[i].setCasa(Integer.valueOf(arquivo.nextLine()));
            receptor[i].setContaCorrente(Double.valueOf(arquivo.nextLine()));
            receptor[i].setDirecao(Boolean.valueOf(arquivo.nextLine()));
            receptor[i].setPTurno(Boolean.valueOf(arquivo.nextLine()));
            receptor[i].setParadaObrigatoria(Byte.valueOf(arquivo.nextLine()));
            i++;
        }
        arquivo.close();
        return receptor;
    }
}