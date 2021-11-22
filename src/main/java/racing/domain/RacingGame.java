package racing.domain;

public class RacingGame {

    private final Cars Cars;

    public RacingGame(Cars Cars) {
        this.Cars = Cars;
    }

    public void start(int numberOfMoves) {
        CustomRandomAble customRandom = new CustomRandom();

        for (int i = 0; i < numberOfMoves; i++) {
            Cars.move(customRandom);
        }
    }
}
