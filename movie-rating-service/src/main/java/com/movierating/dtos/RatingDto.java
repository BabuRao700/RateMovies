package com.movierating.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
	private int movieId;
	private float rating;
}
