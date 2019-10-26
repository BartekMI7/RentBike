package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Bike {

    private String IdBikeNr;
    private int DateOfProduction;

    public String toString(){
        return "Bike ID: "+IdBikeNr+" Year: "+DateOfProduction;
    }

}
