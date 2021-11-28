## 학습 목표

---

### 경험해야할 학습 목표
- Github 기반으로 온라인 코드리뷰 경험
- JUnit을 활용한 단위 테스트 경험
- 자바 Code Convention을 지키면서 프로그래밍하는 경험
- 메서드를 분리하는 리팩토링 경험

### 경험할 객체지향 생활 체조 원칙
- 규칙 1 : 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- 규칙 2 : else 예약어를 쓰지 않는다.

이 두가지 원칙을 통해 메소드를 분리해 메소드가 한 가지 작업만 담당하도록 구현하는 연습을 목표로 한다.  
이 같은 원칙 아래에서 **메소드의 라인 수를 15라인**이 넘지 않도록 구현한다.

## Clean Code 가이드

---

### 메소드(함수)
#### 작게 만들어라.
- 함수를 만드는 첫 번재 규칙은 **'작게'**이다. 함수를 만드는 두 번째 규칙은 **'더 작게'**이다.

#### 한 가지만 해라.
- 함수는 한 가지를 해야 한다. 그 한 가지를 잘 해야 한다. 그 한 가지만 해야 한다.

#### 함수 당 추상화 수준은 하나로
- 함수가 확실히 **'한 가지'** 작업만 하려면 함 수 내 모든 문장이 동일한 추상화 수준에 있어야 한다.
- 코드는 위에서 아래로 이야기처럼 일 해야 좋다.

#### 서술적인 이름을 사용하라.
- 이름이 길어도 괜찮다.
- 이름을 정하느라 시간을 들여도 괜찮다.
- 이름을 붙일 때는 일관성이 있어야 한다.

#### 함수 인수
- 함수에서 이상적인 인수 개수는 0개(무항)이다. 다음은 1개이고, 다음은 2개이다.
- 3개는 가능한 피하는 편이 좋다.
- **4개 이상은 특별한 이유가 있어도 사용하면 안된다.**
- 인수가 2 ~ 3개 필요한 경우가 생긴다면 인수를 독자적인 클래스를 생성할 수 있는지 검토해 본다.

#### side effect를 만들지 마라.
- side effect는 많은 경우 예쌍치 못한 버그를 발생시킨다.

#### 명령과 조회를 분리하라.
- 함수는 뭔가를 수행하거나 답하거나 둘 중 하나만 해야 한다. 둘 다 하면 안된다.
- 개체 상태를 변경하거나 아니면 개체 정보를 반환하거나 둘 중 하나다.

#### 오류 코드보다는 예외를 사용하라.
- 오류 처리도 한 가지 작업이다.
  - 함수는 **'한 가지'** 작업만 해야 한다. 오류 처리도 **'한 가지'** 작업에 속한다.
  - 그러므로 오류를 처리하는 함수는 오류만 처리해야 한다.
- try/catch 블록은 원래가 추하다. 코드 구제오 혼란을 일으키며,  
  정상적인 동작과 오류 처리 동작을 뒤섞는다.  
  try/catch 블록을 별도 함수로 뽑아내는 편이 낫다.
  ```java
  public void delete(Page page) {
  try {
    deletePageAndAllReferences(page);
  } catch (Exception e) {
    logError(e);
  }
  ```  

#### 반복하지 마라.
- 중복은 소프트웨어에서 모든 악의 근원이다.

#### 함수를 구현하는 방법은??
> 소프트웨어를 구현하는 행위는 여느 글짓기와 비슷하다. 논문이나 기사를 쓸 때는 먼저 생각을 기록한 후 읽기 좋게 다듬는다.  
> 초안은 대개 서투르고 어수선하므로 원하는 대로 읽힐 때 까지 말을 다듬고 문장을 고치고 문단을 정리한다.
>
> 필자는 함수를 구현할 때도 마찬가지다. 처음에는 길고 복잡하다. 들여쓰기 단계도 많고, 중복된 루프도 많다. 인수 목록도 아주 길다.  
> 이름은 즉흥적이고 코드는 중복된다. 하지만 필자는 그 서투른 코드를 빠짐없이 테스트하는 단위 테스트 케이스도 만든다.
>
> 그런 다음 필자는 코드를 다듬고, 함수를 만들고, 이름을 바꾸고, 중복을 제거한다. 메소드를 줄이고, 순서를 바꾼다. 때로는 전체 클래스를 쪼개기도 한다.  
> 이 와중에도 코드는 항상 단위 테스트를 통과한다.
>
> 결국에는 앞에서 다룬 규칙을 따르는 함수를 얻을 수 있다. 처음부터 딱 짜내지 않는다. 그게 가능한 사람은 없으리라.

