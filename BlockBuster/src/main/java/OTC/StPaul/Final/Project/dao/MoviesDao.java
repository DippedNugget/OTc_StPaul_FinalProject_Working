package OTC.StPaul.Final.Project.dao;

import java.util.List;
import OTC.StPaul.Final.Project.entity.movies;

public interface MoviesDao {
  
  /**
   * 
   * @return
   */
  List<movies> listAllMovies();
  
  /**
   * 
   * @param movie_id
   * @return
   */
  List<movies> retrieveSingleMovieByMovieID(int movie_id);
  
  /**
   * 
   * @param title
   * @return
   */
  List<movies> retrieveSingleMovieByTitle(String title);
  
  /**
   * 
   * @param title
   * @param director
   * @param genre
   * @param rating
   * @param in_stock
   * @param store_locaction
   */
  void addMovie(String title, String director, String genre, String rating, 
      Boolean in_stock, int store_locaction);
  
  /**
   * 
   * @param movie_id
   */
  void deleteMovieById(int movie_id);
  
  /**
   * 
   * @param title
   * @param movie_id
   */
  void updateMovieTitleById(String title, int movie_id);
  
  /**
   * 
   * @param director
   * @param movie_id
   */
  void updateMovieDirectorById(String director, int movie_id);
  
  /**
   * 
   * @param genre
   * @param movie_id
   */
  void updateMovieGenreById(String genre, int movie_id);
  
  /**
   * 
   * @param rating
   * @param movie_id
   */
  void updateMovieRatingById(String rating, int movie_id);
  
  /**
   * 
   * @param in_stock
   * @param movie_id
   */
  void updateMovieStockById(Boolean in_stock, int movie_id);
  
  /**
   * 
   * @param store_location
   * @param movie_id
   */
  void updateMovieLocationById(int store_location, int movie_id);

} //last bracket