package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {

    @DisplayName("전진 조건은 input이 4이상이면 전진가능상태, 4미만이면 정지상태를 반환한다.")
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    @ParameterizedTest
    void isMove(int input, boolean expected) {
        // given
        MoveStrategy moveStrategy = new MoveStrategy();

        // when
        boolean isMove = moveStrategy.isMove(() -> input);

        // then
        assertThat(isMove).isEqualTo(expected);
    }
}
