package stringCalculator;

public class StringCalculator {

    private static final int FIRST_OPERAND_INDEX = 0;
    private static final int FIRST_OPERATOR_INDEX = 1;
    private static final int NEXT_OPERATOR_COUNT = 2;

    public int calculateString(String operandAndOperator) {
        validateBlank(operandAndOperator);

        return calculate(operandAndOperator);
    }

    private int calculate(String operandAndOperator) {
        String[] arrOperandOrOperator  = operandAndOperator.split(" ");
        int length = arrOperandOrOperator.length;

        int result = toInt(arrOperandOrOperator[FIRST_OPERAND_INDEX]);
        for (int i = FIRST_OPERATOR_INDEX; i < length; i += NEXT_OPERATOR_COUNT) {
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
