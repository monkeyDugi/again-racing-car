package racing.domain;

public class RacingGame {

    private final CarCollection carCollection;

    public RacingGame(CarCollection carCollection) {
        this.carCollection = carCollection;
    }

    public void start(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            carCollection.move(new CustomRandom());
        }
    }
}
