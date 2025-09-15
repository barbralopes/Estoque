package view;

import javax.swing.JOptionPane;

public class EstoqueView {

    public int exibirMenu() {
        String[] opcoes = {"Entrada", "Saída", "Transferência", "Consulta", "Finalizar"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "O que deseja fazer?",
                "Menu Estoque",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        return escolha + 1;
    }

    public int escolherEmpresa(String msg) {
        String[] empresas = {"Tijolos KS", "Tijolos Paraju"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                msg,
                "Escolha a empresa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                empresas,
                empresas[0]);
        return escolha + 1;
    }

    public int solicitarQuantidade(String msg) {
        String input = JOptionPane.showInputDialog(msg);
        if (input == null) return 0;
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida!");
            return 0;
        }
    }

    public void mostrarMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
