package controlers;

import com.sun.istack.internal.NotNull;
import dto.UserDTO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.user.UserService;
import utils.UtilClass;
import validators.RegValidator;

import java.util.Locale;


@Controller
public class RegistrationController extends ExceptionsController {

    @Autowired
    private RegValidator regValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/registrationpage", method = {RequestMethod.POST})
    public String Registration(Model model, Locale locale,
                               @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result) {


        regValidator.validate(userEntity, result);
        if (result.hasErrors() || userService.isLoginExists(userEntity.getLogin()) || userService.isEmailExists(userEntity.getEmail())) {
            if (userService.isLoginExists(userEntity.getLogin())) {
                model.addAttribute("formNotification", messageSource.getMessage("205", new Object[]{}, locale));
            } else if (userService.isEmailExists(userEntity.getEmail())) {
                model.addAttribute("formNotification", messageSource.getMessage("206", new Object[]{}, locale));
            }
            return "registrationpage";
        } else {
            try {
                model.addAttribute("formNotification", messageSource.getMessage("305", new Object[]{}, locale));
                model.addAttribute("userDTO", new UserDTO());
                userEntity.setPassword(UtilClass.passEncoding(userEntity.getPassword()));
                userService.createUser(userEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "index";
        }
    }

    @RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
    public String displayUser(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registrationpage";
    }

}

