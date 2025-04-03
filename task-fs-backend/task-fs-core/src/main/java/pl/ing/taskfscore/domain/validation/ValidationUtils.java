package pl.ing.taskfscore.domain.validation;

import io.vavr.collection.List;
import io.vavr.control.Option;

public class ValidationUtils {

    public static final String IS_REQUIRED = "Is required";

    public static Option<ValidationError> isRequired(String attribute, String value) {
        return Option.of(value)
                .orElse(Option.of(""))
                .filterNot(String::isBlank)
                .map(s -> new ValidationError(attribute, IS_REQUIRED));
    }

    public static <T> Option<ValidationError> isRequired(String attribute, List<T> values) {
        return Option.of(values)
                .orElse(Option.of(List.empty()))
                .filter(List::isEmpty)
                .map(l -> new ValidationError(attribute, IS_REQUIRED));
    }
}
