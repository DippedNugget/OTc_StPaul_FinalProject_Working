package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.user_validation;
import OTC.StPaul.Final.Project.service.UserValidationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUserValidationController implements UserValidationController {
  
  @Autowired
  private UserValidationService userValidationService;

  @Override
  public void addUserValidation(Long emp_idFK, String emp_username, String emp_validator) {
    log.info("Added a validation for an employee={}", emp_idFK);
    userValidationService.addUserValidation(emp_idFK, emp_username, emp_validator);
  }

  @Override
  public void deleteUserValidationByEmpId(String emp_idFK) {
    log.info("Deleted the validation of an employee={}", emp_idFK);
    userValidationService.deleteUserValidationByEmpId(emp_idFK);
  }

  @Override
  public void updateUserValidatorByEmpId(String emp_validator, Long emp_idFK, String emp_username) {
    log.info("Updated and employees={} validator", emp_idFK);
    userValidationService.updateUserValidatorByEmpId(emp_validator, emp_idFK, emp_username); 
  }

  @Override
  public void enableUserValidationByEmpId(String emp_idFK) {
    log.info("Enabled an employees={} validation", emp_idFK);
    userValidationService.enableUserValidationByEmpId(emp_idFK);
  }

  @Override
  public void disableUserValidationByEmpId(String emp_idFK) {
    log.info("Disabled and employees={} validation", emp_idFK);
    userValidationService.disableUserValidationByEmpId(emp_idFK);
  }

  @Override
  public ResponseEntity<List<user_validation>> findEmpUsername(Long emp_idFK) {
    log.info("A Request for an employees={} username was made", emp_idFK);
    List<user_validation> userValidation = userValidationService.findEmpUsername(emp_idFK);
    return new ResponseEntity<List<user_validation>>(userValidation, HttpStatus.OK);
  }

} // last bracket
