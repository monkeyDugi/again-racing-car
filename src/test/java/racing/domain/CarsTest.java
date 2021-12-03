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

        Cars cars = new Cars(participatingCarNames);

        // when
        cars.move(() -> 4);

        // then
        List<Car> carList = Arrays.asList(
                                            new Car(carName1, 1, new MoveStrategy()),
                                            new Car(carName2, 1, new MoveStrategy()),
                                            new Car(carName3, 1, new MoveStrategy())
                                        );
        Cars expected = new Cars(carList);

        assertThat(cars.get().get(0).getIndex()).isEqualTo(expected.get().get(0).getIndex());
        assertThat(cars.get().get(1).getIndex()).isEqualTo(expected.get().get(1).getIndex());
        assertThat(cars.get().get(2).getIndex()).isEqualTo(expected.get().get(2).getIndex());
    }

    @DisplayName("n대의 참여 자동자 모두 이동 실패")
    @Test
    void all_cars_fail_move() {
        // given
        String carName1 = "dugi";
        String carName2 = "manse";
        String carName3 = "pobi";

        String participatingCarNames = "dugi,manse,pobi";

        Cars cars = new Cars(participatingCarNames);

        // when
        cars.move(() -> 3);

        // then
        List<Car> carList = Arrays.asList(
                                        new Car(carName1,0, new MoveStrategy()),
                                        new Car(carName2,0, new MoveStrategy()),
                                        new Car(carName3,0, new MoveStrategy())
                                    );
        Cars expected = new Cars(carList);

        assertThat(cars.get().get(0).getIndex()).isEqualTo(expected.get().get(0).getIndex());
        assertThat(cars.get().get(1).getIndex()).isEqualTo(expected.get().get(1).getIndex());
        assertThat(cars.get().get(2).getIndex()).isEqualTo(expected.get().get(2).getIndex());
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

    @DisplayName("우승자를 구한다. 기록이 같으면 모두 우승자이다.")
    @Test
    void getWinner() {
        // given
        String carName1 = "dugi";
        String carName2 = "manse";
        String carName3 = "pobi";

        Cars cars = new Cars(Arrays.asList(
                new Car(carName1, 2, new MoveStrategy()),
                new Car(carName2, 1, new MoveStrategy()),
                new Car(carName3, 2, new MoveStrategy())
        )
        );

        // when
        List<String> winners = cars.getWinners();

        // then
        List<String> expectedWinner = Arrays.asList(carName1, carName3);
        assertThat(winners).isEqualTo(expectedWinner);
    }
}
