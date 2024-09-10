package ferreira.quarkus.core.exception;

public class BusinnessException extends RuntimeException{

    private String message;

    public BusinnessException(String message)
    {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
