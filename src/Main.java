import controller.EstoqueController;
import model.Estoque;
import view.EstoqueView;

public class Main {
    public static void main(String[] args) {
        Estoque model = new Estoque();
        EstoqueView view = new EstoqueView();
        EstoqueController controller = new EstoqueController(model, view);
        controller.iniciar();
    }
}
