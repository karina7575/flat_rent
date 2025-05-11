package com.javaacademy.demo.controller;

import com.javaacademy.demo.dto.AdvertDto;
import com.javaacademy.demo.dto.AdvertDtoResponse;
import com.javaacademy.demo.service.AdvertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
@Tag(name = "Advert Controller", description = "Контроллер для работы с объявлениями")
public class AdvertController {

    private final AdvertService advertService;

    @Operation(summary = "Создание объявления", description = "Создание нового объявления")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Успешное сохранение.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdvertDtoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Апартаменты не найдены.",
                    content = @Content(mediaType = "plain/text"))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdvertDtoResponse create(@RequestBody AdvertDto advertDto) {
        return advertService.saveAdvert(advertDto);
    }

    @Operation(summary = "Получение объявлений", description = "Получение части объявлений в выбранном городе")@ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешный поиск по городу.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Page.class)))
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AdvertDtoResponse> findAllByCity(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam String city) {
        return advertService.findAllByCity(pageNumber, city);
    }
}
