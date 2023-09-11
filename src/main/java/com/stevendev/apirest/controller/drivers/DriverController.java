package com.stevendev.apirest.controller.drivers;

import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.dto.drivers.request.DriverRequestDto;
import com.stevendev.apirest.dto.drivers.response.DriverResponseDto;
import com.stevendev.apirest.service.drivers.DriverService;
import com.stevendev.apirest.swagger.drivers.DriverSwagger;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController implements DriverSwagger {

    private final DriverService driverService;

    @GetMapping
    public List<DriverResponseDto> findAll() {

        return driverService.findAll();
    }

    @GetMapping("/{uuid}")
    public DriverResponseDto findById(@PathVariable UUID uuid) {

        return driverService.findByUuid(uuid);
    }

    @PostMapping
    public DriverResponseDto save(@RequestBody DriverRequestDto request) {

        return driverService.save(request);
    }

    @PutMapping("/{uuid}")
    public DriverResponseDto update(@PathVariable UUID uuid, @RequestBody Driver driver) {

        return driverService.update(uuid, driver);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

        driverService.delete(uuid);
    }
}
