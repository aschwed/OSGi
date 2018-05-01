package org.dhbw.se.table;

import java.util.List;

import org.dhbw.se.table.api.Movie;
import org.dhbw.se.table.api.MovieListConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter implements MovieListConverter {

	@Override
	public String getFormatDescription() {
		return "JSON format";
	}

	@Override
	public String getConvertedContent(List<Movie> movies) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(movies);

	}

	@Override
	public String toString() {
		return getFormatDescription();
	}
}
