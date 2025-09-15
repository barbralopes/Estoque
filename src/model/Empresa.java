package model;

public class Empresa {
    private String nome;
    private int quantidade;

    public Empresa(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidade = quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionar(int qtd) {
        quantidade += qtd;
    }

    public boolean remover(int qtd) {
        if (qtd > 0 && quantidade >= qtd) {
            quantidade -= qtd;
            return true;
        }
        return false;
    }
}
