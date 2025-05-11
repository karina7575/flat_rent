package com.javaacademy.demo.controller;

import com.javaacademy.demo.dto.BookingDto;
import com.javaacademy.demo.dto.BookingDtoResponse;
import com.javaacademy.demo.service.BookingService;
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
@RequestMapping("/booking")
@RequiredArgsConstructor
@Tag(name = "Booking Controller", description = "Контроллер для работы с бронированиями")
public class BookingController {
    private final BookingService bookingService;

    @Operation(summary = "Создание бронирования", description = "Создание нового бронирования")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Успешное сохранение.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookingDtoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Апартаменты не найдены.",
                    content = @Content(mediaType = "plain/text")),
            @ApiResponse(responseCode = "409", description = "Объявление неактивно или даты недоступны.",
                    content = @Content(mediaType = "plain/text"))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDtoResponse save(@RequestBody BookingDto bookingDto) {
        return bookingService.saveBooking(bookingDto);
    }

    @Operation(summary = "Получение бронирований", description = "Получение части бронирований в выбранном городе")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешное поиск по email.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookingDtoResponse.class)))
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<BookingDtoResponse> findAllByCity(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam String email) {
        return bookingService.findAllByEmail(pageNumber, email);
    }



}
