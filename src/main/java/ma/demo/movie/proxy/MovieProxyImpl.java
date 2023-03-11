package ma.demo.movie.proxy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.demo.movie.model.Movie;

@Service
public class MovieProxyImpl implements MovieProxy {
	
	ObjectMapper objectMapper = new ObjectMapper();

	public List<Movie> getMovies(){
		List<Movie> movies = new ArrayList<>();
		
		try {
			movies = objectMapper.readValue(readFile(),new TypeReference<List<Movie>>() {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movies;
	}
	
	private String readFile() {
		// Passing the path to the file as a parameter
        FileReader fr;
        String movieJson = "";
		try {
			URL resource = getClass().getClassLoader().getResource("static/movies.json");
			fr = new FileReader(resource.getFile());
		       // Declaring loop variable
	        int i;
	        // Holds true till there is nothing to read
	        while ((i = fr.read()) != -1)
	 
	            // Print all the content of a file
	        	movieJson += ((char)i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return movieJson;
	}
}
