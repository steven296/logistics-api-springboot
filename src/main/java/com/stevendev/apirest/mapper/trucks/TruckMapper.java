package com.stevendev.apirest.mapper.trucks;

import java.util.Objects;
import com.stevendev.apirest.domain.trucks.Truck;
import com.stevendev.apirest.dto.trucks.request.TruckRequestDto;
import com.stevendev.apirest.dto.trucks.response.TruckResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TruckMapper {

    public void update(Truck truckSource, Truck truckTarget) {
        if (Objects.nonNull(truckSource.getCode())) {
            truckTarget.setCode(truckSource.getCode());
        }

        if (Objects.nonNull(truckSource.getEnabled())) {
            truckTarget.setEnabled(truckSource.getEnabled());
        }
    }

    public TruckResponseDto toResponseDto(Truck truck) {
        if( truck == null){
            return null;
        }

        var truckResponseDto = new TruckResponseDto();

        if (Objects.nonNull(truck.getUuid())) {
            truckResponseDto.setUuid(truck.getUuid());
        }

        if (Objects.nonNull(truck.getCode())) {
            truckResponseDto.setCode(truck.getCode());
        }

        if (Objects.nonNull(truck.getEnabled())) {
            truckResponseDto.setEnabled(truck.getEnabled());
        }

        return truckResponseDto;
    }

    public Truck toTruck(TruckRequestDto request) {
        if (request == null) {
            return null;
        }

        var truck = new Truck();

        if (Objects.nonNull(request.getCode())) {
            truck.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getEnabled())) {
            truck.setEnabled(request.getEnabled());
        }

        return truck;
    }
}
