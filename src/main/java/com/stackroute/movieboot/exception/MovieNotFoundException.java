package com.stackroute.movieboot.exception;

public class MovieNotFoundException extends Exception {
   String s;
  public MovieNotFoundException(String s)
	{
	   super(s);
	   }
}
