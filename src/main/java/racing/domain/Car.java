package racing.domain;

import java.util.Objects;

public class Car {

    private int index = 0;

    public Car() {}

    public Car(int index) {
        this.index = index;
    }

    public void move(CustomRandomAble random) {
        MoveStrategy moveStrategy = new MoveStrategy();

        if (moveStrategy.isMove(random)) {
            this.index++;
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return index == car.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
