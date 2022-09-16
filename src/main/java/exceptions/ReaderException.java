package exceptions;

public class ReaderException extends RuntimeException {
    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ReaderException(final String message) {
        super(message);
    }
}
