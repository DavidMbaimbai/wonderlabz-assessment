package com.wonderlabz.assessment.backend.controller;

import com.wonderlabz.assessment.backend.model.Response;
import com.wonderlabz.assessment.backend.service.ConversionService;
import com.wonderlabz.assessment.backend.service.impl.ConversionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {ConversionController.class})
@ExtendWith(SpringExtension.class)
@Import(ConversionServiceImpl.class)
class ConversionControllerTest {

    @MockBean
    private ConversionService conversionService;

    @Autowired
    private MockMvc mockMvc;
    Response response;

    @BeforeEach
    void setUp() {
        response = Response
                .builder()
                .result(BigDecimal.valueOf(20.20))
                .build();
    }

    @Test
    void convertingKelvinToCelsius() throws Exception {
        when(conversionService.convertingKelvinToCelsius(any(Double.class))).thenReturn(response);
        mockMvc.perform(get("/conversions/ktoc/280"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void convertingCelsiusToKevin() throws Exception {
        when(conversionService.convertingCelsiusToKevin(any(Double.class))).thenReturn(response);
        mockMvc.perform(get("/conversions/ctok/6.85"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void convertingMilesToKilometres() throws Exception {
        when(conversionService.convertingMilesToKilometres(any(Double.class))).thenReturn(response);
        mockMvc.perform(get("/conversions/mtok/6.00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void convertingKilometersToMiles() throws Exception {
        when(conversionService.convertingKilometersToMiles(any(Double.class))).thenReturn(response);
        mockMvc.perform(get("/conversions/ktom/9.65"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }
}