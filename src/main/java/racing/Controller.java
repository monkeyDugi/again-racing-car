package racing;

import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Controller {

    public void run() {
        int participatingCars = InputView.answerParticipatingCars();
        int numberOfMoves = InputView.answerNumberOfMoves();

        Cars cars = new Cars(participatingCars);
        RacingGame racingGame = new RacingGame(cars);

        racingGame.start(numberOfMoves);

        ResultView.showRacingResult(cars, numberOfMoves);
    }
}
