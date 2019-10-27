package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Bike {

    private String idBikeNr;
    private int dateOfProduction;



    public String toString(){
        return "Bike ID: "+idBikeNr+" Year: "+dateOfProduction;
    }

}
