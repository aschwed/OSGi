package org.dhbw.se.table.component;

import org.dhbw.se.table.api.MovieListConverter;
import org.dhbw.se.table.ui.TableUI;

public class TableComponent {

	private TableUI tableUI;

	public TableComponent() {
		super();
		tableUI = new TableUI();
	}

	public void bindConverterService(MovieListConverter converter) {
		tableUI.addConverter(converter);
	}

	public void unbindConverterService(MovieListConverter converter) {
		tableUI.removeConverter(converter);
	}

	public void activate() {
		tableUI.startUI();
	}

}
