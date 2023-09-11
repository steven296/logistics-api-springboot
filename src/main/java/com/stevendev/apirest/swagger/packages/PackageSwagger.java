package com.stevendev.apirest.swagger.packages;

import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.dto.packages.request.PackageRequestDto;
import com.stevendev.apirest.dto.packages.response.PackageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;

@Tag(name = "Packages", description = "API de Packages")
public interface PackageSwagger {

    @Operation(
            summary = "Listar Packages",
            description = "Endpoint que nos ayuda a listar todos los Packages de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public List<PackageResponseDto> findAll();

    @Operation(
            summary = "Buscar Package",
            description = "Endpoint que nos ayuda a encontrar un package por su uuid"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto findById(UUID uuid);

    @Operation(
            summary = "Guardar Package y sus respectivos productos",
            description = "Endpoint que nos ayuda a guardar un package y sus respectivos PackagesProducts"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto save(PackageRequestDto request);

    @Operation(
            summary = "Actualizar estado de Package ",
            description = "Endpoint que nos ayuda a actualizar el estado de un package"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto updateStatus(UUID uuid, Package myPackage);
}
