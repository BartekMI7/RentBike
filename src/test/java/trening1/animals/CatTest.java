package trening1.animals;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {
    @Test
    public void testCatFood(){
        //given
        Cat cat1 = new Cat();
        //when
        List<FoodKind> list = cat1.foodKind();
        //then
        assertTrue(cat1.foodKind().contains(FoodKind.MYSZY));
        assertTrue(cat1.foodKind().contains(FoodKind.MIESO));
        assertTrue(cat1.foodKind().contains(FoodKind.KARMA));


    }

}