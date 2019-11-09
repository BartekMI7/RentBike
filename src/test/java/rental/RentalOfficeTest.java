package rental;

import lombok.ToString;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        String bikeList1 = rentalOffice.toString();
        //List<Bike> list1 = new ArrayList<>();
        //when
        //then
        System.out.println(bikeList1);
        //rentalOffice.printBikeList();
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
        Date endDate = simpleDateFormat.parse("2019-10-23 11:44:13");
        rentalOffice.rentBike("3", "ABC123456", startDate1);
        rentalOffice.rentBike("2", "EFG345678", startDate2);
        rentalOffice.rentBike("1", "HJK234567", startDate2);
        rentalOffice.giveBackBike("3", endDate);
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
        rentalOffice.giveBackBike("1", endDate);
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
        rentalOffice.giveBackBikeWithPayment("1", endDate1);
        rentalOffice.giveBackBikeWithPayment("2", endDate2);

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
        rentalOffice.rentBikeByOneClient("1", "ABC123456", startDate);
        rentalOffice.rentBikeByOneClient("2", "HJK234567", startDate2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rentBikeByOneClientTestException() throws ParseException {
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
        rentalOffice.rentBikeByOneClient("1", "ABC123456", startDate);
        rentalOffice.rentBikeByOneClient("2", "ABC123456", startDate2);
    }

    @Test
    public void topUpAccountTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 25.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 15.10);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 18.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        //when
        rentalOffice.topUpAccount("ABC123456", 10.4);
        rentalOffice.topUpAccount("EFG345678", 12.0);
        rentalOffice.topUpAccount("HJK234567", 5.0);
        //then
        assertEquals(Double.valueOf(35.6), Double.valueOf(client1.getSaldoClient()));
        assertEquals(Double.valueOf(27.10), Double.valueOf(client2.getSaldoClient()));
        assertEquals(Double.valueOf(23.45), Double.valueOf(client3.getSaldoClient()));
    }

    @Test
    public void toStringBikeListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2017);
        //then
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);

        String list1 = rentalOffice.toStringBikeList();
        //when
        //then
        assertEquals("1 2016\n" +
                        "2 2016\n" +
                        "3 2017\n",
                list1);
    }

    @Test
    public void toStringClientListTest() {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 25.20);
        Client client2 = new Client("Andrzej", "Paz", "EFG345678", 15.10);
        Client client3 = new Client("Jan", "Nowak", "HJK234567", 18.45);
        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        String list1 = rentalOffice.toStringClientList();
        //when
        //then
        assertEquals("Jan Kowalski ABC123456 25.2\n" +
                "Andrzej Paz EFG345678 15.1\n" +
                "Jan Nowak HJK234567 18.45\n", list1);
    }

    @Test
    public void toStringActualRentList() throws ParseException {
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
        rentalOffice.rentBike("3", "HJK234567", startDate1);
        rentalOffice.giveBackBike("1", endDate);

        String list1 = rentalOffice.toStringActualRentList();
        //when
        //then
        assertEquals("BIKE ID: 2 CLIENT: Andrzej Paz EFG345678 0.0 BORROW DATE: Tue Oct 22 11:24:23 CEST 2019 DATE OF RETURN: null\n" +
                "BIKE ID: 3 CLIENT: Jan Nowak HJK234567 0.0 BORROW DATE: Tue Oct 22 10:30:23 CEST 2019 DATE OF RETURN: null\n", list1);

    }

    @Test
    public void saveClientListToFileTest() throws FileNotFoundException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Client client1 = new Client("Jan", "Kowalski", "ABC123456");
        Client client2 = new Client("Andrzej", "Paz", "EFG345678");
        Client client3 = new Client("Jan", "Nowak", "HJK234567");

        rentalOffice.addClientToClientList(client1);
        rentalOffice.addClientToClientList(client2);
        rentalOffice.addClientToClientList(client3);
        rentalOffice.topUpAccount("ABC123456", 15.9);
        rentalOffice.saveClientListToFile();
        //when
        //then
    }

    @Test
    public void readClientListFromFile() throws FileNotFoundException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        //when
        //then
        rentalOffice.readClientListFromFile();
        rentalOffice.printClientList();


    }

    @Test
    public void saveBikeListToFile() throws FileNotFoundException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1",2018);
        Bike bike2 = new Bike("2",2018);
        Bike bike3 = new Bike("3",2019);
        Bike bike4 = new Bike("4",2019);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.addBikeToBikeList(bike4);
        rentalOffice.saveBikeListToFile();
        //when
        //then
    }


}