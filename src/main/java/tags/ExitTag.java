package tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Redlaw on 15.09.2016.
 */

public class ExitTag extends TagSupport {

    private String userDTO;
    private String loggedAs;

    public void setUserDTO(String userDTO) {
        this.userDTO = userDTO;
    }

    public void setLoggedAs(String loggedAs) {
        this.loggedAs = loggedAs;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(loggedAs + " <b>" + this.userDTO+"</b>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
}





