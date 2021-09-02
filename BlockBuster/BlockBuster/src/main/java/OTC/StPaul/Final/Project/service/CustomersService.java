package OTC.StPaul.Final.Project.service;

import java.util.List;
import OTC.StPaul.Final.Project.entity.customers;

public interface CustomersService {
  List<customers> listAllCustomers();
  
  List<customers> retrieveCustomersByCustomerID(int customer_id);
  
  List<customers> retrieveCustomerACustomerByFirstNameAndLastName(String first_name, String last_name);
  
  void addCustomer(String first_name, String last_name, String address, String phone);
  
  void deleteCustomerById(int customer_id);
  
  void updateCustomerFisrtNameById(String first_name, int customer_id);
  
  void updateCustomerLastNameById(String last_name, int customer_id);
  
  void updateCustomerAddressById(String address, int customer_id);
  
  void updateCustomerPhoneById(String phone, int customer_id);
  
} // last bracket
