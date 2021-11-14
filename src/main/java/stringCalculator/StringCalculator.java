package stringCalculator;

public class StringCalculator {


    public int calculateString(String operandAndOperator) {
        validateBlank(operandAndOperator);

        return calculate(operandAndOperator);
    }

    private int calculate(String operandAndOperator) {
        String[] arrOperandOrOperator  = operandAndOperator.split(" ");
        int length = arrOperandOrOperator.length;

        int result = toInt(arrOperandOrOperator[0]);
        for (int i = 1; i < length; i += 2) {
            String operator = arrOperandOrOperator[i];
            int operand = toInt(arrOperandOrOperator[i + 1]);

            result = operate(operator, result, operand);
        }

        return result;
    }

    private void validateBlank(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자는 입력할 수 없습니다.");
        }
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }

    private int operate(String operator, int number1, int number2) {
        int result = 0;

        Operator[] values = Operator.values();
        for (Operator value : values) {
            result = value.getOperator(operator)
                          .calculate(number1, number2);
        }

        return result;
    }
}
