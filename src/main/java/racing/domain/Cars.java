package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(int participatingCars) {
        for (int i = 0; i < participatingCars; i++) {
            cars.add(new Car());
        }
    }

    public void move(CustomRandomAble customRandomAble) {
        for (Car car : cars) {
            car.move(customRandomAble);
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars that = (Cars) o;
        return Objects.equals(get(), that.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }
}