package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void add_movie(Movie name){
        movieRepository.saveMovie(name) ;
    }
    public void add_director(Director name){
       movieRepository.saveDirector(name);
    }
    public void add_Director_Pair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }


    public Movie findMovie(String movie) {
        return movieRepository.findMovie(movie);
    }

    public Director findDirector(String director) {
        return movieRepository.findDirector(director);
    }

    public List<String> findMoviesFromDirector(String dirctor) {
        return movieRepository.findMoviesFromDirector(dirctor);
    }

    public List<String > findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String dirctor) {
        movieRepository.deleteDirector(dirctor);
    }

    public void deleteAllDirector() {
        movieRepository.deleteAllDirector();
    }

    public String  getDirectorName(String movie) {
        return movieRepository.getDirectorName(movie);
    }
}
