package edu.exapmle.notebook.logic;

import edu.exapmle.notebook.logic.impl.NotebookLogicImpl;

public final class LogicProvider {
	private static final LogicProvider instance = new LogicProvider();
	private final NotebookLogic logic;

	private LogicProvider() {
		logic = new NotebookLogicImpl();
	}

	public NotebookLogic getNotebookLogic() {
		return logic;
	}

	public static LogicProvider getInstance() {
		return instance;
	}
}
