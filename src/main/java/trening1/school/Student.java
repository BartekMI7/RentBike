package trening1.school;

import trening1.Validators.PeselValidator;

public class Student {
    protected String firstName;
    protected String lastName;
    protected String pesel;

    public Student(){

    }

    public Student(String firstName, String lastName, String pesel){
        this.firstName=firstName;
        this.lastName=lastName;
        setPesel(pesel);

    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        PeselValidator peselValidator = new PeselValidator();
        boolean validate = peselValidator.validate(pesel);
        if (validate){
            this.pesel = pesel;
        }
        else {
            throw new IllegalArgumentException("Niepoprawny pesel");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }
}
