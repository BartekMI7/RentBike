package trening1.animals;

import java.util.Arrays;
import java.util.List;

public class Dog implements Pet {
    List<FoodKind> foodDog = Arrays.asList(FoodKind.KARMA,FoodKind.MLEKO,FoodKind.MIESO);

    @Override
    public List<FoodKind> foodKind() {
        return foodDog;
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
