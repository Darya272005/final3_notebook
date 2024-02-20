package edu.exapmle.notebook.controller.impl;

import edu.exapmle.notebook.controller.Command;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.LogicProvider;
import edu.exapmle.notebook.logic.NotebookLogic;

public class AddNoteCommand implements Command {
	private final NotebookLogic logic;

	public AddNoteCommand() {
		LogicProvider logicProvider = LogicProvider.getInstance();
		logic = logicProvider.getNotebookLogic();
	}

	@Override
	public String execute(String request) {
		String response;

		String[] params = request.split("\n");
		String title = params[1].split("=")[1];
		String content = params[2].split("=")[1];

		if (title.isEmpty() || content.isEmpty()) {
			throw new RuntimeException("Title or content is null.");
		}

		Note newNote = new Note();
		newNote.setTitle(title);
		newNote.setContent(content);

		try {
			logic.add(newNote);
			response = "The record was saved successfully.";
		} catch (LogicException e) {
			response = "Something went wrong. Try again.";
		}

		return response;
	}
}
