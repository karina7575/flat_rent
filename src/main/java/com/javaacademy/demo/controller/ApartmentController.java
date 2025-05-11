package com.javaacademy.demo.controller;

import com.javaacademy.demo.dto.ApartmentDto;
import com.javaacademy.demo.service.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartment")
@RequiredArgsConstructor
@Tag(name = "Apartment Controller", description = "Контроллер для работы с помещениями")
public class ApartmentController {
    private final ApartmentService apartmentService;

    @Operation(summary = "Создание помещения", description = "Создание нового помещения")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Успешное сохранение.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApartmentDto.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApartmentDto create(@RequestBody ApartmentDto apartmentDto) {
        return apartmentService.saveApartment(apartmentDto);
    }
}
