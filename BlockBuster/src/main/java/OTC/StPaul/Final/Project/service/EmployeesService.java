package OTC.StPaul.Final.Project.service;

import java.util.List;
import OTC.StPaul.Final.Project.entity.employees;

public interface EmployeesService {

  /**
   * 
   * @return
   */
  List<employees> listAllEmployees();

  /**
   * 
   * @param store_idFK
   * @return
   */
  List<employees> retrieveEmployeesByStoreID(Long store_idFK);

  /**
   * 
   * @param employee_idPK
   * @return
   */
  List<employees> retrieveSingleEmployeeByEmployeeId(Long employee_idPK);
  
  /**
   * 
   * @param first_name
   * @param last_name
   * @param address
   * @param phone
   * @param store_idFK
   */
  void addEmployee(String first_name, String last_name, String address, String phone,
      Long store_idFK);

  /**
   * 
   * @param employee_idPK
   */
  void deleteEmployeeById(Long employee_idPK);

  /**
   * 
   * @param full_name
   * @param employee_idPK
   */
  void updateEmployeeFirstNameById(String full_name, Long employee_idPK);

  /**
   * 
   * @param last_name
   * @param employee_idPK
   */
  void updateEmployeeLastNameById(String last_name, Long employee_idPK);

  /**
   * 
   * @param address
   * @param employee_idPK
   */
  void updateEmployeeAddressById(String address, Long employee_idPK);

  /**
   * 
   * @param phone
   * @param employee_idPK
   */
  void updateEmployeePhoneById(String phone, Long employee_idPK);

} //last bracket
