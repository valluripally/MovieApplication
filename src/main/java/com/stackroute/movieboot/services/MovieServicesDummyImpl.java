package com.stackroute.movieboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieAlreadyExistsException;
import com.stackroute.movieboot.exception.MovieNotFoundException;

@Service
@Qualifier("id2")
public class MovieServicesDummyImpl implements MovieService {

	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
		System.out.println("save note");
		return null;
	}

	@Override
	public List<Movie> getallMovie() {
		System.out.println("get all note");
		return null;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		System.out.println("update note");
		return null;
	}

	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		System.out.println("delete note");
		return false;
	}

	@Override
	public Movie getName(String movieTitle) {
		System.out.println("note name");
		return null;
	}

//	@Override
//	public List<Movie> getByMovieTitle(String movieTitle) {
//		System.out.println("get by title");
//		return null;
//	}

}
