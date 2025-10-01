package Exercise1_Design_Pattern.Creational_Design_Pattern.employee_factory_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Employee employee = EmployeeFactory.getEmployee("WEB DEVELOPER");
        // System.out.println(employee);
        // int salary = employee.salary();
        // System.out.println(salary);

        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n<------------ Welcome to Employee Factory System Application ------------>");
            System.out.println("1. Hire Android Developer");
            System.out.println("2. Hire Web Developer");
            System.out.println("3. View All Employees");
            System.out.println("4. Show Total Payroll");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                Employee emp = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
                employees.add(emp);
                System.out.println("Hired: " + emp.getRole() + " with salary " + emp.salary());
            
            }else if (choice == 2) {
                Employee emp = EmployeeFactory.getEmployee("WEB DEVELOPER");
                employees.add(emp);
                System.out.println("Hired: " + emp.getRole() + " with salary " + emp.salary());
            
            }else if (choice == 3) {
                if (employees.isEmpty()) {
                    System.out.println("No employees hired yet.");
                } else {
                    System.out.println("\n--- Employee List ---");
                    for (int i = 0; i < employees.size(); i++) {
                        System.out.println((i + 1) + ". " + employees.get(i));
                    }
                }
            
            }else if (choice == 4) {
                if (employees.isEmpty()) {
                    System.out.println("No employees hired yet :(. Payroll = 0");
                } else {
                    int total = 0;
                    for (Employee emp : employees) {
                        total += emp.salary();
                    }
                    System.out.println("Total Payroll: " + total);
                }
            
            }else if (choice == 5) {
                System.out.println("Exiting Employee Factory System... Thank you for using the Application :)");
                sc.close();
                break;
            
            }else {
                System.out.println("Invalid choice! Please try again. :(");
            }
        }
    }
}
