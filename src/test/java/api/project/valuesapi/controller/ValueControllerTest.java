package api.project.valuesapi.controller;

import api.project.valuesapi.entity.Value;
import api.project.valuesapi.exception.ValueNotFoundException;
import api.project.valuesapi.repository.ValueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValueControllerTest {
    @Mock
    private ValueController valueController;

    @Test
    void deleteById() throws ValueNotFoundException {
        String response = valueController.deleteById(1L);
        assertNotNull(response);
    }
}