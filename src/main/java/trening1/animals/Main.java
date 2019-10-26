package trening1.animals;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        for (FoodKind item: cat1.foodCat) {
            System.out.println(item);
        }
        System.out.println("cat:\n");
        cat1.foodCat.stream().forEach(System.out::println);
        System.out.println("dog\n");
        System.out.println("stream ver.1");
        dog1.foodKind().stream().forEach(System.out::println);
        System.out.println("stream ver.2");
        dog1.foodDog.stream().forEach(food-> System.out.println(food));
    }
}
