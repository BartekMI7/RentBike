package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@Setter

public class Client {
    private String firstName;
    private String lastName;
    private String idNumber;
    private BigDecimal saldoClient;

    public Client(String firstName, String lastName, String idNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.idNumber=idNumber;
    }

    public String toString(){
        return firstName+ " " +lastName+ " " +idNumber;
    }

    public void topUpAccount(BigDecimal moneyAmount){
        setSaldoClient(getSaldoClient().add(moneyAmount));



    }

}
