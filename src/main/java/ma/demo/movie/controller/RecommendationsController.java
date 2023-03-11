package ma.demo.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ma.demo.movie.model.Movie;
import ma.demo.movie.service.MovieService;

@Controller
public class RecommendationsController {

	@Autowired
	MovieService movieService;
	
	@Operation(description = "The /recommendations endpoint accept a query parameter genre that contains the user's preferred movie genre. The endpoint return a list of movies that belong to the specified genre, sorted by release year in descending order.\r\n"
			+ "\r\n"
			+ "")
	@Parameter(name="genre", description = "Genre, Exmple : Crime, Adventure, Action, Comedy, Drama")
	@GetMapping("/recommendations")
	@ResponseBody
	public ResponseEntity<?> getFoos(@RequestParam String genre) {
		
		List<Movie> movies = movieService.getRecommendations(genre);
		
        return ResponseEntity.status(HttpStatus.OK).body(movies);
	}
	
}
