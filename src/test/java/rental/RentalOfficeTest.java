package rental;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class RentalOfficeTest {
    String pattern = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    @Test
    public void addClientToClientListTest() {
        //given
        Client client1 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client2 = new Client("Jan", "Kowalski", "DFR16549875");
        Client client3 = new Client("Jan", "Nowak", "GDH16454512");
        ArrayList<Client> clientList1 = new ArrayList<>();

        RentalOffice rentalOffice1 = new RentalOffice();
        //when
        rentalOffice1.addClientToClientList(client1);
        rentalOffice1.addClientToClientList(client2);
        rentalOffice1.addClientToClientList(client3);

        //then
        assertEquals(3, rentalOffice1.getClientList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClientToClientListTestExceptionTest() {
        //given
        Client client1 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client2 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client3 = new Client("Jan", "Nowak", "GDH16454512");
        ArrayList<Client> clientList1 = new ArrayList<>();

        RentalOffice rentalOffice1 = new RentalOffice();
        //when
        rentalOffice1.addClientToClientList(client1);
        rentalOffice1.addClientToClientList(client2);
        rentalOffice1.addClientToClientList(client3);

        //then
        assertEquals(2, rentalOffice1.getClientList().size());
    }


    @Test
    public void removeClientFromClientListTest() {
        //given
        Client client1 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client2 = new Client("Jan", "Kowalski", "ABB10484639");
        Client client3 = new Client("Jan", "Nowak", "GDH16454512");
        ArrayList<Client> clientList1 = new ArrayList<>();
        //when
        RentalOffice rentalOffice1 = new RentalOffice();
        rentalOffice1.addClientToClientList(client1);
        rentalOffice1.addClientToClientList(client2);
        rentalOffice1.addClientToClientList(client3);

        rentalOffice1.removeClientFromClientList(client2);

        //then
        assertEquals(2, rentalOffice1.getClientList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeClientFromClientListExceptionTest() {
        //given
        Client client1 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client2 = new Client("Jan", "Kowalski", "ABB10484639");
        Client client3 = new Client("Jan", "Nowak", "GDH16454512");
        ArrayList<Client> clientList1 = new ArrayList<>();
        //when
        RentalOffice rentalOffice1 = new RentalOffice();
        rentalOffice1.addClientToClientList(client1);
        rentalOffice1.addClientToClientList(client2);
        rentalOffice1.addClientToClientList(client3);

        rentalOffice1.removeClientFromClientList(client2);
        rentalOffice1.removeClientFromClientList(client2);

        //then
        //assertEquals(2,rentalOffice1.getClientList().size());
    }

    @Test
    public void addBikeToBikeListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        //when
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        //then
        assertEquals(3, rentalOffice.getBikeList().size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void addBikeToBikeListExceptionTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        //when
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike2);
        //then
        assertEquals(3, rentalOffice.getBikeList().size());


    }

    @Test
    public void removeBikeFromBikeListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        //when
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.removeBikeFromBikeList(bike3);
        //then
        assertEquals(2, rentalOffice.getBikeList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeBikeFromBikeListExceptionTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        //when
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.removeBikeFromBikeList(bike1);
        //then
        //assertEquals(,rentalOffice.getBikeList().size());
    }

    @Test
    public void printClientListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Client client1 = new Client("Jan", "Kowalski", "ABC15645648");
        Client client2 = new Client("Jan", "Zieliński", "ABC15645688");
        Client client3 = new Client("Jan", "Nowak", "GDH16454512");
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        //when
        //then
        rentalOffice.printClientList();
    }

    @Test
    public void printBikeListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        //when
        //then
        rentalOffice.printBikeList();
    }

    @Test
    public void rentBikeTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456");
        Client client2 = new Client("Andrzej", "Paz", "EFG345678");
        Client client3 = new Client("Jan", "Nowak", "HJK234567");
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate = simpleDateFormat.parse("2019-10-26 15:25:30");

        //when
        //then
        rentalOffice.rentBike("3", "ABC123456", startDate);


    }

    @Test
    public void giveBackBikeTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456");
        Client client2 = new Client("Andrzej", "Paz", "EFG345678");
        Client client3 = new Client("Jan", "Nowak", "HJK234567");
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate = simpleDateFormat.parse("2019-10-26 15:25:36");
        rentalOffice.rentBike("3", "ABC123456", startDate);

        //when

        Date endDate = simpleDateFormat.parse("2019-10-26 18:46:34");
        //then
        rentalOffice.giveBackBike("3", endDate);

    }

    @Test
    public void printRentBikeListTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456");
        Client client2 = new Client("Andrzej", "Paz", "EFG345678");
        Client client3 = new Client("Jan", "Nowak", "HJK234567");
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate1 = simpleDateFormat.parse("2019-10-22 10:30:23");
        Date startDate2 = simpleDateFormat.parse("2019-10-22 11:24:23");
        rentalOffice.rentBike("3", "ABC123456", startDate1);
        rentalOffice.rentBike("2", "EFG345678", startDate2);
        //when
        //then
        rentalOffice.printRentList();


    }

    @Test
    public void printActualRentBikeListTest() throws ParseException {
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456");
        Client client2 = new Client("Andrzej", "Paz", "EFG345678");
        Client client3 = new Client("Jan", "Nowak", "HJK234567");
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate1 = simpleDateFormat.parse("2019-10-22 10:30:23");
        Date startDate2 = simpleDateFormat.parse("2019-10-22 11:24:23");
        Date endDate = simpleDateFormat.parse("2019-10-22 13:22:26");
        rentalOffice.rentBike("1", "ABC123456", startDate1);
        rentalOffice.rentBike("2", "EFG345678", startDate2);
        rentalOffice.rentBike("3", "HJK234567", startDate2);
        rentalOffice.giveBackBike("1",endDate);
        //when
        //then
        rentalOffice.printActualRentList();



    }

    @Test
    public void rentBikeIfSaldoOkTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 12.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 11.0);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 45.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate = simpleDateFormat.parse("2019-10-22 12:23:14");
        //rentalOffice.rentBikeIfSaldoOk("1","ABC123456",startDate);
        rentalOffice.rentBikeIfSaldoOk("2", "EFG345678", startDate);
        //rentalOffice.rentBikeIfSaldoOk("3","HJK234567",startDate);

    }

    @Test(expected = IllegalArgumentException.class)
    public void rentBikeIfSaldoOkTestException() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 9.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 1.10);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 8.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        rentalOffice.rentBikeIfSaldoOk("1", "ABC123456", startDate);
        rentalOffice.rentBikeIfSaldoOk("2", "EFG345678", startDate);
        rentalOffice.rentBikeIfSaldoOk("3", "HJK234567", startDate);

    }

    @Test
    public void giveBackBikeWithPaymentTest() throws ParseException {
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 25.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 15.10);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 18.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);

        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        Date endDate1 = simpleDateFormat.parse("2019-10-22 19:45:34");
        Date endDate2 = simpleDateFormat.parse("2019-10-23 20:23:34");

        rentalOffice.rentBikeIfSaldoOk("1", "ABC123456", startDate);
        rentalOffice.rentBikeIfSaldoOk("2", "EFG345678", startDate);
        rentalOffice.rentBikeIfSaldoOk("3", "HJK234567", startDate);
        rentalOffice.giveBackBikeWithPayment("1",endDate1);
        rentalOffice.giveBackBikeWithPayment("2",endDate2);

        System.out.println(client1.getSaldoClient());
        System.out.println(client2.getSaldoClient());

    }

    @Test
    public void rentBikeByOneClientTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 25.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 15.10);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 18.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        Date startDate2 = simpleDateFormat.parse("2019-10-22 18:25:34");
        //when
        rentalOffice.rentBikeByOneClient("1","ABC123456",startDate);
        rentalOffice.rentBikeByOneClient("2","ABC123456",startDate2);




    }

}