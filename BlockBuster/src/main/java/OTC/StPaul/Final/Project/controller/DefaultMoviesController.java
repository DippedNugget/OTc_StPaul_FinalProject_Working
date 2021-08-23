package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.movies;
import OTC.StPaul.Final.Project.service.MoviesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultMoviesController implements MoviesController {
  
  @Autowired
  private MoviesService moviesService;

  @Override
  public ResponseEntity<List<movies>> listAllMovies() {
    log.info("A Request for the complete movies list was made");
    List<movies> movies = moviesService.listAllMovies();
    return new ResponseEntity<List<movies>>(movies, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<movies>> retrieveSingleMovieByMovieID(int movie_id) {
    log.info("A Request for a single movies={} information was made", movie_id);
    List<movies> singleMovie = moviesService.retrieveSingleMovieByMovieID(movie_id);
    return new ResponseEntity<List<movies>>(singleMovie, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<movies>> retrieveSingleMovieByTitle(String title) {
    log.info("A Request for a single movies={} title information was made", title);
    List<movies> singleMovieTitle = moviesService.retrieveSingleMovieByTitle(title);
    return new ResponseEntity<List<movies>>(singleMovieTitle, HttpStatus.OK);
  }

  @Override
  public void addMovie(String title, String director, String genre, String rating, Boolean in_stock,
      int store_location) {
    log.info("Added a movie");
    moviesService.addMovie(title, director, genre, rating, in_stock, store_location);  
  }

  @Override
  public void deleteMovieById(int movie_id) {
    log.info("Deleted a movie");
    moviesService.deleteMovieById(movie_id);
  }

  @Override
  public void updateMovieTitleById(String title, int movie_id) {
   log.info("Update a movies={} title", movie_id);
   moviesService.updateMovieTitleById(title, movie_id);
  }

  @Override
  public void updateMovieDirectorById(String director, int movie_id) {
    log.info("Update a movies={} director", movie_id);
    moviesService.updateMovieDirectorById(director, movie_id);
  }

  @Override
  public void updateMovieGenreById(String genre, int movie_id) {
    log.info("Update a movies={} genre", movie_id);
    moviesService.updateMovieGenreById(genre, movie_id);
  }

  @Override
  public void updateMovieRatingById(String rating, int movie_id) {
    log.info("Update a movies={} rating", movie_id);
    moviesService.updateMovieRatingById(rating, movie_id);
  }

  @Override
  public void updateMovieStockById(Boolean in_stock, int movie_id) {
    log.info("Update a movies={} stock", movie_id);
    moviesService.updateMovieStockById(in_stock, movie_id);
  }

  @Override
  public void updateMovieLocationById(int store_location, int movie_id) {
    log.info("Update a movies={} store location number", movie_id);
    moviesService.updateMovieLocationById(store_location, movie_id);
  }

} // last bracket
