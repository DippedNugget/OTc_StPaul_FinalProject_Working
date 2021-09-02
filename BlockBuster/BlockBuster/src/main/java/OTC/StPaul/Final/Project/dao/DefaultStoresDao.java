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
import OTC.StPaul.Final.Project.entity.stores;

@Component
@Service
@Transactional
public class DefaultStoresDao implements StoresDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<stores> listAllStores() {
    // @formatter:off
    String sql = "" + "SELECT * " + "FROM stores";
    // @formatter:on
    return jdbcTemplate.query(sql, new ResultSetExtractor<List<stores>>() {

      @Override
      public List<stores> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          //@formatter:off
          return List.of(stores.builder()
              .store_idPK(rs.getInt("store_idPK"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .build());
          //@formatter:on
        }
        //return extractData1(null);
        return null;
      }
    });
  }

  @Override
  public List<stores> retrieveAStoreByStoreId(int store_idPK) {
    // @formatter:off
    String sql = "" + "SELECT * " + "FROM stores " + "WHERE store_idPK = :store_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("store_idPK", store_idPK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<> () {
      @Override
      public stores mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
          // @formatter:off
          return stores.builder()
              .store_idPK(rs.getInt("store_idPK"))
              .address(rs.getString("address"))
              .phone(rs.getString("phone"))
              .build();
         // @formatter:on
      }
    });
  }
    
  @Override
  public void addStore(String address, String phone) {
    // @formatter:off
    String sql = "" + "INSERT INTO stores (" + "address, phone" + ") "
        + "VALUES (" + ":address, :phone" + ")";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<> ();
    params.put("address", address);
    params.put("phone", phone);
    
    jdbcTemplate.update(sql, params);
  }

  @Override
  public void deleteStoreById(int store_idPK) {
    // @formatter:off
    String sql = "" + "DELETE FROM stores " 
    + "WHERE store_idPK = :store_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("store_idPK", store_idPK);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public void updateAddressByStoreId(String address, int store_idPK) {
    // @formatter:off
    String sql = "" + "UPDATE stores " + "SET address = :address " + "WHERE store_idPK = :store_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("address", address);
    params.put("store_idPK", store_idPK);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public void updatePhoneByStroreId(String phone, int store_idPK) {
    // @formatter:off
    String sql = "" + "UPDATE stores " + "SET phone = :phone " + "WHERE store_idPK = :store_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("phone", phone);
    params.put("store_idPK", store_idPK);
    
    jdbcTemplate.update(sql, params);
    
  }

} // last bracket