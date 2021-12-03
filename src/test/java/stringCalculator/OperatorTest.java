package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("더하기 테스트")
    @Test
    void add() {
        // given
        int number1 = 1;
        int number2 = 2;

        // when
        Operator operator = Operator.ADDITION;
        Integer actualValue = operator.calculate(number1, number2);

        int expected = 3;

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("빼기 테스트")
    @Test
    void subtract() {
        // given
        int number1 = 1;
        int number2 = 2;

        // when
        Operator operator = Operator.SUBTRACTION;
        Integer actualValue = operator.calculate(number1, number2);

        int expected = -1;

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("곱하기 테스트")
    @Test
    void multiply() {
        // given
        int number1 = 1;
        int number2 = 2;

        // when
        Operator operator = Operator.MULTIPLE;
        Integer actualValue = operator.calculate(number1, number2);

        int expected = 2;

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("나누기 테스트")
    @Test
    void divide() {
        // given
        int number1 = 10;
        int number2 = 2;

        // when
        Operator operator = Operator.DIVISION;
        Integer actualValue = operator.calculate(number1, number2);

        int expected = 5;

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("0으로 나눌 경우 ArithmeticException")
    @Test
    void divideByZero() {
        // given
        int number1 = 10;
        int number2 = 0;
        Operator operator = Operator.DIVISION;

        // when
        assertThatThrownBy(() -> operator.calculate(number1, number2))
                // then
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @DisplayName("사칙연산 기호 이외 문자일 경우 예외")
    @Test
    void validateInvalidOperators() {
        // given
        String operator = "@";
        int number1 = 1;
        int number2 = 2;

        // when
        assertThatThrownBy(() -> {
            Operator[] values = Operator.values();
            for (Operator value : values) {
                value.getOperator(operator).calculate(number1, number2);
            }
        })
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 연산자가 포함되었습니다. 사칙연산 기호(+, -, *, /)를 입력 해주세요");
    }
}
