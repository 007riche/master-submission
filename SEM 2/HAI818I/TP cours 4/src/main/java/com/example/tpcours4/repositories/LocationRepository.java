package com.example.tpcours4.repositories;

import com.example.tpcours4.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
