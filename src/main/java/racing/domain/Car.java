package racing.domain;

import java.util.Objects;

public class Car {

    private final CarIndex index;
    private final MoveStrategyAble moveStrategy;
    private final CarName name;

    public Car(String name, int index, MoveStrategyAble moveStrategy) {
        this(name, new CarIndex(index), moveStrategy);
    }

    public Car(String name, MoveStrategyAble moveStrategy) {
        this(name, new CarIndex(), moveStrategy);
    }

    private Car(String name, CarIndex carIndex, MoveStrategyAble moveStrategy) {
        this.name = new CarName(name);
        this.index = carIndex;
        this.moveStrategy = moveStrategy;
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
        return name.getName();
    }

    public int getHistoryIndex(int index) {
        return this.index.getIndex(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getIndex(), car.getIndex()) && Objects.equals(moveStrategy, car.moveStrategy) && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), moveStrategy, getName());
    }
}
