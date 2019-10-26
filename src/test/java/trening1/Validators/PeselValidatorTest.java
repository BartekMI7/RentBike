package trening1.Validators;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeselValidatorTest {
    @Test
    public void testPeselNull(){
        //given
        String pesel = null;
        PeselValidator peselValidator = new PeselValidator();

        //when
        boolean result = peselValidator.validate(pesel);

        //then
        assertFalse(result);
    }
    @Test
    public void testPeselCorrect(){
        //given
        String pesel = "02070803628";
        PeselValidator peselValidator1 = new PeselValidator();


        //when
        boolean result1 = peselValidator1.validate(pesel);

        //then
        assertTrue(result1);
    }


    @Test
    public void testPeselIncorrect(){
        //given
        String pesel = "02070803626";
        PeselValidator peselValidator = new PeselValidator();
        //when
        boolean result = peselValidator.validate(pesel);
        //then
        assertFalse(result);


    }
}