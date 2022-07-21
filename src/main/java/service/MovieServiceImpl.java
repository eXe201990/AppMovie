package service;

import org.springframework.stereotype.Service;
import repository.HibernateMovieRespository;
import repository.MovieRepository;
import web.exceptions.NoMovieException;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Resource
    private MovieRepository movieRepository;

    private final HibernateMovieRespository hibernateMovieRepository;

    public MovieServiceImpl(  HibernateMovieRespository  hibernateMovieRepository) {
        this.hibernateMovieRepository = hibernateMovieRepository;
    }


    @Override
    public List<MovieDTO> getAll() {
        return movieRepository.getAll();
    }

    @Override
    public MovieDTO getById(String id) {
        MovieDTO movieDTO = movieRepository.getById(id);
        if(movieDTO == null) {
            throw new NoMovieException(id);
        }
        return movieDTO;
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
          return      movieRepository.save(movieDTO);
    }

    @Override
    public void delete(String movieId) {
        MovieDTO dbMovie =getById(movieId);
        if (dbMovie == null) {
            throw new RuntimeException("Movie doesn't exists!");
        }
        movieRepository.delete(movieId);
    }

    @Override
    public void update(String movieId, MovieDTO movieDTO) {
        movieRepository.update(movieId, movieDTO);
    }

    @Override
    public List<MovieDTO> search(String startsWith) {
        return movieRepository.findAllByNameStartingWith(startsWith);
    }
}
