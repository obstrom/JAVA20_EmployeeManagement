package employeeManagementSystem;

import java.util.ArrayList;

public class MenuStatistics implements Menu {

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

        // Get salary from first employee as a starting point
        double lowestFoundSalary = allEmployees.get(0).getSalary();

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
