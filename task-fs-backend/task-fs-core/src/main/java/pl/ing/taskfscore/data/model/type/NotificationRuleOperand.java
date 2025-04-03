package pl.ing.taskfscore.data.model.type;

import io.vavr.collection.Stream;
import io.vavr.control.Option;

public enum NotificationRuleOperand {
    IS("is"),
    IS_NOT("is not"),
    IS_EQUAL_TO("is equal to"),
    IS_GREATER_THAN("is greater than"),
    IS_LESS_THAN("is less than"),
    IS_GREATER_THAN_OR_EQUAL_TO("is greater or equal to"),
    IS_LESS_THAN_OR_EQUAL_TO("is less or equal to");

    public final String value;

    NotificationRuleOperand(String value) {
        this.value = value;
    }

    public static Option<NotificationRuleOperand> of(String value) {
        return Stream.of(values()).find(o -> o.value.equals(value));
    }
}
