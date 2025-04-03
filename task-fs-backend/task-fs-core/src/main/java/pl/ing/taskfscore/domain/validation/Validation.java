package pl.ing.taskfscore.domain.validation;

import io.vavr.collection.Set;

public abstract class Validation<T> {

    private final T record;

    public Validation(T record) {
        this.record = record;
    }

    public Set<ValidationError> validate() {
        return gatherValidators().flatMap(validator -> validator.validate(record));
    }

    public abstract Set<Validator<T>> gatherValidators();
}
