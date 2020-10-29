package employeeManagementSystem;

import java.util.ArrayList;

public class EmployeeHandler {
    static private final ArrayList<Employee> ALL_EMPLOYEES = new ArrayList<Employee>();

    public void createNewEmployee(EmployeeCategory employeeCategory, int ID, String firstName, String lastName, int salary, Gender gender, String dateOfBirth, Department department) {
        switch (employeeCategory) {
            case MANAGER -> ALL_EMPLOYEES.add(new Manager(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case TECHNICIAN -> ALL_EMPLOYEES.add(new Technician(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case SECRETARY -> ALL_EMPLOYEES.add(new Secretary(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case PROGRAMMER -> ALL_EMPLOYEES.add(new Programmer(ID, firstName, lastName, salary, gender, dateOfBirth, department));
        }
    }

    public static ArrayList<Employee> getAllEmployees() {
        return ALL_EMPLOYEES;
    }

    public static Employee findEmployee(int employeeID) {
        Employee returnObject = null;
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getID() == employeeID) {
                returnObject = employee;
            }
        }
        return returnObject;
    }

    public static ArrayList<Employee> findEmployee(Department department) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getDepartment() == department) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public static ArrayList<Employee> findEmployee(String name) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getFullName().toLowerCase().contains(name.toLowerCase())) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public static ArrayList<Employee> findEmployee(Gender gender) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: ALL_EMPLOYEES) {
            if (employee.getGender() == gender) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public void removeEmployee(Employee employee) {
        try {
            ALL_EMPLOYEES.remove(employee);
            System.out.println(employee.getFullName() + " has been removed.");
        } catch (Exception e) {
            System.out.println("No employee to remove.");
        }
    }

}
