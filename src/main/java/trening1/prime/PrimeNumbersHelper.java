package trening1.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumbersHelper {

    public List<Integer> allNumbers() {
        List<Integer> listAllNumbers = new ArrayList<>();
        for (int i = 1 ; i<=10000 ; i++){
            listAllNumbers.add(i);
        }
        return listAllNumbers;
    }

    public List<Integer> primeNumbers(){
        List<Integer> listAllNumbers = new ArrayList<>();
        for (int i = 1 ; i<=10000 ; i++){
            listAllNumbers.add(i);
        }
        List<Integer> primeList = listAllNumbers
                .stream()
                .map(a-> {
                    List<Integer> tmp = new ArrayList<>();
                    for (int i=1; i<=10000;i++){
                        if (a%i==0){
                            tmp.add(i);
                        }
                    }
                    if (tmp.size()==2){
                        return a;
                    }
                    return null;
                })
                .filter(a->a!=null)
                .collect(Collectors.toList());
        return primeList;
    }
}
