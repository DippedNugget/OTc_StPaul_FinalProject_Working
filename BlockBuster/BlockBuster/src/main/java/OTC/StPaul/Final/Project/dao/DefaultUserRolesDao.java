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
import OTC.StPaul.Final.Project.entity.Individual_Roles;
import OTC.StPaul.Final.Project.entity.user_roles;

@Component
@Service
@Transactional
public class DefaultUserRolesDao implements UserRolesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // gets users roles of an employee by emp_username
  @Override
  public List<user_roles> getUserRoles(String emp_username) {

    // @formatter:off
    String sql = ""
       + "SELECT emp_username, user_role "
       + "FROM user_roles "
       + "WHERE emp_username = :emp_username";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("emp_username", emp_username);

    return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {

      @Override
      public List<user_roles> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(user_roles.builder()
              .emp_username(rs.getString("emp_username"))
              .user_role(rs.getString("user_role"))
              .build());
          // @formatter:on
        }

        return extractData(null);
      }
    });
  }

  // retrieve all employees of a single role
  @Override
  public List<user_roles> retrieveAllEmployeesOfACertainRole(Individual_Roles role) {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM user_roles "
        + "WHERE user_role = :user_role";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("user_role", role.toString());

    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public user_roles mapRow(ResultSet rs, int rowNum) throws SQLException {

        // @formatter:off
          return user_roles.builder()
              .role_id(rs.getLong("role_id"))
              .emp_username(rs.getString("emp_username"))
              .user_role(rs.getString("user_role"))
              .build();
          // @formatter:on
      }
    });
  }

  // add a role for an employee
  @Override
  public void addRolesForEmployees(user_roles userRoles) {

    // @formatter:off
    String sql = ""
        + "INSERT INTO user_roles ("
        + "emp_username, user_role"
        + ") VALUES ("
        + ":emp_username, :user_role"
        + ")";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("emp_username", userRoles.getEmp_username());
    params.put("user_role", userRoles.getUser_role());

    jdbcTemplate.update(sql, params);
  }

  // delete a role for an employee
  @Override
  public void deleteRolesFromEmployeeByRoleId(Long role_id) {

    // @formatter:off
    String sql = ""
        + "DELETE FROM user_roles "
        + "WHERE role_id = :role_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("role_id", role_id);

    jdbcTemplate.update(sql, params);
  }

  @Override
  public void addRolesForEmployees(String emp_username, String user_role) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO user_roles ("
        + "emp_username, user_role"
        + ") VALUES ("
        + ":emp_username, :user_role"
        + ")";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("emp_username", emp_username);
    params.put("user_role", user_role);

    jdbcTemplate.update(sql, params);
  }

} // last bracket