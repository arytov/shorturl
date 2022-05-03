package ru.arytov.shorturl.mapper;

import org.mapstruct.Mapper;

import ru.arytov.shorturl.cassandra.ShortUrlEntity;
import ru.arytov.shorturl.endpoings.ShortUrlDTO;

@Mapper
public interface ShortUrlMapper {
    ShortUrlEntity dtoToEntity (ShortUrlDTO dto);
    ShortUrlDTO entityToDto(ShortUrlEntity entity);
    
}
