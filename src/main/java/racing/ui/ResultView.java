package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    private ResultView() {}

    private static final String INDEX_LINE = "-";

    public static void showRacingResult(Cars cars, int numberOfMoves) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMoves; i++) {
            printCarsLine(cars, i);
            System.out.println();
        }

        printWinners(cars.getWinners());
    }

    private static void printCarsLine(Cars cars, int i) {
        List<Car> carList = cars.get();
        for (Car car : carList) {
            printCarLine(car, i);
        }
    }

    private static void printCarLine(Car car, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");

        int index = car.getHistoryIndex(i);
        for (int j = 0; j < index; j++) {
            sb.append(INDEX_LINE);
        }

        System.out.println(sb);
    }

    private static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();

        for (String winnerName : winners) {
            appendWinner(sb, winnerName);
        }

        sb.append("가 최종 우승 하였습니다.");

        System.out.println(sb);
    }

    private static void appendWinner(StringBuilder sb, String winnerName) {
        if (sb.length() > 0) {
            sb.append(",");
        }

        sb.append(winnerName);
    }
}
