package command.files;

public class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public OpenTextFileOperation(TextFile newTextFile) {
        textFile = newTextFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}