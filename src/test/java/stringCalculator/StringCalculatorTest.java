package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("연산자와 피연산자의 문자열을 덧셈한다.")
    @CsvSource(value = {"1 + 1:2", "1 + 2:3", "0 + 2:2"}, delimiter = ':')
    @ParameterizedTest
    void add(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actualValue = stringCalculator.calculateString(input);

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("연산자와 피연산자의 문자열을 뺄셈한다.")
    @CsvSource(value = {"1 - 1:0", "1 - 2:-1", "0 - 2:-2", "10 - 2:8"}, delimiter = ':')
    @ParameterizedTest
    void subtract(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actualValue = stringCalculator.calculateString(input);

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("연산자와 피연산자의 문자열을 곱셈한다.")
    @CsvSource(value = {"1 * 1:1", "1 * 2:2", "0 * 2:0"}, delimiter = ':')
    @ParameterizedTest
    void multiply(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actualValue = stringCalculator.calculateString(input);

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("연산자와 피연산자의 문자열을 나눗셈한다.")
    @CsvSource(value = {"1 / 1:1", "1 / 2:0", "0 / 2:0"}, delimiter = ':')
    @ParameterizedTest
    void divide(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actualValue = stringCalculator.calculateString(input);

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("모든 연산자가 들어간 문자열을 계산 한다.")
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    @ParameterizedTest
    void calculateAllOperator(String input, int expected) {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        // when
        int actualValue = stringCalculator.calculateString(input);

        // then
        assertThat(actualValue).isEqualTo(expected);
    }

    @DisplayName("입력 값이 공백 문자열, 빈 문자열이면 IllegalArgumentException")
    @Test
    void isBlankEmpty() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String input = "";

        // when
        assertThatThrownBy(() -> stringCalculator.calculateString(input))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자는 입력할 수 없습니다.");
    }

    @DisplayName("입력 null이면 IllegalArgumentException")
    @Test
    void isBlankNull() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String input = null;

        // when, then
        assertThatThrownBy(() -> stringCalculator.calculateString(input))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자는 입력할 수 없습니다.");
    }
}
