package com.wonderlabz.assessment.backend.service.impl;

import com.wonderlabz.assessment.backend.model.Response;
import com.wonderlabz.assessment.backend.service.ConversionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@Import(ConversionServiceImpl.class)
@DataJpaTest
class ConversionServiceImplTest {

    @Autowired
    private ConversionService conversionService;

    private NumberFormat formatter;

    @BeforeEach
    void setUp() {
        formatter = DecimalFormat.getInstance();
        formatter.setMaximumFractionDigits(2);
    }

    @Test
    void convertingKelvinToCelsius() {
        Response response = conversionService.convertingKelvinToCelsius(280);
        assertEquals(6.85, response.getResult().doubleValue());
    }

    @Test
    void convertingCelsiusToKevin() {
        Response response = conversionService.convertingCelsiusToKevin(6.85);
        assertEquals(280, response.getResult().doubleValue());
    }

    @Test
    void convertingMilesToKilometres() {
        Response response = conversionService.convertingMilesToKilometres(6.00);
        assertEquals(9.65, response.getResult().doubleValue());
    }

    @Test
    void convertingKilometersToMiles() {
        Response response = conversionService.convertingKilometersToMiles(9.65);
        assertEquals(6.00, response.getResult().doubleValue());
    }
}