package GeekBrains.OOP.Sem7;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.getReal(), imaginary + other.getImaginary());
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = real * other.getReal() - imaginary * other.getImaginary();
        double imaginaryPart = real * other.getImaginary() + imaginary * other.getReal();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber div(ComplexNumber other) {
        if (other.getReal() == 0 && other.getImaginary() == 0) {
            throw new ArithmeticException("Divide by 0 error");
        }
        double realPart = (real * other.getReal() + imaginary * other.getImaginary())
                / (Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2));
        double imaginaryPart = (imaginary * other.getReal() - real * other.getImaginary())
                / (Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2));
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
