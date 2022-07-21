package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.Movie;
import service.HibernateMovieService;
import service.MovieDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hibernate/movies")
public class HibernateMovieController {
    private final HibernateMovieService movieService;

    public HibernateMovieController(HibernateMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@NotEmpty @PathVariable String id) {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@Valid @RequestBody MovieDTO movieDTO){
        return movieService.create(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotEmpty @PathVariable("id") String movieId) {
        movieService.delete(movieId);
    }

    @PutMapping("/{id}")
    public void update(@NotEmpty @PathVariable("id") String movieId, @Valid @RequestBody MovieDTO movieDTO) {
        movieService.update(movieId, movieDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> search(
            @NotEmpty @RequestParam(value = "startsWith", required = true) String startsWith,
            @RequestParam("intParam") Integer intParam
    ) {
        return ResponseEntity.of(Optional.of(movieService.search(startsWith)));

    }

    @GetMapping("/searchWithBox")
    public ResponseEntity<List<Movie>> search(@Valid RequestParamBox searchParameters) {
        return ResponseEntity.of(Optional.of(movieService.search(searchParameters.getStartsWith())));
    }
    }

