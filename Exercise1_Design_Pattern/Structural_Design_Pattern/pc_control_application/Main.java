package Exercise1_Design_Pattern.Structural_Design_Pattern.pc_control_application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerFacade computer = new ComputerFacade();
        boolean running = true;

        while (running) {
            System.out.println("<------------ Welcome To PC Control Application ------------>");
            System.out.println("1. Start Computer");
            System.out.println("2. Shutdown Computer");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    computer.startComputer();
                    break;
                case 2:
                    computer.shutdownComputer();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting... Thank You For Using the Application! :)");
                    break;
                default:
                    System.out.println("Invalid option. Please Try Again! :(");
            }
        }
    }
}
