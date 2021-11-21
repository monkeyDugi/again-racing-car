package racing.domain;

@FunctionalInterface
public interface MoveStrategyAble {

    boolean isMove(CustomRandomAble random);
}
