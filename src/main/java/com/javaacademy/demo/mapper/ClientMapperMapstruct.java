package com.javaacademy.demo.mapper;

import com.javaacademy.demo.dto.ClientDto;
import com.javaacademy.demo.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapperMapstruct {

    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);
}
