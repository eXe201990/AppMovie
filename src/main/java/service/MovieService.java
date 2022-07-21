package service;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAll();

    MovieDTO getById(String id);

    MovieDTO create(MovieDTO movieDTO);

    void delete(String movieId);

    void update(String movieId, MovieDTO movieDTO);

    List<MovieDTO> search(String startsWith);

}
