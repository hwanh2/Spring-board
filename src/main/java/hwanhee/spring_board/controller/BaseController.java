package hwanhee.spring_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("data","welcome");
        return "index";
    }
}
