package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarCollectionTest {

    @DisplayName("n대의 참여 자동차 모두 이동 성공")
    @Test
    void all_cars_move() {
        // given
        int participatingCars = 3;

        CarCollection cars = new CarCollection(participatingCars);

        // when
        cars.move(() -> 4);

        // then
        List<Car> carList = Arrays.asList(new Car(1), new Car(1), new Car(1));
        CarCollection expected = new CarCollection(carList);
        assertThat(cars).isEqualTo(expected);
    }

    @DisplayName("n대의 참여 자동자 모두 이동 실패")
    @Test
    void all_cars_fail_move() {
        // given
        int participatingCars = 3;

        CarCollection cars = new CarCollection(participatingCars);

        // when
        cars.move(() -> 3);

        // then
        List<Car> carList = Arrays.asList(new Car(0), new Car(0), new Car(0));
        CarCollection expected = new CarCollection(carList);
        assertThat(cars).isEqualTo(expected);
    }
}