package trening1.rozne.stream1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*

public class StaffPublic {

    private String name;
    private int age;
    private String extra;
    //...
}
 */
@Getter
@AllArgsConstructor
@Setter

public class StaffPublic {
    private String name;
    private int age;
    private String extra;

    public StaffPublic(){

    }

    public String toString(){
        return name+" "+age+" "+extra;
    }
}