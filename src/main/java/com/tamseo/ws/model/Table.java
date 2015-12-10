package com.tamseo.ws.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tables")
public class Table {

  @Id
  private String id;
  private String tableId;
  private String name;
  private String description;
  private String siteId;
  
  public Table() {
    
  }
  
  public Table(String name, String description, String site_id) {
    this.name = name;
    this.description = description;
    this.siteId = site_id;
  }

  @Override
  public String toString() {
    return "Table [id=" + id + ", name=" + name + ", description=" + description + ", siteId="
        + siteId + "]";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSiteId() {
    return siteId;
  }

  public void setSiteId(String siteId) {
    this.siteId = siteId;
  }

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }
}
