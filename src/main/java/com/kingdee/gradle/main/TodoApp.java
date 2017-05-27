package com.kingdee.gradle.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import com.kingdee.gradle.dao.TodoItemDao;
import com.kingdee.gradle.dao.impl.TodoItemDaoImpl;
import com.kingdee.gradle.domain.TodoItem;

public class TodoApp {

	public static void main(String[] args) throws IOException {
		TodoItemDao todoItemDao = new TodoItemDaoImpl();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String param = bufferedReader.readLine();
		while (!param.equals("exit")) {
			if (param.startsWith("save")) {
				String[] params = param.split(" ");
				TodoItem item = new TodoItem();
				item.setName(params[1]);
				todoItemDao.save(item);
			}
			if (param.startsWith("get")) {
				String[] params = param.split(" ");
				Boolean finished = isEmpty(params[1]) ? null : Boolean.parseBoolean(params[1]);
				List<TodoItem> list = todoItemDao.get(finished);
				for (TodoItem todoItem : list) {
					bufferedWriter.write(todoItem.toString() + "\r\n");
				}
				bufferedWriter.flush();
			}
			if (param.startsWith("fn")) {
				String[] params = param.split(" ");
				long id = Long.parseLong(params[1]);
				todoItemDao.finish(id);
			}
		}
	}
	
	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}
}
