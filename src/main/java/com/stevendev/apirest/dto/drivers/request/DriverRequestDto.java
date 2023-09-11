package com.stevendev.apirest.dto.drivers.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRequestDto {
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enabled;
}
