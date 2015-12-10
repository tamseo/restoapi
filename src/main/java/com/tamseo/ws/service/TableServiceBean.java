package com.tamseo.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamseo.ws.model.Table;
import com.tamseo.ws.repository.TableRepository;

/**
 * Provide services for Table
 * 
 * @author tam.nguyenvan
 *
 */
@Service
public class TableServiceBean implements TableService {

  @Autowired
  private TableRepository tableRepository;

  @Override
  public List<Table> findAll() {
    return tableRepository.findAll();
  }

  @Override
  public List<Table> findTablesBySiteId(String siteId) {
    return tableRepository.findBySiteId(siteId);
  }

}
