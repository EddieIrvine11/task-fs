package pl.ing.taskfscore.domain.validation.template.validator;

import io.vavr.collection.Set;
import pl.ing.taskfscore.domain.model.NotificationTemplateDTO;
import pl.ing.taskfscore.domain.validation.ValidationError;
import pl.ing.taskfscore.domain.validation.ValidationUtils;
import pl.ing.taskfscore.domain.validation.Validator;

public class NotificationTemplateContentValidator implements Validator<NotificationTemplateDTO> {

    private static final String ATTRIBUTE = "content";

    @Override
    public Set<ValidationError> validate(NotificationTemplateDTO record) {
        return ValidationUtils.isRequired(ATTRIBUTE, record.content()).toSet();
    }
}
