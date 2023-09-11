package com.stevendev.apirest.service.packages.impl;

import com.stevendev.apirest.dao.packages.PackageRepository;
import com.stevendev.apirest.mapper.packages.PackageMapper;
import com.stevendev.apirest.mock.packages.PackageMock;
import com.stevendev.apirest.mock.packages.PackageResponseDtoMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PackageServiceImplTest {

    @Mock
    private PackageRepository packageRepository;
    @Mock
    private PackageMapper packageMapper;

    @InjectMocks
    private PackageServiceImpl service;

    @Test
    void findAll() {

        // Arrange - Given
        var responsePackageDto = PackageResponseDtoMock.build();

        Mockito.when(packageRepository.findAll()).thenReturn(
            Collections.singletonList(PackageMock.build())
        );

        Mockito.when(packageMapper.toResponseDto(Mockito.any())).thenReturn(
            responsePackageDto
        );

        // Act - When
        var response = service.findAll();

        // Assert - Then
        assertNotNull(response);
        assertEquals(responsePackageDto.getCode(), response.get(0).getCode());
    }


}