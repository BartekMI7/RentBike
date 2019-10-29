package rental;

import org.junit.Test;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class RentTest {
    String pattern = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @Test
    public void differenceDateMinuteTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 10.20);

        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.addClientToClientList(client1);
        //when
        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        Date endDate = simpleDateFormat.parse("2019-10-26 18:38:25");
        rentalOffice.rentBikeIfSaldoOk("1", "ABC123456", startDate);
        Rent rent = new Rent(client1, bike1, startDate, endDate);
        System.out.println(rent.differenceDateMinute());
        //when
        //then

    }

    @Test
    public void differenceDateHourTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 10.20);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.addClientToClientList(client1);
        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        Date endDate = simpleDateFormat.parse("2019-10-26 19:38:25");
        rentalOffice.rentBikeIfSaldoOk("1", "ABC123456", startDate);
        Rent rent = new Rent(client1, bike1, startDate, endDate);
        System.out.println(rent.differenceDateHour());
        //when
        //then
    }
    @Test
    public void differenceDateDaysTest() throws ParseException {
        //given
        RentalOffice rentalOffice = new RentalOffice();
        Bike bike1 = new Bike("1", 2016);
        Bike bike2 = new Bike("2", 2016);
        Bike bike3 = new Bike("3", 2016);
        Client client1 = new Client("Jan", "Kowalski", "ABC123456", 10.20);
        rentalOffice.addBikeToBikeList(bike1);
        rentalOffice.addBikeToBikeList(bike2);
        rentalOffice.addBikeToBikeList(bike3);
        rentalOffice.addClientToClientList(client1);
        Date startDate = simpleDateFormat.parse("2019-10-22 18:23:34");
        Date endDate = simpleDateFormat.parse("2019-10-26 19:38:25");
        rentalOffice.rentBikeIfSaldoOk("1", "ABC123456", startDate);
        Rent rent = new Rent(client1, bike1, startDate, endDate);
        System.out.println(rent.differenceDateDays());
        //when
        //then
    }

}