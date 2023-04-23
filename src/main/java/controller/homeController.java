package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {

/*    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }*/
    @GetMapping("/home")
    public String index() {
        return "index";
    }
}
