package pl.ing.taskfscore.domain.validation.template;

import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.Map;
import io.vavr.collection.Set;
import pl.ing.taskfscore.domain.model.NotificationTemplateDTO;
import pl.ing.taskfscore.domain.validation.Validation;
import pl.ing.taskfscore.domain.validation.Validator;
import pl.ing.taskfscore.domain.validation.template.validator.NotificationTemplateContentValidator;
import pl.ing.taskfscore.domain.validation.template.validator.NotificationTemplateReceiversValidator;
import pl.ing.taskfscore.domain.validation.template.validator.NotificationTemplateRulesValidator;
import pl.ing.taskfscore.domain.validation.template.validator.NotificationTemplateTitleValidator;

public class NotificationTemplateValidation extends Validation<NotificationTemplateDTO> {

    private final Map<String, Validator<NotificationTemplateDTO>> validators;
    private final Set<String> excluded;

    public NotificationTemplateValidation(NotificationTemplateDTO dto, Set<String> excluded) {
        super(dto);

        this.excluded = excluded;
        this.validators = HashMap.of(
                "title", new NotificationTemplateTitleValidator(),
                "content", new NotificationTemplateContentValidator(),
                "receivers", new NotificationTemplateReceiversValidator(),
                "rules", new NotificationTemplateRulesValidator()
        );
    }

    public NotificationTemplateValidation(NotificationTemplateDTO dto) {
        this(dto, HashSet.empty());
    }

    @Override
    public Set<Validator<NotificationTemplateDTO>> gatherValidators() {
        return validators.filterNotKeys(excluded::contains).values().toSet();
    }
}
