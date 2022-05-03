package ru.arytov.shorturl.cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("url")
public class ShortUrlEntity {
    @PrimaryKey 
    String shortUrl;

    String originalUrl;
    String customAlias;
    String userName;
    String expireDate;

}
