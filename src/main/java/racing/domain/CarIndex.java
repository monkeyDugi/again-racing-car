package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarIndex {

    private static final int START_INDEX = 1;
    private List<Integer> indexes = new ArrayList<>();

    public CarIndex() {
        this.indexes.add(START_INDEX);
    }

    public CarIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("최소 시작 index는 1이상 이어야 합니다.");
        }

        this.indexes.add(index);
    }

    public void moveForward() {
        indexes.add(getLastIndex() + 1);
    }

    public void stop() {
        indexes.add(getLastIndex());
    }

    public Integer getLastIndex() {
        return indexes.get(size() - 1);
    }

    public int getIndex(int index) {
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
