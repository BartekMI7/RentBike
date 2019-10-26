package trening1.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fish implements Pet{
    List<FoodKind> foodFish = Arrays.asList(FoodKind.RYBY);

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
