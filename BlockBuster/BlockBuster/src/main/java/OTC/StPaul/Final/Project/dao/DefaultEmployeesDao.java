package OTC.StPaul.Final.Project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import OTC.StPaul.Final.Project.entity.employees;

@Component
@Service
@Transactional
public class DefaultEmployeesDao implements EmployeesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // returns a list of all employees in database (from every store)
  @Override
  public List<employees> listAllEmployees() {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM employees";
    // @formatter:on

    return jdbcTemplate.query(sql, new ResultSetExtractor<>() {
      @Override
      public List<employees> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(employees.builder()
              .employee_idPK(rs.getLong("employee_idPK"))
              .first_name(rs.getString("first_name"))
              .last_name(rs.getString("last_name"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .store_idFK(rs.getLong("store_idFK"))
              .build());
          // @formatter:on
        }

        return extractData(null);
      }
    });

  }

  // returns all employees for a specific store using the store id number
  @Override
  public List<employees> retrieveEmployeesByStoreID(Long store_idFK) {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM employees "
        + "WHERE store_idFK = :store_idFK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("store_idFK", store_idFK);

    return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {
      @Override
      public List<employees> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(employees.builder()
              .employee_idPK(rs.getLong("employee_idPK"))
              .first_name(rs.getString("first_name"))
              .last_name(rs.getString("last_name"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .store_idFK(rs.getLong("store_idFK"))
              .build());
          // @formatter:on
        }

        return extractData(null);
      }
    });
  }

  // returns a single employee by by employee id number
  @Override
  public List<employees> retrieveSingleEmployeeByEmployeeId(Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM employees "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("employee_idPK", employee_idPK);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public employees mapRow(ResultSet rs, int rowNum) throws SQLException {

        // @formatter:off
          return employees.builder()
              .employee_idPK(rs.getLong("employee_idPK"))
              .first_name(rs.getString("first_name"))
              .last_name(rs.getString("last_name"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .store_idFK(rs.getLong("store_idFK"))
              .build();
          // @formatter:on
      }
    });
  }

  // adds an employee to the database
  @Override
  public void addEmployee(String first_name, String last_name, String address, String phone,
      Long store_idFK) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO employees ("
        + "first_name, last_name, address, phone, store_idFK"
        + ") VALUES ("
        + ":first_name, :last_name, :address, :phone, :store_idFK"
        + ")";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();

    params.put("first_name", first_name);
    params.put("last_name", last_name);
    params.put("address", address);
    params.put("phone", phone);
    params.put("store_idFK", store_idFK);
    
    jdbcTemplate.update(sql, params);
  }

  // deletes and employee by employee id number
  public void deleteEmployeeById(Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "DELETE FROM employees "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("employee_idPK", employee_idPK);

    jdbcTemplate.update(sql, params);
  }

  // updates an employees first name by employee id number
  public void updateEmployeeFirstNameById(String first_name, Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "UPDATE employees "
        + "SET first_name = :first_name "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("first_name", first_name);
    params.put("employee_idPK", employee_idPK);

    jdbcTemplate.update(sql, params);
  }

  // updates an employees last name by employee id number
  public void updateEmployeeLastNameById(String last_name, Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "UPDATE employees "
        + "SET last_name = :last_name "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("last_name", last_name);
    params.put("employee_idPK", employee_idPK);

    jdbcTemplate.update(sql, params);
  }

  // updates an employees address by employee id number
  public void updateEmployeeAddressById(String address, Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "UPDATE employees "
        + "SET address = :address "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("address", address);
    params.put("employee_idPK", employee_idPK);

    jdbcTemplate.update(sql, params);
  }

  // updates an employees phone number by employee id number
  public void updateEmployeePhoneById(String phone, Long employee_idPK) {

    // @formatter:off
    String sql = ""
        + "UPDATE employees "
        + "SET phone = :phone "
        + "WHERE employee_idPK = :employee_idPK";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("phone", phone);
    params.put("employee_idPK", employee_idPK);

    jdbcTemplate.update(sql, params);
  }

} // last bracket