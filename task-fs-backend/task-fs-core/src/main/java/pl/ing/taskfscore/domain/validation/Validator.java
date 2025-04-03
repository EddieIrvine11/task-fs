package pl.ing.taskfscore.domain.validation;

import io.vavr.collection.Set;

public interface Validator<T> {

    Set<ValidationError> validate(T record);
}
