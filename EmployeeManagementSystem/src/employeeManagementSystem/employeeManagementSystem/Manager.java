package employeeManagementSystem;

import java.util.Date;

// Sub-klass till Employee
public class Manager extends Employee {
    private static final double BONUS = 0.08; // Bonus = +8%
    private static final EmployeeCategory CATEGORY = EmployeeCategory.MANAGER; // Enum för att hantera Manager som ett val

    // Konstruktor som tar in värden för sub-klassen och skickar upp dem till super-klassens konstruktor
    Manager(int ID, String firstName, String lastName, int salary, Gender gender, Date dateOfBirth, Department department) {
        super(ID, firstName, lastName, salary, gender, dateOfBirth, department);
    }

    // :: METHODS
    // "Update" metoder som ropar på Super-klassens setter metoder
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

    // :: GETTERS
    @Override
    double getBonus() {
        return this.getBaseSalary() * BONUS;
    }

    @Override
    EmployeeCategory getCategory() { return CATEGORY; }

}
