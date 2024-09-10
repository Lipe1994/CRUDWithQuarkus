package ferreira.quarkus.api.handles;


import ferreira.quarkus.core.exception.BusinnessEmptyException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessEmptyExceptionErrorHandler implements ExceptionMapper<BusinnessEmptyException> {
    @Override
    public Response toResponse(BusinnessEmptyException b) {

        var error = new ErrorResponse();
        error.setMessage(b.toString());

        return Response.status(Response.Status.NOT_FOUND.getStatusCode(), b.toString())
                .entity(error)
                .build();
    }
}


