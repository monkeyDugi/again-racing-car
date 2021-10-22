## String 클래스에 대한 학습 테스트

---

### 요구사항 1
- [x] "1,2"을 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

#### 힌트
- [x] 배열로 반화하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
- [x] 배열로 반화하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.

### 요구사항 2
- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 `()`을 제거하고 "1,2"를 반환하도록 구현한다.

### 요구사항 3
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면  
  StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] Junit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

#### 힌트
- [AssertJ Exception Assertions](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion) 문서 참고
```java
import static org.assertj.core.api.Assertions.*;

assertThatThrownBy(() -> {
    // ...
}).isInstanceOf(IndexOutOfBoundsException.class)
  .hasMessageContaining("Index: 2, Size: 2");
```
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).withMessageMatching("Index: \\d+, Size: \\d+");
```
자주 발생하는 Exception의 경우 Exception별 메소드를 제공하고 있음.
- assertThatIllegalArgumentException()
- assertThatIllegalStateException()
- assertThatIOException()
- assertThatNullPointerException()

## Set Collection에 대한 학습 테스트

---
- 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
```java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}
```

### 요구사항 1
- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트를 구현한다.

### 요구사항 2
- [x] Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 학습 테스트를 구현하려 한다.
- [x] 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- [x] JUnit의 parameterizedTest를 활용해 중복 코드를 제거해 본다.
```java
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
```
#### 힌트
- [Guide to JUnit5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```

### 요구사항 3
- [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.  
  입력 값에 따라 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- [x] 예를 들어 1,2,3 값은 contains 메소드 실행결과 true,4,5 값을 넣으면 false가 반환되는 테스트를 하나의 Test Case로 구현한다.

#### 힌트
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서에서 @CsvSource를 활용한다.
```java
@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
    String actualValue = input.toLowerCase();
    assertEquals(expected, actualValue);
}
```

### assertj 활용

---

- [Introduction to AssertJ](https://www.baeldung.com/introduction-to-assertj) 문서 참고해 assertj의 다양한 활용법 익힌다.

## 2단계 - 문자열 사칙연산 계산기 구현

---

### 기능 요구사항
- [ ] 사용자가 읿력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- [ ] 입력 문자열의 숫자와 사칙 연산 사이에는 **반드시 빈 공백 문자열**이 있다고 가정한다.
- [ ] **나눗셈의 경우 결과 값을 정수**로 떨어지는 값으로 한정한다.
- [ ] 문자열 계산기는 **사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정**된다.  
  즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다
- [ ] 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 10을 출력해야 한다.

### 프로그래밍 요구사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 기능 분리 힌트
- 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
  - 덧셈
  - 뺄셈
  - 곱셈
  - 나눗셈
  - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메서드를 활용한다.
- 반복적인 패턴을 찾아 반복문으로 구현한다.
