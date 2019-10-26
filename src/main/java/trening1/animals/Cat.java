package trening1.animals;

import java.util.Arrays;
import java.util.List;

public class Cat implements Pet {
    List<FoodKind> foodCat = Arrays.asList(FoodKind.MYSZY, FoodKind.MIESO, FoodKind.KARMA);

    @Override
    public List<FoodKind> foodKind() {
        return foodCat;
    }

    @Override
    public void doIntroduce() {
        System.out.println("Hi! I'm sweet cat. My name is Tom ");

    }

    @Override
    public void doVoice() {
        System.out.println("Miaaauuuuuuuuuuuuuu");
    }

    @Override
    public void doFeed(Food food) {

    }
}
