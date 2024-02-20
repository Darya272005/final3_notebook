package edu.exapmle.notebook.dao.impl;

import edu.exapmle.notebook.dao.DaoException;
import edu.exapmle.notebook.dao.NoteBookDao;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.util.CreateNewDate;

import java.util.List;

public class FileNoteBookDao implements NoteBookDao {
	private final FileDataBase myDb;

	public FileNoteBookDao() {
		myDb = new FileDataBase("myFile.txt");
	}

	@Override

	public void save(Note note) throws DaoException {
		int id = myDb.getId();
		note.setId(id);

		if (note.getDate() == null) {
			note.setDate(CreateNewDate.addDate());
		}

		myDb.writeToFile(note);
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		return myDb.readFromFile();
	}

	@Override
	public void deleteAll() throws DaoException {
		myDb.deleteAll();
	}

	@Override
	public void update(Note note) throws DaoException {
		myDb.updateFromFile(note);
	}
}
