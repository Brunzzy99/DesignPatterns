package command.electronicDevices;

public class Radio implements ElectronicDevice {
    private boolean onOffStatus = false;
    private int volume = 0;

    @Override
    public void on() {
        onOffStatus = true;
    }

    @Override
    public void off() {
        onOffStatus = false;
    }

    @Override
    public void volumeUp() {
        volume ++;
    }

    @Override
    public void volumeDown() {
        volume --;
    }

    @Override
    public boolean getStatus() {
        return onOffStatus;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}