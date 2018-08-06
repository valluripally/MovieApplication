package com.stackroute.movieboot.services;

import java.util.List;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.exception.MovieAlreadyExistsException;
import com.stackroute.movieboot.exception.MovieNotFoundException;


public interface MovieService {
public Movie saveMovie(Movie movie)throws MovieAlreadyExistsException; 
public List<Movie> getallMovie();
public Movie updateMovie(Movie movie);
public boolean deleteMovie(int movieId) throws MovieNotFoundException;
public Movie getName(String movieTitle);
//public List<Movie> getByMovieTitle(String movieTitle);

}
