package com.epam.lab.ValidationParamErrorTest;

import com.epam.lab.entity.Cylinder;
import com.epam.lab.validators.ParamValidator;
import com.epam.lab.validators.ValidationParamError;
import org.apache.el.util.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ParamValidatorTest {
    private ParamValidator paramValidator = new ParamValidator();
    @Test
    public void validatorTest() {
        Cylinder c = new Cylinder(0.0, Double.MAX_VALUE * 15);
        ValidationParamError value1 = paramValidator.validateParam(c.getHeight());
        ValidationParamError value2 = paramValidator.validateParam(c.getRadius());
        if(value1.getErrorMessages().size() != 0){
            value1.setStatus(HttpStatus.BAD_REQUEST);
            ResponseEntity<Object> obj1 = new ResponseEntity<>(value1, HttpStatus.BAD_REQUEST);
            Assertions.assertEquals(HttpStatus.BAD_REQUEST, obj1.getStatusCode());
        }
        if(value2.getErrorMessages().size() != 0){
            value2.setStatus(HttpStatus.BAD_REQUEST);
            ResponseEntity<Object> obj2 = new ResponseEntity<>(value2, HttpStatus.BAD_REQUEST);
            Assertions.assertEquals(HttpStatus.BAD_REQUEST, obj2.getStatusCode());
        }
    }
}
