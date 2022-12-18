package at.itkolleg.jokeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jokes")
public class JokeRestApi {

    @Autowired
    JokesRepository jokesRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id)
    {
        Optional<Joke> optionalJoke = jokesRepository.findById(id);
        if(optionalJoke.isPresent()){
            return ResponseEntity.ok(optionalJoke.get());
        }else {
            throw new JokeNotFoundException("This joke is not in our database!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Joke>> getAllJokes(){
        return ResponseEntity.ok(jokesRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Joke> deleteJokeById(@PathVariable Long id){
        Optional<Joke> optionalJoke = jokesRepository.findById(id);
        if(optionalJoke.isPresent()){
            jokesRepository.deleteById(id);
            return ResponseEntity.ok(optionalJoke.get());
        }else {
            throw new JokeNotFoundException("This joke is not in our database!");
        }
    }

    @PostMapping
    public ResponseEntity<Joke> insertJoke(@RequestBody Joke joke){
        joke.setId(null);
        Joke jokeInserted = this.jokesRepository.save(joke);
        return ResponseEntity.ok(jokeInserted);
    }
}
