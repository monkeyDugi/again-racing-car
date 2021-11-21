package racing.domain;

import java.util.Objects;

public class Car {

    private final CarIndex index;
    private final MoveStrategyAble moveStrategy;
    private final String name;

    public Car(int index, MoveStrategyAble moveStrategy, String name) {
        this.index = new CarIndex(index);
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public Car(MoveStrategyAble moveStrategy, String name) {
        this.index = new CarIndex();
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public void move(CustomRandomAble random) {
        if (moveStrategy.isMove(random)) {
            index.moveForward();

            return;
        }

        index.stop();
    }

    public int getIndex() {
        return index.getLastIndex();
    }

    public String getName() {
        return name;
    }

    public int getHistoryIndex(int index) {
        return this.index.getIndex(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getIndex(), car.getIndex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex());
    }
}
