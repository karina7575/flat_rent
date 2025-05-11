package com.javaacademy.demo.service;

import com.javaacademy.demo.dto.ClientDto;
import com.javaacademy.demo.entity.Client;
import com.javaacademy.demo.exception.FilledIdException;
import com.javaacademy.demo.mapper.ClientMapperMapstruct;
import com.javaacademy.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapperMapstruct clientMapperMapstruct;

    public ClientDto save(ClientDto clientDto) {
        if (clientDto.getId() != null) {
            throw new FilledIdException("ID клиента должен быть null");
        }
        Client client = clientRepository.save(clientMapperMapstruct.toEntity(clientDto));
        log.trace("Клиент сохранен.");
        return clientMapperMapstruct.toDto(clientRepository.findById(client.getId()).orElseThrow());
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
        log.trace("Клиент удален.");
    }
}
