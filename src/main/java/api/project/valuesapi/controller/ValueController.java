package api.project.valuesapi.controller;

import api.project.valuesapi.entity.Value;
import api.project.valuesapi.exception.ValueNotFoundException;
import api.project.valuesapi.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ValueController {

    private ValueRepository valueRepository;

    @Autowired
    public ValueController(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    @GetMapping
    public String welcome(){
        return "Welcome";
    }

    @PostMapping("/createValue")
    @ResponseStatus(HttpStatus.CREATED)
    public String createValue(@RequestBody Value value){
        String name = value.getValueName();
        String content = value.getValueContent();
        if( name.length()<2 || content.length()<2 )
        { return "request is not valid"; }
        else{
            valueRepository.save(value);
            return "request completed: " + value.getValueName();
        }
    }

    @GetMapping("/listAllValues")
    public List<Value> listAllValues(){
        return valueRepository.findAll();
    }

    @GetMapping("/listOne/{id}")
    public Optional<Value> listValue(@PathVariable Long id) throws ValueNotFoundException {
        Optional<Value> optionalValue = valueRepository.findById(id);
        if(optionalValue.isEmpty()){
            throw new ValueNotFoundException(id);
        }
        return valueRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) throws ValueNotFoundException {
        Value value = verifyExists(id);
        valueRepository.deleteById(value.getId());
        return "Deletado";
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id) throws ValueNotFoundException {
        Value value = verifyExists(id);
        valueRepository.save(value);
        return "Existe e foi modificado: "+value.getValueName();
    }

    private Value verifyExists(Long id) throws ValueNotFoundException {
        return valueRepository.findById(id)
                .orElseThrow(() -> new ValueNotFoundException(id));
    }

}
