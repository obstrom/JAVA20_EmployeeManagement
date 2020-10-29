package employeeManagementSystem;

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

    protected Employee findHighestSalaryEmployee() {

        //Hämta alla instanserade employees
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        //Sparar anställd med högst lön
        Employee highestSalaryEmployee = null;
        double highestFoundSalary = 0;

        //Specificera salary
        for (Employee thisEmployee: allEmployees) {
            double salary = thisEmployee.getSalary();
            if ( salary > highestFoundSalary ) {
                highestSalaryEmployee = thisEmployee;
                highestFoundSalary = thisEmployee.getSalary();
            }
        }

        return highestSalaryEmployee;

    }

    protected Employee findLowestSalaryEmployee() {

        //Hämta alla instanserade employees
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        //Sparar anställd med lägst lön
        Employee lowestSalaryEmployee = null;
        double lowestFoundSalary = 0;

        //Specificera salary
        for (Employee thisEmployee: allEmployees) {
            double salary = thisEmployee.getSalary();
            if ( salary < lowestFoundSalary ) {
                lowestSalaryEmployee = thisEmployee;
                lowestFoundSalary = thisEmployee.getSalary();
            }
        }

        return lowestSalaryEmployee;

    }
}
