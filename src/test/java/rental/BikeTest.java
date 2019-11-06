package rental;

import org.junit.Test;

import static org.junit.Assert.*;

public class BikeTest {

    @Test
    public void toStringTest(){
        //given
        Bike bike1 = new Bike("1", 2016);
        //when
        //then
        System.out.println(bike1.toString());


    }

}