package ama;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robertfernandes on 2/7/2017.
 */
@RestController
public class WebController {

    @RequestMapping("/")
    public String hi() {
        return "hi";
    }
}
