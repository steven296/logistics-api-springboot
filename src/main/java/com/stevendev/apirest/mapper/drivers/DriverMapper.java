package com.stevendev.apirest.mapper.drivers;

import java.util.Objects;
import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.dto.drivers.request.DriverRequestDto;
import com.stevendev.apirest.dto.drivers.response.DriverResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public void update(Driver driverSource, Driver driverTarget) {
        if (Objects.nonNull(driverSource.getCode())) {
            driverTarget.setCode(driverSource.getCode());
        }

        if (Objects.nonNull(driverSource.getName())) {
            driverTarget.setName(driverSource.getName());
        }

        if (Objects.nonNull(driverSource.getCellphone())) {
            driverTarget.setCellphone(driverSource.getCellphone());
        }

        if (Objects.nonNull(driverSource.getEmail())) {
            driverTarget.setEmail(driverSource.getEmail());
        }

        if (Objects.nonNull(driverSource.getEnabled())) {
            driverTarget.setEnabled(driverSource.getEnabled());
        }
    }

    public DriverResponseDto toResponseDto(Driver driver) {
        if( driver == null){
            return null;
        }

        var driverResponseDto = new DriverResponseDto();

        if (Objects.nonNull(driver.getUuid())) {
            driverResponseDto.setUuid(driver.getUuid());
        }

        if (Objects.nonNull(driver.getCode())) {
            driverResponseDto.setCode(driver.getCode());
        }

        if (Objects.nonNull(driver.getName())) {
            driverResponseDto.setName(driver.getName());
        }

        if (Objects.nonNull(driver.getCellphone())) {
            driverResponseDto.setCellphone(driver.getCellphone());
        }

        if (Objects.nonNull(driver.getEmail())) {
            driverResponseDto.setEmail(driver.getEmail());
        }

        if (Objects.nonNull(driver.getEnabled())) {
            driverResponseDto.setEnabled(driver.getEnabled());
        }

        return driverResponseDto;
    }

    public Driver toDriver(DriverRequestDto request) {
        if (request == null) {
            return null;
        }

        var driver = new Driver();

        if (Objects.nonNull(request.getCode())) {
            driver.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getName())) {
            driver.setName(request.getName());
        }

        if (Objects.nonNull(request.getCellphone())) {
            driver.setCellphone(request.getCellphone());
        }

        if (Objects.nonNull(request.getEmail())) {
            driver.setEmail(request.getEmail());
        }

        if (Objects.nonNull(request.getEnabled())) {
            driver.setEnabled(request.getEnabled());
        }

        return driver;
    }
}
