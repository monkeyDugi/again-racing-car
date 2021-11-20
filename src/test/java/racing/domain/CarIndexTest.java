package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarIndexTest {

    @DisplayName("이동을 시도하는 index의 현재 값을 모두 저장한다.")
    @Test
    void index_history_add() {
        // given
        CarIndex carIndex = new CarIndex();
        int increaseCount = 3;

        // when
        for (int i = 0; i < increaseCount; i++) {
            carIndex.moveForward();
        }

        carIndex.stop();

        // then
        assertThat(carIndex.getIndex(0)).isEqualTo(1);
        assertThat(carIndex.getIndex(1)).isEqualTo(2);
        assertThat(carIndex.getIndex(2)).isEqualTo(3);
        assertThat(carIndex.getIndex(3)).isEqualTo(4);
        assertThat(carIndex.getIndex(4)).isEqualTo(4);
    }

    @DisplayName("최소 시작 인덱스는 1미만이면 예외")
    @Test
    void minimum_index() {
        // when
        Assertions.assertThatThrownBy(() -> new CarIndex(0))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 시작 index는 1이상 이어야 합니다.");
    }
}