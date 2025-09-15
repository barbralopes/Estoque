package controller;

import model.Estoque;
import model.Empresa;
import view.EstoqueView;

public class EstoqueController {

    private Estoque model;
    private EstoqueView view;

    public EstoqueController(Estoque model, EstoqueView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.exibirMenu();

            switch (opcao) {
                case 1: // Entrada
                    Empresa eEntrada = escolherEmpresa();
                    int qtdEntrada = view.solicitarQuantidade("Quantidade para entrada:");
                    if (qtdEntrada > 0) {
                        model.entrada(eEntrada, qtdEntrada);
                        view.mostrarMensagem("Entrada realizada!\n\n" + model.consultar());
                    }
                    break;
                case 2: // Saída
                    Empresa eSaida = escolherEmpresa();
                    int qtdSaida = view.solicitarQuantidade("Quantidade para saída:");
                    if (qtdSaida > 0) {
                        if (model.saida(eSaida, qtdSaida)) {
                            view.mostrarMensagem("Saída realizada!\n\n" + model.consultar());
                        } else {
                            view.mostrarMensagem("Estoque insuficiente!");
                        }
                    }
                    break;
                case 3: // Transferência
                    Empresa origem = escolherEmpresa();
                    Empresa destino = escolherEmpresa();
                    int qtdTransf = view.solicitarQuantidade("Quantidade para transferência:");
                    if (qtdTransf > 0) {
                        if (model.transferencia(origem, destino, qtdTransf)) {
                            view.mostrarMensagem("Transferência realizada!\n\n" + model.consultar());
                        } else {
                            view.mostrarMensagem("Transferência inválida ou estoque insuficiente!");
                        }
                    }
                    break;
                case 4: // Consulta
                    view.mostrarMensagem(model.consultar());
                    break;
                case 5: // Finalizar
                    view.mostrarMensagem("Programa finalizado!");
                    rodando = false;
                    break;
                default:
                    view.mostrarMensagem("Opção inválida!");
            }
        }
    }

    private Empresa escolherEmpresa() {
        int escolha = view.escolherEmpresa("Escolha a empresa:");
        if (escolha == 1) return model.getKS();
        else return model.getParaju();
    }
}
