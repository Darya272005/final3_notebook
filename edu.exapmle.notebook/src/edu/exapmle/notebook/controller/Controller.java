package edu.exapmle.notebook.controller;

public class Controller {
	private final char paramDelimiter = '\n';
	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		String[] lines = request.split(Character.toString(paramDelimiter));
		String commandName = lines[0];
		Command command = provider.getCommand(commandName);

		if (command == null) {
			return "Command not found";
		}

		String[] args = new String[lines.length - 1];
		System.arraycopy(lines, 1, args, 0, args.length);

		return command.execute(args);
	}
}
