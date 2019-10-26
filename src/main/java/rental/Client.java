package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Client {
    private String firstName;
    private String lastName;
    private String IdNumber;

    public String toString(){
        return firstName+ " " +lastName+ " " +IdNumber;
    }

}
