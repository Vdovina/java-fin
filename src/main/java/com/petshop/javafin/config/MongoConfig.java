//package com.petshop.javafin.config;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.internal.MongoClientImpl;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    @Value("${spring.data.mongodb.host}")
//    private String host;
//
//    @Value("${spring.data.mongodb.database}")
//    private  String database;
//
//    @Override
//    public MongoClient mongoClient(){
//        return new MongoClients.create();
//    }
//
//
//    @Override
//    protected String getDatabaseName() {
//        return database;
//    }
//}
