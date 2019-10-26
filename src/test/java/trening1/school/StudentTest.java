package trening1.school;

import org.junit.Test;

import java.awt.geom.Path2D;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testConstructorPass(){
        //given
        Student givenStudent = new Student();


        //when
        givenStudent.setFirstName("Bartek");
        givenStudent.setLastName("Klocek");
        givenStudent.setPesel("02070803628");
        //

        assertEquals("Bartek",givenStudent.getFirstName());
        assertEquals("Klocek",givenStudent.getLastName());
        assertEquals("02070803628",givenStudent.getPesel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorFailed(){
        //given
        Student givenStudent = new Student();
        //when
        givenStudent.setFirstName("Bartek");
        givenStudent.setLastName("Klocek");
        givenStudent.setPesel("02070803624");
        //then
        assertFalse(true);
    }

    @Test
    public void testConstuctor2(){
        //given
        Student givenStudent = new Student("Bartosz", "Klocek", "02070803628");
        //when
        //than
        assertEquals("Bartosz",givenStudent.getFirstName());
        assertEquals("Klocek",givenStudent.getLastName());
        assertEquals("02070803628",givenStudent.getPesel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorStudentFailed(){
        //given
        Student givenStudent = new Student("Bartosz", "Klocek", "02070803626");
        //when
        //then
    }





}