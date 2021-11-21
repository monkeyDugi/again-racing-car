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
        String carName1 = "dugi";
        String carName2 = "manse";
        String carName3 = "pobi";

        String participatingCarNames = "dugi,manse,pobi";

        Cars Cars = new Cars(participatingCarNames);

        // when
        Cars.move(() -> 4);

        // then
        List<Car> carList = Arrays.asList(
                                            new Car(2, new MoveStrategy(), carName1),
                                            new Car(2, new MoveStrategy(), carName2),
                                            new Car(2, new MoveStrategy(), carName3)
                                        );
        Cars expected = new Cars(carList);
        assertThat(Cars).isEqualTo(expected);
    }

    @DisplayName("n대의 참여 자동자 모두 이동 실패")
    @Test
    void all_cars_fail_move() {
        // given
        String carName1 = "dugi";
        String carName2 = "manse";
        String carName3 = "pobi";

        String participatingCarNames = "dugi,manse,pobi";

        Cars Cars = new Cars(participatingCarNames);

        // when
        Cars.move(() -> 3);

        // then
        List<Car> cars = Arrays.asList(
                                        new Car(1, new MoveStrategy(), carName1),
                                        new Car(1, new MoveStrategy(), carName2),
                                        new Car(1, new MoveStrategy(), carName3)
                                    );
        Cars expected = new Cars(cars);
        assertThat(Cars).isEqualTo(expected);
    }

    @DisplayName("각 자동차 이름을 기준으로 참여 자동차를 생성한다.")
    @Test
    void cars_create() {
        // given
        String participatingCarNames = "dugi,manse,pobi";

        // when
        Cars cars = new Cars(participatingCarNames);

        // then
        int expectedParticipatingCarsOfNumber = 3;
        assertThat(cars.size()).isEqualTo(expectedParticipatingCarsOfNumber);
    }
}