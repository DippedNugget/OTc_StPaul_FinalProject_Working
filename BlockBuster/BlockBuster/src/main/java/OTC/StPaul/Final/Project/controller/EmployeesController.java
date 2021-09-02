package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.employees;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface EmployeesController {

  @GetMapping("/employees")
  ResponseEntity<List<employees>> listAllEmployees();
  
  @GetMapping("/employeesbystoreid/{store_idFK}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<employees>> retrieveEmployeesByStoreID(
      @PathVariable Long store_idFK);
  
  @GetMapping("/employeebyid/{employee_idPK}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<employees>> retrieveSingleEmployeeByEmployeeId(
      @PathVariable Long employee_idPK);
  
  @PostMapping("/employees/addemployee")
  @ResponseStatus(code = HttpStatus.CREATED)
  void addEmployee(
      @RequestParam(required = true) String first_name,
      @RequestParam(required = true) String last_name,
      @RequestParam(required = true) String address,
      @RequestParam(required = true) String phone,
      @RequestParam(required = true) Long store_idFK
      );
  
  @DeleteMapping("/deleteemployee/{employee_idPK}")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteEmployeeById(
      @PathVariable Long employee_idPK);
  
  @PutMapping("/updateemployees/{first_name}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateEmployeeFirstNameById(
      @RequestParam(required = true) String first_name, 
      @RequestParam(required = true) Long employee_idPK);

  @PutMapping("/updateemployees/{last_name}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateEmployeeLastNameById(
      @RequestParam(required = true) String last_name, 
      @RequestParam(required = true) Long employee_idPK);
  
  @PutMapping("/updateemployees/{address}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateEmployeeAddressById(
      @RequestParam(required = true) String address,
      @RequestParam(required = true) Long employee_idPK);
  
  @PutMapping("/updateemployees/{phone}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateEmployeePhoneById(
      @RequestParam(required = true) String phone,
      @RequestParam(required = true) Long employee_idPK);
  
} // last bracket
