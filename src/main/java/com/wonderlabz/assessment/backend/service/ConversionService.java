package com.wonderlabz.assessment.backend.service;

import com.wonderlabz.assessment.backend.model.Response;

public interface ConversionService {
    Response convertingKelvinToCelsius(double kelvin);
    Response convertingCelsiusToKevin(double celsius) ;
    Response convertingMilesToKilometres(double miles);
    Response convertingKilometersToMiles(double kilometers);
}
