package com.stevendev.apirest.service.trucks;

import java.util.List;
import java.util.UUID;
import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.domain.trucks.Truck;
import com.stevendev.apirest.dto.trucks.request.TruckRequestDto;
import com.stevendev.apirest.dto.trucks.response.TruckResponseDto;

public interface TruckService {
    List<TruckResponseDto> findAll();

    TruckResponseDto findByUuid(UUID truckUuid);

    TruckResponseDto findByCode(String code);

    TruckResponseDto save(TruckRequestDto request);

    TruckResponseDto update(UUID truckUuid, Truck truck);

    void delete(UUID truckUuid);

    TruckResponseDto addToDriver(Driver driver, TruckRequestDto request);
}
