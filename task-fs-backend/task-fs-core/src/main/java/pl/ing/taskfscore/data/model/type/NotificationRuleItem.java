package pl.ing.taskfscore.data.model.type;

import io.vavr.collection.Stream;
import io.vavr.control.Option;

public enum NotificationRuleItem {
    GOLD("gold"),
    SILVER("silver"),
    PLATINUM("platinum");

    public final String value;

    NotificationRuleItem(String value) {
        this.value = value;
    }

    public static Option<NotificationRuleItem> of(String value) {
        return Stream.of(values()).find(o -> o.value.equals(value));
    }
}
