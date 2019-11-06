package trening1.school;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolStudentTest {
    @Test
    public void testConstructorSchoolStudent(){
        //given
        SchoolStudent givenSchoolStudent = new SchoolStudent();

        //when
        givenSchoolStudent.setFirstName("Bartek");
        givenSchoolStudent.setLastName("Klocek");
        givenSchoolStudent.setPesel("02070803628");
        givenSchoolStudent.setSchoolName("Staszic");

        //then
        assertEquals("Bartek",givenSchoolStudent.getFirstName());
        assertEquals("Klocek",givenSchoolStudent.getLastName());
        assertEquals("02070803628",givenSchoolStudent.getPesel());
        assertEquals("Staszic",givenSchoolStudent.getSchoolName());
    }
    @Test
    public void testConstructor2(){
        Student givenStudent = new Student("Bartosz","3a","02070803628");

    }


}