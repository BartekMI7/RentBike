package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@AllArgsConstructor
@Setter

public class Rent {
    private Client borrower;
    private Bike borrowedBike;
    //private int borrowId; // ID wypozyczenia
    private Date dateStart;
    private Date dateEnd;
    private long dateDifference;

    public Rent(Client borrower, Bike borrowedBike, Date dateStart, Date dateEnd) {
        this.borrower = borrower;
        this.borrowedBike = borrowedBike;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String toString() {
        return "BIKE ID: " + borrowedBike.getIdBikeNr() + " CLIENT: " + borrower + " BORROW DATE: " + dateStart + " DATE OF RETURN: " + dateEnd;
    }

    public long differenceDateMinute() {
        return (dateEnd.getTime() - dateStart.getTime()) / (60 * 1000); //w minutach
    }

    public long differenceDateSecond() {
        return (dateEnd.getTime() - dateStart.getTime()) / (1000); //w sekundach
    }

    public long differenceDateHour() {
        return (dateEnd.getTime() - dateStart.getTime()) / (60 * 1000 * 60); //w godzinach
    }
    public long differenceDateDays() {
        return (dateEnd.getTime() - dateStart.getTime()) / (60 * 1000 * 60*24); //w dniach
    }


}