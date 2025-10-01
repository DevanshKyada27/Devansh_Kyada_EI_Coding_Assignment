package Exercise1_Design_Pattern.Creational_Design_Pattern.employee_factory_system;

public class AndroidDeveloper implements Employee{
    public int salary() {
        System.out.println("Getting android developer salary.....");
        return 75000;
    }

    public String getRole() {
        return "Android Developer";
    }

    @Override
    public String toString() {
        return "Android Developer";
    }
}
