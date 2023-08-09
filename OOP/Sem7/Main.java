package GeekBrains.OOP.Sem7;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController();

        ComplexNumber a = view.readComplexNumber();
        ComplexNumber b = view.readComplexNumber();
        char operator = view.readOperator();
        ComplexNumber result = controller.performOperation(a, b, operator);
        view.displayResult(result);
    }
}
