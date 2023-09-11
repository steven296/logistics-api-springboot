package com.stevendev.apirest.mock.packages;

import com.stevendev.apirest.dto.packages.response.PackageResponseDto;

public class PackageResponseDtoMock {

    public static PackageResponseDto build() {
        var packageResponse = new PackageResponseDto();
        packageResponse.setCode("C2023");

        return packageResponse;
    }
}
