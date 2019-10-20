package com.example.cinema;

import com.example.cinema.domain.EMovieCategory;
import com.example.cinema.domain.Movie;
import com.example.cinema.service.MarathonService;
import com.example.cinema.service.MovieService;
import com.example.cinema.service.SessionService;
import com.example.cinema.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CinemaRunner implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(CinemaRunner.class);

    private MarathonService marathonService;
    private MovieService movieService;
    private SessionService sessionService;
    private TicketService ticketService;
//wstrzyknięcie serwisów poprzez konstruktor
    public CinemaRunner(MarathonService marathonService, MovieService movieService, SessionService sessionService, TicketService ticketService) {
        this.marathonService = marathonService;
        this.movieService = movieService;
        this.sessionService = sessionService;
        this.ticketService = ticketService;
    }

    @Override
    public void run(String... args) throws Exception{
        movieServiceInvocations();

    }

    private void movieServiceInvocations(){
        Page<Movie> allMovies = movieService.getAllMovies(PageRequest.of(1,2, Sort.by("title")));
        LOG.info("1. AllMovies. TotalElements={}, TotalPages={}", allMovies.getTotalElements(), allMovies.getTotalPages());
        allMovies.get().forEach(movie -> LOG.info("   {}",,movie));

        Page<Movie> moviesByPartOfTitle = movieService.getMoviesByPartOfTitle("gry", Pageable.unpaged());
        LOG.info("2. MoviesByPartOfTitle. TotalElements={}, TotalPages={}", moviesByPartOfTitle.getTotalElements(), moviesByPartOfTitle.getTotalPages());
        moviesByPartOfTitle.get().forEach(movie -> LOG.info("   {}", movie));

        Page<Movie> comedyMovies = movieService.getMoviesInCategory(EMovieCategory.COMEDY, Pageable.unpaged());
        LOG.info("3. comedyMovies. TotalElements={}, TotalPAges={}", comedyMovies.getTotalElements(), comedyMovies.getTotalPages());
        comedyMovies.get().forEach(movie -> LOG.info("   {}", movie));

        Movie movieWithId7 = movieService.getMovie(7L).get();
        LOG.info("4. movieWithId7 - {}", movieWithId7);
        movieService.updateMovie(7L, movieWithId7.getTitle(), EMovieCategory.DRAMA, 140, movieWithId7.getDescription(), 18, "/posterGreenBook.png");

        Movie movieWithId7AfterUpdate = movieService.getMovie(7L).get();
        LOG.info("5. movieWithId7AfterUpdate - {}", movieWithId7AfterUpdate);

        Long newMovieId = movieService.createMovie("Jak wytresować smoka 3", EMovieCategory.FAMILY, 104, "Witamy w krainie wikingów i dzikich smoków...", 7, null);
        Movie newMovie = movieService.getMovie(newMovieId).get();
        LOG.info("6. newMovie - {}", newMovie);

        movieService.removeMovie(5L);


    }
}
