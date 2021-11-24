package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    private final Cars cars; 
    
    public Winner(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        List<Car> cars = this.cars.get();

        List<Integer> carIndexs = new ArrayList<>();
        for (Car car : cars) {
            carIndexs.add(car.getIndex());
        }

        int max = Collections.max(carIndexs);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getIndex() == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
