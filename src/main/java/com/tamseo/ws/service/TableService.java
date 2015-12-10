package com.tamseo.ws.service;

import java.util.Collection;
import java.util.List;

import com.tamseo.ws.model.Table;

public interface TableService {
  
  /**
   * Get all tables 
   * @return A {@link Collection} of {@link Table}
   */
  public Collection<Table> findAll();
  
  /**
   * Get a list of tables by site Id
   * @param siteId
   * @return A {@link List} of {@link Table}
   */
  public List<Table> findTablesBySiteId(String siteId);

}
