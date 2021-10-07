package firstStage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {

    private Set<Integer> numbers;
    private int setSize;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, 1, 2, 3);
        numbers = new HashSet<>(list);
        setSize = numbers.size();
    }

    @DisplayName("요구사항 1 : Set의 size() 메소드를 활용해 Set의 크기 확인")
    @Test
    void size() {
        int size = numbers.size();

        assertThat(size).isEqualTo(setSize);
    }

    @DisplayName("요구사항 2 : Set의 contains() 메소드로 1,2,3 값 존재 확인")
    @ValueSource(ints= {1, 2, 3})
    @ParameterizedTest
    void containsValueSource(int number) {
        assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers.containsAll(list)).isTrue(); // containsAll도 사용해 봤다.
    }

    @DisplayName("")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
//    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void containsCsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
