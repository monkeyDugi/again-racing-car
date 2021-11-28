package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class winnerTest {

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
        Winner winner = new Winner(cars);

        // when
        List<String> winners = winner.getWinners();

        // then
        List<String> expectedWinner = Arrays.asList(carName1, carName3);
        assertThat(winners).isEqualTo(expectedWinner);
    }
}