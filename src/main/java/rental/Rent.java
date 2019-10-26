package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@Getter
@AllArgsConstructor

public class Rent {
    private Client clientBorrowBike;
    private Bike BorrowedBike;
    private int IdBorrowedBike; // ID wypozyczenia
    private Date dateStart;
    private Date dateEnd;
}