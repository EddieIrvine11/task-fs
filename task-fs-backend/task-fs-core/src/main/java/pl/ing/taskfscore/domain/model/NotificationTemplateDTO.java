package pl.ing.taskfscore.domain.model;

import io.vavr.collection.List;
import pl.ing.taskfscore.data.model.NotificationTemplate;

import java.util.Comparator;
import java.util.UUID;

public record NotificationTemplateDTO(
        UUID id,
        String title,
        String content,
        List<String> receivers,
        List<NotificationRuleDTO> rules
) {

    public static NotificationTemplateDTO from(NotificationTemplate template) {
        return new NotificationTemplateDTO(
                template.id(),
                template.title(),
                template.content(),
                template.receivers().toSortedSet().toList(),
                template.rules()
                        .toSortedSet(Comparator.comparing(r -> r.operator().value))
                        .map(NotificationRuleDTO::from)
                        .toList()
        );
    }
}
