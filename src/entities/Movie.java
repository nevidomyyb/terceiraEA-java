package entities;

public class Movie {
	
	private String name;
	private String director;
	private String description;
	private String genrer;
	private String duration;
	private boolean threeDFilm;
	
	public Movie() {
		
	}
	
	public Movie (String name, String director, String description, String genrer, String duration) {
		this.name = name;
		this.director = director;
		this.description = description;
		this.genrer = genrer;
		this.duration = duration;
	}

	public String toStrign() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenrer() {
		return genrer;
	}

	public void setGenrer(String genrer) {
		this.genrer = genrer;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isThreeDFilm() {
		return threeDFilm;
	}

	public void setThreeDFilm(boolean threeDFilm) {
		this.threeDFilm = threeDFilm;
	}
	
	
	
}
