package ch.ederlukas.lambdas;

public class Calculation<T extends Number> {
    public T calcSquare(CalculationLambda<T> square, T number) {
        return square.calc(number);
    }
}
