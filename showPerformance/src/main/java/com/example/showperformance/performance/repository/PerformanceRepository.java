package com.example.showperformance.performance.repository;

import com.example.showperformance.performance.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    boolean existsByPerformId(String performId);
}
