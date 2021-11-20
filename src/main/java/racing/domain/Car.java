package racing.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Car {

    CarIndex index;

    public Car() {
        this.index = new CarIndex();
    }

    public Car(int index) {
        this.index = new CarIndex(index);
    }

    public void move(CustomRandomAble random) {
        Collection<Car> car = new HashSet<>();
        MoveStrategy moveStrategy = new MoveStrategy();

        if (moveStrategy.isMove(random)) {
            index.moveForward();

            return;
        }

        index.stop();
    }

    public int getIndex() {
        return index.getLastIndex();
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
