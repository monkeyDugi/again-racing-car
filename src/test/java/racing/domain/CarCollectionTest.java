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

        CarCollection carCollection = new CarCollection(participatingCars);

        // when
        carCollection.move(() -> 4);

        // then
        List<Car> carList = Arrays.asList(new Car(2), new Car(2), new Car(2));
        CarCollection expected = new CarCollection(carList);
        assertThat(carCollection).isEqualTo(expected);
    }

    @DisplayName("n대의 참여 자동자 모두 이동 실패")
    @Test
    void all_cars_fail_move() {
        // given
        int participatingCars = 3;

        CarCollection carCollection = new CarCollection(participatingCars);

        // when
        carCollection.move(() -> 3);

        // then
        List<Car> cars = Arrays.asList(new Car(1), new Car(1), new Car(1));
        CarCollection expected = new CarCollection(cars);
        assertThat(carCollection).isEqualTo(expected);
    }
}