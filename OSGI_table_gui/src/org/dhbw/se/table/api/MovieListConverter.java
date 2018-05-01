package org.dhbw.se.table.api;

import java.util.List;

public interface MovieListConverter {
	public String getFormatDescription();
	
	public String getConvertedContent(List<Movie> movies);
	
}
