package pl.ing.taskfscore.domain.service;

import io.vavr.collection.Set;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;
import pl.ing.taskfscore.data.model.NotificationRule;
import pl.ing.taskfscore.data.model.NotificationTemplate;
import pl.ing.taskfscore.data.model.type.NotificationRuleOperand;
import pl.ing.taskfscore.data.model.type.NotificationRuleOperator;
import pl.ing.taskfscore.data.repository.NotificationTemplateRepository;
import pl.ing.taskfscore.domain.model.NotificationTemplateDTO;
import pl.ing.taskfscore.domain.validation.ValidationError;
import pl.ing.taskfscore.domain.validation.template.NotificationTemplateValidation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class NotificationService {

    private final NotificationTemplateRepository notificationTemplateRepository;

    public NotificationService(NotificationTemplateRepository notificationTemplateRepository) {
        this.notificationTemplateRepository = notificationTemplateRepository;
    }

    public Flux<NotificationTemplateDTO> getAllTemplates() {
        return notificationTemplateRepository.findAll().map(NotificationTemplateDTO::from);
    }

    public Mono<NotificationTemplateDTO> getOneTemplate(UUID id) {
        return notificationTemplateRepository.findById(id).map(NotificationTemplateDTO::from);
    }

    @Transactional
    public Mono<Either<Set<ValidationError>, NotificationTemplateDTO>> create(
            NotificationTemplateDTO dto
    ) {
        NotificationTemplateValidation validation = new NotificationTemplateValidation(dto);
        Set<ValidationError> errors = validation.validate();

        if (errors.isEmpty()) {
            return Mono.just(Either.left(errors));
        }

        NotificationTemplate newTemplate = new NotificationTemplate(
                null,
                dto.title(),
                dto.content(),
                dto.receivers().toSet(),
                dto.rules().map(
                        r -> new NotificationRule(
                                NotificationRuleOperator.of(r.operator()).get(),
                                NotificationRuleOperand.of(r.operand()).get(),
                                r.value()
                        )
                ).toSet()
        );

        return Mono.just(Either.right(NotificationTemplateDTO.from(newTemplate)));
    }
}
