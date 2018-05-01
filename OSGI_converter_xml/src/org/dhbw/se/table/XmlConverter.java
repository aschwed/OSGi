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



@XmlRootElement(name = "movies")
class MyMovieList {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "movie")
	protected List<Movie> movies;
	public List<Movie> getMovies(){
		return movies;
	}
	
	public MyMovieList(List<Movie> movies) {
		this.movies = movies;
	}

	public MyMovieList() {
		super();
	}
}

public class XmlConverter implements MovieListConverter {

	@Override
	public String getFormatDescription() {
		return "XML format";
	}

	@Override
	public String getConvertedContent(List<Movie> movies) {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(MyMovieList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(new MyMovieList(movies), sw);
			String xmlString = sw.toString();

			return xmlString;
		} catch (JAXBException e) {
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public String toString() {
		return getFormatDescription();
	}
}
