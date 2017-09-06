package controlers;

import converter.PostToPostDTOConverter;
import dto.MessagesDTO;
import dto.RoomDTO;
import dto.UserDTO;
import entity.MessagesEntity;
import entity.RoomEntity;
import entity.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.message.MessageService;
import service.profile.RoomService;
import service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@Controller
public class PostController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/makepost", method = RequestMethod.POST)
    public String displayUser(@ModelAttribute("newMessage") MessagesDTO messagesDTO, HttpSession session, @RequestParam("image") MultipartFile image) {

        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        UserEntity userEntity = userService.getUserByLogin(userDTO.getLogin());
        RoomDTO roomDTO=(RoomDTO)session.getAttribute("enterRoom");
        RoomEntity roomEntity=roomService.getRoomByName(roomDTO.getRoom_name());

        MessagesEntity newMessage = new MessagesEntity();
        java.util.Date date = new java.util.Date();
        newMessage.setPostDate(new java.sql.Date(date.getTime()));
        newMessage.setUserID(userEntity);
        newMessage.setText(messagesDTO.getText());
        newMessage.setRoomID(roomEntity);

        try {
            newMessage.setImage(image.getBytes());

        } catch (IOException e) {
            LOGGER.error(messageSource.getMessage("dao.post.saveBlob", new Object[]{image}, Locale.ENGLISH));
        }

        messageService.createMessage(newMessage);
        return "redirect:/chatpage";
//        return "redirect:/postloginpage";
    }


    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public String postUpdateInit(Model model, @PathVariable(value = "id") Long id, HttpServletResponse response) {
         MessagesEntity messagesEntity = messageService.getMessageById(id);

        // Creating postDTO object using converter and post object
        MessagesDTO messagesDTO = PostToPostDTOConverter.convertoEntityToDTO(messagesEntity);


        model.addAttribute("message", messagesDTO);
        return "/chatpage";
    }


    @RequestMapping(value = "/messagedit", method = RequestMethod.POST)
    public String postUpdate(Model model, @ModelAttribute("message") MessagesDTO messagesDTO) {

        messageService.messageEdit(messagesDTO);
        return "redirect:/chatpage#" + messagesDTO.getMessageID();
    }

    /**
     * Refreshing POSTS page using model renew
     *
     * @param model
     * @return jsp page
     */
    @RequestMapping(value = "/chatpage", method = RequestMethod.GET)
    public String displayUser(Model model) {
        model.addAttribute("newMessage", new MessagesDTO());
        model.addAttribute("messages",messageService.getAllMessage());

        return "/chatpage";
    }

    // Post destroy
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String postDeletiont(Model model, @PathVariable(value = "id") Long id) {
        MessagesEntity messagesEntity = messageService.getMessageById(id);
        messageService.deleteMessage(messagesEntity);
        return "redirect:/chatpage";
    }


    @RequestMapping(value = "/changeRoom", method = RequestMethod.GET)
    public String changeRoom (HttpSession session){
        session.removeAttribute("enterRoom");
        return "redirect:/postloginpage";
    }

    @RequestMapping(value = "/mymessages", method = RequestMethod.GET)
    public String showOnlyMyPosts(HttpSession session) {
        session.setAttribute("ownpage", 1);
        return "redirect:/chatpage";
    }


    @RequestMapping(value = "/allmessages", method = RequestMethod.GET)
    public String showAllThePosts(HttpSession session) {
        session.setAttribute("ownpage", 0);
        return "redirect:/chatpage";
    }
}
