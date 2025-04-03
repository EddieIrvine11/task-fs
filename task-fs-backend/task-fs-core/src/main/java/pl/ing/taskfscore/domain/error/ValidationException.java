package pl.ing.taskfscore.domain.error;

import io.vavr.collection.List;
import pl.ing.taskfscore.domain.validation.ValidationError;

public class ValidationException extends RuntimeException {

    public final List<ValidationError> errors;

    public ValidationException(List<ValidationError> errors) {
        this.errors = errors;
    }
}
