package com.javaacademy.demo.service;

import com.javaacademy.demo.dto.ClientDto;
import com.javaacademy.demo.entity.Client;
import com.javaacademy.demo.mapper.ClientMapperMapstruct;
import com.javaacademy.demo.repository.ClientRepository;

public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapperMapstruct clientMapperMapstruct;

    public ClientDto save(ClientDto clientDto) {
        Client client = clientRepository.save(clientMapperMapstruct.toEntity(clientDto));
        return clientMapperMapstruct.toDto(clientRepository.findById(client.getId()).orElseThrow());
    }
}
