package model.enums;

/**
 * Enum for Exceptions.
 */
public enum ExceptionType {

    PATH_NOT_FOUND("File directory not found"),
    DATA_FORMAT_ERROR("There are errors in your file format"),
    DATA_EXTRA_SCORE("The number of pinfalls are out of limit"),
    DATA_NEGATIVE_NUMBER("Negative numbers are not allowed"),
    DATA_INVALID_SCORE("Invalid score in the file"),
    DATA_EMPTY_FILE("Empty File");

    private String message;

    public String getMessage() {
        return this.message;
    }

    ExceptionType(final String message) {
        this.message = message;
    }
}
