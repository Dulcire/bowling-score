package exceptions;

import java.io.IOException;

public class FileNotFound extends IOException {

    public FileNotFound(final String message) {
        super(message);
    }
}
