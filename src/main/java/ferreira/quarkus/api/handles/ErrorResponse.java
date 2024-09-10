package ferreira.quarkus.api.handles;

import java.util.List;

public class ErrorResponse {
    private String message;
    private List<String> errors = List.of();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
