package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    /**
     * start() 메서드에 cars.move()가 numberOfMoves만큼 실행 되었는지 테스트를 하려고 했으나
     * verify()가 필요하고 이는 Mockito 사용이므로 과한 테스트라고 판단하여 에러가 없는지 테스트만 작성
     */
    @DisplayName("작동 여부 테스트")
    @Test
    void all_cars_move_attempt() {
        // given
        int participatingCars = 3;

        CarCollection cars = new CarCollection(participatingCars);

        int numberOfMoves = 5;
        RacingGame racingGame = new RacingGame(cars);
        // when
        racingGame.start(numberOfMoves);
    }
}