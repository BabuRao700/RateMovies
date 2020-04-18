package com.movierating.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_id")
	private int Id;

	@Column(name = "movie_id")
	private Integer movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "avg_rating")
	private float avgRating;

	@Column(name = "counter")
	private int noOfVotes;
}
