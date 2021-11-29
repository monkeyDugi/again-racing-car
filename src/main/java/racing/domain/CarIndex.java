package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarIndex {

    private static final int START_MOVE_INDEX = 1;
    private static final int MINIMUM_MOVE_INDEX = 0;

    private static final int NEXT_MOVE_INDEX = 1;

    private final List<Integer> indexes = new ArrayList<>();

    public CarIndex() {}

    public CarIndex(int index) {
        if (index < MINIMUM_MOVE_INDEX) {
            throw new IllegalArgumentException("최소 시작 index는 " + MINIMUM_MOVE_INDEX + "이상 이어야 합니다.");
        }

        this.indexes.add(index);
    }

    public void moveForward() {
        if (indexes.isEmpty()) {
            indexes.add(START_MOVE_INDEX);

            return;
        }

        indexes.add(getLastIndex() + NEXT_MOVE_INDEX);
    }

    public void stop() {
        if (indexes.isEmpty()) {
            indexes.add(MINIMUM_MOVE_INDEX);

            return;
        }

        indexes.add(getLastIndex());
    }

    public int getLastIndex() {
        validateNotMove();

        return indexes.get(size() - 1);
    }

    private void validateNotMove() {
        int index = size() - 1;

        if (index < 0) {
            throw new IllegalArgumentException("자동차가 이동한 기록이 없습니다.");
        }
    }
    
    int getIndex(int index) {
        return indexes.get(index);
    }

    public int size() {
        return indexes.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarIndex carIndex = (CarIndex) o;
        return Objects.equals(indexes, carIndex.indexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexes);
    }
}
