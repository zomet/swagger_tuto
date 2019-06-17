package fr.zomet.tech.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiddenSwaggerController {

    @GetMapping(path = "/hidden", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean hidden() {
        return true;
    }
}
