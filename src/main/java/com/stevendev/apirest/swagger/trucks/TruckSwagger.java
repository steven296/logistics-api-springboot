package com.stevendev.apirest.swagger.trucks;

import com.stevendev.apirest.domain.trucks.Truck;
import com.stevendev.apirest.dto.trucks.request.TruckRequestDto;
import com.stevendev.apirest.dto.trucks.response.TruckResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;

@Tag(name = "Trucks", description = "API de trucks")
public interface TruckSwagger {

    @Operation(
            summary = "Listar Trucks",
            description = "Endpoint que nos ayuda a listar todos los Trucks de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }
    )
    public List<TruckResponseDto> findAll();

    @Operation(
            summary = "Buscar Truck",
            description = "Endpoint que nos ayuda encontrar un Truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto findById(UUID uuid);

    @Operation(
            summary = "Guardar Truck",
            description = "Endpoint que nos ayuda guardar un Truck"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto save(TruckRequestDto request);

    @Operation(
            summary = "Actualizar Truck",
            description = "Endpoint que nos ayuda a actualizar un Truck por medio de su uuid y la información a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto update(UUID uuid, Truck request);

    @Operation(
            summary = "Eliminar Truck",
            description = "Endpoint que nos ayuda a eliminar un Truck por medio de su uuid"
    )
    public void delete(UUID uuid);
}
