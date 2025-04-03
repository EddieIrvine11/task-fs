package pl.ing.taskfscore.data.model;

import io.vavr.collection.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document
public record NotificationTemplate(
        @Id UUID id,
        @Field String title,
        @Field String content,
        @Field Set<String> receivers,
        @Field Set<NotificationRule> rules
) {
}
