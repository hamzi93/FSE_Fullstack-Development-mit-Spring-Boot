package at.itkolleg.jokeapp;

public class JokeNotFoundException extends RuntimeException {
    public JokeNotFoundException(String s) {
        super(s);
    }
}
