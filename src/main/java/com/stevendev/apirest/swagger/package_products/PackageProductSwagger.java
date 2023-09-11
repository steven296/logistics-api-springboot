package com.stevendev.apirest.swagger.package_products;

import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.dto.package_products.response.PackageProductResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.UUID;

@Tag(name = "Package Products", description = "API de Package Products")
public interface PackageProductSwagger {

    @Operation(
            summary = "Listar Productos de un Paquete",
            description = "Endpoint que nos ayuda a listar todos los Productos de un Paquete"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public List<PackageProductResponseDto> findAll();

    @Operation(
            summary = "Buscar Producto de un Paquete",
            description = "Endpoint que nos ayuda a buscar un Producto por UUID"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public PackageProductResponseDto findById(UUID uuid);

    @Operation(
            summary = "Eliminar Producto de un Paquete",
            description = "Endpoint que nos ayuda a eliminar el Producto de un Paquete solo si el paquete se encuentra en estado LOADED."
    )
    public ResponseEntity<String> delete(UUID uuid);
}
