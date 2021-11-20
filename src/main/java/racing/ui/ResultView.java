package racing.ui;

import racing.domain.Car;
import racing.domain.CarCollection;

import java.util.List;

public class ResultView {

    private static final String INDEX_LINE = "-";

    public static void showRacingResult(CarCollection carCollection, int numberOfMoves) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMoves; i++) {
            printCarsLine(carCollection, i);

            System.out.println();
        }
    }

    private static void printCarsLine(CarCollection carCollection, int i) {
        List<Car> cars = carCollection.getCars();
        for (Car car : cars) {
            printCarLine(car, i);
        }
    }

    private static void printCarLine(Car car, int i) {
        StringBuilder sb = new StringBuilder();

        int index = car.getHistoryIndex(i);
        for (int j = 0; j < index; j++) {
            sb.append(INDEX_LINE);
        }

        System.out.println(sb);
    }
}
