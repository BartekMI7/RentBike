package trening1.school;

public class ClassStudent extends SchoolStudent{

    private String classNr;

    public ClassStudent(){
    }

    public ClassStudent(String classNr,SchoolStudent schoolStudent){
        super(schoolStudent);
        this.classNr=classNr;
    }

    public String getClassNr() {
        return classNr;
    }

    public void setClassNr(String classNr) {
        this.classNr = classNr;
    }
}
