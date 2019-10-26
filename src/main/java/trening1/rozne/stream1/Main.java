package trening1.rozne.stream1;

/*
 new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
 */

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Staff> result = Arrays.asList(
                new Staff("mkyoung", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );
        /*
        List<String> result1 = result
                .stream()
                .map(a -> a.getName())
                .collect(Collectors.toList());
        result1.stream().forEach(a-> System.out.println(a));
        System.out.println(" - - - - - - - - ");
*/

        List<StaffPublic> result2 =result
                .stream()
                .map(a->{
                    StaffPublic staffPublic1 = new StaffPublic();
                    staffPublic1.setName(a.getName());
                    staffPublic1.setAge(a.getAge());
                    if ("mkyoung".equals(a.getName())){
                        staffPublic1.setExtra("ZASTRZEZONE!");
                    }
                    return staffPublic1;
                }).collect(Collectors.toList());

        result2.stream().forEach(a-> System.out.println(a));
    }
}
