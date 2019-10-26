package trening1.animals;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DogTest {
    @Test
    public void testDogFood(){
        //given
        Dog dog = new Dog();
        //when
        List<FoodKind> listDog = dog.foodKind();
        //then
        assertTrue(dog.foodKind().contains(FoodKind.MIESO));
        assertTrue(listDog.contains(FoodKind.MLEKO));
        assertTrue(listDog.contains(FoodKind.KARMA));




    }

}