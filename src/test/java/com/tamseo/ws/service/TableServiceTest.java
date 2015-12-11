package com.tamseo.ws.service;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tamseo.ws.AbstractTest;
import com.tamseo.ws.model.Table;

public class TableServiceTest extends AbstractTest {

  @Autowired
  private TableService tableService;

  @Test
  public void testGetAllTables() {
    Collection<Table> tables = tableService.findAll();
    Assert.assertEquals(5, tables.size());
  }

  @Test
  public void testGetTableBySiteId() {
    List<Table> tables = tableService.findTablesBySiteId("S001");
    Assert.assertEquals("Table 1", tables.get(0).getName());
  }
}
