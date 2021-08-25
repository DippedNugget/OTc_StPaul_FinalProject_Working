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
import OTC.StPaul.Final.Project.entity.movies;

@Component
@Service
@Transactional
public class DefaultMoviesDao implements MoviesDao {

  @Autowired
  public NamedParameterJdbcTemplate jdbcTemplate;
  
  // returns a list of all movies in database (from every store)
  @Override
  public List<movies> listAllMovies() {
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM movies";
    // @formatter:on
    
    return jdbcTemplate.query(sql, new ResultSetExtractor<>() {
      @Override
      public List<movies> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
          // @formatter:off
          return List.of(movies.builder()
              .movie_id(rs.getInt("movie_id"))
              .title(rs.getString("title"))
              .director(rs.getString("director"))
              .genre(rs.getString("genre"))
              .rating(rs.getString("rating"))
              .in_stock(rs.getBoolean("in_stock"))
              .store_location(rs.getInt("store_location"))
              .build());
          // @formatter:on
        }
        return extractData(null);
      }
    });
   
  }

  // returns a single movie by movie id number
  @Override
  public List<movies> retrieveSingleMovieByMovieID(int movie_id) {
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM movies "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("movie_id", movie_id);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public movies mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        // @formatter:off
          return movies.builder()
              .movie_id(rs.getInt("movie_id"))
              .title(rs.getString("title"))
              .director(rs.getString("director"))
              .genre(rs.getString("genre"))
              .rating(rs.getString("rating"))
              .in_stock(rs.getBoolean("in_stock"))
              .store_location(rs.getInt("store_location"))
              .build();
          // @formatter:on
      }
    });
  }

  // returns a single movie by title
  @Override
  public List<movies> retrieveSingleMovieByTitle(String title) {
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM movies "
        + "WHERE title = :title";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("title", title);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public movies mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        // @formatter:off
          return movies.builder()
              .movie_id(rs.getInt("movie_id"))
              .title(rs.getString("title"))
              .director(rs.getString("director"))
              .genre(rs.getString("genre"))
              .rating(rs.getString("rating"))
              .in_stock(rs.getBoolean("in_stock"))
              .store_location(rs.getInt("store_location"))
              .build();
          // @formatter:on
      }
    });
  }

  @Override
  public void addMovie(String title, String director, String genre, String rating, Boolean in_stock,
      int store_location) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO movies ("
        + "title, director, genre, rating, in_stock, store_location"
        + ")VALUES ("
        + ":title, :director, :genre, :rating, :in_stock, :store_location"
        + ")";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    
    params.put("title", title);
    params.put("director", director);
    params.put("genre", genre);
    params.put("rating", rating);
    params.put("in_stock", in_stock);
    params.put("store_location", store_location);
    
    jdbcTemplate.update(sql, params); 
  }
  
  // deletes a movie by id number
  public void deleteMovieById(int movie_id) {   
    // @formatter:off
    String sql = ""
        + "DELETE FROM movies "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("movie_id", movie_id);
    
    jdbcTemplate.update(sql,  params);  
  }

  // updates a movie title by movie id number
  public void updateMovieTitleById(String title, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET title = :title "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("title", title);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
    
  }

  // updates a movie director by movie id number
  public void updateMovieDirectorById(String director, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET director = :director "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("director", director);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
    
  }

  // updates a movie genre by movie id number
  public void updateMovieGenreById(String genre, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET genre = :genre "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("genre", genre);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
    
  }

 // updates a movie rating by movie id number
  public void updateMovieRatingById(String rating, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET rating = :rating "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("rating", rating);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
    
  }

 // updates a movie stock by movie id number
  public void updateMovieStockById(Boolean in_stock, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET in_stock = :in_stock "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("in_stock", in_stock);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
    
  }

  // updates a movie's location by movie id number
  public void updateMovieLocationById(int store_location, int movie_id) {
 // @formatter:off
    String sql = ""
        + "UPDATE movies "
        + "SET store_location = :store_location "
        + "WHERE movie_id = :movie_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("store_location", store_location);
    params.put("movie_id", movie_id);

    jdbcTemplate.update(sql, params);
  }

} // last bracket
