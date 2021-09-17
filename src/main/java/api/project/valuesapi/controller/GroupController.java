package api.project.valuesapi.controller;

import api.project.valuesapi.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    private ValueRepository valueRepository;

    @Autowired
    public GroupController(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }


}
