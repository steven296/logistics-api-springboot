package com.stevendev.apirest.controller.packages;

import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.dto.packages.request.PackageRequestDto;
import com.stevendev.apirest.dto.packages.response.PackageResponseDto;
import com.stevendev.apirest.service.packages.PackageService;
import com.stevendev.apirest.swagger.packages.PackageSwagger;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages")
public class PackageController implements PackageSwagger {

    private final PackageService packageService;

    @GetMapping
    public List<PackageResponseDto> findAll() {

        return packageService.findAll();
    }

    @GetMapping("/{uuid}")
    public PackageResponseDto findById(@PathVariable UUID uuid) {

        return packageService.findByUuid(uuid);
    }

    @PostMapping
    public PackageResponseDto save(@RequestBody PackageRequestDto request) {

        return packageService.save(request);
    }

    @PatchMapping("/{uuid}/status")
    public PackageResponseDto updateStatus(@PathVariable UUID uuid, @RequestBody Package myPackage){
        return packageService.updateStatus(uuid, myPackage);
    }
}
