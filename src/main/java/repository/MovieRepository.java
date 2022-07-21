package repository;

import service.MovieDTO;

import java.util.List;

public interface MovieRepository {

      List<MovieDTO> getAll();

     MovieDTO  getById(String id);

      MovieDTO  save(MovieDTO movieDTO);

      void delete(String movieId);

      void update(String movieId, MovieDTO movieDTO);

      List<MovieDTO>  findAllByNameStartingWith(String startsWith);
}
