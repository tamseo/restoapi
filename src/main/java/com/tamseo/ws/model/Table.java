package com.tamseo.ws.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="table")
public class Table {

  @Id
  private String id;
  
  private String name;
  private String description;
  private String site_id;
  
  public Table() {
    
  }
  
  public Table(String name, String description, String site_id) {
    this.name = name;
    this.description = description;
    this.site_id = site_id;
  }

  @Override
  public String toString() {
    return "Table [id=" + id + ", name=" + name + ", description=" + description + ", site_id="
        + site_id + "]";
  }
}
