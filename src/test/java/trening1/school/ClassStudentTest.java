package trening1.school;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassStudentTest {
    @Test
    public void testConstructorClassStudent(){
        //given
        ClassStudent givenClassStudent = new ClassStudent();

        //when
        givenClassStudent.setFirstName("Bartosz");
        givenClassStudent.setLastName("Klocek");
        givenClassStudent.setPesel("02070803628");
        givenClassStudent.setSchoolName("Staszic");
        givenClassStudent.setClassNr("3a");

        //then
        assertEquals("Bartosz",givenClassStudent.getFirstName());
        assertEquals("Klocek",givenClassStudent.getLastName());
        assertEquals("02070803628",givenClassStudent.getPesel());
        assertEquals("Staszic",givenClassStudent.getSchoolName());
        assertEquals("3a",givenClassStudent.getClassNr());


    }

}