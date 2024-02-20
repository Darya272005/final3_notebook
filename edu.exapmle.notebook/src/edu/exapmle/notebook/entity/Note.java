package edu.exapmle.notebook.entity;

import edu.exapmle.notebook.util.GenerateId;

import java.util.Date;
import java.util.Objects;

public class Note {
	private int id;
	private String title;
	private String content;
	private Date date;

	public Note() {
	}

	public Note(int id, String title, String content, Date date) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Note(String title, String content, Date date) {
		this.id = GenerateId.nextId();
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Note(String title, String content) {
		this.id = GenerateId.nextId();
		this.title = title;
		this.content = content;
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Note other = (Note) obj;
		return id == other.id && Objects.equals(title, other.title) && Objects.equals(content, other.content)
				&& Objects.equals(date, other.date);
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
}
