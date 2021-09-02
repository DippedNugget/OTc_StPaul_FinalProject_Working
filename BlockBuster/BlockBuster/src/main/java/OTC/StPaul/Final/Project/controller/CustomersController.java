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
import OTC.StPaul.Final.Project.entity.customers;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
  @Server(url = "http://localhost:8080", description = "Local Server.")})

public interface CustomersController {
  @GetMapping("/customers") ResponseEntity<List<customers>> listAllCustomers();
  
  @GetMapping("/customers/{customer_id}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<customers>> retrieveCustomersByCustomerId(@RequestParam(required = true)Integer customer_id);
  
  @GetMapping("/customer/{first_name, last_name}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<customers>> retrieveCustomerACustomerByFirstNameAndLastName(@RequestParam(required = true) String first_name, String last_name);
  
  @PostMapping("/customers/addcustomer")
  @ResponseStatus(code = HttpStatus.CREATED) void addCustomers (
      @RequestParam(required = true) String first_name,
      @RequestParam(required = true) String last_name,
      @RequestParam(required = true) String address,
      @RequestParam(required = true) String phone
      );
  @DeleteMapping("/deletecustomer/{customer_id}")
  @ResponseStatus(code = HttpStatus.OK) void deleteCustomerById(
      @RequestParam(required = true) int customer_id
      );
  @PutMapping("/updatecustomers/{first_name}")
  @ResponseStatus(code = HttpStatus.OK)void updateCustomerFirstNameById(
      @RequestParam(required = true) String first_name, 
      @RequestParam(required = true) int customer_id
      );
  @PutMapping("/updatecustomers/{last_name}")
  @ResponseStatus(code = HttpStatus.OK)void updateCustomerLastNameById(
      @RequestParam(required = true) String last_name, 
      @RequestParam(required = true) int customer_id
      );
  @PutMapping("/updatcustomers/{address}")
  @ResponseStatus(code = HttpStatus.OK)void updateCustomerAddressById(
      @RequestParam(required = true) String address,
      @RequestParam(required = true) int customer_id
      );
  @PutMapping("/updatecustomers/{phone}")
  @ResponseStatus(code = HttpStatus.OK)void updateCustomerPhoneById(
      @RequestParam(required = true) String phone,
      @RequestParam(required = true) int customer_id);

} // last bracket
