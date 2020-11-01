package employeeManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuEmployeeSystem {

    // Skapa variabler för strängformatering (normal och fetstil, nyrad)
    final static String boldTextStart = "\033[1m";
    final static String regularTextStart = "\033[0m";
    final static String newLine = "\n";

    public static void employeeMenu() {

        while (true) {
            System.out.println(boldTextStart + "Employee management" + regularTextStart);
            System.out.println("1-Register new employee");
            System.out.println("2-Remove employee");
            System.out.println("3-Update employee");
            System.out.println("4-Search for employee");
            System.out.println("5-Display all employees");
            System.out.println("0-Back to main menu");

            // Ta in text från användaren
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase(); // Omvandla input till lower case för jämförelse

            if (userInput.equals("1") || userInput.contains("new")) {
                System.out.println(newLine + "Register new employee selected");

                // Hämta från användaren data om den nya Employee för alla attribut
                int id = getNewEmployeeID();
                String firstName = getNewEmployeeName("Enter employee first name: ");
                String lastName = getNewEmployeeName("Enter employee last name: ");
                int salary = getNewEmployeeSalary();
                Gender gender = getNewEmployeeGender();
                Date dateOfBirth = getNewEmployeeDateOfBirth();
                Department department = getNewEmployeeDepartment();
                EmployeeCategory category = getNewEmployeeCategory();

                // Skapa en ny Employee via Utility-klassen för Employee
                EmployeeHandler.createNewEmployee(category, id, firstName, lastName, salary, gender, dateOfBirth, department);

            } else if (userInput.equals("2") || userInput.contains("remove")) {

                System.out.println("Remove employee selected" + newLine);
                System.out.println(boldTextStart + "Remove employee" + regularTextStart);

                // Gå till dynamisk submenu för att välja Employee
                // Med handlingen att ta bort en Employee
                searchForEmployeeMenu(SearchOption.REMOVE); // Skicka in REMOVE enum som option

            } else if (userInput.equals("3") || userInput.contains("update")) {

                System.out.println("Update employee selected" + newLine);
                System.out.println(boldTextStart + "Update employee" + regularTextStart);

                // Gå till dynamisk submenu för att välja Employee
                // Med handlingen att uppdatera en Employee
                searchForEmployeeMenu(SearchOption.UPDATE); // Skicka in UPDATE enum som option

            } else if (userInput.equals("4") || userInput.contains("search")) {

                System.out.println("Search for employee selected" + newLine);
                System.out.println(boldTextStart + "Search for employee" + regularTextStart);

                // Gå till dynamisk submenu för att välja Employee
                // Med handlingen att granska en Employee
                searchForEmployeeMenu(SearchOption.SEARCH); // Skicka in SEARCH enum som option

            } else if (userInput.equals("5") || userInput.contains("display") || userInput.contains("all")) {

                System.out.println(newLine + "Display all employees selected");

                // Kör metod för att skriva ut en lista på alla Employees
                printAllEmployees();

            } else if (userInput.equals("0") || userInput.contains("exit") || userInput.contains("quit")) {
                break; // Gå tillbaka till start menu
            } else {
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }

    }

    // Metod för att skriva ut alla employees i systemet
    public static void printAllEmployees() {

        // Loop igenom alla Employee och skriv ut en lista på deras ID och namn
        for (Employee thisEmployee: EmployeeHandler.getAllEmployees()) {
            System.out.println("#" + thisEmployee.getID() + ". " + thisEmployee.getFullName());
        }
        System.out.print(newLine);

    }

    // Metod för att ta ett nytt ID från användaren
    public static int getNewEmployeeID() {

        int newID = 0; // Skapa start värde

        while (true) {

            // Ta input från användaren
            System.out.print("Enter employee ID: ");
            Scanner scan = new Scanner(System.in);

            try {
                // Försök att omvandla input till en int
                newID = Integer.parseInt(scan.nextLine());

                // Hämta ID för int och kolla om ID redan är taget
                if ( EmployeeHandler.findEmployee(newID) != null ) {
                    throw new ArrayStoreException(); // Om det är taget, skapa ett error
                }

            } catch (NumberFormatException e) { // Fånga error om input inte är en int
                System.out.println("ID needs to be a whole number. Try again!");
                continue;
            } catch (ArrayStoreException e) { // Fånga error om ID redan är taget
                System.out.println("ID is taken. Try again!");
                continue;
            }
            break;
        }
        return newID;

    }

    // Metod för att ta ett förnamn eller efternamn från användaren
    // Tar ett argument med texten som ska skrivas ut
    public static String getNewEmployeeName(String printMessage) {
        System.out.print(printMessage);

        // Ta input från användaren
        Scanner scan = new Scanner(System.in);
        String userInputFirstName = scan.nextLine();

        return userInputFirstName;
    }

    // Metod för att ta en ny grundlön från användaren
    public static int getNewEmployeeSalary() {
        int salary = 0; // Start värde
        while (true) {

            // Ta input från användaren
            System.out.print("Enter base salary: ");
            Scanner scan = new Scanner(System.in);

            try {
                // Försök att omvandla input till en int
                salary = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {  // Fånga error om input inte är en int
                System.out.println("Salary needs to be a whole number. Try again!");
                continue; // Börja om loopen från början
            }
            break;
        }
        return salary;
    }

    // Metod för att ta ett gender från användaren
    public static Gender getNewEmployeeGender() {
        Gender returnGender = null; // Start värde

        // Skriv ut valen
        System.out.println("Enter employee gender");
        System.out.println("1-Male");
        System.out.println("2-Female");
        System.out.println("3-Unspecified");

        Scanner scan = new Scanner(System.in);

        while (true) {
            // Ta input ifrån användaren
            String userInput = scan.nextLine().toLowerCase();

            // Kolla om input stämmer mot något av valen
            // Sätt isåfall start värde till valets korresponderande Gender enum keyword
            // Om det inte matchar något, ge om ny input och kör igen
            if (userInput.contains("1") || userInput.contains("male")) {
                returnGender = Gender.MALE;
                break;
            } else if (userInput.contains("2") || userInput.contains("female")) {
                returnGender = Gender.FEMALE;
                break;
            } else if (userInput.contains("3") || userInput.contains("unspecified")) {
                returnGender = Gender.UNSPECIFIED;
                break;
            } else {
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }

        return returnGender;
    }

    // Metod för att ta ett datum från användaren
    public static Date getNewEmployeeDateOfBirth() {
        Date returnDate = null; // Start värde
        while (true) {

            // Ta input ifrån användaren
            System.out.print("Enter employee date of birth (yy/mm/dd): ");
            Scanner scan = new Scanner(System.in);

            try {
                // Försök att omvandla input String till ett Date-objekt
                returnDate = new SimpleDateFormat("yy/MM/dd").parse(scan.nextLine());
                break;
            } catch (ParseException e) { // Formatet matchar inte ett datum för Date-objekt
                System.out.println("Date format is wrong. Try again!");
            }
        }
        return returnDate;
    }

    // Metod för att ta ett Department från användaren
    public static Department getNewEmployeeDepartment() {
        Department returnDepartment = null; // Start värde

        // Skriv ut valen
        System.out.println("Enter employee department");
        System.out.println("1-Management");
        System.out.println("2-Marketing");
        System.out.println("3-IT");
        System.out.println("4-Economy");
        System.out.println("5-HR");

        Scanner scan = new Scanner(System.in);

        while (true) {
            // Ta input från användaren
            String userInput = scan.nextLine().toLowerCase();

            // Kolla om input stämmer mot något av valen
            // Sätt isåfall start värde till valets korresponderande Gender enum keyword
            // Om det inte matchar något, ge om ny input och kör igen
            if (userInput.equals("1") || userInput.contains("management")) {
                returnDepartment = Department.MANAGEMENT;
                break;
            } else if (userInput.equals("2") || userInput.contains("marketing")) {
                returnDepartment = Department.MARKETING;
                break;
            } else if (userInput.equals("3") || userInput.contains("it")) {
                returnDepartment = Department.IT;
                break;
            } else if (userInput.equals("4") || userInput.contains("economy")) {
                returnDepartment = Department.ECONOMY;
                break;
            } else if (userInput.equals("5") || userInput.contains("hr")) {
                returnDepartment = Department.HR;
                break;
            } else {
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }

        return returnDepartment;
    }

    // Metod för att ta ett Category från användaren
    public static EmployeeCategory getNewEmployeeCategory() {
        EmployeeCategory returnCategory = null; // Start värde

        // Skriv ut valen
        System.out.println("Enter employee category");
        System.out.println("1-Manager");
        System.out.println("2-Programmer");
        System.out.println("3-Technician");
        System.out.println("4-Secretary");

        Scanner scan = new Scanner(System.in);

        while (true) {

            // Ta input från användaren
            String userInput = scan.nextLine().toLowerCase();

            // Kolla om input stämmer mot något av valen
            // Sätt isåfall start värde till valets korresponderande Gender enum keyword
            // Om det inte matchar något, ge om ny input och kör igen
            if (userInput.equals("1") || userInput.contains("manager")) {
                returnCategory = EmployeeCategory.MANAGER;
                break;
            } else if (userInput.equals("2") || userInput.contains("programmer")) {
                returnCategory = EmployeeCategory.PROGRAMMER;
                break;
            } else if (userInput.equals("3") || userInput.contains("technician")) {
                returnCategory = EmployeeCategory.TECHNICIAN;
                break;
            } else if (userInput.equals("4") || userInput.contains("secretary")) {
                returnCategory = EmployeeCategory.SECRETARY;
                break;
            } else {
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }

        return returnCategory;
    }

    // Metod för att hitta en Employee från ett ID
    // Skickar tillbaka null om ID inte finns
    public static Employee getEmployeeByIDFromInput() {
        Employee returnObject = null; // Start värde
        System.out.println(newLine + "Enter employee ID: ");
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                // Ta värde ifrån användaren
                String userInput = scan.nextLine();

                // Försök omvandla input till int
                int inputID = Integer.parseInt(userInput);

                // Ropa på getter som tar ett ID och skriv över start värdet
                // Värdet förblir null om ID inte finns
                returnObject = EmployeeHandler.findEmployee(inputID);
                break;
            } catch (NumberFormatException e) { // Error om input inte är en int
                System.out.println("ID needs to be a whole number! Try again");
            }
        }

        return returnObject;
    }

    // Metod för att hitta en Employee från ett för- eller efternamn
    // Skickar tillbaka null om ingen match hittas
    public static Employee getEmployeeByNameFromInput() {
        Employee returnObject = null; // Start värde
        System.out.println("\nEnter employees exact name: ");
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Ta värde ifrån användaren
            String userInput = scan.nextLine();

            // Ropa på getter som tar delar av ett namn och skickar tillbaka en ArrayList med alla matchningar
            // Listan blir tomm om ingen match hittades
            ArrayList<Employee> resultList = EmployeeHandler.findEmployee(userInput);

            // Kolla om listan är tomm
            if (resultList.isEmpty()) {
                // Tomm lista. Skriv ut felmeddelande och börja om
                System.out.println("No employee found! Try again");
            } else {
                // Listan innehåller en eller flera Employee-objekt
                // Skicka tillbaka första Employee-objektet i listan
                returnObject = resultList.get(0);
                break;
            }
        }

        return returnObject;
    }

    // Dynamisk metod för att hitta en Employee baserat på ID eller Namn
    // Används av Remove, Update och Search for employee
    // Tar ett argument för vilken handling (Remove, Update, Search) som ska tas
    public static void searchForEmployeeMenu(SearchOption option) {
        System.out.println("1-Find employee by ID");
        System.out.println("2-Find employee by exact name");

        Scanner scan = new Scanner(System.in);

        while (true) {
            // Ta input från användaren
            String userInput = scan.nextLine().toLowerCase();

            // Kolla om input stämmer mot något av valen
            if (userInput.equals("1") || userInput.contains("id")) {

                // Hämta employee-objektet med ID
                Employee employee = getEmployeeByIDFromInput();

                // Skriv ut namnet på Employee som valts
                System.out.println(employee.getFullName() + " has been selected." + newLine);

                // Skicka vidare meny val och Employee-objekt till nästa metod
                searchForEmployeeMenuAction(option, employee);
                break;
            } else if (userInput.equals("2") || userInput.contains("name")) {

                // Hämta första employee-objekt med namn som matchar
                Employee employee = getEmployeeByNameFromInput();

                // Skriv ut namnet på Employee som valts
                System.out.println(employee.getFullName() + " has been selected." + newLine);

                // Skicka vidare meny val och Employee-objekt till nästa metod
                searchForEmployeeMenuAction(option, employee);
                break;
            } else {
                System.out.println("Unknown input. Try again!" + newLine);
            }
        }
    }

    // Dynamisk metod för att visa meny för Remove, Update eller Search for Employee
    // Tar meny val (enum keyword) och Employee-objekt från föregående metod
    public static void searchForEmployeeMenuAction(SearchOption option, Employee employee) {

        // Switch som ropar på rätt meny metod
        // Tar enum keyword för menyval
        switch (option) {
            case REMOVE: {
                // Ta bort Employee-objekt från ArrayListan med alla employees
                EmployeeHandler.removeEmployee(employee);
            }
            case UPDATE: {
                // Ropa på metod för "update employee" menyn
                // Skickar vidare vald Employee-objekt
                updateEmployeeMenu(employee);
                break;
            }
            case SEARCH: {
                // Ropa på metod för "search for employee" menyn
                // Skickar vidare vald Employee-objekt
                employeeDisplayMenu(employee);
                break;
            }
        }
    }

    // Metod för menyn "Update employee"
    // Tar vald Employee som ska uppdateras som ett argument
    public static void updateEmployeeMenu(Employee employee) {

        updateMenuLoop: // Keyword för att kunna break nested-loop meny
        while (true) {
            System.out.println(newLine + boldTextStart + "Select action" + regularTextStart);
            System.out.println("1-Update ID");
            System.out.println("2-Update first name");
            System.out.println("3-Update last name");
            System.out.println("4-Update gender");
            System.out.println("5-Update date of birth");
            System.out.println("6-Update base salary");
            System.out.println("7-Update department");
            System.out.println("0-Return to Employee Management menu");

            Scanner scan = new Scanner(System.in);

            while (true) {
                // Ta input från användaren
                String userInput = scan.nextLine().toLowerCase();

                // Kolla om input stämmer mot något av valen
                if (userInput.equals("1") || userInput.contains("id")) {

                    // Ropa på metod för att fråga användaren efter ett ID
                    int newID = getNewEmployeeID();

                    // Sätt nytt ID för vald Employee
                    employee.setID(newID);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + "'s ID has been updated to " + newID);
                    break;
                } else if (userInput.equals("2") || userInput.contains("first name")) {

                    // Ropa på metod för att fråga användaren efter ett förnamn
                    String newFirstName = getNewEmployeeName("\"Enter employee first name: \"");

                    // Sätt nytt förnamn för vald Employee
                    employee.setFirstName(newFirstName);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + " name has been updated.");
                    break;
                } else if (userInput.equals("3") || userInput.contains("last name")) {

                    // Ropa på metod för att fråga användaren efter ett förnamn
                    String newLastName = getNewEmployeeName("Enter employee last name: ");

                    // Sätt nytt förnamn för vald Employee
                    employee.setFirstName(newLastName);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + " name has been updated.");
                    break;
                } else if (userInput.equals("4") || userInput.contains("gender")) {

                    // Ropa på metod för att fråga användaren efter ett Gender
                    Gender newGender = getNewEmployeeGender();

                    // Sätt nytt Gender för vald Employee
                    employee.setGender(newGender);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + " gender has been changed to " + newGender);
                    break;
                } else if (userInput.equals("5") || userInput.contains("date of birth")) {

                    // Ropa på metod för att fråga användaren efter ett Date of Birth
                    Date newDateOfBirth = getNewEmployeeDateOfBirth();

                    // Sätt nytt Date of Birth för vald Employee
                    employee.setDateOfBirth(newDateOfBirth);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + " date of birth has been changed to " + employee.getDateOfBirthString());
                    break;
                } else if (userInput.equals("6") || userInput.contains("salary")) {

                    // Ropa på metod för att fråga användaren efter en ny grundlön
                    int newBaseSalary = getNewEmployeeSalary();

                    // Sätt nytt grundlön för vald Employee
                    employee.setBaseSalary(newBaseSalary);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + "'s base salary is now " + employee.getBaseSalary());
                    break;
                } else if (userInput.equals("7") || userInput.contains("department")) {

                    // Ropa på metod för att fråga användaren efter en ny Department
                    Department newDepartment = getNewEmployeeDepartment();

                    // Sätt ny Department för vald Employee
                    employee.setDepartment(newDepartment);

                    // Bekräfta ändringen och gå tillbaka
                    System.out.println(employee.getFullName() + " department changed to " + employee.getDepartment());
                    break;
                } else if (userInput.equals("0") || userInput.contains("return") || userInput.contains("exit")) {
                    break updateMenuLoop; // Break nested-loop, gå tillbaka till Employee Management menyn
                } else {
                    System.out.println("Unknown input. Try again!" + newLine); // Ingen match
                }
            }
        }
    }

    // Metod för menyn "Search employee"
    // Tar vald Employee och visar all relevant data
    public static void employeeDisplayMenu(Employee employee) {

        // Hämta data från vald Employee och skriv ut
        System.out.println("Name: " + employee.getFullName());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Date of birth: " + employee.getDateOfBirthString());
        System.out.println("ID: " + employee.getID());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Category: " + employee.getCategory());
        System.out.println("Salary: " + employee.getSalary() + " SEK (inkl. bonus)");
        System.out.println("Bonus: " + employee.getBonus() + " SEK (+" + employee.getBonusPercentageDecimal() * 100 + "%)" + newLine);

    }

}
