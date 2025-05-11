package com.javaacademy.demo.mapper;

import com.javaacademy.demo.dto.ClientDto;
import com.javaacademy.demo.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapperMapstruct {

    ClientDto toDto(Client client);
    Client toEntity(ClientDto clientDto);
}
