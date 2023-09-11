package com.stevendev.apirest.controller.trucks;

import com.stevendev.apirest.domain.trucks.Truck;
import com.stevendev.apirest.dto.trucks.request.TruckRequestDto;
import com.stevendev.apirest.dto.trucks.response.TruckResponseDto;
import com.stevendev.apirest.service.trucks.TruckService;
import com.stevendev.apirest.swagger.trucks.TruckSwagger;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/trucks")
public class TruckController implements TruckSwagger {

    private final TruckService truckService;

    @GetMapping
    public List<TruckResponseDto> findAll() {

        return truckService.findAll();
    }

    @GetMapping("/{uuid}")
    public TruckResponseDto findById(@PathVariable UUID uuid) {

        return truckService.findByUuid(uuid);
    }

    @PostMapping
    public TruckResponseDto save(@RequestBody TruckRequestDto request) {

        return truckService.save(request);
    }

    @PutMapping("/{uuid}")
    public TruckResponseDto update(@PathVariable UUID uuid, @RequestBody Truck truck){

        return truckService.update(uuid, truck);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

        truckService.delete(uuid);
    }
}
