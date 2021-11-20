package racing.domain;

import java.util.Random;

public class CustomRandom implements CustomRandomAble {

    private static final Random random = new Random();

    @Override
    public int nextInt() {
        return random.nextInt(10);
    }
}
