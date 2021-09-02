package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.CustomersDao;
import OTC.StPaul.Final.Project.entity.customers;

@Service
public class DefaultCustomersService implements CustomersService {
  
  @Autowired
  private CustomersDao customersDao;

  @Override
  public List<customers> listAllCustomers() {
    return customersDao.listAllCustomers();
  }

  @Override
  public List<customers> retrieveCustomersByCustomerID(int customer_id) {
    return customersDao.retrieveCustomersByCustomerID(customer_id);
  }

  @Override
  public List<customers> retrieveCustomerACustomerByFirstNameAndLastName(String first_name,
      String last_name) {
    return customersDao.retrieveCustomerACustomerByFirstNameAndLastName(first_name, last_name);
  }

  @Override
  public void addCustomer(String first_name, String last_name, String address, String phone) {
    customersDao.addCustomer(first_name, last_name, address, phone);
    
  }

  @Override
  public void deleteCustomerById(int customer_id) {
    customersDao.deleteCustomerById(customer_id);
    
  }

  @Override
  public void updateCustomerFisrtNameById(String first_name, int customer_id) {
    customersDao.updateCustomerFisrtNameById(first_name, customer_id);
    
  }

  @Override
  public void updateCustomerLastNameById(String last_name, int customer_id) {
    customersDao.updateCustomerLastNameById(last_name, customer_id);
    
  }

  @Override
  public void updateCustomerAddressById(String address, int customer_id) {
    customersDao.updateCustomerAddressById(address, customer_id);
    
  }

  @Override
  public void updateCustomerPhoneById(String phone, int customer_id) {
    customersDao.updateCustomerPhoneById(phone, customer_id);
    
  }
  
} // last bracket
