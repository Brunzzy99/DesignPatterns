package command;

import command.electronicDevices.*;
import command.files.OpenTextFileOperation;
import command.files.SaveTextFileOperation;
import command.files.TextFile;
import command.files.TextFileOperationExecutor;
import org.testng.annotations.Test;

public class CommandTest {
    @Test
    public void testCommandOnTelevision() {
        //DEVICE
        var newDevice = Remote.getTelevision();

        //COMMANDS
        var onCommand = new TurnOnElectronicDevice(newDevice);
        var offCommand = new TurnOffElectronicDevice(newDevice);
        var volumeUpCommand = new TurnVolumeUp(newDevice);
        var volumeDownCommand = new TurnVolumeDown(newDevice);

        //BUTTONS
        var onButton = new DeviceButton(onCommand);
        var offButton = new DeviceButton(offCommand);
        var volumeUpButton = new DeviceButton(volumeUpCommand);
        var volumeDownButton = new DeviceButton(volumeDownCommand);

        //TESTS
        onButton.press();
        assert newDevice.getStatus();
        offButton.press();
        assert !newDevice.getStatus();
        volumeUpButton.press();
        assert newDevice.getVolume() == 1;
        volumeUpButton.press();
        assert newDevice.getVolume() == 2;
        volumeDownButton.press();
        assert newDevice.getVolume() == 1;
        volumeDownButton.press();
        assert newDevice.getVolume() == 0;
    }

    @Test
    public void testCommandOnRadio() {
        //DEVICE
        var newDevice = Remote.getRadio();

        //COMMANDS
        var onCommand = new TurnOnElectronicDevice(newDevice);
        var offCommand = new TurnOffElectronicDevice(newDevice);
        var volumeUpCommand = new TurnVolumeUp(newDevice);
        var volumeDownCommand = new TurnVolumeDown(newDevice);

        //BUTTONS
        var onButton = new DeviceButton(onCommand);
        var offButton = new DeviceButton(offCommand);
        var volumeUpButton = new DeviceButton(volumeUpCommand);
        var volumeDownButton = new DeviceButton(volumeDownCommand);

        //TESTS
        onButton.press();
        assert newDevice.getStatus();
        offButton.press();
        assert !newDevice.getStatus();
        volumeUpButton.press();
        assert newDevice.getVolume() == 1;
        volumeUpButton.press();
        assert newDevice.getVolume() == 2;
        volumeDownButton.press();
        assert newDevice.getVolume() == 1;
        volumeDownButton.press();
        assert newDevice.getVolume() == 0;
    }

    @Test
    public void testFiles() {
        var textFileOperationExecutor = new TextFileOperationExecutor();
        String test1 = textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
        String test2 = textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
        assert test1.equals("Opening file file1.txt");
        assert test2.equals("Saving file file2.txt");
    }

    @Test
    public void testFilesUsingLambdaExpression() {
        var textFileOperationExecutor = new TextFileOperationExecutor();
        String test1 = textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt");
        String test2 = textFileOperationExecutor.executeOperation(() -> "Saving file file2.txt");
        assert test1.equals("Opening file file1.txt");
        assert test2.equals("Saving file file2.txt");
    }

    @Test
    public void testFilesUsingMethodReference() {
        var textFileOperationExecutor = new TextFileOperationExecutor();
        var textFile1 = new TextFile("file1.txt");
        var textFile2 = new TextFile("file2.txt");
        String test1 = textFileOperationExecutor.executeOperation(textFile1::open);
        String test2 = textFileOperationExecutor.executeOperation(textFile2::save);
        assert test1.equals("Opening file file1.txt");
        assert test2.equals("Saving file file2.txt");
    }
}
