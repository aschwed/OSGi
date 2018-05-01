package org.dhbw.se.table.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import org.dhbw.se.table.api.Movie;
import org.dhbw.se.table.api.MovieListConverter;

public class TableUI {

	JComboBox<MovieListConverter> combo;

	public TableUI() {
		super();
		combo = new JComboBox<>();
	}

	public void addConverter(MovieListConverter converter) {
		combo.addItem(converter);
	}

	public void removeConverter(MovieListConverter converter) {
		combo.removeItem(converter);
	}

	List<Movie> sampleMovies() {
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1994, "The Shawshank Redemption", "Frank Darabont", 9.2));
		result.add(new Movie(1972, "The Godfather", "Francis Ford Coppola", 9.2));
		result.add(new Movie(1974, "The Godfather: Part II", "Francis Ford Coppola", 9.0));
		result.add(new Movie(2008, "The Dark Knight", "Christopher Nolan", 9.0));
		result.add(new Movie(1957, "12 Angry Men", "Sidney Lumet", 8.9));
		result.add(new Movie(1993, "Schindler's List", "Steven Spielberg", 8.9));
		result.add(new Movie(2003, "The Lord of the Rings: The Return of the King", "Peter Jackson", 8.9));
		return result;
	}

	Object[][] sampleMoviesAsDoubleArray() {
		List<Movie> movies = sampleMovies();
		Object[][] result = new Object[movies.size()][4];
		for (int i = 0; i < movies.size(); i++) {
			result[i][0] = movies.get(i).getYear();
			result[i][1] = movies.get(i).getTitle();
			result[i][2] = movies.get(i).getDirector();
			result[i][3] = movies.get(i).getImdbRating();
		}
		return result;
	}

	public void startUI() {

		JFrame frame = new JFrame("Table Converter");
		JTable table = new JTable(sampleMoviesAsDoubleArray(),
				new String[] { "Year", "Title", "Director", "IMDB Rating" });
		JTextArea area = new JTextArea(30, 100);
		JScrollPane scroll = new JScrollPane(area);
		JButton button = new JButton("Convert");

		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(table.getTableHeader());
		frame.add(table);
		frame.add(scroll);
		frame.add(combo);
		frame.add(button);

		frame.setSize(800, 500);
		frame.setLocation(200, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText(((MovieListConverter) combo.getSelectedItem()).getConvertedContent(sampleMovies()));
			}
		});

	}

}

