package org.voghbum.youprojectspring.service;

import com.voghbum.util.data.repository.RepositoryException;
import com.voghbum.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;
import org.voghbum.youprojectspring.converter.MovieConverter;
import org.voghbum.youprojectspring.data.dal.MovieServiceApplicationDAL;
import org.voghbum.youprojectspring.dto.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final MovieConverter m_movieConverter;

    public MovieService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter) {

        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_movieConverter = movieConverter;
    }

    public List<MovieDTO> findAllMovies() {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findAllMovies().spliterator(), false).map(m_movieConverter::toMovieDTO).collect(Collectors.toList());
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.findAllMovies", ex.getCause());
        }
    }

    public long countMovies()
    {
        try {
            return m_movieServiceApplicationDAL.countMovies();
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.countMovies", ex.getCause());
        }

    }


    public MovieDTO saveMovie(MovieDTO movieDTO) {
        try {
            m_movieServiceApplicationDAL.saveMovie(m_movieConverter.toMovie(movieDTO));

            return movieDTO;
        } catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.saveMovie", ex.getCause());
        }
    }

    public List<MovieDTO> findMoviesByMonthYear(int month, int year) {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByMonthYear(month, year).spliterator(), false)
                    .map(m_movieConverter::toMovieDTO)
                    .collect(Collectors.toList());

        } catch (Throwable ex) {
            throw new DataServiceException("MovieApplicationService.findMoviesByMonthYear", ex.getCause());
        }
    }

    public List<MovieDTO> findMoviesByYear(int year) {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByYear(year).spliterator(), false)
                    .map(m_movieConverter::toMovieDTO)
                    .collect(Collectors.toList());

        } catch (Throwable ex) {
            throw new DataServiceException("MovieApplicationService.findMoviesByYear", ex.getCause());
        }
    }


}
