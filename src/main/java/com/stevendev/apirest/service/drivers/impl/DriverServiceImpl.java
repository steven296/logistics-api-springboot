package com.stevendev.apirest.service.drivers.impl;

import com.stevendev.apirest.dao.drivers.DriverRepository;
import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.dto.drivers.request.DriverRequestDto;
import com.stevendev.apirest.dto.drivers.response.DriverResponseDto;
import com.stevendev.apirest.mapper.drivers.DriverMapper;
import com.stevendev.apirest.service.drivers.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;
    private DriverMapper driverMapper;

    @Override
    public List<DriverResponseDto> findAll() {

        return driverRepository
                .findAll()
                .stream()
                .map( driver -> driverMapper.toResponseDto(driver))
                .toList();
    }

    @Override
    public DriverResponseDto findByName(String name) {

        var person = driverRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException(""));

        return driverMapper.toResponseDto(person);
    }

    @Override
    public DriverResponseDto findByUuid(UUID driverUuid) {
        return driverMapper.toResponseDto(findById(driverUuid));
    }

    @Override
    public DriverResponseDto save(DriverRequestDto request) {
        var driverSaved = driverRepository.save(driverMapper.toDriver(request));

        return driverMapper.toResponseDto(driverSaved);
    }

    @Override
    public DriverResponseDto update(UUID driverUuid, Driver driver) {
        var driverFound = findById(driverUuid);

        driverMapper.update(driver, driverFound);

        return driverMapper.toResponseDto(driverRepository.save(driverFound));
    }

    @Override
    public void delete(UUID driverUuid) {
        var driverFound = findById(driverUuid);
        driverRepository.delete(driverFound);
    }

    private Driver findById(UUID driverUuid) {
        return driverRepository.findById(driverUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }
}
