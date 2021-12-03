package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("random 값이 4 이상이면 전진을 한다.")
    @Test
    void move() {
        // given
        String name = "dugi";
        Car car = new Car(name, new MoveStrategy());

        // when
        car.move(() -> 4);
        int carIndex = car.getIndex();

        // then
        assertThat(carIndex).isEqualTo(1);
    }

    @DisplayName("random 값이 4 미만이면 정지 한다.")
    @Test
    void no_move() {
        // given
        String name = "dugi";
        Car car = new Car(name, new MoveStrategy());

        // when
        car.move(() -> 3);
        int carIndex = car.getIndex();

        // then
        assertThat(carIndex).isZero();
    }

    @DisplayName("자동차는 이름을 갖는다.")
    @Test
    void create_car_name() {
        // given
        String name = "dugi";

        // when
        Car car = new Car(name, new MoveStrategy());

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void car_name_max_exception() {
        // given
        String name = "sports";

        // when
        assertThatThrownBy(() -> new Car(name, new MoveStrategy()))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름은 1자 보다 작을 수 없다.")
    @Test
    void car_name_minimum_exception() {
        // given
        String name = "  ";

        // when
        assertThatThrownBy(() -> new Car(name, new MoveStrategy()))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

    @DisplayName("자동차 이름은 1자 이상이어야 한다.")
    @Test
    void car_name_minimum() {
        // given
        String name = "s";

        // when
        Car car = new Car(name, new MoveStrategy());

        // then
        assertThat(car.getName()).isEqualTo(name);
    }
}
