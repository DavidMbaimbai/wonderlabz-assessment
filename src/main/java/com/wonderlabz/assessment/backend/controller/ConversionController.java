package com.wonderlabz.assessment.backend.controller;

import com.wonderlabz.assessment.backend.model.Response;
import com.wonderlabz.assessment.backend.service.ConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class ConversionController {
    @Autowired
    private ConversionService conversionService;
    @GetMapping("/conversions/ktoc/{kelvin}")
    public ResponseEntity<Response> convertingKelvinToCelsius(@PathVariable double kelvin) {
        log.info("Converting {} kelvin to celsius", kelvin);
        return new ResponseEntity<Response>(conversionService.convertingKelvinToCelsius(kelvin), HttpStatus.OK);
    }
    @GetMapping("/conversions/ctok/{celsius}")
    public ResponseEntity<Response> convertingCelsiusToKevin(@PathVariable double celsius){
        log.info("Converting {} celsius to kelvin", celsius);
        return new ResponseEntity<Response>(conversionService.convertingCelsiusToKevin(celsius), HttpStatus.OK);
    }
    @GetMapping("/conversions/mtok/{miles}")
    public ResponseEntity<Response> convertingMilesToKilometres(@PathVariable double miles) {
        log.info("Converting {} miles to kilometers", miles);
        return new ResponseEntity<Response>(conversionService.convertingMilesToKilometres(miles), HttpStatus.OK);
    }
    @GetMapping("/conversions/ktom/{kilometers}")
    public ResponseEntity<Response> convertingKilometersToMiles(@PathVariable double kilometers){
        log.info("Service: Converting {} kilometers to miles", kilometers );
        return new ResponseEntity<Response>(conversionService.convertingKilometersToMiles(kilometers), HttpStatus.OK);
    }
}
