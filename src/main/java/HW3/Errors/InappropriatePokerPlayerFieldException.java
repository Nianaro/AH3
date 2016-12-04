package HW3.Errors;

public class InappropriatePokerPlayerFieldException extends AssertionError {
    public InappropriatePokerPlayerFieldException(String message) {
        super(message);
    }
}
