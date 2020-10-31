package employeeManagementSystem;

import java.util.ArrayList;
import java.util.Date;

// Utility eller Helper-klass för Employee som bara innehåller statiska attribut och metoder.
public class EmployeeHandler {
    // ArrayList för att lagra alla nuvarande Employees.
    // Listan uppdateras när Employees tas bort och läggs till.
    static final ArrayList<Employee> ALL_EMPLOYEES = new ArrayList<Employee>();

    // Metod för att skapa en ny Employee som även tar en Enum
    // för vilken category (subklass av Employee) som ska skapas
    static void createNewEmployee(EmployeeCategory employeeCategory, int ID, String firstName, String lastName, int salary, Gender gender, Date dateOfBirth, Department department) {
        switch (employeeCategory) {
            case MANAGER:
                ALL_EMPLOYEES.add(new Manager(ID, firstName, lastName, salary, gender, dateOfBirth, department));
                break;
            case TECHNICIAN:
                ALL_EMPLOYEES.add(new Technician(ID, firstName, lastName, salary, gender, dateOfBirth, department));
                break;
            case SECRETARY:
                ALL_EMPLOYEES.add(new Secretary(ID, firstName, lastName, salary, gender, dateOfBirth, department));
                break;
            case PROGRAMMER:
                ALL_EMPLOYEES.add(new Programmer(ID, firstName, lastName, salary, gender, dateOfBirth, department));
                break;
        }
    }

    // Getter för ArrayList med alla Employees
    static ArrayList<Employee> getAllEmployees() {
        return ALL_EMPLOYEES;
    }

    // :: FIND EMPLOYEE METHODS
    // Method Overloading av för att hitta Employee i ArrayList
    // utifrån olika inputs (ID, Department, Name, Gender)
    static Employee findEmployee(int employeeID) {
        Employee returnObject = null;
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getID() == employeeID) {
                returnObject = employee;
            }
        }
        return returnObject;
    }

    static ArrayList<Employee> findEmployee(Department department) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getDepartment() == department) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    static ArrayList<Employee> findEmployee(String name) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getFullName().toLowerCase().contains(name.toLowerCase())) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    static ArrayList<Employee> findEmployee(Gender gender) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getGender() == gender) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    // :: REMOVE EMPLOYEE
    // Tar ett Employee objekt som argument och försöker
    // ta bort den ifrån ArrayList med alla Employees
    static void removeEmployee(Employee employee) {
        try {
            ALL_EMPLOYEES.remove(employee);
            System.out.println(employee.getFullName() + " has been removed.");
        } catch (Exception e) {
            System.out.println("No employee to remove.");
        }
    }
}
