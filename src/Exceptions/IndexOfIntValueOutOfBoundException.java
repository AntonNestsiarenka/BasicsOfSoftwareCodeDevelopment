package Exceptions;

public class IndexOfIntValueOutOfBoundException extends Exception {
    public IndexOfIntValueOutOfBoundException() {
        super();
    }

    public IndexOfIntValueOutOfBoundException(String message) {
        super(message);
    }

    public IndexOfIntValueOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOfIntValueOutOfBoundException(Throwable cause) {
        super(cause);
    }
}
