package employeemanagemntsystem;

public class MenuStatistics implements Menu {

    @Override
    public String findEmployeeByName(String nameToFind) {
        return null;
    }
    
    // Detta är en test

    @Override
    public int findEmployeeById(int idToFind) {
        return 0;
    }

    @Override
    public Department findEmployeeByDepartment(Department departmentToFind) {
        return null;
    }
    
     protected void salaryHighest() {
        
        //Specificera salary
        ArrayList<Employee> findEmployeeById = new ArrayList<Employee>();
        
        //Räknar ut högsta lönen
        int maxNumber = findEmployeeById[0];

        //Specificera salary
        for (int i = 0; i < findEmployeeById.length; i++) {
            if (findEmployeeById[i] > maxNumber) {
                maxNumber = findEmployeeById[i];
            }
        }
        System.out.println("The highest salary in the company is: " + maxNumber);

    }
    
    protected void salaryLowest() { 
        
        //Specificera salary
        ArrayList<Employee> findEmployeeById = new ArrayList<Employee>();
     
        ///Räknar ut lägsta lönen
        int minNumber = findEmployeeById[0];

        //Specifiera salary
        for(int i = 0; i < findEmployeeById.length; i++){
            if (findEmployeeById[i] < minNumber) {
                minNumber = findEmployeeById[i];
            }
        }
        System.out.println("The lowest salary in the company is: " + minNumber);  
    }
    
    protected void averageWage() { 
        
        //Specifiera salary och ID
        ArrayList<Employee> allEmployees = new ArrayList<Employee>();

        int total = 0; 
        //Alla löner delat på antalet anställda.
        //Kan lägga in total/(double)n); om det skulle bli decimalnummer 
        for(i=0; i<n; i++) {
            total += a[i];
            System.out.println("Average: " + total/n); 
        }    
        
    }

}
