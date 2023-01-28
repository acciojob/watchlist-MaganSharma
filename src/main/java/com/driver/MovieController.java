package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseExtractor;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_Movie")
    public ResponseEntity<String>addMovie(@RequestBody() Movie movie){
        movieService.add_movie(movie);
        return  new ResponseEntity<>("New Movie is Added",HttpStatus.CREATED);
    }
     @PostMapping("/add_director")
    public ResponseEntity<String >addDirector(@RequestBody() Director director){
        movieService.add_director(director);
        return  new ResponseEntity<>("New Director is Added",HttpStatus.CREATED);

     }
     @PostMapping("/add_movie_dirctor_pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam("name") String movie,@RequestParam("director") String director){
        movieService.add_Director_Pair(movie,director);
        return new ResponseEntity<>("New Movie Dirrector PairAdded Successsfully",HttpStatus.CREATED);
     }
     @GetMapping("/get_Movie_By_name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable String name){
        Movie movie=movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
     }
    @GetMapping("/get_Director_By_name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String name){
        Director directors=movieService.findDirector(name);
        return new ResponseEntity<>(directors,HttpStatus.CREATED);
    }
    @GetMapping("/get_Movie_By_Director_name/{name}")
    public ResponseEntity<List<String>>getMovieByDirectorName(@PathVariable String dirctor){
        List<String> movies=movieService.findMoviesFromDirector(dirctor);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get_All_Movies/{name}")
    public ResponseEntity<List<String>>findAllMovies(){
       List<String> movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
@DeleteMapping("/delete_Director_By_name")
    public ResponseEntity<String> DeleteDirectorByName(@RequestParam String dirctor){
 movieService.deleteDirector(dirctor);
 return new ResponseEntity<>(dirctor +"Remove Sucessfully",HttpStatus.CREATED);
}
    @DeleteMapping("/delete_All_Directors")
    public ResponseEntity<String> DeleteAllDirector(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("Removed All Sucessfully",HttpStatus.CREATED);
    }
    //geting director by  movie name
    @GetMapping("/get_Director_By_Movie_Name")
    public String getDirectorName(@RequestParam String movie){
        return movieService.getDirectorName(movie);
    }


}
