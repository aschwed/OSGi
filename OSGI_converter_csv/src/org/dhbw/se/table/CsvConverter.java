package org.dhbw.se.table;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dhbw.se.table.api.Movie;
import org.dhbw.se.table.api.MovieListConverter;



public class CsvConverter implements MovieListConverter {

	@Override
	public String getFormatDescription() {
		return "CSV format";
	}

	@Override
	public String getConvertedContent(List<Movie> movies) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Year,Title,Director,Rating\n");
		for (Movie movie : movies) {
			buffer.append(movie.getYear());
			buffer.append(",");
			buffer.append(movie.getTitle());
			buffer.append(",");
			buffer.append(movie.getDirector());
			buffer.append(",");
			buffer.append(movie.getImdbRating());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	@Override
	public String toString() {
		return getFormatDescription();
	}
}
