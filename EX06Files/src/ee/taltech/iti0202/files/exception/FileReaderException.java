package ee.taltech.iti0202.files.exception;

public class FileReaderException extends RuntimeException {


    private String message;

    public FileReaderException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
