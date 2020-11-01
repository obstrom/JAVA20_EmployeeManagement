package employeeManagementSystem;

import java.util.Date;

// Sub-klass till Employee
public class Secretary extends Employee {
    private static final double BONUS = 0.03; // Bonus = +3%
    private static final EmployeeCategory CATEGORY = EmployeeCategory.SECRETARY; // Enum för att hantera SECRETARY som ett val

    // Konstruktor som tar in värden för sub-klassen och skickar upp dem till super-klassens konstruktor
    Secretary(int ID, String firstName, String lastName, int salary, Gender gender, Date dateOfBirth, Department department) {
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
    double getBonusPercentageDecimal() { return BONUS; }

    @Override
    EmployeeCategory getCategory() { return CATEGORY; }

}
