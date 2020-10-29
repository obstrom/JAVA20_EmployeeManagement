package employeemanagemntsystem;

import java.util.ArrayList;

public class MenuStatistics implements Menu {

    @Override
    public String findEmployeeByName(String nameToFind) {
        return null;
    }

    @Override
    public int findEmployeeById(int idToFind) {
        return 0;
    }

    @Override
    public Department findEmployeeByDepartment(Department departmentToFind) {
        return null;
    }

    protected void salaryHighest() {

        //Hämta alla instanserade employees
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        //Sparar högsta lönen
        int maxNumber = 0;

        //Specificera salary
        for (Employee thisEmployee: allEmployees) {
            int salary = thisEmployee.getSalary();
            if ( salary > maxNumber ) {
                maxNumber = salary;
            }
        }

        System.out.println("The highest salary in the company is: " + maxNumber);

    }

    protected void salaryLowest() {

        //Hämta alla instanserade employees
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        //Sparar lägsta lönen
        int minNumber = 0;

        //Specificera salary
        for (Employee thisEmployee: allEmployees) {
            int salary = thisEmployee.getSalary();
            if ( salary < minNumber ) {
                minNumber = salary;
            }
        }

        System.out.println("The lowest salary in the company is: " + minNumber);
    }
}
