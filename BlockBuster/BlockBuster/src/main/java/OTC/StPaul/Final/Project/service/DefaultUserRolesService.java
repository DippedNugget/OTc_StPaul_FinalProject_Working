package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.UserRolesDao;
import OTC.StPaul.Final.Project.entity.Individual_Roles;
import OTC.StPaul.Final.Project.entity.user_roles;

@Service
public class DefaultUserRolesService implements UserRolesService{
  
  @Autowired
  private UserRolesDao userRolesDao;
  
  @Override
  public List<user_roles> getUserRoles(String emp_username) {
    return userRolesDao.getUserRoles(emp_username);
  }
  
  @Override
  public List<user_roles> retrieveAllEmployeesOfACertainRole(Individual_Roles role) {
    return userRolesDao.retrieveAllEmployeesOfACertainRole(role);
  }
  
  @Override
  public void addRolesForEmployees(user_roles userRoles) {
    userRolesDao.addRolesForEmployees(userRoles);
  }
  
  @Override
  public void addRolesForEmployees(String emp_username, String user_role) {
    userRolesDao.addRolesForEmployees(emp_username, user_role);
  }

  @Override
  public void deleteRolesFromEmployeeByRoleId(Long role_id) {
    userRolesDao.deleteRolesFromEmployeeByRoleId(role_id);
  }

} // last bracket
