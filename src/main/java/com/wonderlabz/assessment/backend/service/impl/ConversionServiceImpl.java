package com.wonderlabz.assessment.backend.service.impl;

import com.wonderlabz.assessment.backend.model.Conversion;
import com.wonderlabz.assessment.backend.model.Response;
import com.wonderlabz.assessment.backend.repository.ConversionRepository;
import com.wonderlabz.assessment.backend.service.ConversionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
@Service
@Slf4j
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {

    private final ConversionRepository repository;

    @Override
    public Response convertingKelvinToCelsius(double kelvin) {
        log.info("Converting {} kelvin to celsius" , kelvin);
        Response response = Response
                .builder()
                .result(BigDecimal.valueOf(kelvin - 273.15).setScale(2, RoundingMode.HALF_UP))
                .build();
        response.getResult().setScale(2, RoundingMode.HALF_UP);
        Conversion conversion = Conversion
                .builder()
                .cFrom("Kelvin")
                .cTo("Celsius")
                .fromValue(kelvin)
                .toValue(response.getResult().doubleValue())
                .build();
        repository.saveAndFlush(conversion);
        return response;
    }

    @Override
    public Response convertingCelsiusToKevin(double celsius)  {
        log.info("Converting {} celsius to kelvin", celsius);
        Response response = Response
                .builder()
                .result(BigDecimal.valueOf(celsius + 273.15).setScale(2, RoundingMode.HALF_UP))
                .build();
        response.getResult().setScale(2, RoundingMode.HALF_UP);
        Conversion conversion = Conversion
                .builder()
                .cFrom("Celsius")
                .cTo("Kevin")
                .fromValue(celsius)
                .toValue(response.getResult().doubleValue())
                .build();
        repository.saveAndFlush(conversion);
        return response;
    }

    @Override
    public Response convertingMilesToKilometres(double miles){
        log.info("Converting {} miles to kilometers", miles);
        Response response = Response
                .builder()
                .result(BigDecimal.valueOf(miles * 1.609).setScale(2, RoundingMode.HALF_UP))
                .build();
        response.getResult().setScale(2, RoundingMode.HALF_UP);
        Conversion conversion = Conversion
                .builder()
                .cFrom("Miles")
                .cTo("Kilometers")
                .fromValue(miles)
                .toValue(response.getResult().doubleValue())
                .build();
        repository.saveAndFlush(conversion);
        return response;

    }

    @Override
    public Response convertingKilometersToMiles(double kilometers){
        log.info("Service: Converting {} kilometers to miles");
        Response response = Response
                .builder()
                .result(BigDecimal.valueOf(kilometers/1.609).setScale(2, RoundingMode.HALF_UP))
                .build();
        response.getResult().setScale(2, RoundingMode.HALF_UP);
        Conversion conversion = Conversion
                .builder()
                .cFrom("Kilometers")
                .cTo("Miles")
                .fromValue(kilometers)
                .toValue(response.getResult().doubleValue())
                .build();
        repository.saveAndFlush(conversion);
        return response;
    }
}
