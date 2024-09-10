package ferreira.quarkus.api.handles;

import ferreira.quarkus.core.exception.BusinnessException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Provider
public class BusinessExceptionErrorHandler implements ExceptionMapper<BusinnessException> {
    @Override
    public Response toResponse(BusinnessException b) {

        var error = new ErrorResponse();
        error.setMessage(b.toString());

        return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), b.toString())
                .entity(error)
                .build();
    }
}


