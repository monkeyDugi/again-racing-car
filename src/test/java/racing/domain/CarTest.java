package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("random 값이 4 이상이면 전진을 한다.")
    @Test
    void move() {
        // given
        Car car = new Car();

        // when
        car.move(() -> 4);
        int carIndex = car.getIndex();

        // then
        assertThat(carIndex).isEqualTo(2);
    }

    @DisplayName("random 값이 4 미만이면 정지 한다.")
    @Test
    void no_move() {
        // given
        Car car = new Car();

        // when
        car.move(() -> 3);
        int carIndex = car.getIndex();

        // then
        assertThat(carIndex).isEqualTo(1);
    }
}