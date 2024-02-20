package edu.exapmle.notebook.controller.impl;

import edu.exapmle.notebook.controller.Command;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.LogicProvider;
import edu.exapmle.notebook.logic.NotebookLogic;
import edu.exapmle.notebook.output.NotebookOutput;

import java.util.List;

public class OutputNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;

		try {
			List<Note> myNotes = logic.allNotes();
			NotebookOutput output = new NotebookOutput();
			output.print("all notes", myNotes);

			if (myNotes == null || myNotes.isEmpty()) {
				response = "There are no records to output.";
			} else {
				response = "The output was successful";
			}
		} catch (LogicException e) {
			throw new RuntimeException(e);
		}

		return response;
	}
}
