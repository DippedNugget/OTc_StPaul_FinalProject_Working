package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.concessions;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface ConcessionsController {

  @GetMapping("/concessions")
  ResponseEntity<List<concessions>> listAllConcessions();
  
  @GetMapping("/concessions/{concessions_id}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<concessions>> retrieveSingleConcessionByConcessionID(
      @RequestParam(required = true) int concessions_id);
  
  @GetMapping("/concessions/{full_name}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<concessions>> retrieveSingleConcessionByName(
      @RequestParam(required = true) String full_name);
  
  @PostMapping("/concessions/addconcession")
  @ResponseStatus(code = HttpStatus.CREATED)
  void addMovie(
      @RequestParam(required = true) String full_name,
      @RequestParam(required = true) double price,
      @RequestParam(required = true) int quantity
      );
  
  @DeleteMapping("/deleteconcession/{concessions_id}")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteConcessionById(
      @RequestParam(required = true) int concessions_id);
  
  @PutMapping("/updateconcession/{full_name}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateConcessionNameById(
      @RequestParam(required = true) String full_name, 
      @RequestParam(required = true) int concessions_id);
  
  @PutMapping("/updateconcession/{price}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateConcessionPriceById(
      @RequestParam(required = true) double price, 
      @RequestParam(required = true) int concessions_id);
  
  @PutMapping("/updateconcession/{quantity}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateConcessionQuantityById(
      @RequestParam(required = true) int quantity, 
      @RequestParam(required = true) int concessions_id);
  
} // last bracket
