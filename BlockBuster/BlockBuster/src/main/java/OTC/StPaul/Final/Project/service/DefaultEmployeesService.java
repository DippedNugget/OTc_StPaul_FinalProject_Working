package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.EmployeesDao;
import OTC.StPaul.Final.Project.entity.employees;

@Service
public class DefaultEmployeesService implements EmployeesService{
  
  @Autowired
  private EmployeesDao employeesDao;
  
  @Override
  public List<employees> listAllEmployees() {
    return employeesDao.listAllEmployees();
  }
  
  @Override
  public List<employees> retrieveEmployeesByStoreID(Long store_idFK) {
    return employeesDao.retrieveEmployeesByStoreID(store_idFK);
  }
  
  @Override
  public List<employees> retrieveSingleEmployeeByEmployeeId(Long employee_idPK) {
    return employeesDao.retrieveSingleEmployeeByEmployeeId(employee_idPK);
  }
  
  @Override
  public void addEmployee(String first_name, String last_name, String address, String phone,
      Long store_idFK) {
    employeesDao.addEmployee(first_name, last_name, address, phone, store_idFK);
  }
  
  @Override
  public void deleteEmployeeById(Long employee_idPK) {
    employeesDao.deleteEmployeeById(employee_idPK);
  }
  
  @Override
  public void updateEmployeeFirstNameById(String full_name, Long employee_idPK) {
    employeesDao.updateEmployeeFirstNameById(full_name, employee_idPK);
  }
  
  @Override
  public void updateEmployeeLastNameById(String last_name, Long employee_idPK) {
    employeesDao.updateEmployeeLastNameById(last_name, employee_idPK);
  }
  
  @Override
  public void updateEmployeeAddressById(String address, Long employee_idPK) {
    employeesDao.updateEmployeeAddressById(address, employee_idPK);
  }
  
  @Override
  public void updateEmployeePhoneById(String phone, Long employee_idPK) {
    employeesDao.updateEmployeePhoneById(phone, employee_idPK);
  }

} // last bracket
