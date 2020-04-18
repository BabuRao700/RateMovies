package com.movierating.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
	private Integer movieId;
	private float rating;
}
