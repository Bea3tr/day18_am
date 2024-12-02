package ssf.day18_am.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ssf.day18_am.model.Carpark;
import ssf.day18_am.services.CarparkService;

@RestController
@RequestMapping
public class CpApiController {

    @Autowired
    private CarparkService cpSvc;
    
    @GetMapping(path="/api/carparks")
    public ResponseEntity<List<Carpark>> getRates() {
        
        List<Carpark> carparks = cpSvc.getCarparks();
        return ResponseEntity.ok()
                            .body(carparks);
    }

}
