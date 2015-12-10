package com.tamseo.ws.repository;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tamseo.ws.Application;
import com.tamseo.ws.model.Table;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@SpringApplicationConfiguration(classes = Application.class)
public class TableRepositoryTest {

  @Autowired
  private TableRepository tableRepository;

  @Test
  public void testGetAllTables() {

    Collection<Table> tables = tableRepository.findAll();
    Assert.assertEquals(2, tables.size());
  }

  @Test
  public void testGetTableBySiteId() {

    List<Table> tables = tableRepository.findBySiteId("S001");
    Assert.assertEquals("Table 1", tables.get(0).getName());
  }

  @Test
  public void testGetTableById() {

    Table table = tableRepository.findByTableId("TB0002");
    Assert.assertEquals("Table 2", table.getName());
  }


}
