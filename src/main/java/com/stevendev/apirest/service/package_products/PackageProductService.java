package com.stevendev.apirest.service.package_products;

import java.util.List;
import java.util.UUID;
import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.dto.package_products.request.PackageProductRequestDto;
import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;

public interface PackageProductService {
    List<PackageProductResponseDto> findAll();

    //List<PackageProduct> findAllPackageProduct();

    PackageProductResponseDto findByUuid(UUID packageProductUuid);

    PackageProductResponseDto save(PackageProductRequestDto request);

    PackageProductResponseDto update(UUID packageProductUuid, PackageProduct packageProduct);

    boolean delete(UUID packageProductUuid);

    void addAllToPackage(Package myPackage, List<PackageProduct> products);
}
