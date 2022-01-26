package com.wonderlabz.assessment.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cFrom;
    private String cTo;
    @Column(name = "from_value")
    private Double fromValue;
    @Column(name = "to_value")
    private Double toValue;
}
