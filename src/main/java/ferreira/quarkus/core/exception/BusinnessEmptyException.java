package ferreira.quarkus.core.exception;

public class BusinnessEmptyException extends RuntimeException{

    public String message;
    public BusinnessEmptyException(String message)
    {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
