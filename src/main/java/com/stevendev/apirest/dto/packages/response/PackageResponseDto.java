package com.stevendev.apirest.dto.packages.response;

import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.domain.packages.StatusType;
import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PackageResponseDto {
    private UUID uuid;
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private StatusType status;
    private List<PackageProduct> products;
}
