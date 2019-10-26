package trening1.animals;

import java.util.Arrays;
import java.util.List;

public class Bird implements Pet{
    List<FoodKind> foodBird = Arrays.asList(FoodKind.MYSZY,FoodKind.ZBOZE,FoodKind.RYBY);

    @Override
    public List<FoodKind> foodKind() {
        return null;
    }

    @Override
    public void doIntroduce() {

    }

    @Override
    public void doVoice() {

    }

    @Override
    public void doFeed(Food food) {

    }
}
