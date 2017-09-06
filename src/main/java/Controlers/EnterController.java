package controlers;



import dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.profile.RoomService;


import javax.servlet.http.HttpSession;


@Controller
public class EnterController {



    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/postloginpage", method = RequestMethod.POST)
    public String displayUser(@ModelAttribute("enterRoom") RoomDTO roomDTO, HttpSession session) {

        session.setAttribute("enterRoom", roomDTO);
        return "redirect:/chatpage";
    }
    @RequestMapping(value = "/postloginpage", method = RequestMethod.GET)
    public String displayUser(Model model) {
        model.addAttribute("enterRoom", new RoomDTO());
        model.addAttribute("rooms",roomService.getAllRooms());
        return "/postloginpage";
    }
}

