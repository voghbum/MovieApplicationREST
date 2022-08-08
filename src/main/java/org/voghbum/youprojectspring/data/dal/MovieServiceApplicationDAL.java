package org.voghbum.youprojectspring.data.dal;

import com.voghbum.util.data.repository.RepositoryException;
import org.springframework.stereotype.Component;
import org.voghbum.youprojectspring.data.entity.Director;
import org.voghbum.youprojectspring.data.entity.Movie;
import org.voghbum.youprojectspring.data.repository.IDirectorRepository;
import org.voghbum.youprojectspring.data.repository.IMovieRepository;

@Component
public class MovieServiceApplicationDAL {
    private final IMovieRepository m_movieRepository;
    private final IDirectorRepository m_directorRepository;

    public MovieServiceApplicationDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository) {
        m_movieRepository = movieRepository;
        m_directorRepository = directorRepository;
    }

    public Iterable<Movie> findAllMovies() {
        try {
            return m_movieRepository.findAll();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllMovies", ex);
        }
    }

    public Iterable<Movie> findMoviesByMonthYear(int month, int year) {
        try {
            return m_movieRepository.findMoviesByMonthAndYear(month, year);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllMoviesByMonthYear", ex);
        }
    }

    public Iterable<Movie> findMoviesByYear(int year) {
        try {
            return m_movieRepository.findMoviesByYear(year);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllMoviesByYear", ex);
        }
    }

    public long countMovies() {
        try {
            return m_movieRepository.count();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.countMovies", ex);
        }
    }

    public Movie saveMovie(Movie movie) {
        try {
            return m_movieRepository.save(movie);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.saveMovie", ex);
        }
    }

    public long countDirectors() {

        try {
            return m_directorRepository.count();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.countDirector", ex);
        }
    }

    public Director saveDirector(Director director) {
        try {
            return m_directorRepository.save(director);
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.saveDirector", ex);
        }
    }

    public Iterable<Director> findAllDirectors() {
        try {
            return m_directorRepository.findAll();
        } catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllDirectors", ex);
        }
    }


}
