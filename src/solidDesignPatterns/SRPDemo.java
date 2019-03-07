package solidDesignPatterns;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
 Single responsibility principle:
 
 SRP Force you to put one Responsibility into any single class - if we add more responsibilities while you end up with something that is very unmanageable.
 
 The single responsibility principle is a computer programming principle that states that every module, class, or function
 should have responsibility over a single part of the functionality provided by the software, and that responsibility should be entirely encapsulated by the class.
 All its services should be narrowly aligned with that responsibility.
 
  
You probably have heard about SOLID principles: single responsibility, open-closed, liskov substitution, interface segregation and dependency inversion. 
The first letter, S, represents Single Responsibility Principle (SRP) and its importance cannot be overstated. 
I would even argue that it is a necessary and sufficient condition for good code. 
In fact, in any code that is badly written, you can always find a class that has more than one responsibility - form1.cs or index.php containing a few thousand lines of code 
is not something that rare to come by and all of us probably have seen or done it.
 */

class Journal {
	private final List<String> entries = new ArrayList<>();

	private static int count = 0;

	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	// here we break SRP
	public void save(String filename) throws Exception {
		try (PrintStream out = new PrintStream(filename)) {
			out.println(toString());
		}
	}

	public void load(String filename) {
	}

	public void load(URL url) {
	}
}

// handles the responsibility of persisting objects
class Persistence {
	public void saveToFile(Journal journal, String filename, boolean overwrite) throws Exception {
		if (overwrite || new File(filename).exists())
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
	}

	public void load(Journal journal, String filename) {
	}

	public void load(Journal journal, URL url) {
	}
}

class SRPDemo {
	public static void main(String[] args) throws Exception {
		Journal j = new Journal();
		j.addEntry("I cried today");
		j.addEntry("I ate a bug");
		out.println(j);

		Persistence p = new Persistence();
		String filename = "c:\\temp\\journal.txt";
		p.saveToFile(j, filename, true);

		// windows!
		Runtime.getRuntime().exec("notepad.exe " + filename);
	}
}