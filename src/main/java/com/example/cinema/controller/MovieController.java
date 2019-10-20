package com.example.cinema.controller;

import com.example.cinema.domain.Movie;
import com.example.cinema.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cinematwo/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
        Long id = movieService.createMovie(movie.getTitle(), movie.getCategory(), movie.getLength(), movie.getDescription(), movie.getRequiredAge(),null );
        movie.setId(id);
        return movie;
    }


}
