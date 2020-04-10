package com.movierating.commentsservice;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class HttpResponse {
    private String message;
}
