package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.MoviesDao;
import OTC.StPaul.Final.Project.entity.movies;

@Service
public class DefaultMoviesService implements MoviesService {

  @Autowired
  private MoviesDao moviesDao;
  
  @Override
  public List<movies> listAllMovies() {
    return moviesDao.listAllMovies();
  }

  @Override
  public List<movies> retrieveSingleMovieByMovieID(int movie_id) {
    return moviesDao.retrieveSingleMovieByMovieID(movie_id);
  }

  @Override
  public List<movies> retrieveSingleMovieByTitle(String title) {
    return moviesDao.retrieveSingleMovieByTitle(title);
  }

  @Override
  public void addMovie(String title, String director, String genre, String rating, Boolean in_stock,
      int store_locaction) {
   moviesDao.addMovie(title, director, genre, rating, in_stock, store_locaction);  
  }

  @Override
  public void deleteMovieById(int movie_id) {
   moviesDao.deleteMovieById(movie_id);  
  }

  @Override
  public void updateMovieTitleById(String title, int movie_id) {
   moviesDao.updateMovieTitleById(title, movie_id);  
  }

  @Override
  public void updateMovieDirectorById(String director, int movie_id) {
    moviesDao.updateMovieDirectorById(director, movie_id);    
  }

  @Override
  public void updateMovieGenreById(String genre, int movie_id) {
    moviesDao.updateMovieGenreById(genre, movie_id); 
  }

  @Override
  public void updateMovieRatingById(String rating, int movie_id) {
    moviesDao.updateMovieRatingById(rating, movie_id);
  }

  @Override
  public void updateMovieStockById(Boolean in_stock, int movie_id) {
    moviesDao.updateMovieStockById(in_stock, movie_id);    
  }

  @Override
  public void updateMovieLocationById(int store_location, int movie_id) {
    moviesDao.updateMovieLocationById(store_location, movie_id);  
  }

} //last bracket
