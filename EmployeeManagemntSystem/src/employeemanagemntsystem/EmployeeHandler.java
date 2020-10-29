package employeemanagemntsystem;

import java.util.ArrayList;

public class EmployeeHandler {
    private ArrayList<Employee> allEmployees = new ArrayList<Employee>();

    public void createNewEmployee(EmployeeCategory employeeCategory, int ID, String firstName, String lastName, int salary, Gender gender, String dateOfBirth, Department department) {
        switch (employeeCategory) {
            case MANAGER -> allEmployees.add(new Manager(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case TECHNICIAN -> allEmployees.add(new Technician(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case SECRETARY -> allEmployees.add(new Secretary(ID, firstName, lastName, salary, gender, dateOfBirth, department));
            case PROGRAMMER -> allEmployees.add(new Programmer(ID, firstName, lastName, salary, gender, dateOfBirth, department));
        }
    }

    public Employee findEmployee(int employeeID) {
        Employee returnObject = null;
        for (Employee employee: allEmployees) {
            if (employee.getID() == employeeID) {
                returnObject = employee;
            }
        }
        return returnObject;
    }

    public ArrayList<Employee> findEmployee(Department department) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: allEmployees) {
            if (employee.getDepartment() == department) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public ArrayList<Employee> findEmployee(String name) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: allEmployees) {
            if (employee.getFullName().toLowerCase().contains(name.toLowerCase())) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public ArrayList<Employee> findEmployee(Gender gender) {
        ArrayList<Employee> returnList = new ArrayList<Employee>();
        for (Employee employee: allEmployees) {
            if (employee.getGender() == gender) {
                returnList.add(employee);
            }
        }
        return returnList;
    }

    public void removeEmployee(Employee employee) {
        try {
            allEmployees.remove(employee);
            System.out.println(employee.getFullName() + " has been removed.");
        } catch (Exception e) {
            System.out.println("No employee to remove.");
        }
    }

}
