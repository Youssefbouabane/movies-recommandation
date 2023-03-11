package ma.demo.movie.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.demo.movie.model.Movie;
import ma.demo.movie.proxy.MovieProxy;

@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	MovieProxy movieProxy;
	
	@Override
	public List<Movie> getRecommendations(String genre) {
		
		return movieProxy.getMovies().stream().filter((movie)->{
			return movie.getGenre().toLowerCase().equals(genre.toLowerCase());
		}).sorted(new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return (o1.getReleaseYear() < o2.getReleaseYear())? 1:-1;
			}}).toList();
		
		 
	}
	
	

}
