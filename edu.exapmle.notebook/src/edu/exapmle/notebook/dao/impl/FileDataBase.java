package edu.exapmle.notebook.dao.impl;

import edu.exapmle.notebook.dao.DaoException;
import edu.exapmle.notebook.dao.NoteBookDao;
import edu.exapmle.notebook.entity.Note;
import edu.exapmle.notebook.util.CreateNewDate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileDataBase {
	private final File file;

	public FileDataBase(String filePath) {
		this.file = new File(filePath);
	}

	synchronized public List<Note> readFromFile() throws DaoException {
		List<Note> notes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String line;

			while ((line = reader.readLine()) != null) {
				String[] params = line.split("&");

				Note newNote = new Note();
				newNote.setId(Integer.parseInt(params[0].split("=")[1]));
				newNote.setTitle(params[1].split("=")[1]);
				newNote.setContent(params[2].split("=")[1]);
				String dateInString = params[3].split("=")[1];

				try {
					Date date = formatter.parse(dateInString);
					newNote.setDate(date);
				} catch (Exception e) {
					throw new DaoException(e);
				}

				notes.add(newNote);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}

		return notes;
	}

	synchronized public void writeToFile(Note note) throws DaoException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = "Id=" + note.getId() + "&Title=" + note.getTitle() + "&Content=" + note.getContent() + "&Date="
					+ formatter.format(note.getDate());
			writer.println(str);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public int countOfNotes() throws DaoException {
		List<Note> notes = readFromFile();
		return notes.size();
	}

	private int lastId() throws DaoException {
		return countOfNotes();
	}

	public int getId() throws DaoException {
		return lastId() + 1;
	}

	synchronized public void deleteAll() throws DaoException {
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.print("");
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	synchronized public void updateFromFile(Note note) throws DaoException {
		List<Note> tempNotes = new ArrayList<>(readFromFile());
		for (Note tempNote : tempNotes) {
			if (tempNote.getId() == note.getId()) {
				tempNote.setTitle(note.getTitle());
				tempNote.setContent(note.getContent());
				break;
			}
		}

		deleteAll();

		for (Note tempNote : tempNotes) {
			writeToFile(tempNote);
		}
	}
}
