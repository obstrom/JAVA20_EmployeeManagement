package employeeManagementSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
    private int ID;
    private String firstName;
    private String lastName;
    private int baseSalary;
    private Gender gender;
    private Date dateOfBirth;
    private Department department;

    public Employee(int ID, String firstName, String lastName, int baseSalary, Gender gender, Date dateOfBirth, Department department) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.gender = gender;
        this.department = department;
        this.dateOfBirth = dateOfBirth;

        /*try {
            this.dateOfBirth = new SimpleDateFormat("yy/MM/dd").parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

    public int getID() {
        return ID;
    }

    public Department getDepartment() {
        return department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public double getSalary() {
        return this.getBonus() + this.getBaseSalary();
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirthString) {
        try {
            this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // Abstrakta metoder
    abstract void updateName(String firstName, String LastName);
    abstract void updateDateOfBirth(String date);
    abstract void updateDepartment(Department newDepartment);
    abstract void updateBaseSalary(int newBaseSalary);
    abstract void updateGender(Gender newGender);
    abstract double getBonus();

}