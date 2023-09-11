package com.stevendev.apirest.service.drivers;

import java.util.List;
import java.util.UUID;

import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.dto.drivers.request.DriverRequestDto;
import com.stevendev.apirest.dto.drivers.response.DriverResponseDto;

public interface DriverService {
    List<DriverResponseDto> findAll();

    DriverResponseDto findByUuid(UUID driverUuid);

    DriverResponseDto findByName(String name);

    DriverResponseDto save(DriverRequestDto request);

    DriverResponseDto update(UUID driverUuid, Driver driver);

    void delete(UUID driverUuid);
}
