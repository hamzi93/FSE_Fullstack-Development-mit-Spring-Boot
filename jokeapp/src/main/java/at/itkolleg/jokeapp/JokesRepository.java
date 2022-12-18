package at.itkolleg.jokeapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JokesRepository extends JpaRepository<Joke,Long> {
    public List<Joke> getAllByGenre(String genre);

}
