package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.Individual_Roles;
import OTC.StPaul.Final.Project.entity.user_roles;
import OTC.StPaul.Final.Project.service.UserRolesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUserRolesController implements UserRolesController{
  
  @Autowired
  private UserRolesService userRolesService;

  @Override
  public ResponseEntity<List<user_roles>> getUserRoles(String emp_username) {
    log.info("A Request for an emplyees={} role was made", emp_username);
    List<user_roles> userRoles = userRolesService.getUserRoles(emp_username);
    return new ResponseEntity<List<user_roles>>(userRoles, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<user_roles>> retrieveAllEmployeesOfACertainRole(
      Individual_Roles role) {
    log.info("A Request for an emplyees={} role was made", role);
    List<user_roles> userRoles = userRolesService.retrieveAllEmployeesOfACertainRole(role);
    return new ResponseEntity<List<user_roles>>(userRoles, HttpStatus.OK);
  }

  @Override
  public void addRolesForEmployees(String emp_username, String user_role) {
    log.info("Added a user role for an employee={}", emp_username);
    userRolesService.addRolesForEmployees(emp_username, user_role);
  }

  @Override
  public void deleteRolesFromEmployeeByRoleId(Long role_id) {
    log.info("Delete a user role from an employee");
    userRolesService.deleteRolesFromEmployeeByRoleId(role_id);
  }

}
