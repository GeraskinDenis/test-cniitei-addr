package exception;

public class AddressServiceException extends RuntimeException {
    public AddressServiceException(String message) {
        super(message);
    }

    public AddressServiceException(Throwable cause) {
        super(cause);
    }
}
