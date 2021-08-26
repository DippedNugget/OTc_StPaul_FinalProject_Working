package OTC.StPaul.Final.Project.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.entity.customers;

@Component
@Service
@Transactional
public class DefaultCustomersDao implements CustomersDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<customers> listAllCustomers() {
    // @formatter:off
    String sql = "" + "SELECT * " + "FROM customers";
    // @formatter:on
    return jdbcTemplate.query(sql, new ResultSetExtractor<>()) {
      public List<Customers> extractDate(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(customers.builder()
              .customer_id(rs.getInt("customer_id"))
              .first_name(rs.getString("first_name"))
              .last_name(rs.getString("last_name"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .build());
          // @formatter:on
        }
        return extractData(null);
      }
    });
  }

  @Override
  public List<customers> retrieveCustomersByCustomerID(int customer_id) {
    
    // @formatter:off
    String sql = "" + "SELECT * " + "FROM customers" + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customer_id);
    return jdbcTemplate.query(sql, new RowMapper<>() {
      @Overide
      public customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return customers.builder()
            .customer_id(rs.getInt("customer_id"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .address(rs.getString("address"))
            .phone(rs.getString("phone"))
            .build();
        // @formatter:on
      }
    });
      
  }

  @Override
  public List<customers> retrieveCustomerACustomerByFirstNameAndLastName(String first_name,
      String last_name) {
    // @formatter:off
    String sql = "" + "SELECT * " + "FROM customers" + "WHERE first_name AND last_name = :first_name AND last_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name, last_name", first_name, last_name);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Overide
      public customers mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return customers.builder()
            .customer_id(rs.getInt("customer_id"))
            .first_name(rs.getString("first_name"))
            .last_name(rs.getString("last_name"))
            .address(rs.getString("address"))
            .phone(rs.getString("phone"))
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public void addCustomer(String first_name, String last_name, String address, String phone) {
    // @formatter:off
    String sql = "" + "INSERT INTO employees (" + "first_name, last_name, address, phone" + ") VALUES ("+ ":first_name, :last_name, :address, :phone" + ")";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", first_name);
    params.put("last_name", last_name);
    params.put("address", address);
    params.put("phone", phone);
    
    jdbcTemplate.update(sql, params);
  }

  @Override
  public void deleteCustomerById(int customer_id) {
    // @formatter:off
    String sql = "" + "DELETE FROM customers " + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customer_id);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public void updateCustomerFisrtNameById(String first_name, int customer_id) {
    // @formatter:off
    String sql = "" + "UPDATE customers " + "SET first_name = :first_name " + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", first_name);
    params.put("customer_id", customer_id);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public void updateCustomerLastNameById(String last_name, int customer_id) {
    // @formatter:off
    String sql = "" + "UPDATE customers " + "SET last_name = :last_name " + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("last_name", last_name);
    params.put("customer_id", customer_id);
    
    jdbcTemplate.update(sql, params);
  }

  @Override
  public void updateCustomerAddressById(String address, int customer_id) {
    // @formatter:off
    String sql = "" + "UPDATE customers " + "SET address = :address " + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address", address);
    params.put("customer_id", customer_id);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public void updateCustomerPhoneById(String phone, int customer_id) {
    // @formatter:off
    String sql = "" + "UPDATE employees " + "SET phone = :phone " + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("phone", phone);
    params.put("customer_id", customer_id);
    
    jdbcTemplate.update(sql, params);
    
  }
  
}
