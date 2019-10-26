package rental;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RentalOfficeTest {
    @Test
    public void addClientToClientListTest(){
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
       assertEquals(3,rentalOffice1.getClientList().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addClientToClientListTestExceptionTest(){
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
        assertEquals(2,rentalOffice1.getClientList().size());
    }



    @Test
    public void removeClientFromClientListTest(){
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
        assertEquals(2,rentalOffice1.getClientList().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeClientFromClientListExceptionTest(){
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
    public void addBikeToBikeListTest(){
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
        assertEquals(3,rentalOffice.getBikeList().size());

    }

    @Test (expected = IllegalArgumentException.class)
    public void addBikeToBikeListExceptionTest(){
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
        assertEquals(3,rentalOffice.getBikeList().size());


    }

    @Test
    public void removeBikeFromBikeListTest(){
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
        assertEquals(2,rentalOffice.getBikeList().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeBikeFromBikeListExceptionTest(){
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
    public void printClientListTest(){
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
    public void printBikeListTest(){
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

}