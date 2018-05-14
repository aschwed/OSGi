# OSGi Tutorial

### 1.Clone my github repository:

![Screenshot1](s01_git_clone.PNG)

![Screenshot2](s02_git_protocol.PNG)


![Screenshot3](s03_importprojects.PNG)

### 2.Set a target platform
### OSGI_table_gui->Open file OsgiTargetDefinition.target->Set as active target platform (upper right corner)
Specific OSGi bundles such as Equinox console are available now and will start together with user defined bundles.


![Screenshot4](s04_target.PNG)

### Reload the target platform

![Screenshot5](s05_reload.PNG)

### 3.Run the project
Select Run as the OSGi framework option.

![Screenshot6](s06_run_as.PNG)

Here you can see the UI containing a sample data table, a dropdown menu with available formats and a convert button. You can choose a format and convert the data.
![Screenshot7](s07_running.PNG)

### 4. Create a new bundle

Now we are going to extend functionality and add a new module to convert the data to markdown. All we need to do is to create a new project (which is also an OSGi bundle), to define dependencies and provide the bundle as a service component.

![Screenshot8](s08_new_project.PNG)

Be sure to run your plug-in with an OSGi framework (Equinox).

![Screenshot9](s09_md.PNG)

### 5. Configure the MANIFEST.md file
Select the dependencies tab, click the add button in the imported packages section, add imported packages (select org.dhbw.se.table.api)
Save!

![Screenshot10](s10_import_package.PNG)

### 6. Create new class
Next you need to create the implementation class. You don't need to write code, just copy it.:)

![Screenshot11](s01_create_class.PNG)

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






### 7. Define the service layer
Create the OSGI-INF folder in your project.
Create a component definition file and place it into the OSGI-ING folder.
![Screenshot12](s12_component_def.PNG)
New->Plug-in development->Component Definition

Choose the implementation class as well.



![Screenshot13](s13_component_class.PNG)

### 8. Declare services
To declare a service choose the service tab, click the Add button and select the MovieListConverter interface. Now the markdown converter service can be registered, and an instance of the class will be created.
![Screenshot14](s14_declare_service.PNG)

### 9. Run the application again and see what happens next

![Screenshot15](s15_result.PNG)

### 10. Now you can use the OSGi consoleand control your bundles dynamically.
Use the following commands: ss, bundle<id>, start bundle <id>, stop bundle <id>

![Screenshot1](s01_git_clone.PNG)









