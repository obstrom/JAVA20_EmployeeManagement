package employeemanagemntsystem;

public class Manager extends Employee {
    Manager(int ID, String firstName, String lastName, int salary, Gender gender, String dateOfBirth, Department department) {
        super(ID, firstName, lastName, salary, gender, dateOfBirth, department);
    }

    @Override
    void updateName(String firstName, String LastName) {
        super.setFirstName(firstName);
        super.setLastName(LastName);
    }

    @Override
    void updateDateOfBirth(String date) {
        super.setDateOfBirth(date);
    }

    @Override
    void updateDepartment(Department newDepartment) {
        super.setDepartment(newDepartment);
    }

    @Override
    void updateSalary(int newSalary) {
        super.setSalary(newSalary);
    }

    @Override
    void updateGender(Gender newGender) {
        super.setGender(newGender);
    }

    //hejhej
}
