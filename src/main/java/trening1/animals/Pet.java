package trening1.animals;

import java.util.List;

public interface Pet {
    public List<FoodKind> foodKind();
    void doIntroduce();
    void doVoice();
    void doFeed(Food food);
}
