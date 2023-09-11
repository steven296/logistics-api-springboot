package com.stevendev.apirest.swagger.drivers;

import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.dto.drivers.request.DriverRequestDto;
import com.stevendev.apirest.dto.drivers.response.DriverResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;

@Tag(name = "Drivers", description = "API de drivers")
public interface DriverSwagger {

    @Operation(
            summary = "Listar Drivers",
            description = "Endpoint que nos ayuda a listar todos los Drivers de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }
    )
    public List<DriverResponseDto> findAll();

    @Operation(
            summary = "Buscar Driver",
            description = "Endpoint que nos ayuda encontrar un Driver por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto findById(UUID uuid);

    @Operation(
            summary = "Guardar Driver",
            description = "Endpoint que nos ayuda guardar un Driver"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto save(DriverRequestDto request);

    @Operation(
            summary = "Actualizar Driver",
            description = "Endpoint que nos ayuda a actualizar un Driver por medio de su uuid y la información a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto update(UUID uuid, Driver driver);

    @Operation(
            summary = "Eliminar Driver",
            description = "Endpoint que nos ayuda a eliminar un Driver por su uuid"
    )
    public void delete(UUID uuid);
}
