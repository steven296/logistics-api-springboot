package com.stevendev.apirest.service.packages.impl;
import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.dao.packages.PackageRepository;
import com.stevendev.apirest.dto.packages.request.PackageRequestDto;
import com.stevendev.apirest.dto.packages.response.PackageResponseDto;
import com.stevendev.apirest.mapper.packages.PackageMapper;
import com.stevendev.apirest.service.packages.PackageService;
import com.stevendev.apirest.service.package_products.PackageProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PackageServiceImpl implements PackageService {

    private PackageRepository packageRepository;
    private PackageMapper packageMapper;
    private PackageProductService packageProductService;

    @Override
    public List<PackageResponseDto> findAll() {

        return packageRepository.findAll().stream()
                .map(mypackage -> packageMapper.toResponseDto(mypackage))
                .collect(Collectors.toList());
    }

    @Override
    public PackageResponseDto findByUuid(UUID packageUuid) {

        return packageMapper.toResponseDto(
                findById(packageUuid)
        );
    }

    @Override
    public PackageResponseDto findByCode(String code) {

        var mypackage = packageRepository.findByCode(code)
                .orElseThrow( ()-> new IllegalStateException("") );

        return packageMapper.toResponseDto(mypackage);
    }

    @Override
    public PackageResponseDto save(PackageRequestDto request) {
        var myPackageSaved = packageRepository.save(packageMapper.toPackage(request));

        if(Objects.nonNull(request.getProducts())) {
            packageProductService.addAllToPackage(myPackageSaved, request.getProducts());
        }

        return packageMapper.toResponseDto(myPackageSaved);
    }

    @Override
    public PackageResponseDto update(UUID packageUuid, Package myPackage) {

        var packageFound = findById(packageUuid);
        packageMapper.update(myPackage, packageFound);

        return packageMapper.toResponseDto(
                packageRepository.save(packageFound)
        );
    }

    @Override
    public PackageResponseDto updateStatus(UUID packageUuid, Package myPackage) {
        var myPackageFound = findById(packageUuid);
        myPackageFound.setStatus(myPackage.getStatus());

        return packageMapper.toResponseDto(packageRepository.save(myPackageFound));
    }

    private Package findById(UUID packageUuid) {
        return packageRepository.findById(packageUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }
}
