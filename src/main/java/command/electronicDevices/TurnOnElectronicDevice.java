package command.electronicDevices;

public class TurnOnElectronicDevice implements Command {
    private ElectronicDevice electronicDevice;

    public TurnOnElectronicDevice(ElectronicDevice newElectronicDevice) {
        electronicDevice = newElectronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.on();
    }
}