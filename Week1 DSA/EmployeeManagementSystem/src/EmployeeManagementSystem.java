//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private final Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Adding employees
        ems.addEmployee(new Employee(1, "John Doe", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Developer", 65000));
        ems.addEmployee(new Employee(3, "Emily Davis", "Designer", 60000));

        // Traversing employees
        System.out.println("All employees:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee emp = ems.searchEmployee(2);
        if (emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        System.out.println("\nDeleting employee with ID 1:");
        boolean isDeleted = ems.deleteEmployee(1);
        if (isDeleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traversing employees after deletion
        System.out.println("\nAll employees after deletion:");
        ems.traverseEmployees();
    }
}
