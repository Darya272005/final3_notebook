package edu.exapmle.notebook.logic.impl;
import java.util.ArrayList;
import java.util.List;

import edu.exapmle.notebook.dao.DaoException;
import edu.exapmle.notebook.dao.DaoProvider;
import edu.exapmle.notebook.dao.NoteBookDao;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.logic.LogicException;
import edu.exapmle.notebook.logic.NotebookLogic;
import edu.exapmle.notebook.output.NotebookOutput;

public class NotebookLogicImpl implements NotebookLogic {
    private final NoteBookDao dao;

    public NotebookLogicImpl() {
        DaoProvider provider = DaoProvider.getInstance();
        dao = provider.getNoteBookDao();
    }

    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public void add(String title, String content) throws LogicException {
        Note n = new Note(title, content);
        add(n);
    }

    public List<Note> find(String text) throws LogicException {
        List<Note> result = new ArrayList<>();

        List<Note> myNotes;
        try {
            myNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }

        NotebookOutput output = new NotebookOutput();
        output.print("search by: " + text, result);

        return result;
    }

    private boolean isTextInNote(Note n, String text) {
        String title = n.getTitle();
        String content = n.getContent();
        return title.contains(text) || content.contains(text);
    }

    public List<Note> allNotes() throws LogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public void clean() throws LogicException {
        try {
            dao.deleteAll();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void update(Note note) throws LogicException {
        try {
            dao.update(note);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }
}
