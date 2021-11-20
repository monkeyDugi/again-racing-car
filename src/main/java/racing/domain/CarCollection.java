package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarCollection {

    private List<Car> cars = new ArrayList<>();

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public CarCollection(int participatingCars) {
        for (int i = 0; i < participatingCars; i++) {
            cars.add(new Car());
        }
    }

    public void move(CustomRandomAble customRandomAble) {
        for (Car car : cars) {
            car.move(customRandomAble);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarCollection that = (CarCollection) o;
        return Objects.equals(getCars(), that.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCars());
    }
}
