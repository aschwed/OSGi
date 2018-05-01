package org.dhbw.se.table.api;

public class Movie {
	private String director;
	private double imdbRating;
	private String title;
	private int year;

	public Movie() {
		super();
	}

	public Movie(int year, String title, String director, double imdbRating) {
		super();
		this.year = year;
		this.title = title;
		this.director = director;
		this.imdbRating = imdbRating;
	}

	public String getDirector() {
		return director;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
