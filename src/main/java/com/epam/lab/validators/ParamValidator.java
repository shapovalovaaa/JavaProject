package com.epam.lab.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ParamValidator {
    private static final Logger logger = LogManager.getLogger(ParamValidator.class);

    public ValidationParamError validateParam (Double param) {
        ValidationParamError response = new ValidationParamError();
        if (param <= 0.0) {
            logger.error("Param value can't be less or equal to zero (<=0)");
            response.addErrorMessage("Param can't be less or equal to zero (<=0)");
        }
        if (param > Double.MAX_VALUE) {
            logger.error("Param value can't be bigger than 1.7*10^308");
            response.addErrorMessage("Param value can't be bigger than 1.7*10^308");
        }
        return response;
    }
}