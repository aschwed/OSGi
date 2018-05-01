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

	static List<Movie> sampleMovies() {

		List<Movie> result = new ArrayList<>();

		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));
		result.add(new Movie(1993, "title1", "director1", 5.5));

		return result;

	}

	static Object[][] sampleMoviesAsDoubleArray() {

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

	public static void startUI(List<MovieListConverter> converters) {

		JFrame frame = new JFrame("Table Converter");
		JTable table = new JTable(sampleMoviesAsDoubleArray(),
				new String[] { "Year", "Title", "Director", "IMDB Rating" });
		JTextArea area = new JTextArea(30, 100);
		JScrollPane scroll = new JScrollPane(area);
		JComboBox<MovieListConverter> combo = new JComboBox<>(converters.toArray(new MovieListConverter[] {}));
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
