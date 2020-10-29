package employeeManagementSystem;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static EmployeeHandler handler = new EmployeeHandler();

    public static void main(String[] args) {
        try {
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 1, "Oscar", "Bergström", 33333, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("91/06/05"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 2, "Tomas", "Gustavsson", 50000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("65/01/02"), Department.MANAGEMENT);
            handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 3, "Stina", "Malmqvist", 40000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("78/06/21"), Department.HR);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 4, "Robert", "Tegner", 45000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("81/04/15"), Department.HR);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 5, "Martin", "Tegner", 47000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("72/12/02"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.SECRETARY, 6, "Lisa", "Lundberg", 36000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("69/11/04"), Department.HR);
            handler.createNewEmployee(EmployeeCategory.SECRETARY, 7, "Eva", "Svenssonr", 33000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("45/09/11"), Department.MARKETING);
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 8, "Clas", "Larsson", 52000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("56/11/06"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 9, "Elise", "Pettersson", 45000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("78/05/03"), Department.ECONOMY);
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 10, "Kalle", "Ljungberg", 56000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("67/09/23"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.SECRETARY, 11, "Olle", "Klasson", 34000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("89/01/02"), Department.ECONOMY);
            handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 12, "Lotta", "Gabrielsson", 48000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("78/03/12"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 13, "Charlotte", "Persson", 60000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("76/04/13"), Department.MANAGEMENT);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 14, "Liselotte", "Berg", 56000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("65/05/14"), Department.MARKETING);
            handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 15, "Sven", "Ström", 38000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("72/06/24"), Department.IT);
            handler.createNewEmployee(EmployeeCategory.SECRETARY, 16, "Emma", "Lind", 37000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("91/12/05"), Department.MARKETING);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 17, "Oliver", "Sandberg", 62000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("73/02/02"), Department.ECONOMY);
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 18, "Patrik", "Wallin", 56000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("71/05/19"), Department.MANAGEMENT);
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 19, "Anna", "Eklund", 57000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("87/07/10"), Department.MANAGEMENT);
            handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 20, "Linnea", "Holm", 24000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("96/10/23"), Department.ECONOMY);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 21, "Adam", "Söderberg", 34000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("81/09/23"), Department.MARKETING);
            handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 22, "Ida", "Nordström", 45000, Gender.FEMALE, new SimpleDateFormat("yy/MM/dd").parse("67/04/16"), Department.ECONOMY);
            handler.createNewEmployee(EmployeeCategory.SECRETARY, 23, "Martin", "Tegner", 23000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("97/09/15"), Department.HR);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 24, "Lars", "Nyberg", 48000, Gender.MALE, new SimpleDateFormat("yy/MM/dd").parse("86/07/13"), Department.HR);
            handler.createNewEmployee(EmployeeCategory.MANAGER, 25, "Fia", "Viklund", 34000, Gender.UNSPECIFIED, new SimpleDateFormat("yy/MM/dd").parse("89/08/14"), Department.HR);
        } catch (ParseException e) {
            System.out.println("Date format wrong!");
        }
        /*Employee employee2 = handler.findEmployee(2);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date employeeBirthday = employee2.getDateOfBirth();
        System.out.println("Tomas = " + dateFormat.format(employeeBirthday));

        ArrayList<Employee> tegnerEmployees = handler.findEmployee("tegner");
        for (Employee thisEmployee: tegnerEmployees) {
            System.out.println(thisEmployee.getFirstName() + " är en Tegner");
        }*/

        /*for (Employee thisEmployee: EmployeeHandler.getAllEmployees()) {
            System.out.println(thisEmployee.getFullName() + " har lönen: " + thisEmployee.getSalary());
        }*/

        /*MenuStatistics statistics = new MenuStatistics();
        Employee hasHighestSalary = statistics.findHighestSalaryEmployee();
        System.out.println(hasHighestSalary.getFullName() + " har den högsta lönen med " + hasHighestSalary.getSalary() + " kr.");*/

        startMenu();

    }
        
    public static void startMenu() {
        while (true) {
        System.out.println("\n\033[1mWelcome to Employee Management System.\033[0m");
        System.out.println("What do you want to do?");
        System.out.println("1-Employee management");
        System.out.println("2-Employee statistics");
        System.out.println("3-Exit program.\n");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.contains("1") || userInput.contains("management")) {
                System.out.println("Management selected\n");
                EmployeeMenu();
                continue;
            } else if (userInput.contains("2") || userInput.contains("statistics")) {
                // Skapa ny "MenuStatistics" class
                // Visa meny för den (loop) - break ut
                System.out.println("Statistics selected\n");
                continue;
            } else if (userInput.contains("3") || userInput.contains("exit") || userInput.contains("quit")) {
                break;
            } else {
                System.out.println("Unknown input. Try again!\n");
            }
        }

    }

    public static void EmployeeMenu() {

        while (true) {
            System.out.println("\n\033[1mEmployee management\033[0m");
            System.out.println("1-Register new employee");
            System.out.println("2-Remove employee");
            System.out.println("3-Update employee");
            System.out.println("4-Search for employee");
            System.out.println("5-Display all employees");
            System.out.println("0-Back to main menu");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.contains("1") || userInput.contains("new")) {
                // Skapa en ny meny för att ta all information för ny Employee
                // Skapa en ny employee och lägg i Arraylistan
                System.out.println("\nRegister new employee selected");

                // Hämta info ifrån användaren om den nya Employee
                int id = getNewEmployeeID();
                String[] name = getNewEmployeeName();
                int salary = getNewEmployeeSalary();
                Gender gender = getNewEmployeeGender();
                Date dateOfBirth = getNewEmployeeDateOfBirth();
                Department department = getNewEmployeeDepartment();
                EmployeeCategory category = getNewEmployeeCategory();

                // Skapa ny Employee
                EmployeeHandler.createNewEmployee(category, id, name[0], name[1], salary, gender, dateOfBirth, department);

                continue;
            } else if (userInput.contains("2") || userInput.contains("remove")) {
                // Gå till meny för att välja Employee
                // Ta bort den Employee
                System.out.println("Remove employee selected\n");
                continue;
            } else if (userInput.contains("3") || userInput.contains("update")) {
                // Gå till meny för att välja Employee
                // Visa meny för att uppdatera Employee
                System.out.println("Update employee selected\n");
                continue;
            } else if (userInput.contains("4") || userInput.contains("search")) {
                // Gå till meny för att sök efter en/flera Employee
                System.out.println("Search for employee selected\n");
                continue;
            } else if (userInput.contains("5") || userInput.contains("display") || userInput.contains("all")) {
                System.out.println("\nDisplay all employees selected");
                printAllEmployees();
                continue;
            } else if (userInput.contains("0") || userInput.contains("exit") || userInput.contains("quit")) {
                break;
            } else {
                System.out.println("Unknown input. Try again!\n");
            }
        }

    }

    public static void printAllEmployees() {
        for (Employee thisEmployee: EmployeeHandler.getAllEmployees()) {
            System.out.println("#" + thisEmployee.getID() + ". " + thisEmployee.getFullName());
        }
    }

    public static int getNewEmployeeID() {
        int newID = 0;
        while (true) {
            System.out.println("Enter employee ID: ");
            Scanner scan = new Scanner(System.in);

            try {
                newID = Integer.parseInt(scan.nextLine().strip());
                if ( EmployeeHandler.findEmployee(newID) != null ) {
                    throw new ArrayStoreException();
                }
            } catch (NumberFormatException e) {
                System.out.println("ID needs to be a whole number. Try again!");
                continue;
            } catch (ArrayStoreException e) {
                System.out.println("ID is taken. Try again!");
                continue;
            }
            break;
        }
        return newID;
    }

    public static String[] getNewEmployeeName() {
        System.out.println("Enter employee first name: ");
        Scanner scan = new Scanner(System.in);
        String userInputFirstName = scan.nextLine().strip();

        System.out.println("Enter employee last name: ");
        String userInputLastName = scan.nextLine().strip();

        return new String[] { userInputFirstName, userInputLastName };
    }

    public static int getNewEmployeeSalary() {
        int salary = 0;
        while (true) {
            System.out.println("Enter salary: ");
            Scanner scan = new Scanner(System.in);

            try {
                salary = Integer.parseInt(scan.nextLine().strip());
            } catch (NumberFormatException e) {
                System.out.println("Salary needs to be a whole number. Try again!");
                continue;
            }
            break;
        }
        return salary;
    }

    public static Gender getNewEmployeeGender() {
        Gender returnGender = null;
        System.out.println("Enter employee gender");
        System.out.println("1-Male");
        System.out.println("2-Female");
        System.out.println("3-Unspecified");

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userInput = scan.nextLine().toLowerCase();

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
                System.out.println("Unknown input. Try again!\n");
            }
        }

        return returnGender;
    }

    public static Date getNewEmployeeDateOfBirth() {
        Date returnDate = null;
        while (true) {
            System.out.println("Enter employee date of birth (yy/mm/dd): ");
            Scanner scan = new Scanner(System.in);

            try {
                returnDate = new SimpleDateFormat("yy/MM/dd").parse(scan.nextLine().strip());
                break;
            } catch (ParseException e) {
                System.out.println("Date format is wrong. Try again!");
            }
        }
        return returnDate;
    }

    public static Department getNewEmployeeDepartment() {
        Department returnDepartment = null;
        System.out.println("Enter employee department");
        System.out.println("1-Management");
        System.out.println("2-Marketing");
        System.out.println("3-IT");
        System.out.println("4-Economy");
        System.out.println("5-HR");

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userInput = scan.nextLine().toLowerCase();

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
                System.out.println("Unknown input. Try again!\n");
            }
        }

        return returnDepartment;
    }

    public static EmployeeCategory getNewEmployeeCategory() {
        EmployeeCategory returnCategory = null;
        System.out.println("Enter employee category");
        System.out.println("1-Manager");
        System.out.println("2-Programmer");
        System.out.println("3-Technician");
        System.out.println("4-Secretary");

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userInput = scan.nextLine().toLowerCase();

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
                System.out.println("Unknown input. Try again!\n");
            }
        }

        return returnCategory;
    }

    public static String EmployeeStatistics() {
    
    Scanner scan = new Scanner(System.in);


        System.out.println("1-Average wage at the company");
        System.out.println("2-Highest salary at the company");
        System.out.println("3-Lowest salary at the company");
        System.out.println("4-Total bonus");
        System.out.println("5-Women in percentage in the company");
        System.out.println("6-Men perecntage of the variouswork role categories ");
        System.out.println("0-Back to main menu");
        
    String EmployeeStatistics = scan.nextLine();
    return EmployeeStatistics;
    
    }
    
    public static void Menu() {
        int EmployeeManagement = 0;
        int EmployeeMenu;
        int EmployeeStatistics;
        
        switch (EmployeeManagement) {
            case 1: 
                System.out.println("Employee managment");
                
                    if (1>0) {
                        System.out.println("Register new employee");
                        break;    
                    } else if (2>1) {
                        System.out.println("Fire employee");  
                        break;
                    } else if (3>2) {
                        System.out.println("Update name of employee");
                        break;
                    } else if (4>3) {
                        System.out.println("Update age of employee");
                        break;
                    } else if (5>4) {
                        System.out.println("Update departement of employee");
                        break;
                    } else if (6>5) {
                        System.out.println("Update salary of employee");
                        break;
                    } else if (7>6) {
                        System.out.println("Serach employee by name");
                        break;
                    } else if (8>7) {
                        System.out.println("Serach employee by id");
                        break;
                    } else if (9>8) {
                        System.out.println("Serach employee by departement");
                        break;
                    } else if (10>9) {
                        System.out.println("Display all employees");
                        break;
                    } else
                        System.out.println("Back to main menu");
                        break;
            case 2:
                System.out.println("EmployeeStatistics");
                
                if (1>0){
                        System.out.println("Average wage at the company");
                        break;
                    }else if(2>1){
                        System.out.println("Highest salary at the company");
                        break;
                    }else if(3>2){
                        System.out.println("Lowest salary at the company");
                        break;
                    }else if(4>3){
                        System.out.println("Total bonus");
                        break;
                    }else if(5>4){
                        System.out.println("Women in percentage in the company");
                        break;
                    }else if(6>5){
                        System.out.println("Men perecntage of the variouswork role categories");
                        break;
                    }else
                        System.out.println("Back to main menu");
                        break;
                    
            default:
                System.out.println("Wrong choice!Try again:");
                    
        }
        
    }
    
    
    //Starta om loopen
    public static void reStart(){
          System.out.println("Do you want to go back to the menu? y/n ");
          Scanner sc = new Scanner(System.in);
          String igen =  sc.nextLine();
          if (igen.equals("y")){
              boolean EmployeeMenu = true;
            
          }else if (igen.equals("n")){
              boolean EmployeeMenu = false;
              System.out.println("Good Bye");
              System.exit(0);
          }
    }         
              
    
}
