# OSGi Tutorial

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)

### Do something

![Screenshot1](s01_git_clone.PNG)







### Sonme code

```java
package demo;

import java.util.List;

import org.dhbw.se.table.api.Movie;
import org.dhbw.se.table.api.MovieListConverter;

public class MDConverter implements MovieListConverter {

	@Override
	public String getFormatDescription() {
		return "Markdown format";
	}

	@Override
	public String getConvertedContent(List<Movie> movies) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Year | Title | Director | Rating\n");
		buffer.append("---- | ---- | -------  | ---- \n");
		for (Movie movie : movies) {
			buffer.append(movie.getYear());
			buffer.append(" | ");
			buffer.append(movie.getTitle());
			buffer.append(" | ");
			buffer.append(movie.getDirector());
			buffer.append(" | ");
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



```
