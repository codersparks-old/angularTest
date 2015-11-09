package example.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by codersparks on 09/11/2015.
 */
@RestController
public class Controller {

    @RequestMapping(value="/superhero", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseObject> superhero(@RequestBody RequestObject requestObject) {

        StringBuilder builder = new StringBuilder();
        builder.append("The superhero with alias: ")
                .append(requestObject.getSuperheroAlias())
                .append(" is really known as: ")
                .append(requestObject.getName());

        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage(builder.toString());

        ResponseEntity<ResponseObject> responseObjectResponseEntity = new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
        return responseObjectResponseEntity;


    }
}
