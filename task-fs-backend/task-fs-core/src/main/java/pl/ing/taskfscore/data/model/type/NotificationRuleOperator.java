package pl.ing.taskfscore.data.model.type;

import io.vavr.collection.Stream;
import io.vavr.control.Option;

public enum NotificationRuleOperator {
    ITEM("item"),
    PRICE("price");

    public final String value;

    NotificationRuleOperator(String value) {
        this.value = value;
    }

    public static Option<NotificationRuleOperator> of(String value) {
        return Stream.of(values()).find(o -> o.value.equals(value));
    }
}
