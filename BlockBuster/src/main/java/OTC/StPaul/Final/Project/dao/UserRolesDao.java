package OTC.StPaul.Final.Project.dao;

import java.util.List;
import OTC.StPaul.Final.Project.entity.Individual_Roles;
import OTC.StPaul.Final.Project.entity.user_roles;

public interface UserRolesDao {

  /**
   * 
   * @param emp_username
   * @return
   */
  List<user_roles> getUserRoles(String emp_username);
  
  /**
   * 
   * @param role
   * @return
   */
  List<user_roles> retrieveAllEmployeesOfACertainRole(Individual_Roles role);

  /**
   * 
   * @param userRoles
   */
  void addRolesForEmployees(user_roles userRoles);
  
  /**
   * 
   * @param emp_username
   * @param user_role
   */
  void addRolesForEmployees(String emp_username, String user_role);
  
  /**
   * 
   * @param role_id
   */
  void deleteRolesFromEmployeeByRoleId(Long role_id);

} // last bracket
