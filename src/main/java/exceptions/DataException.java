package exceptions;

import java.io.IOException;

public class DataException extends IOException {
    public DataException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DataException(final String message) {
        super(message);
    }

    public DataException() {

    }
}