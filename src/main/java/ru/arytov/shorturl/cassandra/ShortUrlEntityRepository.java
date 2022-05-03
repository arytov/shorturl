package ru.arytov.shorturl.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlEntityRepository extends CassandraRepository<ShortUrlEntity, String> {
    //
}