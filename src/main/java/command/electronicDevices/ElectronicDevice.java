package command.electronicDevices;

public interface ElectronicDevice {
    void on();
    void off();
    void volumeUp();
    void volumeDown();
    boolean getStatus();
    int getVolume();
}