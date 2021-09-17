package api.project.valuesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ValueController {

    @GetMapping
    public String getValue(){
        return "value";
    }
}
