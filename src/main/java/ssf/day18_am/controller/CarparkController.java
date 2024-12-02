package ssf.day18_am.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import ssf.day18_am.constant.Constant;
import ssf.day18_am.model.Carpark;

@Controller
@RequestMapping
public class CarparkController {

    RestTemplate restTemplate = new RestTemplate();
    
    @GetMapping(path="/carparks")
    public String getRates(Model model) {

        // get from ResponseEntity of rest controller
        List<Carpark> carparks = restTemplate.exchange(Constant.LOCAL_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Carpark>>() {
        }).getBody();

        model.addAttribute("carparks", carparks);
        return "index";
    }
}
