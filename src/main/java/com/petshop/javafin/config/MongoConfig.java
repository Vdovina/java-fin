package com.petshop.javafin.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.database}")
    private  String database;

    @Value("${spring.data.mongodb.uri}")
    private  String connectionString;

    @Override
    public MongoClient mongoClient(){
        return new MongoClients.create(connectionString);
    }


    @Override
    protected String getDatabaseName() {
        return database;
    }
}
