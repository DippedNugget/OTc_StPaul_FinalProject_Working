package OTC.StPaul.Final.Project.service;

import java.util.List;
import OTC.StPaul.Final.Project.entity.user_validation;

public interface UserValidationService {

  
  /**
   * 
   * @param emp_idFK
   * @param emp_username
   * @param emp_validator
   */
  void addUserValidation(Long emp_idFK, String emp_username, String emp_validator);

  /**
   * 
   * @param emp_validator
   * @param emp_idFK
   */
  void updateUserValidatorByEmpId(String emp_validator, Long emp_idFK, String emp_username);

  /**
   * 
   * @param emp_idFK
   */
  void deleteUserValidationByEmpId(String emp_idFK);

  /**
   * 
   * @param emp_idFK
   */
  void enableUserValidationByEmpId(String emp_idFK);

  /**
   * 
   * @param emp_idFK
   */
  void disableUserValidationByEmpId(String emp_idFK);

  /**
   * 
   * @param emp_idFK
   * @return
   */
  List<user_validation> findEmpUsername(Long emp_idFK);

} // last bracket
