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
import OTC.StPaul.Final.Project.entity.concessions;

@Component
@Service
@Transactional
public class DefaultConcessionsDao implements ConcessionsDao {

  @Autowired
  public NamedParameterJdbcTemplate jdbcTemplate;
  
  // returns a list of all concession items
  @Override
  public List<concessions> listAllConcessions() {
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM concessions";
    // @formatter:on
    
    return jdbcTemplate.query(sql,  new ResultSetExtractor<>() {
      @Override
      public List<concessions> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(concessions.builder()
              .concessions_id(rs.getInt("concessions_id"))
              .full_name(rs.getString("full_name"))
              .price(rs.getDouble("price"))
              .quantity(rs.getInt("quantity"))
              .build());
          // @formatter:on
        }
        return extractData(null);
      }
    });
    
  }

  // returns a single concession item by concession id
  @Override
  public List<concessions> retrieveSingleConcessionByConcessionID(int concessions_id) {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM concessions "
        + "WHERE concessions_id = :concessions_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("concessions_id", concessions_id);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public concessions mapRow(ResultSet rs, int rowNum) throws SQLException {
        
     // @formatter:off
        return concessions.builder()
            .concessions_id(rs.getInt("concessions_id"))
            .full_name(rs.getString("full_name"))
            .price(rs.getDouble("price"))
            .quantity(rs.getInt("quantity"))
            .build();
        // @formatter:on
      }
    });
  }

  // returns a single concession item by name
  @Override
  public List<concessions> retrieveSingleConcessionByName(String full_name) {

    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM concessions "
        + "WHERE full_name = :full_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("full_name", full_name);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public concessions mapRow(ResultSet rs, int rowNum) throws SQLException {
        
     // @formatter:off
        return concessions.builder()
            .concessions_id(rs.getInt("concessions_id"))
            .full_name(rs.getString("full_name"))
            .price(rs.getDouble("price"))
            .quantity(rs.getInt("quantity"))
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public void addConcession(String full_name, double price, int quantity) {
 // @formatter:off
    String sql = ""
        + "INSERT INTO concessions ("
        + "full_name, price, quantity"
        + ")VALUES ("
        + ":full_name, :price, :quantity"
        + ")";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    
    params.put("full_name", full_name);
    params.put("price", price);
    params.put("quantity", quantity);
    
    jdbcTemplate.update(sql, params); 
  }

  // deletes a concessions item by id
  @Override
  public void deleteConcessionById(int concessions_id) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM concessions "
        + "WHERE concessions_id = :concessions_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("concessions_id", concessions_id);
    
    jdbcTemplate.update(sql,  params);
  }

  // updates a concession name by concession id number
  @Override
  public void updateConcessionNameById(String full_name, int concessions_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE concessions "
        + "SET full_name = :full_name "
        + "WHERE concessions_id = :concessions_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("full_name", full_name);
    params.put("concessions_id", concessions_id);

    jdbcTemplate.update(sql, params);
  }

  // updates a concession price by concession id
  @Override
  public void updateConcessionPriceById(double price, int concessions_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE concessions "
        + "SET price = :price "
        + "WHERE concessions_id = :concessions_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("price", price);
    params.put("concessions_id", concessions_id);

    jdbcTemplate.update(sql, params);
  }

  @Override
  public void updateConcessionQuantityById(int quantity, int concessions_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE concessions "
        + "SET quantity = :quantity "
        + "WHERE concessions_id = :concessions_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("quantity", quantity);
    params.put("concessions_id", concessions_id);

    jdbcTemplate.update(sql, params);
  }

} // last bracket