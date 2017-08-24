package validators;


import entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "firstName.email", "First Name mustn't be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "lastName.login", "Last Name mustn't be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", "Email mustn't be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Login mustn't be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "password mustn't be empty.");

    }
}
