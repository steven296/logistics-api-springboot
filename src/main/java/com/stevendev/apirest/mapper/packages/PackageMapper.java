package com.stevendev.apirest.mapper.packages;

import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.dto.packages.request.PackageRequestDto;
import com.stevendev.apirest.dto.packages.response.PackageResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PackageMapper {

    public void update(Package packageSource, Package packageTarget) {

        if (Objects.nonNull(packageSource.getCode())) {
            packageTarget.setCode(packageSource.getCode());
        }

        if (Objects.nonNull(packageSource.getWeight())) {
            packageTarget.setWeight(packageSource.getWeight());
        }

        if (Objects.nonNull(packageSource.getSchedule())) {
            packageTarget.setSchedule(packageSource.getSchedule());
        }

        if (Objects.nonNull(packageSource.getStatus())) {
            packageTarget.setStatus(packageSource.getStatus());
        }

        if (Objects.nonNull(packageSource.getIs_deleted())) {
            packageTarget.setIs_deleted(packageSource.getIs_deleted());
        }

        if (Objects.nonNull(packageSource.getDeleted_at())) {
            packageTarget.setDeleted_at(packageSource.getDeleted_at());
        }
    }

    public PackageResponseDto toResponseDto(Package mypackage) {
        if (mypackage == null) {
            return null;
        }

        var packageResponseDto = new PackageResponseDto();

        if (Objects.nonNull(mypackage.getUuid())) {
            packageResponseDto.setUuid(mypackage.getUuid());
        }

        if (Objects.nonNull(mypackage.getCode())) {
            packageResponseDto.setCode(mypackage.getCode());
        }

        if (Objects.nonNull(mypackage.getWeight())) {
            packageResponseDto.setWeight(mypackage.getWeight());
        }

        if (Objects.nonNull(mypackage.getSchedule())) {
            packageResponseDto.setSchedule(mypackage.getSchedule());
        }

        if (Objects.nonNull(mypackage.getStatus())) {
            packageResponseDto.setStatus(mypackage.getStatus());
        }

        return packageResponseDto;
    }

    public Package toPackage(PackageRequestDto request) {
        if (request == null) {
            return null;
        }

        var mypackage = new Package();

        if (Objects.nonNull(request.getCode())) {
            mypackage.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getWeight())) {
            mypackage.setWeight(request.getWeight());
        }

        if (Objects.nonNull(request.getSchedule())) {
            mypackage.setSchedule(request.getSchedule());
        }

        if (Objects.nonNull(request.getStatus())) {
            mypackage.setStatus(request.getStatus());
        }

        return mypackage;
    }
}
