package edu.exapmle.notebook.main;

import edu.exapmle.notebook.controller.Controller;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();

		String request;
		String response;

		request = "ADD\ntitle=Книга\ncontent=Война и мир";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Книга2\ncontent=Мертвые души";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Книга3\ncontent=Туманность Андромеды";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Книга4\ncontent=Властелин Колец";
		response = controller.doAction(request);
		System.out.println(response);

		request = "UPDATE\nid=7\ntitle=Книга5\ncontent=Гордость и предупреждение";
		response = controller.doAction(request);
		System.out.println(response);

		request = "OUTPUT\n";
		response = controller.doAction(request);
		System.out.println(response);
	}
}
