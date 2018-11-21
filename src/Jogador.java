public class Jogador {

    // Variáveis de instância
    private String nome;
    private int casa, inicio;
    private double contaCorrente;
    private boolean direcao, pTurno;
    private byte paradaObrigatoria;

    // Métodos de instância
    /**
     * Método Construtor.
     *
     * @param nome Nome do Jogador.
     * @param inicio Posição de início para o jogo (ordenação do maior para o menor).
     */
    public Jogador(String nome, int inicio) {
        if (!nome.equals("")) this.nome = nome;
        else this.nome = "Jogador" + inicio;
        casa = 0;
        contaCorrente = 0;
        direcao = true;
        if (inicio > 0 && inicio < 7) this.inicio = inicio;
    }

    /**
     * Consulta do nome do Jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Consulta da casa atual do Jogador.
     */
    public int getCasa() {
        return casa;
    }

    /**
     * Consulta do valor de início do Jogador
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * Consulta do valor disponível na conta corrente do Jogador.
     */
    public double getContaCorrente() {
        return contaCorrente;
    }

    /**
     * Consulta do valor atual da variável 'direcao'.
     */
    public boolean getDirecao() {
        return direcao;
    }
    
    /**
     * Consulta do valor atual da variável 'pTurno'
     */
    public boolean getPTurno() {
        return pTurno;
    }
    
    /**
     * Consulta do valor de paradaObrigatoria
     */
    public byte getParadaObrigatoria() {
        return paradaObrigatoria;
    }

    /**
     * Modificação do nome do Jogador
     * 
     * @param novoNome Novo nome do Jogador
     */
    public void setNome(String novoNome) {
        if (nome != "") nome = novoNome;
    }
    
    /**
     * Modificação da casa do Jogador.
     *
     * @param novaCasa indica a nova casa do Jogador.
     */
    public void setCasa(int novaCasa) {
        casa = novaCasa;
    }

    /**
     * Modificação do valor atual de início
     *
     * @param novoInicio Nova posição
     */
    public void setInicio(int novoInicio) {
        inicio = novoInicio;
    }

    /**
     * Modificação do valor disponível na conta corrente do Jogador.
     *
     * @param valorDeEntrada Indica o novo valor que entrará na conta corrente do Jogador.
     */
    public void setContaCorrente(double valorDeEntrada) {
        if (valorDeEntrada > 0) contaCorrente += valorDeEntrada;
    }
    
    /**
     * Modificação do valor da variável 'direcao'
     * 
     * @param novaDirecao Nova direção
     */
    public void setDirecao(boolean novaDirecao) {
        direcao = novaDirecao;
    }

    /**
     * Modificação do valor atual da variável 'pTurno'
     * 
     * @param novoPTurno Novo valor booleano
     */
    public void setPTurno(boolean novoPTurno) {
        pTurno = novoPTurno;
    }
    
    /**
     * Modificação do valor de paradaObrigatoria
     *
     * @param novoValor Atualiza o valor para o jogador não ficar preso na parada obrigatória
     */
    public void setParadaObrigatoria(byte novoValor) {
        paradaObrigatoria = novoValor;
    }

    /**
     * Consulta da situação atual do Jogador.
     */
    public String toString() {
        return "Nome: " + nome + "\nCasa atual: " + casa + "\nValor atual da conta corrente: " + contaCorrente;
    }
}