package employeeManagementSystem;

import java.util.Date;

public class Manager extends Employee {
    private static final double BONUS = 0.08;
    private static final EmployeeCategory CATEGORY = EmployeeCategory.MANAGER;

    Manager(int ID, String firstName, String lastName, int salary, Gender gender, Date dateOfBirth, Department department) {
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
    void updateBaseSalary(int newBaseSalary) {
        super.setBaseSalary(newBaseSalary);
    }

    @Override
    void updateGender(Gender newGender) {
        super.setGender(newGender);
    }

    @Override
    double getBonus() {
        return this.getBaseSalary() * BONUS;
    }

    @Override
    EmployeeCategory getCategory() { return this.CATEGORY; }

}
