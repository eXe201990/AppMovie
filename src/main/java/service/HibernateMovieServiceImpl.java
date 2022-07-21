package service;

import org.springframework.stereotype.Service;
import repository.Actor;
import repository.HibernateMovieRespository;
import repository.Movie;
import web.exceptions.EntityNotFoundException;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class HibernateMovieServiceImpl  implements  HibernateMovieService{

    private final HibernateMovieRespository hibernateMovieRespository;


    public HibernateMovieServiceImpl(HibernateMovieRespository hibernateMovieRespository) {
        this.hibernateMovieRespository = hibernateMovieRespository;
    }

    @Override
    public List<Movie> getAll() {
      return   hibernateMovieRespository.findAll();

    }

    @Override
    public Movie getById(String id) {
         return hibernateMovieRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie", id));
    }

    @Override
    public Movie create(MovieDTO movieDTO) {
        Movie movie = new Movie();
        //when creating a new entity, we don't set the id, we let it to be managed by the db  implementation
        Actor actor = new Actor().setName("Vasile");
        movie.setName(movieDTO.getName())
                .setPosterUrl(movieDTO.getPosterUrl())
                .setRating(movieDTO.getRating())
                .setActors(new HashSet<>(Collections.singleton(actor)));

        //saved movie contains id also

        Movie savedMovie = hibernateMovieRespository.save(movie);
        return  savedMovie;
    }

    @Override
    public void delete(String movieId) {
        Movie movie = getById(movieId);
        hibernateMovieRespository.delete(movie);

    }

    @Override
    public void update(String movieId, MovieDTO movieDTO) {
        Movie dbMovie = getById(movieId);

        dbMovie
                .setName(movieDTO.getName())
                .setPosterUrl(movieDTO.getPosterUrl())
                .setRating(movieDTO.getRating());

        Movie updatedMovie =  hibernateMovieRespository.save(dbMovie);
    }

    @Override
    public List<Movie> search(String startsWith) {
        List<Movie> movies =  hibernateMovieRespository.findAllByNameStartingWith(startsWith);
        return movies;
    }
}
