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

    public Cars(String participatingCarNames) {
        String[] arrParticipatingCarNames = participatingCarNames.split(",");
        MoveStrategyAble moveStrategy = new MoveStrategy();

        for (String participatingCarName : arrParticipatingCarNames) {
            cars.add(new Car(participatingCarName, moveStrategy));
        }
    }

    public void move(CustomRandomAble customRandomAble) {
        for (Car car : cars) {
            car.move(customRandomAble);
        }
    }

    public List<String> getWinners() {
        int max = maxIndex();
        return getWinners(max);
    }

    private List<String> getWinners(int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinners(max, winners, car);
        }

        return winners;
    }

    private void addWinners(int max, List<String> winners, Car car) {
        if (car.getIndex() == max) {
            winners.add(car.getName());
        }
    }

    private int maxIndex() {
        List<Integer> carIndexes = new ArrayList<>();
        for (Car car : cars) {
            carIndexes.add(car.getIndex());
        }

        return Collections.max(carIndexes);
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
