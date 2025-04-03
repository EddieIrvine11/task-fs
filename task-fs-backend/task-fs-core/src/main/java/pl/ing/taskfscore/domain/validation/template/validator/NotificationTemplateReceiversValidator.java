package pl.ing.taskfscore.domain.validation.template.validator;

import io.vavr.collection.Set;
import org.apache.commons.validator.routines.EmailValidator;
import pl.ing.taskfscore.domain.model.NotificationTemplateDTO;
import pl.ing.taskfscore.domain.validation.ValidationError;
import pl.ing.taskfscore.domain.validation.Validator;

import java.text.MessageFormat;

import static pl.ing.taskfscore.domain.validation.ValidationUtils.isRequired;

public class NotificationTemplateReceiversValidator implements Validator<NotificationTemplateDTO> {

    private static final String ATTRIBUTE = "receivers";
    private static final String MESSAGE_PATTERN = "{0} is not email";

    @Override
    public Set<ValidationError> validate(NotificationTemplateDTO record) {
        Set<ValidationError> requiredErrors = isRequired(ATTRIBUTE, record.receivers()).toSet();
        Set<ValidationError> emailErrors = record.receivers()
                .filterNot(EmailValidator.getInstance()::isValid)
                .map(email -> new ValidationError(ATTRIBUTE, MessageFormat.format(MESSAGE_PATTERN, email)))
                .toSet();

        return requiredErrors.addAll(emailErrors);
    }
}
