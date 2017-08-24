package validators;


import dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Login mustn't be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "password mustn't be empty.");
    }
}