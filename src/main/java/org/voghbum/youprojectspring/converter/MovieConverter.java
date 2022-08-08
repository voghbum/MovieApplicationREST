package org.voghbum.youprojectspring.converter;

import org.springframework.stereotype.Component;
import org.voghbum.youprojectspring.data.entity.Movie;
import org.voghbum.youprojectspring.dto.MovieDTO;

import java.time.format.DateTimeFormatter;

@Component
public class MovieConverter {
    private final DateTimeFormatter m_dateTimeFormatter;

    public MovieConverter(DateTimeFormatter dateTimeFormatter) {
        m_dateTimeFormatter = dateTimeFormatter;
    }

    public MovieDTO toMovieDTO(Movie movie) {
        var movieDTO = new MovieDTO();

        movieDTO.setName(movie.getName());
        movieDTO.setCost(movie.getCost());
        movieDTO.setRating(movie.getRating());
        movieDTO.setSceneTimeStr(m_dateTimeFormatter.format(movie.getSceneTime()));

        return movieDTO;
    }

    //TODO:
    public Movie toMovie(MovieDTO movieDTO) {
        throw new UnsupportedOperationException();
    }
}
