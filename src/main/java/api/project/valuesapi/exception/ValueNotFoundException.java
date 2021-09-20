package api.project.valuesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValueNotFoundException extends Exception {
    public ValueNotFoundException(Long id) {
        super("Value not found with id: "+ id);
    }
}
