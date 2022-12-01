package command.files;

public class TextFile {
    private String name;

    public TextFile(String newName) {
        name = newName;
    }

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
