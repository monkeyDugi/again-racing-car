package racing.domain;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void start(int numberOfMoves) {
        CustomRandomAble customRandom = new CustomRandom();

        for (int i = 0; i < numberOfMoves; i++) {
            cars.move(customRandom);
        }
    }
}
