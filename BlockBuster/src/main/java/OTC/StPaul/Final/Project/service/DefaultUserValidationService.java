package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.UserValidationDao;
import OTC.StPaul.Final.Project.entity.user_validation;

@Service
public class DefaultUserValidationService implements UserValidationService{

  @Autowired
  private UserValidationDao userValidationDao;
  
  @Override
  public void addUserValidation(Long emp_idFK, String emp_username, String emp_validator) {
    userValidationDao.addUserValidation(emp_idFK, emp_username, emp_validator);
  }
  
  @Override
  public void updateUserValidatorByEmpId(String emp_validator, Long emp_idFK, String emp_username) {
    userValidationDao.updateUserValidatorByEmpId(emp_validator, emp_idFK, emp_username);
  }
  
  @Override
  public void deleteUserValidationByEmpId(String emp_idFK) {
    userValidationDao.deleteUserValidationByEmpId(emp_idFK);
  }
  
  @Override
  public void enableUserValidationByEmpId(String emp_idFK) {
    userValidationDao.enableUserValidationByEmpId(emp_idFK);
  }
  
  @Override
  public void disableUserValidationByEmpId(String emp_idFK) {
    userValidationDao.disableUserValidationByEmpId(emp_idFK);
  }
  
  @Override
  public List<user_validation> findEmpUsername(Long emp_idFK) {
    return userValidationDao.findEmpUsername(emp_idFK);
  }
  
} // last bracket
