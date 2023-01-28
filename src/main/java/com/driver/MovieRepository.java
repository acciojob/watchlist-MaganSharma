package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository

public class MovieRepository {
    private HashMap<String,Movie>movieMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String,List<String>>directorMovieMap;

    public MovieRepository() {
        this.movieMap=new HashMap<String, Movie>();
        this.directorMap=new HashMap<String, Director>();
        this.directorMovieMap=new HashMap<String, List<String>>();
    }


    public  void saveMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
    }

    public  void saveDirector(Director director) {
directorMap.put(director.getName(), director);
    }

    public  void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){
            List<String>currentMovie=new ArrayList<>();
            if(directorMovieMap.containsKey(director))currentMovie=directorMovieMap.get(director);
            currentMovie.add(movie);
            directorMovieMap.put(director,currentMovie);
        }
    }

    public  Movie findMovie(String movie) {
return movieMap.get(movie);
    }

    public  Director findDirector(String director) {
        return directorMap.get(director);
    }

    public  List<String> findMoviesFromDirector(String dirctor) {
        List<String>movielist=new ArrayList<>();
        if (directorMovieMap.containsKey(dirctor))
            movielist=directorMovieMap.get(dirctor);
        return movielist;
    }

    public  List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String dirctor) {
        List<String>movies=new ArrayList<>();
        if(directorMovieMap.containsKey(dirctor)){
            movies=directorMovieMap.get(dirctor);
            for (String movie: movies
                 ) {if(movieMap.containsKey(movie))
                     movieMap.remove(movie);

            }
            directorMovieMap.remove(dirctor);
        }
        if ((directorMap.containsKey(dirctor))){
            directorMap.remove(dirctor);
        }
    }

    public  void deleteAllDirector() {
        HashSet<String>movieset=new HashSet<>();
        for (String director :directorMovieMap.keySet()
             ) {
            for (String movie :directorMovieMap.get(director)
                    ) {movieset.add(movie);

            }
            
        }
        for (String movie :movieset
             ) {
            if (movieMap.containsKey(movie))
                movieMap.remove(movie);

        }
    }

    public  String getDirectorName(String movie) {
HashSet<String>movieset=new HashSet<>();
        for (String director :directorMovieMap.keySet()
             ) {
            if(directorMovieMap.get(director).contains(movie))
return director;
        }
        return "No such movie exixt";
    }
}
