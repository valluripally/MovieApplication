package com.stackroute.movieboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieAlreadyExistsException;
import com.stackroute.movieboot.exception.MovieNotFoundException;
import com.stackroute.movieboot.repository.MovieRepository;

@Service
@Qualifier("id1")
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		// super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
		if (!(movieRepository.existsById(movie.getMovieId()))) {
			Movie savedMovie = movieRepository.save(movie);
			return savedMovie;
		} else
			throw new MovieAlreadyExistsException("movie allready exists");
	}

	@Override
	public List<Movie> getallMovie() {
		List<Movie> list = (List<Movie>) movieRepository.findAll();
		return list;
	}

	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		boolean flag = false;
		if (movieRepository.existsById(movieId)) {
			movieRepository.deleteById(movieId);

			flag = true;
		} else
			throw new MovieNotFoundException("no id");
		return flag;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		Movie updatedMovie = movieRepository.save(movie);	
		return updatedMovie;
	}

//	@Override
//	public List<Movie> getByMovieTitle(String movieTitle) {
//		List<Movie> movieList = movieRepository.getByMovieName(movieTitle);
//		return movieList;
//	}

	@Override
	public Movie getName(String movieTitle) {
		Movie movieName = movieRepository.getByMovieTitle(movieTitle);
		return movieName;
	}

}
