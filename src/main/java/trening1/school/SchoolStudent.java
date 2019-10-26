package trening1.school;

public class SchoolStudent extends Student {
    private String schoolName;

    public SchoolStudent(){
    }

    public SchoolStudent(Student student, String schoolName){
        this.firstName=student.getFirstName();
        this.lastName=student.getLastName();
        this.pesel=student.getPesel();
        this.schoolName=schoolName;
    }

    public SchoolStudent(SchoolStudent schoolStudent){
        this.firstName=schoolStudent.getFirstName();
        this.lastName=schoolStudent.getLastName();
        this.pesel=schoolStudent.getPesel();
        this.schoolName=schoolStudent.getSchoolName();
    }



    public void setSchoolName(String schoolName){
        this.schoolName=schoolName;
    }

    public String getSchoolName(){
        return schoolName;
    }



}
