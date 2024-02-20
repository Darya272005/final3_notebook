package edu.exapmle.notebook.util;

import java.util.Calendar;
import java.util.Date;

public final class CreateNewDate {
	private CreateNewDate() {
	}

	public static Date addDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}
