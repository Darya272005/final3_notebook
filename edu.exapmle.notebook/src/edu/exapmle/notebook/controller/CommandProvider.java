package edu.exapmle.notebook.controller;

import java.util.HashMap;
import java.util.Map;

import edu.exapmle.notebook.controller.impl.AddNoteCommand;
import edu.exapmle.notebook.controller.impl.UpdateNoteCommand;
import edu.exapmle.notebook.controller.impl.NoSuchCommand;
import edu.exapmle.notebook.controller.impl.OutputNoteCommand;
import edu.exapmle.notebook.controller.impl.CleanNoteCommand;
import edu.exapmle.notebook.controller.impl.FindNoteCommand;

public class CommandProvider {
	private final Map<CommandName, Command> commandRepository = new HashMap<>();

	public CommandProvider() {
		commandRepository.put(CommandName.ADD, new AddNoteCommand());
		commandRepository.put(CommandName.UPDATE, new UpdateNoteCommand());
		commandRepository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
		commandRepository.put(CommandName.OUTPUT, new OutputNoteCommand());
		commandRepository.put(CommandName.CLEAN, new CleanNoteCommand());
		commandRepository.put(CommandName.FIND, new FindNoteCommand());
	}

	public Command getCommand(String commandName) {
		CommandName enumCommandName;
		Command command;

		try {
			enumCommandName = CommandName.valueOf(commandName.toUpperCase());
			command = commandRepository.get(enumCommandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			// Запись лога или обработка ошибки
			command = commandRepository.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}
}
