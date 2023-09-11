package com.stevendev.apirest.service.trucks.impl;

import java.util.List;
import java.util.UUID;
import com.stevendev.apirest.dao.trucks.TruckRepository;
import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.domain.trucks.Truck;
import com.stevendev.apirest.dto.trucks.request.TruckRequestDto;
import com.stevendev.apirest.dto.trucks.response.TruckResponseDto;
import com.stevendev.apirest.mapper.trucks.TruckMapper;
import com.stevendev.apirest.service.trucks.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService {

    private TruckRepository truckRepository;
    private TruckMapper truckMapper;

    @Override
    public List<TruckResponseDto> findAll() {
        return truckRepository
                .findAll()
                .stream()
                .map(truck -> truckMapper.toResponseDto(truck))
                .toList();
    }

    @Override
    public TruckResponseDto findByUuid(UUID truckUuid) {
        return truckMapper.toResponseDto(findById(truckUuid));
    }

    @Override
    public TruckResponseDto findByCode(String code) {
        var truck = truckRepository.findByCode(code).orElseThrow( ()-> new IllegalStateException(""));
        return truckMapper.toResponseDto(truck);
    }

    @Override
    public TruckResponseDto save(TruckRequestDto request) {
        var truckSaved = truckRepository.save(truckMapper.toTruck(request));

        return truckMapper.toResponseDto(truckSaved);
    }

    @Override
    public TruckResponseDto update(UUID truckUuid, Truck truck) {
        var truckFound = findById(truckUuid);
        truckMapper.update(truck, truckFound);

        return truckMapper.toResponseDto(truckRepository.save(truckFound));
    }

    @Override
    public void delete(UUID truckUuid) {
        var truckFound = findById(truckUuid);
        truckRepository.delete(truckFound);
    }

    private Truck findById(UUID truckUuid) {
        return truckRepository.findById(truckUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }

    @Override
    public TruckResponseDto addToDriver(Driver driver, TruckRequestDto request) {

        var truckSaved = truckRepository.save( request.toEntity(driver) );

        return truckMapper.toResponseDto(truckSaved);
    }
}
