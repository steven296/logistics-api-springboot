package com.stevendev.apirest.dto.trucks.request;

import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.domain.trucks.Truck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckRequestDto {
    private String code;
    private Boolean enabled;

    public Truck toEntity(Driver driver) {
        var truck = new Truck();
        truck.setCode(this.code);
        truck.setEnabled(this.enabled);
        truck.setDriver(driver);

        return truck;
    }
}
