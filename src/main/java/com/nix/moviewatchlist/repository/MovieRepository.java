package com.nix.moviewatchlist.repository;

import com.nix.moviewatchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>
{
	// No need to write any code here — JPA handles it!
}

