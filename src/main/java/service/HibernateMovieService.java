package service;

import repository.Movie;

import java.util.List;

public interface HibernateMovieService   {
    List<Movie> getAll();

    Movie getById(String id);

    Movie create(MovieDTO movieDTO);

    void delete(String movieId);

    void update(String movieId, MovieDTO movieDTO);

    List<Movie> search(String startsWith);
}
