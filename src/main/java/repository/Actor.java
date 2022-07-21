package repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Actor {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @NotEmpty(message = "Movie name must be provided!")
    private String name;


    public Actor() {

    }


    public String getId() {
        return id;
    }

    public Actor setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Actor setName(String name) {
        this.name = name;
        return this;
    }
}
