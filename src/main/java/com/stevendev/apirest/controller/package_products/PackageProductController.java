package com.stevendev.apirest.controller.package_products;

import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;
import com.stevendev.apirest.service.package_products.PackageProductService;
import com.stevendev.apirest.swagger.package_products.PackageProductSwagger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages-products")
public class PackageProductController implements PackageProductSwagger {

    private final PackageProductService packageProductService;

    @GetMapping
    public List<PackageProductResponseDto> findAll() {

        return packageProductService.findAll();
    }

    @GetMapping("/{uuid}")
    public PackageProductResponseDto findById(@PathVariable UUID uuid) {

        return packageProductService.findByUuid(uuid);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        boolean isDeleted = packageProductService.delete(uuid);

        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Se eliminó producto con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puedo eliminar producto, ya que tiene estado LOADED");
        }
    }
}
