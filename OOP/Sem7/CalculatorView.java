package GeekBrains.OOP.Sem7;

import java.util.Scanner;

public class CalculatorView {
    private static Scanner scanner = new Scanner(System.in);

    public ComplexNumber readComplexNumber() {
        System.out.print("Enter the real part -> ");
        double real = scanner.nextDouble();
        System.out.print("Enter the imaginary part -> ");
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
    }

    public char readOperator() {
        System.out.print("Enter the operator (+,*,/): -> ");
        return scanner.next().charAt(0);
    }

    public void displayResult(ComplexNumber result) {
        System.out.println("The result is: " + result.getReal() + " + i" + result.getImaginary());
    }
}
