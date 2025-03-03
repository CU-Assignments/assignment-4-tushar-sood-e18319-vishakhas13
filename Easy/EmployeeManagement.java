import java.util.Scanner;
class Employee {
    int empNo;
    String empName;
    String joinDate;
    String designationCode;
    String dept;
    double basicSalary;
    double hra;
    double it;
    double da;
    double totalSalary;
    public void calculateSalary()
    {
        totalSalary=basicSalary+da+hra-it;
    }
    public void displayEmployeeDetails()
    {
        System.out.println("Employee No: " + empNo);
        System.out.println("Employee Name: " + empName);
        System.out.println("Join Date: " + joinDate);
        System.out.println("Designation Code: " + designationCode);
        System.out.println("Department: " + dept);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + hra);
        System.out.println("IT: " + it);
        System.out.println("DA: " + da);
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("------------------------------------");
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Employee No: ");
            employees[i].empNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Employee Name: ");
            employees[i].empName = scanner.nextLine();
            System.out.print("Join Date (yyyy-mm-dd): ");
            employees[i].joinDate = scanner.nextLine();
            System.out.print("Designation Code: ");
            employees[i].designationCode = scanner.nextLine();
            System.out.print("Department: ");
            employees[i].dept = scanner.nextLine();
            System.out.print("Basic Salary: ");
            employees[i].basicSalary = scanner.nextDouble();
            System.out.print("HRA: ");
            employees[i].hra = scanner.nextDouble();
            System.out.print("IT (Income Tax): ");
            employees[i].it = scanner.nextDouble();
            System.out.print("DA (Dearness Allowance): ");
            employees[i].da = scanner.nextDouble();
            employees[i].calculateSalary();
            scanner.nextLine();
        }
        System.out.println("\nEmployee Information:");
        for (int i = 0; i < n; i++) {
            employees[i].displayEmployeeDetails();
        }
        scanner.close();
    }
}
