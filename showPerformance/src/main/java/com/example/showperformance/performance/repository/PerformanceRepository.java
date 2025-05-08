package com.example.showperformance.performance.repository;

import com.example.showperformance.performance.domain.Performance;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    Optional<Performance> findByPerformId(String performId);
}
