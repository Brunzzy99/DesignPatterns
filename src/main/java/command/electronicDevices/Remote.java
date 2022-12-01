package command.electronicDevices;

public class Remote {
    public static ElectronicDevice getTelevision() {
        return new Television();
    }

    public static ElectronicDevice getRadio() {
        return new Radio();
    }
}