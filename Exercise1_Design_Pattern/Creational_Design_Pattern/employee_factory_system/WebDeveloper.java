package Exercise1_Design_Pattern.Creational_Design_Pattern.employee_factory_system;

public class WebDeveloper implements Employee{
    public int salary() {
        System.out.println("Getting Web Developer Salary......");
        return 100000;
    }

    public String getRole() {
        return "Web Developer";
    }

    @Override
    public String toString() {
        return "Web Developer";
    }
}
