package trening1.rozne.stream1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main2 {
    public static void main(String[] args) {

        //even numbers from 1-10;
       IntStream.range(1,10).filter(a->a%2==0).forEach(a->System.out.println(a));

        System.out.println("- - - - - - - - -");

        List<Integer> list1 =  IntStream.range(1,10).filter(a->a%2==0&& a>5).boxed().collect(Collectors.toList());
        System.out.println(list1);
    }
}
