package edu.exapmle.notebook.logic;

import edu.exapmle.notebook.entity.Note;

import java.util.List;

public interface NotebookLogic {

	void add(Note note) throws LogicException;

	void add(String title, String content) throws LogicException;

	List<Note> find(String text) throws LogicException;

	List<Note> allNotes() throws LogicException;

	void clean() throws LogicException;

	void update(Note note) throws LogicException;
}
