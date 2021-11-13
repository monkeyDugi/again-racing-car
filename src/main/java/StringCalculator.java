public class StringCalculator {


    public int calculateString(String operandAndOperator) {
        if (operandAndOperator == null || operandAndOperator.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자는 입력할 수 없습니다.");
        }

        String[] arrOperandOrOperator  = operandAndOperator.split(" ");
        int length = arrOperandOrOperator.length;

        int result = Integer.parseInt(arrOperandOrOperator[0]);
        for (int i = 1; i < length; i++) {
            if (i % 2 == 1) {
                if ("+".equals(arrOperandOrOperator[i])) {
                    result += Integer.parseInt(arrOperandOrOperator[i + 1]);
                } else if ("-".equals(arrOperandOrOperator[i])) {
                    result -= Integer.parseInt(arrOperandOrOperator[i + 1]);
                } else if ("*".equals(arrOperandOrOperator[i])) {
                    result *= Integer.parseInt(arrOperandOrOperator[i + 1]);
                } else if ("/".equals(arrOperandOrOperator[i])) {
                    try {
                        result /= Integer.parseInt(arrOperandOrOperator[i + 1]);
                    } catch (ArithmeticException e) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                } else {
                    throw new IllegalArgumentException("올바르지 않은 연산자가 포함되었습니다. 사칙연산 기호(+, -, *, /)를 입력 해주세요");
                }
            }
        }

        return result;
    }
}
