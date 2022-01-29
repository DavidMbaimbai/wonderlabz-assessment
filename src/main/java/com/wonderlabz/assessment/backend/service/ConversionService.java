package com.wonderlabz.assessment.backend.service;

import com.wonderlabz.assessment.backend.model.Conversion;
import com.wonderlabz.assessment.backend.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConversionService {
    Response convertingKelvinToCelsius(double kelvin);
    Response convertingCelsiusToKevin(double celsius) ;
    Response convertingMilesToKilometres(double miles);
    Response convertingKilometersToMiles(double kilometers);
    List<Conversion> getAllConversions();
}
