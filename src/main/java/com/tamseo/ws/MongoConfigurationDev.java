package com.tamseo.ws;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fakemongo.Fongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.tamseo.ws.model.Table;

@Configuration
@Profile("dev")
public class MongoConfigurationDev {

  @Autowired
  private ApplicationContext context;

  public @Bean MongoDbFactory mongoDbFactory() throws Exception {

    Fongo fongo = new Fongo("mongo server 1");
    insertFakeDataIntoFakeMongoDb(fongo, "tables", Table.class);

    return new SimpleMongoDbFactory(fongo.getMongo(), "restonet");

  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }

  private <T> void insertFakeDataIntoFakeMongoDb(Fongo fongo, String collectionName, Class<T> model)
      throws IOException, JsonParseException, JsonMappingException, JsonProcessingException {

    DB db = fongo.getDB("restonet");
    DBCollection collection = db.getCollection(collectionName);
    Resource resource = context.getResource("classpath:data/mongodb/" + collectionName + ".json");

    InputStream inputStream = resource.getInputStream();
    String json = IOUtils.toString(inputStream);

    ObjectMapper mapper = new ObjectMapper();
    List<T> objects =
        mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, model));

    for (T object : objects) {
      DBObject dbObject = (DBObject) JSON.parse(mapper.writeValueAsString(object));
      collection.insert(dbObject);
    }
  }
}
