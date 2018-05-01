package org.dhbw.se.table.component;

import java.util.ArrayList;
import java.util.List;

import org.dhbw.se.table.api.MovieListConverter;
import org.dhbw.se.table.ui.TableUI;

public class TableComponent {

	private List<MovieListConverter> converters = new ArrayList<>();

	public void bindConverterService(MovieListConverter converter) {
		converters.add(converter);
	}

	public void unbindConverterService(MovieListConverter converter) {
		converters.remove(converter);
	}
	
	public void activate() {

		new Thread() {

			@Override
			public void run() {
				TableUI.startUI(converters);
			}

		}.start();

	}

}
