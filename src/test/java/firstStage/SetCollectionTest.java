package firstStage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // jordy: java 11 이시면 Set.of 를, java 8 이시면 Arrays.asList()를 활용해보시면 어떨까요?
    }

    @DisplayName("요구사항 1 : Set의 size() 메소드를 활용해 Set의 크기 확인")
    @Test
    void size() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3); // jordy: 매직 넘버를 추출해서 expectedResult 같은 변수에 담아 보시는건 어떨까요?
    }

    @DisplayName("요구사항 2 : Set의 contains() 메소드로 1,2,3 값 존재 확인")
    @ValueSource(ints= {1, 2, 3})
    @ParameterizedTest
    void containsValueSource(int number) {
        assertThat(numbers.contains(number)).isTrue(); // jordy: assertThat().containsAll() 을 활용해보시면 어떨까요?
    }

    @DisplayName("")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
//    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':') // jordy: 최종본이시면 불필요한 주석은 제거하시는게 좋을거 같습니다.
    @ParameterizedTest
    void containsCsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected); // jordy: assertThat().containsAll() 을 활용해보시면 어떨까요?
    }
}
