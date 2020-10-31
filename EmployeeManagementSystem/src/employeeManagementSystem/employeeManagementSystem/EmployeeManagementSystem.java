package employeeManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmployeeManagementSystem {

    // Skapa variabler för strängformatering (normal och fetstil, nyrad)
    static String boldTextStart = "\033[1m";
    static String regularTextStart = "\033[0m";
    static String newLine = "\n";

    public static void main(String[] args) {

        // Skapa några Employee för programmet
        // Hantera exception för att skapa datum objekt från String
        try {
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 1, "Oskar", "Haglund", 33333, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("91/06/05"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.TECHNICIAN, 2, "Tomas", "Gustavsson", 50000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("65/01/02"), Department.MANAGEMENT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.TECHNICIAN, 3, "Stina", "Malmqvist", 40000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("78/06/21"), Department.HR);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 4, "Robert", "Tegner", 45000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("81/04/15"), Department.HR);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 5, "Martin", "Tegner", 47000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("72/12/02"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.SECRETARY, 6, "Lisa", "Lundberg", 36000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("69/11/04"), Department.HR);
            EmployeeHandler.createNewEmployee(EmployeeCategory.SECRETARY, 7, "Eva", "Svensson", 33000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("45/09/11"), Department.MARKETING);
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 8, "Clas", "Larsson", 52000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("56/11/06"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 9, "Elise", "Pettersson", 45000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("78/05/03"), Department.ECONOMY);
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 10, "Kalle", "Ljungberg", 56000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("67/09/23"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.SECRETARY, 11, "Olle", "Klasson", 34000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("89/01/02"), Department.ECONOMY);
            EmployeeHandler.createNewEmployee(EmployeeCategory.TECHNICIAN, 12, "Lotta", "Gabrielsson", 48000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("78/03/12"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 13, "Charlotte", "Persson", 60000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("76/04/13"), Department.MANAGEMENT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 14, "Liselotte", "Berg", 56000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("65/05/14"), Department.MARKETING);
            EmployeeHandler.createNewEmployee(EmployeeCategory.TECHNICIAN, 15, "Sven", "Ström", 38000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("72/06/24"), Department.IT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.SECRETARY, 16, "Emma", "Lind", 37000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("91/12/05"), Department.MARKETING);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 17, "Oliver", "Sandberg", 62000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("73/02/02"), Department.ECONOMY);
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 18, "Patrik", "Wallin", 56000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("71/05/19"), Department.MANAGEMENT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 19, "Anna", "Eklund", 57000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("87/07/10"), Department.MANAGEMENT);
            EmployeeHandler.createNewEmployee(EmployeeCategory.TECHNICIAN, 20, "Linnea", "Holm", 24000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("96/10/23"), Department.ECONOMY);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 21, "Adam", "Söderberg", 34000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("81/09/23"), Department.MARKETING);
            EmployeeHandler.createNewEmployee(EmployeeCategory.PROGRAMMER, 22, "Ida", "Nordström", 45000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("67/04/16"), Department.ECONOMY);
            EmployeeHandler.createNewEmployee(EmployeeCategory.SECRETARY, 23, "Martin", "Tegner", 23000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("97/09/15"), Department.HR);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 24, "Lars", "Nyberg", 48000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("86/07/13"), Department.HR);
            EmployeeHandler.createNewEmployee(EmployeeCategory.MANAGER, 25, "Fia", "Viklund", 34000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("89/08/14"), Department.HR);
        } catch (ParseException e) {
            System.out.println("Invalid date format when creating new employees");
        }

        // Kör start menyn
        System.out.print(newLine);
        startMenu();

    }
        
    public static void startMenu() {
        while (true) {
        System.out.println(boldTextStart + "Welcome to Employee Management System." + regularTextStart);
        System.out.println("What do you want to do?");
        System.out.println("1-Employee management");
        System.out.println("2-Employee statistics");
        System.out.println("3-Exit program." + newLine);

            // Ta in text från användaren
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase(); // Omvandla input till lower case för jämförelse

            // Hantera input val
            if (userInput.contains("1") || userInput.contains("management")) {
                System.out.println("Management selected" + newLine);
                MenuEmployeeSystem.employeeMenu();
            } else if (userInput.contains("2") || userInput.contains("statistics")) {
                System.out.println("Statistics selected" + newLine);
                MenuStatistics.statisticsMenu();
            } else if (userInput.contains("3") || userInput.contains("exit") || userInput.contains("quit")) {
                break;
            } else { // Om ingen match hittas, visa felmeddelande
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }

    }

}
