package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HibernateMovieRespository  extends JpaRepository<Movie,String> {

              // @Query("select m from Movie m where m.name like concat(?1, '%')")
               List<Movie> findAllByNameStartingWith(String name);
}
