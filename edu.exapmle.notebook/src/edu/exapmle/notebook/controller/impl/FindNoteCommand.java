package edu.exapmle.notebook.controller.impl;


import edu.exapmle.notebook.controller.Command;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.LogicProvider;
import edu.exapmle.notebook.logic.NotebookLogic;

public class FindNoteCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;

        // validate request
        String[] params = request.split("\n");
        String str = params[1];

        try {
            boolean found = logic.find(str);
            response = found ? "The records was found" : "No records were found";
        } catch (LogicException e) {
            // log error
            response = "Error";
        }

        return response;
    }
}

