package com.stevendev.apirest.dto.package_products.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PackageProductRequestDto {
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
}
