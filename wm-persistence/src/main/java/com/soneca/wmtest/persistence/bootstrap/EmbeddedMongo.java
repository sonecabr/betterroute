package com.soneca.wmtest.persistence.bootstrap;

import com.mongodb.Mongo;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;

import java.io.IOException;

/**
 * @author andre
 * @since 06/12/2015 12:37
 */
public class EmbeddedMongo {


    public Mongo runMongo() throws IOException {
        return new EmbeddedMongoBuilder()
                .version("2.4.5")
                .bindIp("127.0.0.1")
                .port(12345)
                .build();
    }
}
