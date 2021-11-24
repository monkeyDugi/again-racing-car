package racing;

import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.domain.Winner;
import racing.ui.InputView;
import racing.ui.ResultView;

public class Controller {

    public void run() {
        String participatingCarNames = InputView.answerParticipatingCars();
        int numberOfMoves = InputView.answerNumberOfMoves();

        Cars cars = new Cars(participatingCarNames);
        RacingGame racingGame = new RacingGame(cars);
        racingGame.start(numberOfMoves);

        Winner winner = new Winner(cars);

        ResultView.showRacingResult(cars, winner, numberOfMoves);
    }
}
