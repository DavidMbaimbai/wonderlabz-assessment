package com.wonderlabz.assessment.backend.controller;

import com.wonderlabz.assessment.backend.model.Conversion;
import com.wonderlabz.assessment.backend.model.Response;
import com.wonderlabz.assessment.backend.service.ConversionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;
    @GetMapping("/conversions")
    public ResponseEntity<List<Conversion>> listAllConversions() {
        log.info("Getting all conversions");
        return new ResponseEntity<>(conversionService.getAllConversions(), HttpStatus.OK);
    }
    @GetMapping("/conversions/ktoc")
    public ResponseEntity<Response> convertingKelvinToCelsius(@RequestParam double kelvin) {
        log.info("Converting {} kelvin to celsius", kelvin);
        return new ResponseEntity<>(conversionService.convertingKelvinToCelsius(kelvin), HttpStatus.OK);
    }
    @GetMapping("/conversions/ctok")
    public ResponseEntity<Response> convertingCelsiusToKevin(@RequestParam double celsius){
        log.info("Converting {} celsius to kelvin", celsius);
        return new ResponseEntity<>(conversionService.convertingCelsiusToKevin(celsius), HttpStatus.OK);
    }
    @GetMapping("/conversions/mtok")
    public ResponseEntity<Response> convertingMilesToKilometres(@RequestParam double miles) {
        log.info("Converting {} miles to kilometers", miles);
        return new ResponseEntity<>(conversionService.convertingMilesToKilometres(miles), HttpStatus.OK);
    }
    @GetMapping("/conversions/ktom")
    public ResponseEntity<Response> convertingKilometersToMiles(@RequestParam double kilometers){
        log.info("Service: Converting {} kilometers to miles", kilometers );
        return new ResponseEntity<>(conversionService.convertingKilometersToMiles(kilometers), HttpStatus.OK);
    }
}
