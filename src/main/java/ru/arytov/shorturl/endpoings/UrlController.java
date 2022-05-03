package ru.arytov.shorturl.endpoings;


import com.datastax.oss.driver.api.core.CqlSession;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.arytov.shorturl.cassandra.ShortUrlEntity;
import ru.arytov.shorturl.mapper.ShortUrlMapper;

@RestController
public class UrlController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlController.class);
    
    @PostMapping("/urls")
    public ShortUrlDTO createUrl(@RequestBody ShortUrlDTO newShortUrl) {
        newShortUrl.shortUrl = new Generator().generate(newShortUrl.originalUrl);

        insert(newShortUrl);
        return newShortUrl;
    }


    private void insert(ShortUrlDTO newShortUrl) {
        CqlSession cqlSession = CqlSession.builder().withKeyspace("url").build();
        CassandraOperations template = new CassandraTemplate(cqlSession);
        ShortUrlMapper mapper = Mappers.getMapper(ShortUrlMapper.class);
    
        ShortUrlEntity entity = template.insert(mapper.dtoToEntity(newShortUrl));

        //LOGGER.info(template.selectOne(Query.query(Criteria.where("id").is(jonDoe.getId())), Person.class).getId());

        template.truncate(ShortUrlEntity.class);
        cqlSession.close();
    }


    @GetMapping("/urls/{shortName}")
    public String getUrl(@PathVariable String shortName) {
        ShortUrlDTO shortUrl = new ShortUrlDTO();
        return shortUrl.originalUrl;
    }

    @DeleteMapping("/urls/{shortName}")
    public void deleteUrl(@PathVariable String shortName) {
        return;
    }

}