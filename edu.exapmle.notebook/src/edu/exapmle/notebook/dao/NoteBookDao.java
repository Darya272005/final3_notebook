package edu.exapmle.notebook.dao;

import edu.exapmle.notebook.entity.Note;

import java.util.List;

public interface NoteBookDao {

	void save(Note note) throws DaoException;

	List<Note> allNotes() throws DaoException;

	void deleteAll() throws DaoException;

	void update(Note note) throws DaoException;

}
