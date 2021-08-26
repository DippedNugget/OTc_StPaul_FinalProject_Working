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
import OTC.StPaul.Final.Project.entity.user_validation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface UserValidationController {
  
  @PostMapping("/user_validation/addvalidation")
  @ResponseStatus(code = HttpStatus.CREATED)
  void addUserValidation(
      @RequestParam(required = true) Long emp_idFK,
      @RequestParam(required = true) String emp_username,
      @RequestParam(required = true) String emp_validator);
  
  @DeleteMapping("/deleteuser_validation/{emp_idFK}")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteUserValidationByEmpId(
      @PathVariable String emp_idFK);
  
  @PutMapping("/updateuser_validation/{emp_idFK}/{emp_username}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateUserValidatorByEmpId(
      @RequestParam(required = true) String emp_validator,
      @PathVariable Long emp_idFK,
      @PathVariable String emp_username);
  
  @PutMapping("/enableuser_validation/{emp_idFK}")
  @ResponseStatus(code = HttpStatus.OK)
  void enableUserValidationByEmpId(
      @PathVariable String emp_idFK);
  
  @PutMapping("/disableuser_validation/{emp_idFK}")
  @ResponseStatus(code = HttpStatus.OK)
  void disableUserValidationByEmpId(
      @PathVariable String emp_idFK);
  
  @GetMapping("/user_validation/{emp_idFK}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<user_validation>> findEmpUsername(
      @PathVariable Long emp_idFK);
      
} // last bracket
