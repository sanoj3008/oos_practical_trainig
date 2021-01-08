package exceptions;

public class TransactionDoesNotExistException extends Exception{
    public TransactionDoesNotExistException() {
        super();
    }

    public TransactionDoesNotExistException(String msg) {
        super(msg);
    }
}
