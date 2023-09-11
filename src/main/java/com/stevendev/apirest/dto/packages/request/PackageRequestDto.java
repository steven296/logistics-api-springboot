package com.stevendev.apirest.dto.packages.request;

import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.domain.packages.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PackageRequestDto {
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private StatusType status;
    private List<PackageProduct> products;
}
