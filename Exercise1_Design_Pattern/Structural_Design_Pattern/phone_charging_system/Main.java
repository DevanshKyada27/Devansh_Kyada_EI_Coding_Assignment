package Exercise1_Design_Pattern.Structural_Design_Pattern.phone_charging_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // AppleCharger charger = new AdaptorCharger(new ChargerABC());
        // Iphone iphone = new Iphone(charger);
        // iphone.chargeIphone();
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n<------------ Welcomw To Phone Charging System Application ------------>");
            System.out.println("1. Charge iPhone with iPhone Charger (ChargerXYZ)");
            System.out.println("2. Charge iPhone with Android Charger using Adapter (ChargerABC)");
            System.out.println("3. Charge Android Phone with Android Charger (ChargerABC)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    AppleCharger iphoneCharger = new ChargerXYZ();
                    Iphone iphone1 = new Iphone(iphoneCharger);
                    iphone1.chargeIphone();
                    break;

                case 2:
                    AndroidCharger androidChargerForAdapter = new ChargerABC();
                    AppleCharger adapter = new AdaptorCharger(androidChargerForAdapter);
                    Iphone iphone2 = new Iphone(adapter);
                    iphone2.chargeIphone();
                    break;

                case 3:
                    AndroidCharger androidCharger = new ChargerABC();
                    androidCharger.chargeAndroidPhone();
                    break;

                case 4:
                    System.out.println("Exiting Phone Charging System... Thank You for using the Application :)");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again! :(");
            }
        }
    }
}
