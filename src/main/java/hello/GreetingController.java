package hello;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping(value = {"/","home**"},method = RequestMethod.GET)
    public String Welcome(Map <String, Object> model) {
        model.put("message", "To my first spring website");
        return "home";
    }

    @RequestMapping(value = {"/admin**"},method = RequestMethod.GET)
    public String Admin(@RequestParam(value="user", required = true)String name,Map <String, Object> model) {
        model.put("message", "Admin Your flag is GE_CTF{*************}");
        return "home";
    }

    @RequestMapping(value = "/loginerror**")
    public String LoginError(Model model)
    {
        model.addAttribute("loginError", true);
        return "Login";
    }
    @RequestMapping(value = "/login**")
    public String Login() {
        return "login";
    }

}
