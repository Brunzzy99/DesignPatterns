package command.electronicDevices;

public class TurnVolumeDown implements Command {
    ElectronicDevice electronicDevice;

    public TurnVolumeDown(ElectronicDevice newElectronicDevice) {
        electronicDevice = newElectronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.volumeDown();
    }
}