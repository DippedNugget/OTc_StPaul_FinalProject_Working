package OTC.StPaul.Final.Project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import OTC.StPaul.Final.Project.entity.concessions;
import OTC.StPaul.Final.Project.entity.customers;
import OTC.StPaul.Final.Project.entity.movies;
import OTC.StPaul.Final.Project.entity.stores;
import OTC.StPaul.Final.Project.entity.transactions;

@Component
public class DefaultTransactionsDao implements TransactionsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  

  @Override
  public transactions saveTransaction(customers customer, stores store, 
      Double total, List<movies> movies_rented, List<concessions> concessions_purchased) {
    SqlParams params = generateInsertSql(customer, store, total);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Integer transactionId = keyHolder.getKey().intValue();
    saveMovies(movies_rented, transactionId);
    saveConcessions(concessions_purchased, transactionId);
    
    // @formatter:off
    return transactions.builder()
        .transaction_id(transactionId)
        .customer(customer)
        .store(store)
        .movies_rented(movies_rented)
        .concessions_purchased(concessions_purchased)
        .total(total)
        .build();
    // @formatter:on
  }

  /**
   * 
   * @param movies_rented
   * @param transactionId
   */
  private void saveMovies(List<movies> movies_rented, Integer transactionId) {
    for (movies movie : movies_rented) {
      SqlParams params = generateInsertSql(movie, transactionId);
      jdbcTemplate.update(params.sql, params.source);
    }
    
  }

  /**
   * 
   * @param concessions_purchased
   * @param transactionId
   */
  private void saveConcessions(List<concessions> concessions_purchased, Integer transactionId) {
    for (concessions concession : concessions_purchased) {
      SqlParams params = generateInsertSql(concession, transactionId);
      jdbcTemplate.update(params.sql, params.source);
    }
    
  }
  
  /**
   * 
   * @param customer
   * @param store
   * @param total
   * @return
   */
  private SqlParams generateInsertSql(customers customer, stores store, Double total) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO transactions ("
        + "customer_idFK, store_idFK, total"
        + ") VALUES ("
        + ":customer_idFK, :store_idFK, :total"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("customer_idFK", customer.getCustomer_idPK());
    params.source.addValue("store_idFK", store.getStore_idPK());
    params.source.addValue("total", total);
    
    return params;
  }
  
  /**
   * 
   * @param movie
   * @param transactionId
   * @return
   */
  private SqlParams generateInsertSql(movies movie, Integer transactionId) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO transaction_movies ("
        + "movie_idFK, transaction_idFK"
        + ") VALUES ("
        + ":movie_idFK, :transaction_idFK"
        + ")";
    // @formatter:on
    
    params.source.addValue("movie_idFK", movie.getMovie_id());
    params.source.addValue("transaction_idFK", transactionId);
    
    return params;
  }
  
  /**
   * 
   * @param concession
   * @param transactionId
   * @return
   */
  private SqlParams generateInsertSql(concessions concession, Integer transactionId) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO transaction_concessions ("
        + "concessions_idFK, transaction_idFK"
        + ") VALUES ("
        + ":concessions_idFK, :transaction_idFK"
        + ")";
    // @formatter:on
    
    params.source.addValue("concessions_idFK", concession.getConcessions_id());
    params.source.addValue("transaction_idFK", transactionId);
    
    return params;
  }

  @Override
  public Optional<customers> fetchCustomer(Integer customer_idPK) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customers "
        + "WHERE customer_idPK = :customer_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_idPK", customer_idPK);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }
  
  public Optional<stores> fetchStore(Integer store_idPK) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM stores "
        + "WHERE store_idPK = :store_idPK";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("store_idPK", store_idPK);
    
    return Optional.ofNullable(jdbcTemplate.query(sql, params, new StoreResultSetExtractor()));
  }
  
  public List<movies> fetchMovie(List<String> movie_ids) {
    if (movie_ids.isEmpty()) {
      return new LinkedList<>();
    }
    
    Map<String, Object> params = new HashMap<>();
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM movies "
        + "WHERE movie_id IN(";
    // @formatter:on
    
    for (int index = 0; index < movie_ids.size(); index++) {
      String key = "movie_" + index;
      sql += ":" + key + ", ";
      params.put(key, movie_ids.get(index));
    }
    
    sql = sql.substring(0, sql.length() - 2);
    sql += ")";
    
    return jdbcTemplate.query(sql, params, new RowMapper<movies>() {
      @Override
      public movies mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return movies.builder()
            .movie_id(rs.getInt("movie_id"))
            .title(rs.getString("title"))
            .build();
        // @formatter:on
      }
    });
  }
  
  public List<concessions> fetchConcession(List<String> concessions_ids) {
    if (concessions_ids.isEmpty()) {
      return new LinkedList<>();
    }
    
    Map<String, Object> params = new HashMap<>();
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM concessions "
        + "WHERE concessions_id IN(";
    // @formatter:on
    
    for (int index = 0; index < concessions_ids.size(); index++) {
      String key = "concession_" + index;
      sql += ":" + key + ", ";
      params.put(key, concessions_ids.get(index));
    }
    
    sql = sql.substring(0, sql.length() - 2);
    sql += ")";
    
    return jdbcTemplate.query(sql, params, new RowMapper<concessions>() {
      @Override
      public concessions mapRow(ResultSet rs, int rowNum) throws SQLException {
       // @formatter:off
        return concessions.builder()
            .concessions_id(rs.getInt("concessions_id"))
            .full_name(rs.getString("full_name"))
            .price(rs.getDouble("price"))
            .build();
       // @formatter:on
      }
    });
  }
  
  class CustomerResultSetExtractor implements ResultSetExtractor<customers> {
    @Override
    public customers extractData(ResultSet rs) throws SQLException {
      rs.next();
      
      // @formatter:off
      return customers.builder()
          .customer_idPK(rs.getInt("customer_idPK"))
          .first_name(rs.getString("first_name"))
          .last_name(rs.getString("last_name"))
          .build();
      // @formatter:on
    }
  }
  
  class StoreResultSetExtractor implements ResultSetExtractor<stores> {
    @Override
    public stores extractData(ResultSet rs) throws SQLException {
      rs.next();
      
      // @formatter:off
      return stores.builder()
          .store_idPK(rs.getInt("store_idPK"))
          .address(rs.getString("address"))
          .phone(rs.getString("phone"))
          .build();
      // @formatter:on
    }
  }
  
  class MovieResultSetExtractor implements ResultSetExtractor<movies> {
    @Override
    public movies extractData(ResultSet rs) throws SQLException {
      rs.next();
      
      // @formatter:off
      return movies.builder()
          .title(rs.getString("title"))
          .build();
      // @formatter:on
    }
  }
  
  class ConcessionResultSetExtractor implements ResultSetExtractor<concessions> {
    @Override
    public concessions extractData(ResultSet rs) throws SQLException {
      rs.next();
      
      // @formatter:off
      return concessions.builder()
          .full_name(rs.getString("full_name"))
          .price(rs.getDouble("price"))
          .build();
      // @formatter:on
    }
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

} // last bracket