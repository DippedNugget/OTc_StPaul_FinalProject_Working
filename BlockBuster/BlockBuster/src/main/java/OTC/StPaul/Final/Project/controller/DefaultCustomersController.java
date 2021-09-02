package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.customers;
import OTC.StPaul.Final.Project.service.CustomersService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomersController implements CustomersController {
  
  @Autowired
  private CustomersService customersService;

  @Override
  public ResponseEntity<List<customers>> listAllCustomers() {
    log.info("A Request for the complete customers list was made");
    List<customers> customers = customersService.listAllCustomers();
    return new ResponseEntity<List<customers>>(customers, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<customers>> retrieveCustomersByCustomerId(Integer customer_id) {
    log.info("A Request for a customer was made", customer_id);
    List<customers> customers = customersService.retrieveCustomersByCustomerID(customer_id);
    return new ResponseEntity<List<customers>>(customers, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<customers>> retrieveCustomerACustomerByFirstNameAndLastName(
      String first_name, String last_name) {
    log.info("A Request was made for a customer by firstName and lastName", first_name, last_name);
    List<customers> customerFirstNameAndLastName = customersService.retrieveCustomerACustomerByFirstNameAndLastName(first_name, last_name);
    return new ResponseEntity<List<customers>>(customerFirstNameAndLastName, HttpStatus.OK);
  }

  @Override
  public void addCustomers(String first_name, String last_name, String address, String phone) {
    log.info("Added a customer");
    customersService.addCustomer(first_name, last_name, address, phone);
  }

  @Override
  public void deleteCustomerById(int customer_id) {
    log.info("Delete a customer");
    customersService.deleteCustomerById(customer_id);
    
  }

  @Override
  public void updateCustomerFirstNameById(String first_name, int customer_id) {
    log.info("Updated a customer first_name",  customer_id);
    customersService.updateCustomerFisrtNameById(first_name, customer_id);
    
  }

  @Override
  public void updateCustomerLastNameById(String last_name, int customer_id) {
    log.info("Updated a customer last_name", customer_id);
    customersService.updateCustomerLastNameById(last_name, customer_id);
  }

  @Override
  public void updateCustomerAddressById(String address, int customer_id) {
    log.info("Updated customer address", customer_id);
    customersService.updateCustomerAddressById(address, customer_id);
    
  }

  @Override
  public void updateCustomerPhoneById(String phone, int customer_id) {
    log.info("Update a customer phone", customer_id);
    customersService.updateCustomerPhoneById(phone, customer_id);
    
  }

} // last bracket
