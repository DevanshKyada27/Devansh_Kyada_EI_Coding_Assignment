package Exercise1_Design_Pattern.Structural_Design_Pattern.phone_charging_system;

public class AdaptorCharger implements AppleCharger{
    private AndroidCharger charger;

    public AdaptorCharger(AndroidCharger charger) {
        this.charger = charger;
    }

    @Override
    public void chargePhone() {
        charger.chargeAndroidPhone();
        System.out.println("Adapter in action: iPhone is now charging using Android Charger via Adaptor Charger......");
    }
}
