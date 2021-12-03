package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> expectedIndexes = Arrays.asList(1, 2, 3, 3);
        CarIndex expectedCarIndex = new CarIndex(expectedIndexes);
        assertThat(carIndex).isEqualTo(expectedCarIndex);

        assertThat(carIndex.size()).isEqualTo(4);
    }

    @DisplayName("최소 시작 인덱스는 0미만이면 예외")
    @Test
    void exception_minimum_index() {
        // when
        Assertions.assertThatThrownBy(() -> new CarIndex(-1))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 시작 index는 0이상 이어야 합니다.");
    }

    @DisplayName("출발하지 않는 자동차의 위치를 가져올 수 없다.")
    @Test
    void exception_not_move_index() {
        // when
        Assertions.assertThatThrownBy(() -> new CarIndex().getLastIndex())
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 이동한 기록이 없습니다.");
    }
}
