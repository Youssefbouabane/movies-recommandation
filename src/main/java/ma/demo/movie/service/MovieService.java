package ma.demo.movie.service;

import java.util.List;

import ma.demo.movie.model.Movie;

public interface MovieService {

	List<Movie> getRecommendations(String genre);

}
