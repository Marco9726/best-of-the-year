package org.java.demo;

import java.util.Arrays;
import java.util.List;

import org.java.demo.pojo.Movie;
import org.java.demo.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {

	@GetMapping("/")
	public String getHome() {
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		List<Movie> movies = getBestMovies();
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	
	
	@GetMapping("/movies/{id}")
	public String getMovie(Model model , @PathVariable("id") int id) {
		
		Movie movie = getMovieById(id);
		
		if (movie != null)
			model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(Model model , @PathVariable("id") int id) {
		
		Song resS = null;
		
		for(Song s : getBestSongs()) {
			
			if (s.getId() == id )
				resS = s;
			
			if (resS != null)
				model.addAttribute("titles", resS.getTitle());
		}
		
		return "titles";
	}
	
	
	private List<Movie> getBestMovies() {
		
		return Arrays.asList(new Movie[] {
				
				new Movie(1, "movie 1"),
				new Movie(2, "movie 2"),
				new Movie(3, "movie 3"),
				new Movie(4, "movie 4"),
				new Movie(5, "movie 5")
		});
	}
	
	private List<Song> getBestSongs() {
		
		return Arrays.asList(new Song[] {
				
				new Song(1, "song 1"),
				new Song(2, "Song 2"),
				new Song(3, "Song 3"),
				new Song(4, "Song 4"),
				new Song(5, "Song 5")
		});
	}
	
	private Movie getMovieById(int id) {
		
		Movie resM = null;
		
		for(Movie m : getBestMovies()) {
			
			if (m.getId() == id )
				resM = m;
		}
		
		return resM;
	}
	
	
}
