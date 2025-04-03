package pl.ing.taskfscore.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.ing.taskfscore.data.model.NotificationTemplate;

import java.util.UUID;

public interface NotificationTemplateRepository extends ReactiveMongoRepository<NotificationTemplate, UUID> {


}
