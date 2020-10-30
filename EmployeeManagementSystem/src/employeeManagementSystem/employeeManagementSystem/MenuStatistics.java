package employeeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStatistics implements Menu {
    static String boldTextStart = "\033[1m";
    static String regularTextStart = "\033[0m";
    static String newLine = "\n";

    public static void statisticsMenu() {

        while (true) {
            System.out.println("\033[1mEmployee Statistics\033[0m");
            System.out.println("1-Average wage at the company");
            System.out.println("2-Highest salary at the company");
            System.out.println("3-Lowest salary at the company");
            System.out.println("4-Total bonus");
            //System.out.println("5-Women in percentage in the company");
            //System.out.println("6-Men percentage of the various work role categories ");
            System.out.println("0-Back to main menu");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.contains("1") || userInput.contains("average")) {
                ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();
                int salarySum = 0;
                for (Employee employee: allEmployees) {
                    salarySum += employee.getSalary();
                }
                double averageSalary = (double) salarySum / allEmployees.size();
                System.out.println("Average salary in company is: " + averageSalary);
                continue;
            } else if (userInput.contains("2") || userInput.contains("highest")) {
                MenuStatistics statistics = new MenuStatistics();
                Employee employee = statistics.findHighestSalaryEmployee();
                System.out.println(employee.getFullName() + " has the highest salary with " + employee.getSalary());
                continue;
            } else if (userInput.contains("3") || userInput.contains("lowest")) {
                MenuStatistics statistics = new MenuStatistics();
                Employee employee = statistics.findLowestSalaryEmployee();
                System.out.println(employee.getFullName() + " has the lowest salary with " + employee.getSalary());
                continue;
            } else if (userInput.contains("4") || userInput.contains("bonus")) {
                ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();
                double totalBonusSum = 0.0;
                for (Employee employee: allEmployees) {
                    totalBonusSum += employee.getBonus();
                }
                System.out.println("Total bonus in company is: " + totalBonusSum);
                continue;
            }else if (userInput.contains("0") || userInput.contains("exit") || userInput.contains("quit")) {
                break;
            } else {
                System.out.println("Unknown input. Try again!\n");
            }

        }

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
