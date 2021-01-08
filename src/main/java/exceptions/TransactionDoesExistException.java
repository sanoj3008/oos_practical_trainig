package exceptions;

public class TransactionDoesExistException extends Exception{
    public TransactionDoesExistException() {
        super();
    }

    public TransactionDoesExistException(String msg) {
        super(msg);
    }
}
