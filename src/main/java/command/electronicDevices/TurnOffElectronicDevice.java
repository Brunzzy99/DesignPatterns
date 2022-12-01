package command.electronicDevices;

public class TurnOffElectronicDevice implements Command {
    private ElectronicDevice electronicDevice;

    public TurnOffElectronicDevice(ElectronicDevice newElectronicDevice) {
        electronicDevice = newElectronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.off();
    }
}