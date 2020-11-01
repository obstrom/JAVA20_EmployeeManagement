package employeeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStatistics {

    // Skapa variabler för strängformatering (normal och fetstil, nyrad)
    final static String boldTextStart = "\033[1m";
    final static String regularTextStart = "\033[0m";
    final static String newLine = "\n";

    public static void statisticsMenu() {

        while (true) {
            System.out.println(boldTextStart + "Employee Statistics" + regularTextStart);
            System.out.println("1-Average wage at the company");
            System.out.println("2-Highest salary at the company");
            System.out.println("3-Lowest salary at the company");
            System.out.println("4-Total bonus");
            //System.out.println("5-Women in percentage in the company");
            //System.out.println("6-Men percentage of the various work role categories ");
            System.out.println("0-Back to main menu");

            // Ta in text från användaren
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase(); // Omvandla input till lower case för jämförelse

            // Hantera input val
            if (userInput.equals("1") || userInput.contains("average")) {

                // Loop igenom alla användare och summera deras lön
                ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();
                int salarySum = 0;
                for (Employee employee: allEmployees) {
                    salarySum += employee.getSalary();
                }

                // Dela total summan av lönen med antalet Employees och skriv ut
                double averageSalary = (double) salarySum / allEmployees.size();
                System.out.println(newLine + "Average salary in company is: " + averageSalary + newLine);

            } else if (userInput.equals("2") || userInput.contains("highest")) {

                MenuStatistics statistics = new MenuStatistics();
                Employee employee = statistics.findHighestSalaryEmployee();
                System.out.println(newLine + employee.getFullName() + " has the highest salary with " + employee.getSalary() + " SEK" + newLine);

            } else if (userInput.equals("3") || userInput.contains("lowest")) {

                MenuStatistics statistics = new MenuStatistics();
                Employee employee = statistics.findLowestSalaryEmployee();
                System.out.println(newLine + employee.getFullName() + " has the lowest salary with " + employee.getSalary()  + " SEK" + newLine);

            } else if (userInput.equals("4") || userInput.contains("bonus")) {

                // Loop igenom alla användare och summeras deras bonus
                ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();
                double totalBonusSum = 0.0;
                for (Employee employee: allEmployees) {
                    totalBonusSum += employee.getBonus();
                }

                // Skriv ut total summan av bonusen
                System.out.println(newLine + "Total bonus in company is " + totalBonusSum + " SEK" + newLine);

            } else if (userInput.equals("0") || userInput.contains("exit") || userInput.contains("quit")) {
                break; // Gå tillbaka till start menu
            } else {
                System.out.println("Unknown input. Try again!\n");
            }

        }

    }

    // Metod för att hitta Employee med högst lön
    protected Employee findHighestSalaryEmployee() {

        // Hämta alla Employees som en ArrayList
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        // Skapa variabler för att hålla värden
        Employee highestSalaryEmployee = null;
        double highestFoundSalary = 0;

        // Loop igenom alla Employees
        // Om en lön hittas som är högre än tidigare högst hittad lön
        // Spara lönen och Employee
        for (Employee thisEmployee: allEmployees) {
            double salary = thisEmployee.getSalary();
            if ( salary > highestFoundSalary ) {
                highestSalaryEmployee = thisEmployee;
                highestFoundSalary = thisEmployee.getSalary();
            }
        }

        // Skicka tillbaka Employee-objekt med högst lön
        return highestSalaryEmployee;

    }

    // Metod för att hitta Employee med lägst lön
    protected Employee findLowestSalaryEmployee() {

        // Hämta alla Employees som en ArrayList
        ArrayList<Employee> allEmployees = EmployeeHandler.getAllEmployees();

        // Skapa variabel för att hålla hittad Employee
        Employee lowestSalaryEmployee = null;

        // Hämta lönen för den första Employee i listan
        // och använd det som start värde för lägst hittad lön
        double lowestFoundSalary = allEmployees.get(0).getSalary();

        // Loop igenom alla Employees
        // Om en lön hittas som är lägre än tidigare lägst hittad lön
        // Spara lönen och Employee
        for (Employee thisEmployee: allEmployees) {
            double salary = thisEmployee.getSalary();
            if ( salary < lowestFoundSalary ) {
                lowestSalaryEmployee = thisEmployee;
                lowestFoundSalary = thisEmployee.getSalary();
            }
        }

        // Skicka tillbaka Employee-objekt med lägst lön
        return lowestSalaryEmployee;

    }
}
