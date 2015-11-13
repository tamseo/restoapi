package com.tamseo.ws.service;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.tamseo.ws.model.Table;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-context.xml"})
public class TableServiceTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Rule
  public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("test");
  
  @Autowired
  private TableService tableService;

  @Test
  @UsingDataSet(locations = {"/table.json"},loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
  public void testGetAllTables() {

    Collection<Table> tables = tableService.findAll();
    Assert.assertEquals(2, tables.size());
  }
}
