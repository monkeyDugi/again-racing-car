package racing.domain;

public class RacingGame {

    private final Cars Cars;

    public RacingGame(Cars Cars) {
        this.Cars = Cars;
    }

    public void start(int numberOfMoves) {
        CustomRandomAble customRandom = new CustomRandom();

        // -1 : Car 생성 시 CarIndex가 생기므로 실제 시도 횟수 보다 한 번더 이동을 시도하게 된다.
        // 결국 CarIndex의 인덱스가 시도는 5번 했지만 6번의 시도를 하게 된다.
        // 근데 ResultView에서는 Cars(참여 자동차들)로 루프를 돌리기 때문에 numberOfMoves만큼만
        // 이동한 결과를 보여준다.
        // 즉, 우승자를 구하려 하는데 결과 그림과 실제 CarIndex 데이터가 다른 현상이 발생한다.
        // 여기서 -1을 하면 해결이 되지만 이는 CarIndex의 내부 구조를 알아야 하는 것이라 옳지 않다.
        // 실제로 나도 내부 구조 파다가 -1을 해야하는 것을 알게 되었다.
        // 이러면 다른 클라이언트 코드에서도 분명 이런 현상이 발생할 것이다.
        // 그리고 Winner -> getWinners() 메서드도 리팩토링 필요. 지저분함.
        for (int i = 0; i < numberOfMoves - 1; i++) {
//        for (int i = 0; i < numberOfMoves; i++) {
            Cars.move(customRandom);
        }
    }
}
