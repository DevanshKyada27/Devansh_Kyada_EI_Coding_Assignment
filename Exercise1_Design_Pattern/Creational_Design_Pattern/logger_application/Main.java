import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger();  // get single instance

        while (true) {
            System.out.println("\n<------------ Welcome To Logger System Application ------------>");
            System.out.println("1. Log Info Message");
            System.out.println("2. Log Error Message");
            System.out.println("3. Show All Logs");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter info message: ");
                String infoMsg = sc.nextLine();
                logger.logInfo(infoMsg);
                System.out.println("Logger HashCode: " + logger.hashCode());

            } else if (choice == 2) {
                System.out.print("Enter error message: ");
                String errorMsg = sc.nextLine();
                logger.logError(errorMsg);
                System.out.println("Logger HashCode: " + logger.hashCode());
            
            }else if (choice == 3) {
                logger.showLogs();
                System.out.println("Logger HashCode: " + logger.hashCode());
            
            }else if (choice == 4) {
                System.out.println("Exiting Logger System...Thank You for Using the Application :)");
                sc.close();
                break;   // exit the loop
            
            }else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
