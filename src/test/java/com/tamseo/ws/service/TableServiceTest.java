package com.tamseo.ws.service;

import java.util.Collection;

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
    Assert.assertEquals(2, tables.size());
  }
}
