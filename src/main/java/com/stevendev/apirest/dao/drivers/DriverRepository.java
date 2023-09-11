package com.stevendev.apirest.dao.drivers;

import com.stevendev.apirest.domain.drivers.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {
    List<Driver> findAll();

    List<Driver> findAllByName(String name);

    Optional<Driver> findByName(String name);

    List<Driver> findAllByCode(String code);

    Optional<Driver> findByCode(String code);
}
