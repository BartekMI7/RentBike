package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
@Setter

public class Client {
    private String firstName;
    private String lastName;
    private String idNumber;
    //private BigDecimal saldoClient;
    private double saldoClient;

    public Client(String firstName, String lastName, String idNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.idNumber=idNumber;
    }

    public String toString(){
        return firstName+ " " +lastName+ " " +idNumber;
    }

    public void topUpAccount(double moneyAmount){
        setSaldoClient(getSaldoClient()+moneyAmount);
    }


    //public void topUpAccount(BigDecimal moneyAmount){
        //setSaldoClient(getSaldoClient().add(moneyAmount));
        //BigDecimal a = new BigDecimal(String.valueOf(getSaldoClient()));
        //setSaldoClient(a.round(new MathContext(4,RoundingMode.HALF_UP)));
   // }

}
