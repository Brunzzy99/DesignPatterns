package command.electronicDevices;

public class TurnVolumeUp implements Command {
    ElectronicDevice electronicDevice;

    public TurnVolumeUp(ElectronicDevice newElectronicDevice) {
        electronicDevice = newElectronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.volumeUp();
    }
}