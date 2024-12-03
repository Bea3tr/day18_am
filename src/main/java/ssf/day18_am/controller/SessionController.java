package ssf.day18_am.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/main")
    public String getMain() {
        return "session-main";
    }

    @PostMapping("/main")
    public String postClear(HttpSession sess) {
        sess.invalidate();
        return "session-main";
    }

    @GetMapping("/new")
    public String getSession() {
        return "session-new";
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/display")
    public String postCart(Model model, 
        HttpSession sess,
        @RequestBody MultiValueMap<String, String> form) {

        String name = form.getFirst("name");
        String date = form.getFirst("dob");

        // Get session 
        Map<String, String> nameList = (Map<String, String>) sess.getAttribute("nameList");
        if(nameList == null) {
            nameList = new HashMap<>();
            sess.setAttribute("nameList", nameList);
        }
        nameList.put(name, date);
        

        model.addAttribute("nameList", nameList);
        return "session-display";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/display")
    public String getDisplay(Model model, 
        HttpSession sess) {

        // Get session 
        Map<String, Integer> nameList = (Map<String, Integer>) sess.getAttribute("nameList");
        if(nameList == null) {
            nameList = new HashMap<>();
            sess.setAttribute("nameList", nameList);
        }

        model.addAttribute("nameList", nameList);
        return "session-display";
    }


    
}
