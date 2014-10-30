
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;           
import javax.servlet.http.Part;


@FacesValidator(value="FileValidator")
public class FileValidator implements Validator
{


@Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file = (Part) value;
        String text = file.getSubmittedFileName();
        if (!text.contains(".jpg") && !text.contains("png") && 
                !text.contains("jpeg") && !text.contains("bmp")) {
            throw new ValidatorException(new FacesMessage("MapTack only accepts"
                    + " the following file types: jpg, jpeg, png, and bmp."
                    + "The uploaded file: " + text +  " is not one of these extensions."));
        }

    }
}