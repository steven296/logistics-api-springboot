package com.stevendev.apirest.dto.drivers.response;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponseDto {
    private UUID uuid;
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enabled;
}
