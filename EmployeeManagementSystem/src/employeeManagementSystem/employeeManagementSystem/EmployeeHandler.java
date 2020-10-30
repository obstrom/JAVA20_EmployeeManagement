package employeeManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeHandler {
    static final ArrayList<Employee> ALL_EMPLOYEES = new ArrayList<Employee>();

    static void createNewEmployee(EmployeeCategory employeeCategory, int ID, String firstName, String lastName, int salary, Gender gender, Date dateOfBirth, Department department) {
        switch (employeeCategory) {
            case MANAGER -> ALL_EMPLOYEES.add(new Manager(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case TECHNICIAN -> ALL_EMPLOYEES.add(new Technician(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case SECRETARY -> ALL_EMPLOYEES.add(new Secretary(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case PROGRAMMER -> ALL_EMPLOYEES.add(new Programmer(ID, firstName, lastName, salary, gender, dateOfBirth, department));
        }
    }

    static ArrayList<Employee> getAllEmployees() {
        return ALL_EMPLOYEES;
    }

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

    static void removeEmployee(Employee employee) {
        try {
            ALL_EMPLOYEES.remove(employee);
            System.out.println(employee.getFullName() + " has been removed.");
        } catch (Exception e) {
            System.out.println("No employee to remove.");
        }
    }
}
