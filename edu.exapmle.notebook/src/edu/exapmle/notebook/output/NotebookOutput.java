package edu.exapmle.notebook.output;

import edu.exapmle.notebook.entity.Note;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotebookOutput {

	public void print(String title, List<Note> notes) {
		System.out.println();
		System.out.println(title.toUpperCase());
		System.out.println();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (Note note : notes) {
			System.out.printf("%d - %s - %s - %s%n", note.getId(), note.getTitle(), note.getContent(),
					formatter.format(note.getDate()));
		}
	}
}
