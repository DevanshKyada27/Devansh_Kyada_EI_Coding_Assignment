package Exercise1_Design_Pattern.Structural_Design_Pattern.phone_charging_system;

public class ChargerABC implements AndroidCharger{

    @Override
    public void chargeAndroidPhone() {
        System.out.println("Your Android Phone is getting charged with (ChargerABC).......");
    }
    
}
