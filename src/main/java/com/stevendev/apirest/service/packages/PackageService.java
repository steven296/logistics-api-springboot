package com.stevendev.apirest.service.packages;

import java.util.List;
import java.util.UUID;
import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.dto.packages.request.PackageRequestDto;
import com.stevendev.apirest.dto.packages.response.PackageResponseDto;

public interface PackageService {
    List<PackageResponseDto> findAll();

    PackageResponseDto findByUuid(UUID packageUuid);

    PackageResponseDto findByCode(String code);

    PackageResponseDto save(PackageRequestDto request);

    PackageResponseDto update(UUID packageUuid, Package myPackage);

    PackageResponseDto updateStatus(UUID packageUuid, Package myPackage);
}
