package org.voghbum.youprojectspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.voghbum.youprojectspring.data.entity.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
    Iterable<Movie> findMoviesByYear(int year);
    Iterable<Movie> findMoviesByMonthAndYear(int month, int year);
}
