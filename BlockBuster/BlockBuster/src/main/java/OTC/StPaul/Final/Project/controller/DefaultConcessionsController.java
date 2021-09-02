package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.concessions;
import OTC.StPaul.Final.Project.service.ConcessionsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultConcessionsController implements ConcessionsController {

  @Autowired
  private ConcessionsService concessionsService;
  
  @Override
  public ResponseEntity<List<concessions>> listAllConcessions() {
    log.info("A Request for the complete concessions list was made");
    List<concessions> concessions = concessionsService.listAllConcessions();
    return new ResponseEntity<List<concessions>>(concessions, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<concessions>> retrieveSingleConcessionByConcessionID(
      int concessions_id) {
    log.info("A Request for a single concessions={} information was made", concessions_id);
    List<concessions> singleConcession = concessionsService
        .retrieveSingleConcessionByConcessionID(concessions_id);
    return new ResponseEntity<List<concessions>>(singleConcession, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<concessions>> retrieveSingleConcessionByName(String full_name) {
    log.info("A Request for a single concessions={} name information was made", full_name);
    List<concessions> singleConcessionName = concessionsService
        .retrieveSingleConcessionByName(full_name);
    return new ResponseEntity<List<concessions>>(singleConcessionName, HttpStatus.OK);
  }

  @Override
  public void addMovie(String full_name, double price, int quantity) {
    log.info("Added a concession");
    concessionsService.addConcession(full_name, price, quantity); 
  }

  @Override
  public void deleteConcessionById(int concessions_id) {
    log.info("Deleted a concession");
    concessionsService.deleteConcessionById(concessions_id);
  }

  @Override
  public void updateConcessionNameById(String full_name, int concessions_id) {
    log.info("Update a concessions={} full_name", concessions_id);
    concessionsService.updateConcessionNameById(full_name, concessions_id);
  }

  @Override
  public void updateConcessionPriceById(double price, int concessions_id) {
    log.info("Update a concessions={} price", concessions_id);
    concessionsService.updateConcessionPriceById(price, concessions_id);
  }

  @Override
  public void updateConcessionQuantityById(int quantity, int concessions_id) {
    log.info("Update a concessions={} quantity", concessions_id);
    concessionsService.updateConcessionQuantityById(quantity, concessions_id);
  }

} // last bracket
