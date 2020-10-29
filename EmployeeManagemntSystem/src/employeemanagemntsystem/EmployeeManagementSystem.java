package employeemanagemntsystem;

import java.util.Scanner;

public class EmployeeManagementSystem {

    static boolean loop = true;

    public static void main(String[] args) {

        EmployeeHandler handler = new EmployeeHandler();

        handler.createNewEmployee(EmployeeCategory.PROGRAMMER, 1, "Oscar", "Bergström", 50000, Gender.MALE, "91/06/05", Department.IT);
        handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 2, "Tomas", "Gustavsson", 50000, Gender.MALE, "65/01/02", Department.MANAGEMENT);
        handler.createNewEmployee(EmployeeCategory.TECHNICIAN, 3, "Stina", "Malmqvist", 40000, Gender.FEMALE, "78/06/21", Department.HR);
        handler.createNewEmployee(EmployeeCategory.MANAGER, 4, "Robert", "Tegner", 45000, Gender.MALE, "81/04/15", Department.HR);
        handler.createNewEmployee(EmployeeCategory.MANAGER, 5, "Martin", "Tegner", 47000, Gender.MALE, "72/12/02", Department.IT);

        /*Employee employee2 = handler.findEmployee(2);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date employeeBirthday = employee2.getDateOfBirth();
        System.out.println("Tomas = " + dateFormat.format(employeeBirthday));

        ArrayList<Employee> tegnerEmployees = handler.findEmployee("tegner");
        for (Employee thisEmployee: tegnerEmployees) {
            System.out.println(thisEmployee.getFirstName() + " är en Tegner");
        }*/

        startMenu();

    }
        
    public static void startMenu() {
        while (true) {
        System.out.println("\033[1mWelcome to Employee Management System.\033[0m");
        System.out.println("What do you want to do?");
        System.out.println("1-Employee management");
        System.out.println("2-Employee statistics");
        System.out.println("3-Exit program.\n");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine().toLowerCase();

            if (userInput.contains("1") || userInput.contains("management")) {
                // Skapa ny "MenuEmployeeSystem" class
                // Visa meny för den (loop) - break ut
                System.out.println("Management selected\n");
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
    public static String EmployeeMenu() {
    
    Scanner scan = new Scanner(System.in);
    
        System.out.println("Employee managment");
        System.out.println("1-Register new employee");
        System.out.println("2-Fire employee");
        System.out.println("3-Update name of employee");
        System.out.println("4-Update age of employee");
        System.out.println("5-Update departement of employee");
        System.out.println("6-Update salary of employee");
        System.out.println("7-Serach employee by name");
        System.out.println("8-Serach employee by id");
        System.out.println("9-Serach employee by departement");
        System.out.println("10-Display all employees");
        System.out.println("0-Back to main menu");
    String EmployeeMenu = scan.nextLine();
    return EmployeeMenu;
    
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
    
    public static void Menu(){
        int EmployeeManagement = 0;
        int EmployeeMenu;
        int EmployeeStatistics;
        
        switch(EmployeeManagement){
            case 1: 
                System.out.println("Employee managment");
                
                    if(1>0){
                        System.out.println("Register new employee");
                        break;    
                    }else if(2>1){
                        System.out.println("Fire employee");  
                        break;
                    }else if(3>2){
                        System.out.println("Update name of employee");
                        break;
                    }else if(4>3){
                        System.out.println("Update age of employee");
                        break;
                    }else if(5>4){
                        System.out.println("Update departement of employee");
                        break;
                    }else if(6>5){
                        System.out.println("Update salary of employee");
                        break;
                    }else if(7>6){
                        System.out.println("Serach employee by name");
                        break;
                    }else if(8>7){
                        System.out.println("Serach employee by id");
                        break;
                    }else if(9>8){
                        System.out.println("Serach employee by departement");
                        break;
                    }else if(10>9){
                        System.out.println("Display all employees");
                        break;
                    }else
                        System.out.println("Back to main menu");
               
                        break;
                    
            case 2:
                System.out.println("EmployeeStatistics");
                
                if(1>0){
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