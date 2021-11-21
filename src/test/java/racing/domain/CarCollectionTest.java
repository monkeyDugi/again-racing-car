package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 참여 자동차 모두 이동 성공")
    @Test
    void all_cars_move() {
        // given
        int participatingCars = 3;

        Cars Cars = new Cars(participatingCars);

        // when
        Cars.move(() -> 4);

        // then
        List<Car> carList = Arrays.asList(
                                            new Car(2, new MoveStrategy()),
                                            new Car(2, new MoveStrategy()),
                                            new Car(2, new MoveStrategy())
                                        );
        Cars expected = new Cars(carList);
        assertThat(Cars).isEqualTo(expected);
    }

    @DisplayName("n대의 참여 자동자 모두 이동 실패")
    @Test
    void all_cars_fail_move() {
        // given
        int participatingCars = 3;

        Cars Cars = new Cars(participatingCars);

        // when
        Cars.move(() -> 3);

        // then
        List<Car> cars = Arrays.asList(
                                        new Car(1, new MoveStrategy()),
                                        new Car(1, new MoveStrategy()),
                                        new Car(1, new MoveStrategy())
                                    );
        Cars expected = new Cars(cars);
        assertThat(Cars).isEqualTo(expected);
    }
}