package Exercise1_Design_Pattern.Structural_Design_Pattern.pc_control_application;

public class ComputerFacade {
    private PowerSupply power;
    private CoolingSystem cooling;
    private CPU cpu;
    private Memory memory;
    private HardDrive disk;
    private BIOS bios;
    private OperatingSystem os;

    public ComputerFacade() {
        this.power = new PowerSupply();
        this.cooling = new CoolingSystem();
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new HardDrive();
        this.bios = new BIOS();
        this.os = new OperatingSystem();
    }

    public void startComputer() {
        System.out.println("\n------- Starting Your Computer -------");
        power.on();
        cooling.start();
        bios.initialize();
        cpu.start();
        memory.load();
        disk.read();
        os.load();
        System.out.println("Computer is READY!\n");
    }

    public void shutdownComputer() {
        System.out.println("\n------- Shutting Down Your Computer -------");
        os.shutdown();
        bios.shutdown();
        disk.stop();
        memory.clear();
        cpu.shutdown();
        cooling.stop();
        power.off();
        System.out.println("Computer is OFF.\n");
    }
}
