package com.wonderlabz.assessment.backend.repository;

import com.wonderlabz.assessment.backend.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
