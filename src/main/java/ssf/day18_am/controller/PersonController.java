package ssf.day18_am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ssf.day18_am.model.Person;
import ssf.day18_am.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService perSvc;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/create")
    public String postMethodName(@Valid @RequestBody MultiValueMap<String, String> form, BindingResult bindings) {
        Person person = new Person(form.getFirst("id"), form.getFirst("fullName"), 
            form.getFirst("email"), form.getFirst("postalCode"), form.getFirst("phoneNumber"));
        perSvc.insertPerson(person);

        return "redirect:/person/listing";
    }
    
    @PostMapping
    public String postPerson(Model model,
        @Valid @ModelAttribute Person person,
        BindingResult bindings) {

        if(bindings.hasErrors())
            return "person";

        person.setId(perSvc.generateId());
        perSvc.insertPerson(person);
        // Redirect to /persons/listing - not html
        return "redirect:/person/listing";
    }

    @GetMapping("/listing")
    public String personListing(Model model) {
        model.addAttribute("persons", perSvc.getPersons());
        return "personListing";
    }
}
