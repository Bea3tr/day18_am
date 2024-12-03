package ssf.day18_am.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.day18_am.constant.Constant;
import ssf.day18_am.model.Person;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.io.StringReader;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private static final Logger logger = Logger.getLogger(DemoController.class.getName());
    @Autowired @Qualifier(Constant.template02)
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/health")
    public ModelAndView getHealth() {

        ModelAndView mav = new ModelAndView();

        try {
            checkHealth();
            
            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }
        return mav;
    }
    
    private void checkHealth() throws Exception {
        Random rand = new SecureRandom();
        int r = rand.nextInt(11);

        if(r < 6) {
            throw new Exception();
        }
    }

    @GetMapping("/time")
    public String displayDateTime(Model model) {
        
        // YYYY-MM-dd HH:mm:ss    1980-07-25 15:30:40
        // YYYY-MMM-dd hh:mm:ss a 1980-JUL-25 3:30:40 PM
        String strDate = "1980-07-25 15:30:40";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date demoDate = df.parse(strDate);
            long epochMilliseconds = demoDate.getTime();
            Date retrievedDate = new Date(epochMilliseconds);

            model.addAttribute("date", retrievedDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "time";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<String> testHash() {

        List<String> wordList = new LinkedList<>();
        wordList.add("Marina");
        wordList.add("Park");
        wordList.add("Hotel");
        wordList.add("Bridge");
        wordList.add("Merlion");
        wordList.add("Cruise");

        redisTemplate.opsForHash().put("words", "map", wordList.toString());

        Object objWords = redisTemplate.opsForHash().get("words", "map");
        String strObject = objWords.toString();

        strObject = strObject.replace("[", "");
        strObject = strObject.replace("]", "");
        strObject = strObject.replace(" ", "");
        String[] splitWords = strObject.split("\\,");
        
        List<String> retrievedList = new LinkedList<>();
        for(String word : splitWords)
            retrievedList.add(word);
        return retrievedList;
    }

    @GetMapping("/person")
    @ResponseBody
    public String testPersonHash() {
        List<String> personsList = new LinkedList<>();
        personsList.add((new Person("1", "freddy", "freddy@gmail.com", "543212", "9876543")).toString());
        personsList.add((new Person("2", "bonny", "bonny@gmail.com", "123456", "9765421")).toString());

        redisTemplate.opsForHash().put("persons", "map", personsList.toString());

        Object objPerson = redisTemplate.opsForHash().get("persons", "map");

        String strObject = objPerson.toString();

        logger.info(strObject);

        // List<Person> pList = new LinkedList<>();
        // JsonReader reader = Json.createReader(new StringReader(strObject));
        // JsonArray arr = reader.readArray();
        // for (int i = 0; i < arr.size(); i++) {
        //     JsonObject obj = arr.getJsonObject(i);
        //     Person p = new Person(obj.getString("id"), obj.getString("fullName"),
        //                      obj.getString("email"), obj.getString("postalCode"), 
        //                      obj.getString("phoneNumber"));
        //     pList.add(p);
        // }
        

        // strObject = strObject.replace("[", "");
        // strObject = strObject.replace("]", "");
        // String[] splitWords = strObject.split(", ");

        // List<String> retrievedList = new LinkedList<>();
        // for(String word : splitWords)
        //     retrievedList.add(word);
        return strObject;
    }

}
