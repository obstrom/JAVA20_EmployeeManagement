package employeeManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuEmployeeSystem implements Menu {

    static String boldTextStart = "\033[1m";
    static String regularTextStart = "\033[0m";
    static String newLine = "\n";

    public static void employeeMenu() {

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

            // Skapa ny användare
            if (userInput.contains("1") || userInput.contains("new")) {
                // Skapa en ny meny för att ta all information för ny Employee
                // Skapa en ny employee och lägg i Arraylistan
                System.out.println("\nRegister new employee selected");

                // Hämta info ifrån användaren om den nya Employee
                int id = getNewEmployeeID();
                String firstName = getNewEmployeeFirstName();
                String lastName = getNewEmployeeLastName();
                int salary = getNewEmployeeSalary();
                Gender gender = getNewEmployeeGender();
                Date dateOfBirth = getNewEmployeeDateOfBirth();
                Department department = getNewEmployeeDepartment();
                EmployeeCategory category = getNewEmployeeCategory();

                // Skapa ny Employee
                EmployeeHandler.createNewEmployee(category, id, firstName, lastName, salary, gender, dateOfBirth, department);

                continue;
            } else if (userInput.contains("2") || userInput.contains("remove")) {
                System.out.println("Remove employee selected\n");
                System.out.println("\033[1mRemove employee\033[0m");
                searchForEmployeeMenu(SearchOption.REMOVE);
                continue;
            } else if (userInput.contains("3") || userInput.contains("update")) {
                // Gå till meny för att välja Employee
                // Visa meny för att uppdatera Employee
                System.out.println("Update employee selected\n");
                System.out.println("\033[1mUpdate employee\033[0m");
                searchForEmployeeMenu(SearchOption.UPDATE);
                continue;
            } else if (userInput.contains("4") || userInput.contains("search")) {
                // Gå till meny för att sök efter en/flera Employee
                System.out.println("Search for employee selected\n");
                System.out.println("\033[1mSearch for employee\033[0m");
                searchForEmployeeMenu(SearchOption.SEARCH);
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

    public static String getNewEmployeeFirstName() {
        System.out.println("Enter employee first name: ");
        Scanner scan = new Scanner(System.in);
        String userInputFirstName = scan.nextLine().strip();

        return userInputFirstName;
    }

    public static String getNewEmployeeLastName() {
        System.out.println("Enter employee last name: ");
        Scanner scan = new Scanner(System.in);
        String userInputLastName = scan.nextLine().strip();

        return userInputLastName;
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

    public static void searchForEmployeeMenu(SearchOption option) {
        System.out.println("1-Find employee by ID");
        System.out.println("2-Find employee by exact name");

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.equals("1") || userInput.contains("id")) {
                Employee employee = getEmployeeByIDFromInput();
                System.out.println(employee.getFullName() + " has been selected." + newLine);
                searchForEmployeeMenuAction(option, employee);
                break;
            } else if (userInput.equals("2") || userInput.contains("name")) {
                Employee employee = getEmployeeByNameFromInput();
                System.out.println(employee.getFullName() + " has been selected." + newLine);
                searchForEmployeeMenuAction(option, employee);
                break;
            } else {
                System.out.println("Unknown input. Try again!\n");
            }
        }
    }

    public static void searchForEmployeeMenuAction(SearchOption option, Employee employee) {
        switch (option) {
            case REMOVE:
                EmployeeHandler.removeEmployee(employee);
                break;
            case UPDATE:
                updateEmployeeMenu(employee);
                break;
            case SEARCH:
                employeeDisplayMenu(employee);
                break;
        }
    }

    public static void updateEmployeeMenu(Employee employee) {
        updateMenuLoop:
        while (true) {
            System.out.println(newLine + boldTextStart + "Select action" + regularTextStart);
            System.out.println("1-Update ID");
            System.out.println("2-Update first name");
            System.out.println("3-Update last name");
            System.out.println("4-Update gender");
            System.out.println("5-Update date of birth");
            System.out.println("6-Update base salary");
            System.out.println("7-Update department");
            System.out.println("0-Return to main menu");

            Scanner scan = new Scanner(System.in);

            while (true) {
                String userInput = scan.nextLine().toLowerCase();

                if (userInput.equals("1") || userInput.contains("id")) {
                    int newID = getNewEmployeeID();
                    employee.setID(newID);
                    System.out.println(employee.getFullName() + "'s ID has been updated to " + newID);
                    break;
                } else if (userInput.equals("2") || userInput.contains("first name")) {
                    String newFirstName = getNewEmployeeFirstName();
                    employee.setFirstName(newFirstName);
                    System.out.println(employee.getFullName() + " name has been updated.");
                    break;
                } else if (userInput.equals("3") || userInput.contains("last name")) {
                    String newLastName = getNewEmployeeLastName();
                    employee.setFirstName(newLastName);
                    System.out.println(employee.getFullName() + " name has been updated.");
                    break;
                } else if (userInput.equals("4") || userInput.contains("gender")) {
                    Gender newGender = getNewEmployeeGender();
                    employee.setGender(newGender);
                    System.out.println(employee.getFullName() + " gender has been changed to " + newGender);
                    break;
                } else if (userInput.equals("5") || userInput.contains("date of birth")) {
                    Date newDateOfBirth = getNewEmployeeDateOfBirth();
                    employee.setDateOfBirth(newDateOfBirth);
                    System.out.println(employee.getFullName() + " date of birth has been changed to " + employee.getDateOfBirthString());
                    break;
                } else if (userInput.equals("6") || userInput.contains("salary")) {
                    int newBaseSalary = getNewEmployeeSalary();
                    employee.setBaseSalary(newBaseSalary);
                    System.out.println(employee.getFullName() + "'s base salary is now " + employee.getBaseSalary());
                    break;
                } else if (userInput.equals("7") || userInput.contains("department")) {
                    Department newDepartment = getNewEmployeeDepartment();
                    employee.setDepartment(newDepartment);
                    System.out.println(employee.getFullName() + " department changed to " + employee.getDepartment());
                    break;
                } else if (userInput.equals("0") || userInput.contains("return") || userInput.contains("exit")) {
                    break updateMenuLoop;
                } else {
                    System.out.println("Unknown input. Try again!\n");
                }
            }
        }
    }

    public static void employeeDisplayMenu(Employee employee) {
        System.out.println("Name: " + employee.getFullName());
        System.out.println("Gender: " + employee.getGender());
        System.out.println("Date of birth: " + employee.getDateOfBirthString());
        System.out.println("ID: " + employee.getID());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Category: " + employee.getCategory());
        System.out.println("Salary: " + employee.getSalary());
    }

    public static Employee getEmployeeByIDFromInput() {
        Employee returnObject = null;
        System.out.println("\nEnter employee ID: ");

        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                String userInput = scan.nextLine().strip();
                int inputID = Integer.parseInt(userInput);
                returnObject = EmployeeHandler.findEmployee(inputID);
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID needs to be a whole number! Try again");
            }
        }

        return returnObject;
    }

    public static Employee getEmployeeByNameFromInput() {
        Employee returnObject = null;
        System.out.println("\nEnter employees exact name: ");

        Scanner scan = new Scanner(System.in);

        while (true) {
            String userInput = scan.nextLine();
            ArrayList<Employee> resultList = EmployeeHandler.findEmployee(userInput);
            if (resultList.isEmpty()) {
                System.out.println("No employee found! Try again");
            } else {
                returnObject = resultList.get(0);
                break;
            }
        }

        return returnObject;
    }

}
