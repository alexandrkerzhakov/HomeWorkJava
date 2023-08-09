package GeekBrains.OOP.Sem7;

import java.util.logging.Logger;

public class CalculatorController {
    private static final Logger logger = Logger.getLogger(CalculatorController.class.getName());

    public ComplexNumber performOperation(ComplexNumber a, ComplexNumber b, char operator) {
        logger.info("Performing operation: " + a.getReal() + " i" + a.getImaginary() + " " + operator + " " + b.getReal() + " i" + b.getImaginary());
        switch (operator) {
            case '+':
                return a.add(b);
            case '*':
                return a.multiply(b);
            case '/':
                return a.div(b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
