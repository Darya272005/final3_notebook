package edu.exapmle.notebook.controller.impl;

import edu.exapmle.notebook.controller.Command;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.LogicProvider;
import edu.exapmle.notebook.logic.NotebookLogic;

public class UpdateNoteCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;

		String[] params = request.split("\n");
		Note newNote = extractNoteFromParams(params);

		try {
			boolean updated = logic.update(newNote);
			response = updated ? "The record was updated successfully." : "The record was not updated.";
		} catch (LogicException e) {
			// log error
			response = "The record was not updated.";
		}

		return response;
	}

	private Note extractNoteFromParams(String[] params) {
		Note newNote = new Note();

		for (String param : params) {
			String[] keyValue = param.split("=");

			if (keyValue.length == 2) {
				String key = keyValue[0];
				String value = keyValue[1];
				switch (key) {
				case "id":
					newNote.setId(Integer.parseInt(value));
					break;
				case "title":
					newNote.setTitle(value);
					break;
				case "content":
					newNote.setContent(value);
					break;
				default:
					// handle unknown key
					break;
				}
			}
		}

		return newNote;
	}
}
