package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.employees;
import OTC.StPaul.Final.Project.service.EmployeesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEmployeesController implements EmployeesController {
  
  @Autowired
  private EmployeesService employeesService;
  
  @Override
  public ResponseEntity<List<employees>> listAllEmployees() {
    log.info("A Request for the complete emplyees list was made");
    List<employees> employees = employeesService.listAllEmployees();
    return new ResponseEntity<List<employees>>(employees, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<employees>> retrieveEmployeesByStoreID(Long store_idFK) {
    log.info("A Request for a stores={} employees was made", store_idFK);
    List<employees> storeEmployees = employeesService.retrieveEmployeesByStoreID(store_idFK);
    return new ResponseEntity<List<employees>>(storeEmployees, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<employees>> retrieveSingleEmployeeByEmployeeId(Long employee_idPK) {
    log.info("A Request for a single employees={} information was made", employee_idPK);
    List<employees> singleEmployee = employeesService.retrieveSingleEmployeeByEmployeeId(employee_idPK);
    return new ResponseEntity<List<employees>>(singleEmployee, HttpStatus.OK);
  }

  @Override
  public void addEmployee(String first_name, String last_name, String address, String phone,
      Long store_idFK) {
    log.info("Added an employee");
    employeesService.addEmployee(first_name, last_name, address, phone, store_idFK);  
  }

  @Override
  public void deleteEmployeeById(Long employee_idPK) {
    log.info("Deleted an employee");
    employeesService.deleteEmployeeById(employee_idPK);
  }

  @Override
  public void updateEmployeeFirstNameById(String first_name, Long employee_idPK) {
    log.info("Updated an employees={} first name", employee_idPK);
    employeesService.updateEmployeeFirstNameById(first_name, employee_idPK);
  }

  @Override
  public void updateEmployeeLastNameById(String last_name, Long employee_idPK) {
    log.info("Updated an employees={} last name", employee_idPK);
    employeesService.updateEmployeeLastNameById(last_name, employee_idPK);
  }

  @Override
  public void updateEmployeeAddressById(String address, Long employee_idPK) {
    log.info("Updated an employees={} address", employee_idPK);
    employeesService.updateEmployeeAddressById(address, employee_idPK);
  }

  @Override
  public void updateEmployeePhoneById(String phone, Long employee_idPK) {
    log.info("Updated an employees={} phone number", employee_idPK);
    employeesService.updateEmployeePhoneById(phone, employee_idPK);
  }

} // last bracket
