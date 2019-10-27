package rental;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientTest {
    @Test
    public void topUpAccount(){
        //given
        //Client client1 = new Client("Jan", "Kowalski", "ABC123456", new BigDecimal(12.45));
        //Client client2 = new Client("Andrzej", "Nowak", "BCD234567", new BigDecimal(0.40));
        //Client client3 = new Client("Ryszard", "Paz", "IJK123456", new BigDecimal(2.40));
        //when
        //client1.topUpAccount(new BigDecimal(25.40));
        //client2.topUpAccount(22.0);
        //client3.topUpAccount(11.8);
        //then
        //given
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 12.45);
        Client client2 = new Client("Andrzej", "Nowak", "BCD234567", 0.40);
        Client client3 = new Client("Ryszard", "Paz", "IJK123456", 2.40);
        //when
        client1.topUpAccount(10);
        //client2.topUpAccount(22.0);
        //client3.topUpAccount(11.8);
        //then
        client1.getSaldoClient();



    }



}