package com.tamseo.ws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

@Configuration
@Profile("production")
public class MongoDbConfiguationProd {

  @Value("${mongo.host}")
  private String host;
  
  @Value("${mongo.database}")
  private String database;
  
  @Value("${mongo.username}")
  private String username;
  
  @Value("${mongo.passwd}")
  private String passwd;
  
  @SuppressWarnings("deprecation")
  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
    UserCredentials userCredentials = new UserCredentials(username, passwd);
    return new SimpleMongoDbFactory(new Mongo(host), database, userCredentials);
  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
}
