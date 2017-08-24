package Controlers;


import dto.MessagesDTO;
import dto.RoomDTO;
import dto.UserDTO;
import entity.MessagesEntity;
import entity.UserEntity;
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
public class EnterController {


    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private IUserService userService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/postloginpage", method = RequestMethod.POST)
    public String displayUser(@ModelAttribute("enterRoom") RoomDTO roomDTO, HttpSession session) {

        session.setAttribute("enterRoom", roomDTO);
        return "redirect:/chatpage";
    }
    @RequestMapping(value = "/postloginpage", method = RequestMethod.GET)
    public String displayUser(Model model) {
        model.addAttribute("enterRoom", new RoomDTO());
        model.addAttribute("room",roomService.getAllRooms());
        return "/postloginpage";
    }
}
//
////    @RequestMapping(value = "login",method = RequestMethod.GET)
////    public String changeRoom(Model model){
////        model.addAttribute("rooms", iRoomService.getAllRooms());
////        return "/index";
////
////    }
//
//
//        @RequestMapping(value ="login", method = RequestMethod.POST)
//        public String loginPost( Model model, HttpSession session,@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result){
//            loginValidator.validate(userDTO,result);
//            if (result.hasErrors()){
//                return "index";
//
//            }
//            else { if (iuserService.isLoginExists(userDTO.getLogin())) {
//
//                if (iuserService.isPasswpodlCorrect(userDTO)) {
//                    if (session.getAttribute("userDTO") == null) { // if session doesnt contain userDTO object
//                        session.setAttribute("userDTO", userDTO);
//                        session.setAttribute("messageService", iMessageService);
////                        session.setAttribute("roomService",iRoomService);
//                        session.setAttribute("ownpage", 0); // 0 means page shows posts for all users
////                        model.addAttribute("rooms",iRoomService.getAllRooms());
////                        return "/postloginpage";
//
//                        return "redirect:/postloginpage";
//                    }
//                    model.addAttribute("formNotification", "It's impossible to login. Try to exit first!");
//                    return "/index";
//
//                } else {
//                    model.addAttribute("formNotification", "Incorrect password");
//                    return "/index";
//                }
//            } else {
//                model.addAttribute("formNotification",
//                        String.format("User %s doesn't exist", userDTO.getLogin()));
//                return "/index";
//            }
//
//            }
//
//        }
//
//    @RequestMapping(value = "/postloginpage", method = RequestMethod.GET)
//    public String displayUser(Model model) {
//        model.addAttribute("rooms", iRoomService.getAllRooms());
//        return "/postloginpage";
//    }
////
//        @RequestMapping(value = "/",method = RequestMethod.GET)
//        public String loginProcess(Model model){
//            model.addAttribute("userDTO", new UserDTO());
//            return "/index";
//
//        }
//
//        @RequestMapping(value = "exit",method = RequestMethod.GET)
//        public String exit(HttpSession session,Model model){
//            session.invalidate();
//            model.addAttribute("userDTO", new UserDTO());
//            return "index";
//        }
//
//
//
//
//    }
//
//
