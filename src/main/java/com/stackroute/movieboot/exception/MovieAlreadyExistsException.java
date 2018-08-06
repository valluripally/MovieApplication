package com.stackroute.movieboot.exception;

public class MovieAlreadyExistsException extends Exception {
String s;
public MovieAlreadyExistsException(String s)
{
	super(s);
}
}
