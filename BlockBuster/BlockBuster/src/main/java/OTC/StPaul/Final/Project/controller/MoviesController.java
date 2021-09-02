package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.movies;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface MoviesController {
  
  @GetMapping("/movies")
  ResponseEntity<List<movies>> listAllMovies();
  
  @GetMapping("/movies/{movie_id}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<movies>> retrieveSingleMovieByMovieID(
      @RequestParam(required = true) int movie_id);
  
  @GetMapping("/movies/{title}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<movies>> retrieveSingleMovieByTitle(
      @RequestParam(required = true) String title);
  
  @PostMapping("/movies/addmovie")
  @ResponseStatus(code = HttpStatus.CREATED)
  void addMovie(
      @RequestParam(required = true) String title,
      @RequestParam(required = true) String director,
      @RequestParam(required = true) String genre,
      @RequestParam(required = true) String rating,
      @RequestParam(required = true) Boolean in_stock,
      @RequestParam(required = true) int store_location
      );
  
  @DeleteMapping("/deletemovie/{movie_id}")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteMovieById(
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{title}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieTitleById(
      @RequestParam(required = true) String title, 
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{director}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieDirectorById(
      @RequestParam(required = true) String director, 
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{genre}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieGenreById(
      @RequestParam(required = true) String genre, 
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{rating}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieRatingById(
      @RequestParam(required = true) String rating, 
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{in_stock}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieStockById(
      @RequestParam(required = true) Boolean in_stock, 
      @RequestParam(required = true) int movie_id);
  
  @PutMapping("/updatemovies/{store_location}")
  @ResponseStatus(code = HttpStatus.OK)
  void updateMovieLocationById(
      @RequestParam(required = true) int store_location, 
      @RequestParam(required = true) int movie_id);
  
} // last bracket
