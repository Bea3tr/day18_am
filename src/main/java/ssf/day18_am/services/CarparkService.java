package ssf.day18_am.services;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.day18_am.constant.Constant;
import ssf.day18_am.model.Carpark;

@Service
public class CarparkService {

    RestTemplate restTemplate = new RestTemplate();

    public List<Carpark> getCarparks() {
        List<Carpark> carparkList = new LinkedList<>();
        String carparkRawData = restTemplate.getForObject(Constant.CARPARK_URL, String.class);
        JsonReader reader = Json.createReader(new StringReader(carparkRawData));
        JsonArray records = reader.readObject()
                                  .getJsonArray("records");

        for(int i = 0; i < records.size(); i++) {
            JsonObject record = records.getJsonObject(i);
            Carpark cp = new Carpark(record.getInt("_id"), record.getString("carpark"), 
                                    record.getString("category"), record.getString("weekdays_rate_1"), 
                                    record.getString("weekdays_rate_2"), record.getString("saturday_rate"), 
                                    record.getString("sunday_publicholiday_rate"));
            carparkList.add(cp);
        }

        return carparkList;
    }
    
}
