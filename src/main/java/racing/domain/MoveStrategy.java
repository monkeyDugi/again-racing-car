package racing.domain;

public class MoveStrategy implements MoveStrategyAble {

    private static final int BOUND = 4;

    @Override
    public boolean isMove(CustomRandomAble random) {
        return random.nextInt() >= BOUND;
    }
}
