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

    public Rent(Client borrower, Bike borrowedBike, Date dateStart, Date dateEnd){
        this.borrower=borrower;
        this.borrowedBike=borrowedBike;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
    }

    public String toString(){
        return "BIKE ID: "+borrowedBike.getIdBikeNr()+" CLIENT: "+ borrower+" BORROW DATE: "+dateStart+ " DATE OF RETURN: "+dateEnd;
    }

    public long differenceDate(){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String date1 = String.valueOf(getDateStart());
//        String date2 = String.valueOf(getDateEnd());
//        Date d1 = null;
//        Date d2 = null;
//        try {
//            d1 = format.parse(date1);
//            d2 = format.parse(date2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return  (dateEnd.getTime()-dateStart.getTime())/(60*1000); //w minutach
    }

}