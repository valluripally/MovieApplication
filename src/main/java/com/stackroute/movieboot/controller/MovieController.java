package com.stackroute.movieboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieAlreadyExistsException;
import com.stackroute.movieboot.exception.MovieNotFoundException;
import com.stackroute.movieboot.services.MovieService;

@RestController
@RequestMapping("/api/v1/movieboot")
public class MovieController {
	
	
	private MovieService movieservice;

	
	@Autowired
	
	public MovieController(@Qualifier("id2")MovieService movieservice) {
		super();
		this.movieservice = movieservice;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		try {
			Movie savedmovie = movieservice.saveMovie(movie);
		return new ResponseEntity<Movie>(savedmovie, HttpStatus.CREATED);
		}
		catch(MovieAlreadyExistsException e)
		{return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);}
		
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getallMovie() {
		List<Movie> movies = movieservice.getallMovie();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);

	}
	

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<?> deleteMovies(@PathVariable int movieId) {
		try
		{
		movieservice.deleteMovie(movieId);
			return new ResponseEntity<String>("{ \"message\": \"" + "success" + "\"}", HttpStatus.OK);

		//else
			//return new ResponseEntity<String>("{ \"message\": \"" + "failure" + "\"}", HttpStatus.CONFLICT);
		}
		catch(MovieNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/movie", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
		Movie updatmovie = movieservice.updateMovie(movie);
		return new ResponseEntity<Movie>(updatmovie, HttpStatus.CREATED);
	}
//	@RequestMapping(value = "/movie", method = RequestMethod.GET, produces = { "application/json" })
//	public ResponseEntity<?> getMovieDetailByName(@RequestParam("movieTitle")String movieTitle )
//	{
//		Movie movie=movieservice.getName(movieTitle);
//		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
//	}
	
//	@RequestMapping(value = "/movie/{movieTitle}", method = RequestMethod.GET, produces = { "application/json" })
//	public ResponseEntity<?>listByName(@PathVariable String movieTitle)
//	{
//		
//		List<Movie> movieList=movieservice.getByMovieTitle(movieTitle);
//		return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
//	}
}
