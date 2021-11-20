package racing.domain;

public class MoveStrategy {

    public boolean isMove(CustomRandomAble random) {
        return random.nextInt() >= 4;
    }
}
