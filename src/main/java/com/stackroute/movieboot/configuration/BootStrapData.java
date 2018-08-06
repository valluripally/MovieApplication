package com.stackroute.movieboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.repository.MovieRepository;

@Configuration
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {

	private MovieRepository movieRepository;
	@Autowired
	public BootStrapData(MovieRepository movieRepository) {			
		this.movieRepository = movieRepository;
		//	this.movie=movie;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie =new Movie();
		movie.setMovieId(1);
		movie.setMovieTitle("ddlj");
		movieRepository.save(movie);
		Movie testMovie = Movie.builder()
				.movieId(2)
				.movieTitle("foo")
				.build();
		movieRepository.save(testMovie);
		
		Movie testMovie2 = Movie.builder()
				.movieId(1)
				.movieTitle("data")
				.build();
		movieRepository.save(testMovie2);

	}


}
