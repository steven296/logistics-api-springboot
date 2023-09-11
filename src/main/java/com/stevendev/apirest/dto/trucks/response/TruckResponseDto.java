package com.stevendev.apirest.dto.trucks.response;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckResponseDto {
    private UUID uuid;
    private String code;
    private Boolean enabled;
}
