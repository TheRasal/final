package Controlers;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.message.IMessageService;
import service.profile.IRoomService;
import service.user.IUserService;
import validators.LoginValidator;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private IUserService iuserService;

    @Autowired
    private IMessageService iMessageService;

    @Autowired
    private IRoomService roomService;



    @RequestMapping(value ="login", method = RequestMethod.POST)
    public String loginPost( Model model, HttpSession session,@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result){
        loginValidator.validate(userDTO,result);
        if (result.hasErrors()){
            return "index";

        }
        else { if (iuserService.isLoginExists(userDTO.getLogin())) {

            if (iuserService.isPasswpodlCorrect(userDTO)) {
                if (session.getAttribute("userDTO") == null) { // if session doesnt contain userDTO object
                    session.setAttribute("userDTO", userDTO);
                    session.setAttribute("messageService", iMessageService);
                    session.setAttribute("roomService",roomService);
                    session.setAttribute("ownpage", 0); // 0 means page shows posts for all users
                    return "redirect:/postloginpage";
                }
                model.addAttribute("formNotification", "It's impossible to login. Try to exit first!");
                return "/index";

            } else {
                model.addAttribute("formNotification", "Incorrect password");
                return "/index";
            }
        } else {
            model.addAttribute("formNotification",
                    String.format("User %s doesn't exist", userDTO.getLogin()));
            return "/index";
        }

        }

    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loginProcess(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "/index";

    }

    @RequestMapping(value = "exit",method = RequestMethod.GET)
    public String exit(HttpSession session,Model model){
        session.invalidate();
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }




}
