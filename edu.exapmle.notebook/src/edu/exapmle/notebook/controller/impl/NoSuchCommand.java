package edu.exapmle.notebook.controller.impl;

import edu.exapmle.notebook.controller.Command;

public class NoSuchCommand implements Command {
	@Override
	public String execute(String request) {
		String response = "Request error";
		return response;
	}

}