### code convention, format 맞추기
#### 형식을 맞추는 목적
- code convention은 중요하다. 너무 중요해서 무시하기 어렵다.
- code convention은 의사소통의 일환이다. 의사소통은 전문 개발자의 일차적인 의무이다.

#### 적절한 행의 길이를 유지하라.
- 120자 정도로 행 길이를 제한한다.

#### 팀 규칙
- 모든 프로그래머는 자신이 선호하는 규칙이 있다. 하지만 팀에 속한다면 자신이 선호해야 할 규칙은 바로 팀 규칙이다.
- 팀은 한 가지 규칙에 합의해야 한다. 그리고 모든 팀원은 그 규칙을 따라야 한다.

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
- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 **반드시 빈 공백 문자열**이 있다고 가정한다.
- [x] **나눗셈의 경우 결과 값을 정수**로 떨어지는 값으로 한정한다.
- [x] 문자열 계산기는 **사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정**된다.  
  즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다
- [x] 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 10을 출력해야 한다.

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

## 3단계 - 자동차 경주

---

### 기능 요구 사항
- [ ] 초간단 자동차 경주 게임을 구현한다.
- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [ ] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

#### 실행 결과
자동차 대수는 몇 대 인가요?
3
시도할 회수는 몇 회 인가요?
5
```java
실행 결과
        -
        -
        -

        --
        -
        --

        ---
        --
        ---

        ----
        ---
        ----

        ----
        ----
        -----
```

#### 힌트
- 값을 입력 받는 API는 Scanner를 이용한다.
```java
Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int number = scanner.nextInt();
```

- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.

### 프로그래밍 요구 사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다. [참고문서](https://myeonguni.tistory.com/1596)
- else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 요구 사항 분리
결국 n대의 자동차가 특정 조건에 의해 전진하거나 정지하여 현재 위치를 정하고,  
그 위치를 보여주는 요구사항이다.
- [x] 랜덤 값이 4이상이면 true 반환(전진 조건)
- [x] 4미만이면 false 반환(정지 조건)
- [x] 랜덤 값이 4이상이면 전진하기.(이동)
- [x] 랜덤 값이 4미만이면 정지하기.(이동)
- [x] n대의 자동차가 이동 성공, 이동 실패 하기
- [x] 주어진 횟수만큼 자동차들이 이동 시도 하기
- [x] InputView UI 구현
- [x] ResultView UI 구현(아래는 구현 중 추가된 분리 사항)
  - [x] 각 자동차의 index를 기록하기(각 기록을 출력 해주어야 하기 때문)

## 4단계 - 자동차 경주(우승자)

---

### 기능 요구 사항
- 각 자동차에 이름을 부여할 수 있다. **자동차 이름은 5자를 초과할 수 없다.**
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- **자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다. 우승자는 한명 이상일 수 있다.**

**실행 결과**
- 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```java
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

**힌트**
- 규칙 1 : 한 메소드에 오직 한단계의 들여쓰기만 한다.
  - 들여쓰기가 2이상인 메소드의 경우 메소드를 분리하면 들여쓰기를 줄일 수 있다.
  - else를 사용하지 않아 들여쓰기를 줄일 수 있다.
- 자동차 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메소드를 활용한다.
- 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
- 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.

### 프로그래밍 요구 사항
- 들여쓰기를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트 : 들여쓰기 depth를 줄이는 좋은 방법은 메소드를 분리하면 된다.
- 메소드의 길이가 15라인을 넘지 않도록 구현한다.
  - 메소드가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단(UI)로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스로 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
  - [나는 교육과 다르게 이 컨벤션을 지킨다.](https://naver.github.io/hackday-conventions-java/#modifier-order)
- else 예약어를 쓰지 않는다.
  - 힌트 : if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지말라고 하니 switch/case로 구현하는 경우가 있는 이도 허용하지 않는다.
  
### 요구 사항 분리
- [x]  자동차 이름 수 만큼 참여 자동차를 생성한다.
- [x]  이름 수 만큼 정해진 참여 자동차들은 각 이름을 가진다. Car
- [x]  **자동차 이름은 5자를 초과할 수 없다.**
- [x]  **자동차 이름은 1자 이상이어야 한다..**
- [x]  전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.(UI)
- [x]  **자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다. 우승자는 한명 이상일 수 있다.**