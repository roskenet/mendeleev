package de.roskenet.copper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CopperController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        String firstName = name.split(" ")[0];
        return "Hello, " + firstName + "!";
    }
}
