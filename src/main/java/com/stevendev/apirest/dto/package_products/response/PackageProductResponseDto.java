package com.stevendev.apirest.dto.package_products.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PackageProductResponseDto {
    private UUID uuid;
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
}
