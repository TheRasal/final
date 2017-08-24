package tags;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 *  Created by ZheynovVV on 22.09.2016.
 */

public class PostImage extends TagSupport {

    private byte[] imageByte;

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    @Override
    public int doStartTag() {

        if (imageByte != null && imageByte.length > 0) {
            String base64Encoded = Base64.encodeBase64String(imageByte);

            try {
                pageContext.getOut().print("data:image/png;base64," + base64Encoded);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_BODY_INCLUDE;
    }
}
