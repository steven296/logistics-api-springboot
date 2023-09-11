package com.stevendev.apirest.mapper.package_products;

import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.dto.package_products.request.PackageProductRequestDto;
import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PackageProductMapper {

    public void update(PackageProduct pkgPrdSource, PackageProduct pkgPrdTarget) {
        if (Objects.nonNull(pkgPrdSource.getCode())) {
            pkgPrdTarget.setCode(pkgPrdSource.getCode());
        }

        if (Objects.nonNull(pkgPrdSource.getWeight())) {
            pkgPrdTarget.setWeight(pkgPrdSource.getWeight());
        }

        if (Objects.nonNull(pkgPrdSource.getSku())) {
            pkgPrdTarget.setSku(pkgPrdSource.getSku());
        }

        if (Objects.nonNull(pkgPrdSource.getQuantity())) {
            pkgPrdTarget.setQuantity(pkgPrdSource.getQuantity());
        }
    }

    public PackageProductResponseDto toResponseDto(PackageProduct pkgPrd) {
        if( pkgPrd == null){
            return null;
        }

        var packageProductResponseDto = new PackageProductResponseDto();

        if (Objects.nonNull(pkgPrd.getUuid())) {
            packageProductResponseDto.setUuid(pkgPrd.getUuid());
        }

        if (Objects.nonNull(pkgPrd.getCode())) {
            packageProductResponseDto.setCode(pkgPrd.getCode());
        }

        if (Objects.nonNull(pkgPrd.getWeight())) {
            packageProductResponseDto.setWeight(pkgPrd.getWeight());
        }

        if (Objects.nonNull(pkgPrd.getSku())) {
            packageProductResponseDto.setSku(pkgPrd.getSku());
        }

        if (Objects.nonNull(pkgPrd.getQuantity())) {
            packageProductResponseDto.setQuantity(pkgPrd.getQuantity());
        }

        return packageProductResponseDto;
    }

    public PackageProduct toPackageProduct(PackageProductRequestDto request) {

        if (request == null) {
            return null;
        }

        var myPackageProduct = new PackageProduct();

        if (Objects.nonNull(request.getCode())) {
            myPackageProduct.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getWeight())) {
            myPackageProduct.setWeight(request.getWeight());
        }

        if (Objects.nonNull(request.getSku())) {
            myPackageProduct.setSku(request.getSku());
        }

        if (Objects.nonNull(request.getQuantity())) {
            myPackageProduct.setQuantity(request.getQuantity());
        }

        return myPackageProduct;
    }
}
