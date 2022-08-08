package org.voghbum.youprojectspring.controller;

import org.csystem.util.Console;
import com.voghbum.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.voghbum.youprojectspring.dto.MovieDTO;
import org.voghbum.youprojectspring.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
    private final MovieService m_movieService;

    public MovieController(MovieService movieService) {
        m_movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> findAll() {
        try {
            return m_movieService.findAllMovies();
        } catch (DataServiceException ex) {

            //TODO:
            return new ArrayList<MovieDTO>();
        }
    }

    @GetMapping("/moviesbyyear")
    public List<MovieDTO> findMoviesByYear(@RequestParam("year") int year) {
        try {
            return m_movieService.findMoviesByYear(year);
        } catch(DataServiceException ex) {
            Console.writeLine("%s%n%s",ex.getCause(), ex.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/moviesbymonthyear")
    public List<MovieDTO> findMoviesByMonthYear(@RequestParam("month") int month, @RequestParam("year") int year) {
        try {
            return m_movieService.findMoviesByMonthYear(month, year);
        } catch(DataServiceException ex) {
            Console.writeLine("%s%n%s",ex.getCause(), ex.getMessage());
            return new ArrayList<>();
        }
    }

    @GetMapping("/count")
    public long count() {
        return m_movieService.countMovies();
    }
}
