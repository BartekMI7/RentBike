package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter

public class Client {
    private String firstName;
    private String lastName;
    private String IdNumber;
    private double saldoClient;

    public String toString(){
        return firstName+ " " +lastName+ " " +IdNumber;
    }

    public void topUpAccount(double moneyAmount){
        setSaldoClient(getSaldoClient()+moneyAmount);
    }

}
