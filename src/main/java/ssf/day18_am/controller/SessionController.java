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

    @GetMapping
    public String getSession() {
        return "session";
    }

    @PostMapping("/cart")
    public String postCart(Model model, 
        HttpSession sess,
        @RequestBody MultiValueMap<String, String> form) {

        String item = form.getFirst("item");
        int qty = Integer.parseInt(form.getFirst("quantity"));

        // Get session 
        Map<String, Integer> cartList = (Map<String, Integer>) sess.getAttribute("cartList");
        if(cartList == null) {
            cartList = new HashMap<>();
            sess.setAttribute("cartList", cartList);
        }
        
        if(cartList.containsKey(item)) {
            cartList.put(item, cartList.get(item)+qty);
        } else {
            cartList.put(item, qty);
        }

        model.addAttribute("cartList", cartList);
        return "session-cart";
    }
    
}
