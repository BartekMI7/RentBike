package trening1.rozne;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a","b","c","d","e");
        List<String> list2 = list1.stream().map(a-> a.toUpperCase()).collect(Collectors.toList());

        list2.stream().forEach(System.out::println);
        List<String> list3 = list1.stream().map(a-> a.toUpperCase()).collect(Collectors.toList());
        list3.stream().forEach(System.out::println);




    }


}
