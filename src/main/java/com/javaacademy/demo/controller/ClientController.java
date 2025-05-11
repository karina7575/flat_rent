package com.javaacademy.demo.controller;

import com.javaacademy.demo.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/client")
@RestController
@Tag(name = "Client Controller", description = "Контроллер для работы с клиентами")
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "Удаление клиента", description = "Удаление клиента и всех его бронирований")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешное удаление клиента и его бронирований.")
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteClientCascade(@PathVariable @NonNull @Parameter(description = "ID клиента") Integer id) {
        clientService.delete(id);
    }
}
