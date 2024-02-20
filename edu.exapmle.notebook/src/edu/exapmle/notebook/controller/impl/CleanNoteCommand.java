package edu.exapmle.notebook.controller.impl;

import edu.exapmle.notebook.controller.Command;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.LogicProvider;
import edu.exapmle.notebook.logic.NotebookLogic;

public class CleanNoteCommand implements Command {
	private final NotebookLogic logic;

	public CleanNoteCommand() {
		LogicProvider logicProvider = LogicProvider.getInstance();
		logic = logicProvider.getNotebookLogic();
	}

	@Override
	public String execute(String request) {
		String response = null;
		try {
			logic.clean();
			response = "The file has been cleaned";
		} catch (LogicException e) {
			// log
			response = "The file was not cleaned";
		}
		return response;
	}
}
