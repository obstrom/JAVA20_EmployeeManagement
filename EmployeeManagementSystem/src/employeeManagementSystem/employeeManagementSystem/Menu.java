package employeeManagementSystem;

public interface Menu {
    abstract String findEmployeeByName(String nameToFind);
    abstract int findEmployeeById(int idToFind);
    abstract Department findEmployeeByDepartment(Department departmentToFind);
}