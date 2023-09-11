package com.stevendev.apirest.dao.trucks;

import com.stevendev.apirest.domain.trucks.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruckRepository extends CrudRepository<Truck, UUID> {
    List<Truck> findAll();

    List<Truck> findAllByCode(String code);

    Optional<Truck> findByCode(String code);
}
