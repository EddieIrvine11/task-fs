package pl.ing.taskfscore.domain.model;

import pl.ing.taskfscore.data.model.NotificationRule;

public record NotificationRuleDTO(
        String operator,
        String operand,
        String value
) {

    public static NotificationRuleDTO from(NotificationRule rule) {
        return new NotificationRuleDTO(
                rule.operator().value,
                rule.operand().value,
                rule.value()
        );
    }
}
