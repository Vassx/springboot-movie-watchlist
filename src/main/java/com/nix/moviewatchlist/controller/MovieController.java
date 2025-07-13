package com.nix.moviewatchlist.controller;

import com.nix.moviewatchlist.model.Movie;
import com.nix.moviewatchlist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
	@Autowired
	private MovieRepository movieRepository;

	// Create a movie
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie)
	{
		return movieRepository.save(movie);
	}

	// Get all movies
	@GetMapping
	public List<Movie> getAllMovies()
	{
		return movieRepository.findAll();
	}

	// Get a movie by ID
	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable Long id)
	{
		return movieRepository.findById(id).orElse(null);
	}

	// Update a movie
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie)
	{
		return movieRepository.findById(id).map(movie -> {
			movie.setTitle(updatedMovie.getTitle());
			movie.setGenre(updatedMovie.getGenre());
			movie.setRating(updatedMovie.getRating());
			movie.setWatched(updatedMovie.isWatched());
			movie.setComments(updatedMovie.getComments());
			return movieRepository.save(movie);
		}).orElse(null);
	}

	// Delete a movie
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id)
	{
		movieRepository.deleteById(id);
	}
}
