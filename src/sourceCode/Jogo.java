package sourceCode;

import java.util.Scanner;
public class Jogo {

    // Variáveis de instância
    private Jogador [] lista;
    private int posicao;
    private boolean vencedor; // Talvez colocar a variável na classe Jogador.

    // Métodos de instância

    /**
     * Método Construtor.
     *
     * @param jogadores Indica quantos jogadores se cadastraram.
     */
    public Jogo(int jogadores) {
        if (jogadores > 1 && jogadores < 7) lista = new Jogador[jogadores];
        posicao = 0; // Serve de limite para os laços quando percorrerem o vetor de Jogadores.
        vencedor = false;
    }

    /**
     * Método Cadastro.
     *
     * @param nome Nome do Jogador
     */
    public boolean cadastrar(String nome, int inicio) {
        if (posicao == lista.length) return false; // Jogo cheio
        Jogador inicializador = new Jogador(nome, inicio);
        lista[posicao] = inicializador;
        posicao++;
        System.out.println("Ainda restam " + (6 - posicao) + " vagas.");
        return true;
    }

    /**
     * Consulta do valor atual da variável 'posicao'
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * Consulta do vetor com os jogadores cadastrados
     */
    public Jogador [] getJogador() {
        return lista;
    }

    /**
     * Modificação do vetor lista
     *
     * @param vetor Vetor contendo os objetos Jogadores
     */
    public void setLista(Jogador [] vetor) {
        lista = vetor;
    }

    /**
     * Modificação do valor atual da variável 'posicao'
     *
     * @param novaPosicao Novo valor da variável
     */
    public void setPosicao(int novaPosicao) {
        if (novaPosicao > 0 && novaPosicao < 7) posicao = novaPosicao;
    }

    /**
     * Método para ordenar os jogadores de acordo com os valores do dado de início, em ordem decrescente.
     */
    public void ordena() {
        Jogador aux;
        int quant = posicao - 1;
        for (int i = 0; i < quant; i++) {
            for (int j = 0; j < quant - 1; j++) {
                if (lista[j].getInicio() < lista[j + 1].getInicio()) {
                    aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
        ordenaEmOrdemCrescente();
    }

    /**
     * Método que coloca o primeiro colocado como 1, até o último como 6, se houver.
     */
    private void ordenaEmOrdemCrescente() {
        for (int i = 0; i < posicao; i++) {
            lista[i].setInicio(i + 1); // Coloca o primeiro colocado como 1, até o último como 6, se houver.
        }
    }

    /**
     * Método que busca o valor da variável 'posicao' onde o Jogador que teve seu dinheiro reduzido a menos de zero está.
     */
    public int buscarPosicao(String nome){
        for(int i = 0; i < posicao; i++){
            if(nome.equals(lista[i].getNome())) return i;
        }
        return -1;
    }
    
    /**
     * Método que exclui o Jogador que teve seu dinheiro reduzido a menos de zero.
     * 
     * @param jogador Jogador que deve ser excluído
     */
    public boolean excluir(Jogador jogador){
        int indice = buscarPosicao(jogador.getNome());
        if(indice < 0) return false;
        for(int i = indice; i < posicao - 1 ; i++){
            lista[i] = lista[i+1];
        }
        posicao--;
        lista[posicao]=null;
        return true;
    }
    
    /**
     * Método Perdeu Tudo
     * 
     * @param jogador Jogador que deve ser excluído
     */
    public void perdeuTudo(Jogador jogador) {
        boolean perdeu = excluir(jogador);
        if (perdeu) System.out.println("Você perdeu todo o seu dinheiro e foi excluído do jogo.");
        jogada(); // Chamada para voltar ao jogo
    }
    
    /**
     * Método fim
     */
    public void fim() {
        System.out.println("Todos jogadores foram excluídos. Reinicie o jogo.");
        System.exit(0);
    }
    
    /**
     * Método Vencedor
     */
    public static void vencedor(Jogador jogador) {
        System.out.println("Parabéns, " + jogador.getNome() + "! Você venceu o Jogo da Vida!");
        System.exit(0);
    }
    
    /**
     * Método para dizer de qual jogador é a vez.
     */
    public void jogada() {
        Scanner in = new Scanner(System.in);
        int opcao;
        if (posicao == 0) fim();
        for (int i = 0; i < posicao; ) { // i++ acontece diretamente dentro dos condicionais.
            if (lista[i].getInicio() == 1) {
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(lista[i].getCasa() + AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                else i++;
            } else if (lista[i].getInicio() == 2) {
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(lista[i].getCasa() + AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                else i++;
                if (posicao == 2) i = 0;
            } else if (lista[i].getInicio() == 3) {
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(lista[i].getCasa() + AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                else i++;
                if (posicao == 3) i = 0;
            } else if (lista[i].getInicio() == 4) {
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(lista[i].getCasa() + AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                else i++;
                if (posicao == 4) i = 0;
            } else if (lista[i].getInicio() == 5) {
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                else i++;
                if (posicao == 4) i = 0;
            } else { // lista[i].getInicio() == 6
                do {
                    System.out.println(lista[i].getNome());
                    System.out.println("1 - para rolar o dado!");                   
                    opcao = in.nextInt();
                } while (opcao != 1);
                lista[i].setCasa(lista[i].getCasa() + AppJogoDaVida.dado());
                System.out.print(lista[i].getNome() + " ");
                Tabuleiro.tabuleiro(lista[i]);
                System.out.println(lista[i].getCasa());
                if (lista[i].getContaCorrente() < 0) perdeuTudo(lista[i]);
                i = 0;
            }
        }
    }
}