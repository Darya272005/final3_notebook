package edu.exapmle.notebook.dao;

import edu.exapmle.notebook.dao.impl.FileNoteBookDao;

public final class DaoProvider {
	private static final DaoProvider INSTANCE = new DaoProvider();
	private final NoteBookDao noteBookDao;

	private DaoProvider() {
		noteBookDao = new FileNoteBookDao();
	}

	public NoteBookDao getNoteBookDao() {
		return noteBookDao;
	}

	public static DaoProvider getInstance() {
		return INSTANCE;
	}
}