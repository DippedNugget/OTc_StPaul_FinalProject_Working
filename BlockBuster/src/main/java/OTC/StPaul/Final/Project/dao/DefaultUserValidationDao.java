package OTC.StPaul.Final.Project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import OTC.StPaul.Final.Project.entity.user_validation;

@Component
@Service
@Transactional
public class DefaultUserValidationDao extends JdbcDaoSupport implements UserValidationDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public DefaultUserValidationDao(DataSource dataSource) {
    this.setDataSource(dataSource);}
  
  // adds login credentials for a user
  @Override
  public void addUserValidation(Long emp_idFK, String emp_username, String emp_validator) {
    
    // @formatter:off
    String sql = ""
        + "INSERT INTO user_validation ("
        + "emp_idFK, emp_username, emp_validator"
        + ") VALUES ("
        + ":emp_idFK, :emp_username, :emp_validator"
        + ")";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_idFK", emp_idFK);
    params.put("emp_username", emp_username);
    params.put("emp_validator", emp_validator);
    
    jdbcTemplate.update(sql, params);
  }
  
  // delete a users login validation by employee id number
  @Override
  public void deleteUserValidationByEmpId(String emp_idFK) {
    
    // @formatter:off
    String sql = ""
        + "DELETE FROM user_validation "
        + "WHERE emp_idFK = :emp_idFK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_idFK", emp_idFK);
    
    jdbcTemplate.update(sql, params);
  }
  
  // updates an employees emp_validator (password) by employee id number & username
  @Override
  public void updateUserValidatorByEmpId(String emp_validator, Long emp_idFK, String emp_username) {
   
   // @formatter:off
   String sql = ""
       + "UPDATE user_validation "
       + "SET emp_validator = :emp_validator "
       + "WHERE emp_idFK = :emp_idFK "
       + "AND emp_username = :emp_username";
   // @formatter:on
   
   Map<String, Object> params = new HashMap<>();
   params.put("emp_validator", emp_validator);
   params.put("emp_idFK", emp_idFK);
   params.put("emp_username", emp_username);
   
   jdbcTemplate.update(sql, params);
 }
  
  // Enables a Users Validation
  @Override
  public void enableUserValidationByEmpId(String emp_idFK) {
    
    // @formatter:off
    String sql = ""
        + "Update user_validation "
        + "SET ENABLED = true "
        + "WHERE emp_idFK = :emp_idFK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_idFK", emp_idFK);
    
    jdbcTemplate.update(sql, params);
  }
  
  // Disables a Users Validation
  @Override
  public void disableUserValidationByEmpId(String emp_idFK) {
    
    // @formatter:off
    String sql = ""
        + "Update user_validation "
        + "SET ENABLED = false "
        + "WHERE emp_idFK = :emp_idFK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_idFK", emp_idFK);
    
    jdbcTemplate.update(sql, params);
  }
  
  // finds an employees emp_username by emp_idFK
  @Override
  public List<user_validation> findEmpUsername(Long emp_idFK) {
    
    // @formatter:off
    String sql = ""
        + "SELECT emp_idFK, emp_username "
        + "FROM user_validation "
        + "WHERE emp_idFk = :emp_idFK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_idFK", emp_idFK);
    
    return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {
      @Override
      public List<user_validation> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(user_validation.builder()
              .emp_idFK(rs.getLong("emp_idFK"))
              .emp_username(rs.getString("emp_username"))
              .build());
          // @formatter:on
        }

        return extractData(null);
      }
    });
   
  }
  
  // finds a users password for verification purposes
  @Override
  public List<user_validation> findUserInfo(String emp_username) {
    
    // @formatter:off
    String sql = ""
        + "SELECT emp_username, emp_validator "
        + "FROM user_validation "
        + "WHERE emp_username = :emp_username";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("emp_username", emp_username);
    
    return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {
      @Override
      public List<user_validation> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(user_validation.builder()
              .emp_username(rs.getString("emp_username"))
              .emp_validator(rs.getString("emp_validator"))
              .build());
          // @formatter:on
        }

        return extractData(null);
      }
    });
  }
  
  // gets users roles for login type
  @SuppressWarnings("deprecation")
  @Override
  public List<String> getUserRoles(String emp_username) {
    
    // @formatter:off
    String sql = ""
        + "SELECT user_role "
        + "FROM user_roles "
        + "WHERE emp_username = ?";
    // @formatter:on
    
    Object[] params = new Object[] {emp_username};
    
    List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
    
    return roles;
  }
  
} // last bracket
