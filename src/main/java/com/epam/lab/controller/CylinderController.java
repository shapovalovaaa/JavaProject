package com.epam.lab.controller;

import com.epam.lab.cash.InMemoryCash;
import com.epam.lab.counter.RequestCounterThread;
import com.epam.lab.counter.RequestResponse;
import com.epam.lab.entity.Cylinder;
import com.epam.lab.service.VolumeService;
import com.epam.lab.validators.ParamValidator;
import com.epam.lab.validators.ValidationParamError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab")
public class CylinderController {
    private static final Logger logger = LogManager.getLogger(CylinderController.class);
    @Autowired
    private final VolumeService volumeService;
    private ParamValidator paramValidator;
    private InMemoryCash inMemoryCash;

    public CylinderController(final VolumeService volumeService, ParamValidator paramValidator,
                              InMemoryCash inMemoryCash) {
        this.volumeService = volumeService;
        this.paramValidator = paramValidator;
        this.inMemoryCash = inMemoryCash;
    }
    @GetMapping(path="/countCylinderVolume")
    public ResponseEntity<Object> cylinderVolume(@RequestParam("height") double height, @RequestParam ("radius") double radius)
    {
        RequestCounterThread t = new RequestCounterThread();

        ValidationParamError response = paramValidator.validateParam(height);
        ValidationParamError responseRadius = paramValidator.validateParam(radius);

        if(response.getErrorMessages().size() != 0){
            response.setStatus(HttpStatus.BAD_REQUEST);
            logger.error("Height argument is not valid");

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if(responseRadius.getErrorMessages().size() != 0){
            responseRadius.setStatus(HttpStatus.BAD_REQUEST);
            logger.error("Radius argument is not valid");
            return new ResponseEntity<>(responseRadius, HttpStatus.BAD_REQUEST);
        }
        try {
            Cylinder cylinder = new Cylinder(height, radius);
            double volume = volumeService.count(cylinder);
            ValidationParamError responseVolume = paramValidator.validateParam(volume);
            if (responseVolume.getErrorMessages().size() == 0) {
                cylinder.setVolume(volume);
                inMemoryCash.saveCylinder(cylinder);
                logger.info("Successfully getMapping");
                responseVolume.setCylinder(cylinder);
                return new ResponseEntity<>(responseVolume, HttpStatus.OK);
            } else {
                response.addErrorMessage("Result is not valid");
                response.setStatus(HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleUnchecked(RuntimeException e) {
        RequestCounterThread t = new RequestCounterThread();

        ValidationParamError response = new ValidationParamError();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.addErrorMessage("Error 500: " + RuntimeException.class);
        logger.error("Error 500 occurred");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping(path="/cylinders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cylinder>> getAllCylinders() {
        return ResponseEntity.ok(inMemoryCash.getAllSavedCylinders());
    }
    @GetMapping(path="/cylinders/size")
    @ResponseStatus(HttpStatus.OK)
    public RequestResponse getCylindersCount() {
        return new RequestResponse("size", inMemoryCash.getCylinderCount());
    }
}