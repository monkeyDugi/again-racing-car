package racing.domain;

public class RacingGame {

    private final CarCollection cars;

    public RacingGame(CarCollection cars) {
        this.cars = cars;
    }

    public void start(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            cars.move(new CustomRandom());
        }
    }
}
