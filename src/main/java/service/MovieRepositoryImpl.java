package service;

import repository.MovieProvider;
import repository.MovieRepository;

import java.util.List;

public class MovieRepositoryImpl  implements MovieRepository {
    @Override
    public List<MovieDTO> getAll() {
        return MovieProvider.getAll();
    }

    @Override
    public MovieDTO getById(String id) {
         return MovieProvider.getById(id);
    }

    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        return MovieProvider.save(movieDTO);
    }

    @Override
    public void delete(String movieId) {
        MovieProvider.delete(movieId);
    }

    @Override
    public void update(String movieId, MovieDTO movieDTO) {
            MovieProvider.update(movieId,movieDTO);
    }

    @Override
    public List<MovieDTO> findAllByNameStartingWith(String startsWith) {
        return MovieProvider.findAllByNameStartingWith(startsWith);
    }
}
