package stringCalculator;

import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    MULTIPLE("*", (number1, number2) -> number1 * number2),
    DIVISION("/", (number1, number2) -> {
        if (number2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return number1 / number2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public Integer calculate(int number1, int number2) {
        return this.biFunction.apply(number1, number2);
    }

    public Operator getOperator(String operator) {
        Operator[] values = values();
        for (Operator value : values) {
            if (value.operator.equals(operator)) {
                return value;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 연산자가 포함되었습니다. 사칙연산 기호(+, -, *, /)를 입력 해주세요");
    }
}
