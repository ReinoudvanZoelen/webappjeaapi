package BeanValidation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class BeanValidation_ValidationService {
    public static ArrayList<String> ValidateBeans(Object objectToValidate){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var validationMessages = validator.validate(objectToValidate);

        ArrayList<String> constaintMessages = new ArrayList();

        for (Iterator<ConstraintViolation<Object>> constaintViolation = validationMessages.iterator(); constaintViolation.hasNext();) {
            ConstraintViolation<Object> myViolation = constaintViolation.next();
            constaintMessages.add(myViolation.getConstraintDescriptor().getMessageTemplate());
        }

        return constaintMessages;
    }
}
