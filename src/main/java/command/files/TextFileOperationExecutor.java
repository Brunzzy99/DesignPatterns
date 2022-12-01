package command.files;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperationList = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperationList.add(textFileOperation);
        return textFileOperation.execute();
    }
}