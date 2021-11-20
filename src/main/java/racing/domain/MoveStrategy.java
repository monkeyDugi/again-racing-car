package racing.domain;

public class MoveStrategy {

    private static final int BOUND = 4;

    public boolean isMove(CustomRandomAble random) {
        return random.nextInt() >= BOUND;
    }
}
