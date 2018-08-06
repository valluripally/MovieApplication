package com.stackroute.movieboot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	private int movieId;
	private String movieTitle;
	private int movieRating;
	private int releaseYear;
}
