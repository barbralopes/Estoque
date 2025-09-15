package model;

public class Estoque {
    private Empresa ks;
    private Empresa paraju;

    public Estoque() {
        ks = new Empresa("Tijolos KS", 100);
        paraju = new Empresa("Tijolos Paraju", 50);
    }

    public Empresa getKS() {
        return ks;
    }

    public Empresa getParaju() {
        return paraju;
    }

    public void entrada(Empresa empresa, int qtd) {
        empresa.adicionar(qtd);
    }

    public boolean saida(Empresa empresa, int qtd) {
        return empresa.remover(qtd);
    }

    public boolean transferencia(Empresa origem, Empresa destino, int qtd) {
        if (origem == destino) return false;
        if (origem.remover(qtd)) {
            destino.adicionar(qtd);
            return true;
        }
        return false;
    }

    public String consultar() {
        return "Estoque atual:\n" +
                ks.getNome() + " -> " + ks.getQuantidade() + " unidades\n" +
                paraju.getNome() + " -> " + paraju.getQuantidade() + " unidades";
    }
}
