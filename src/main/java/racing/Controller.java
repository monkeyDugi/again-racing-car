package racing;

import racing.domain.CarCollection;
import racing.domain.RacingGame;
import racing.ui.InputView;

public class Controller {

    public void run() {
        int participatingCars = InputView.answerParticipatingCars();
        int numberOfMoves = InputView.answerNumberOfMoves();

        CarCollection cars = new CarCollection(participatingCars);
        RacingGame racingGame = new RacingGame(cars);

        racingGame.start(numberOfMoves);
    }
}
