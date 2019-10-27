package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


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

    public String toString(){
        return "BIKE ID: "+borrowedBike.getIdBikeNr()+" CLIENT: "+ borrower+" BORROW DATE: "+dateStart;
    }
}