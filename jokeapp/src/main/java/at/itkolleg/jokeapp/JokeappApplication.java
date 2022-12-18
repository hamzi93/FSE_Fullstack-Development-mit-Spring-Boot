package at.itkolleg.jokeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JokeappApplication implements ApplicationRunner {

    @Autowired
    JokesRepository jokesRepository;

    public static void main(String[] args) {
        SpringApplication.run(JokeappApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jokesRepository.save(new Joke(null, "Chuck Norris pausiert Online spiele", "Chuck Norris Witze",0));
        jokesRepository.save(new Joke(null, "Chuck Norris nächster Witz hahaha", "Chuck Norris Witze",0));
        jokesRepository.save(new Joke(null, "Deine Mutter ist fett", "Deine Mutter Witze",0));
        System.out.println("Hallo App Runner");
    }
}
