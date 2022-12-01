package command.files;

public class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public SaveTextFileOperation(TextFile newTextFile) {
        textFile = newTextFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
