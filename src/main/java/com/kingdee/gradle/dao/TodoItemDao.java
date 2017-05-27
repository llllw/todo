package com.kingdee.gradle.dao;

import java.util.List;

import com.kingdee.gradle.domain.TodoItem;

public interface TodoItemDao {

	void save(TodoItem todoItem);
	
	List<TodoItem> get(Boolean finished);
	
	void finish(long id);
}
