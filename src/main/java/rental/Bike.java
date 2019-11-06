package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Bike {

    private String idBikeNr;
    private int dateOfProduction;



    public String toString(){
        return idBikeNr+" "+dateOfProduction;
    }

}
