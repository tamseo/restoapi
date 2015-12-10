/**
 * 
 */
package com.tamseo.ws.web.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tamseo.ws.model.Table;
import com.tamseo.ws.service.TableService;

/**
 * @author tam.nguyenvan
 *
 */

@RestController
public class TableController extends BaseController {

  @Autowired
  private TableService tableService;

  @RequestMapping(value = "/api/tables", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<Table>> getTables() {
    Collection<Table> tables = tableService.findAll();
    return new ResponseEntity<Collection<Table>>(tables, HttpStatus.OK);
  }

  @RequestMapping(value = "/api/table/{siteId}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Table>> getTablesBySiteId(@PathVariable String siteId) {
    List<Table> tables = tableService.findTablesBySiteId(siteId);
    return new ResponseEntity<List<Table>>(tables, HttpStatus.OK);
  }

  
}
