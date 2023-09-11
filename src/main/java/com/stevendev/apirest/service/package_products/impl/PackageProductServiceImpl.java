package com.stevendev.apirest.service.package_products.impl;

import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.dao.package_products.PackageProductRepository;
import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.domain.packages.StatusType;
import com.stevendev.apirest.dto.package_products.request.PackageProductRequestDto;
import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;
import com.stevendev.apirest.mapper.package_products.PackageProductMapper;
import com.stevendev.apirest.service.package_products.PackageProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PackageProductServiceImpl implements PackageProductService {

    private PackageProductRepository packageProductRepository;
    private PackageProductMapper packageProductMapper;


    @Override
    public List<PackageProductResponseDto> findAll() {
        return packageProductRepository
                .findAll()
                .stream()
                .map(packageProduct ->  packageProductMapper.toResponseDto(packageProduct))
                .toList();
    }

    @Override
    public PackageProductResponseDto findByUuid(UUID packageProductUuid) {
        var myPackageProduct = findById(packageProductUuid);
        return packageProductMapper.toResponseDto(myPackageProduct);
    }

    @Override
    public PackageProductResponseDto save(PackageProductRequestDto request) {
        var myPackageProduct = packageProductMapper.toPackageProduct(request);
        var myPackageProductSaved =  packageProductRepository.save(myPackageProduct);

        return packageProductMapper.toResponseDto(myPackageProductSaved);
    }

    @Override
    public PackageProductResponseDto update(UUID packageProductUuid, PackageProduct myPackageProduct) {
        var packageProductFound = findById(packageProductUuid);

        packageProductMapper.update(myPackageProduct, packageProductFound);

        return packageProductMapper.toResponseDto(packageProductRepository.save(packageProductFound));
    }

    @Override
    public boolean delete(UUID uuid) {
        var packageProductFound = findById(uuid);
        if(packageProductFound.getMyPackage().getStatus() ==  StatusType.LOADED) {
            return false;
        }else {
            packageProductRepository.delete(packageProductFound);
            return true;
        }
    }

    private PackageProduct findById(UUID packageProductUuid) {
        return packageProductRepository.findById(packageProductUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }

    @Override
    public void addAllToPackage(Package myPackage, List<PackageProduct> products){
        products.forEach(product -> product.setMyPackage(myPackage));
        packageProductRepository.saveAll(products);
    }
}
