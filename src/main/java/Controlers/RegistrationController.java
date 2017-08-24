package Controlers;

import dto.UserDTO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.user.IUserService;
import utils.UtilClass;
import validators.RegValidator;

@Controller
public class RegistrationController {

    @Controller
    public class RegController extends ExceptionsController {

        @Autowired
        private RegValidator regValidator;

        @Autowired
        private IUserService userService;

        /**
         * Registration of user and adding user+profile to DB
         *
         * @param model
         * @param userEntity
         * @param result
         * @return
         */
        @RequestMapping(value = "/registrationpage", method = {RequestMethod.POST})
        public String Registration(Model model,
                                   @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result) {

            regValidator.validate(userEntity, result);

            if (result.hasErrors()) {
                return "registrationpage";
            } else {

                if (userService.isLoginExists(userEntity.getLogin())) {
                    model.addAttribute("formNotification",
                            String.format("User with login <b>%s </b>" +
                                            "was already registered",
                                    userEntity.getLogin()));
                    return "registrationpage";

                } else {

                    if (userService.isEmailExists(userEntity.getEmail())) {

                        model.addAttribute("formNotification",
                                String.format("User with email <b>%s </b>" +
                                        "was already registered", userEntity.getEmail()));
                        return "registrationpage";

                    } else {
                        try {
                            model.addAttribute("formNotification",
                                    String.format("User with login <b>%s </font></b>" +
                                            "has been created", userEntity.getLogin()));
                            model.addAttribute("userDTO", new UserDTO());

                            //Password encofing
                            userEntity.setPassword(UtilClass.passEncoding(userEntity.getPassword()));

                            //Profile creation for our new user
//                            Profile profile = new Profile();
//                            profile.setFirstName(userEntity.getFirstName());
//                            profile.setLastName(userEntity.getLastName());
//                            profile.setEmail(userEntity.getEmail());
//                            userEntity.setProfile(profile);
//                            profile.setUser(userEntity);
                            userService.createUser(userEntity);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return "index";
                    }
                }
            }
        }

        /**
         * Adding a model object to registrationpage.jsp
         *
         * @param model
         * @return
         */
        @RequestMapping(value = "/registrationpage", method = RequestMethod.GET)
        public String displayUser(Model model) {
            model.addAttribute("userEntity", new UserEntity());
            return "registrationpage";
        }

    }
}
