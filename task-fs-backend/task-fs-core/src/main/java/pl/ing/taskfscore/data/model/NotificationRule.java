package pl.ing.taskfscore.data.model;

import pl.ing.taskfscore.data.model.type.NotificationRuleOperand;
import pl.ing.taskfscore.data.model.type.NotificationRuleOperator;

public record NotificationRule(
        NotificationRuleOperator operator,
        NotificationRuleOperand operand,
        String value
) {
}
