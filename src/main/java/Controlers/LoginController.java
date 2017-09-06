package controlers;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.user.UserService;
import validators.LoginValidator;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class LoginController {


    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(Model model, Locale locale, HttpSession session, @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {
        loginValidator.validate(userDTO, result);
        if (result.hasErrors()) {
            return "index";

        } else if (userService.isLoginExists(userDTO.getLogin()) && userService.isPasswpodlCorrect(userDTO) && session.getAttribute("userDTO") == null) {
            session.setAttribute("userDTO", userDTO);
            session.setAttribute("ownpage", 0);
            return "redirect:/postloginpage";
        } else {
            model.addAttribute("formNotification", messageSource.getMessage("207", new Object[]{}, locale));
            return "/index";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginProcess(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/index";

    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/index";

    }

    @RequestMapping(value = "exit", method = RequestMethod.GET)
    public String exit(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }


}
