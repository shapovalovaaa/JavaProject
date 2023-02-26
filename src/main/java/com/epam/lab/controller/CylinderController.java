package com.epam.lab.controller;

import com.epam.lab.entity.Cylinder;
import com.epam.lab.exception.ValueException;
import com.epam.lab.service.VolumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lab")
public class CylinderController {
    private static final Logger logger = LogManager.getLogger(CylinderController.class);
    private final VolumeService volumeService;

    public CylinderController(VolumeService volumeService) {
        this.volumeService = volumeService;
    }
    @GetMapping(path="/countCylinderVolume")
    public Cylinder cylinderVolume(@RequestParam("height") double height, @RequestParam ("radius") double radius)
    throws ValueException {
        if (!validParam(height) || !validParam(radius))
            throw new ValueException(HttpStatus.BAD_REQUEST,"invalid input");

        Cylinder cylinder = new Cylinder(height, radius);
        volumeService.setVolumeService(cylinder);
        double volume = volumeService.count();

        if(!validParam(volume))
            throw new ValueException(HttpStatus.NOT_FOUND, "value of result is out of range");
        logger.info("Successfully getMapping");
        return new Cylinder(height, radius, volume);
    }
    public boolean validParam(double param) {
        if (param <= 0 || param > Double.MAX_VALUE)
            return false;
        return true;
    }

    @ExceptionHandler(ValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // обработчик unchecked ошибок
    public ResponseEntity<String> handleMyException(ValueException e) {
        logger.warn("error 400");
        return new ResponseEntity<>("<h1>Error 400<br></h1>" + ValueException.class + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // обработчик unchecked ошибок
    public ResponseEntity<String> handleUnchecked(RuntimeException e) {
        logger.warn("error 500");
        return new ResponseEntity<>("<h1>Error 500<br></h1>" + RuntimeException.class + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
