package com.kingdee.gradle.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.kingdee.gradle.dao.TodoItemDao;
import com.kingdee.gradle.domain.TodoItem;

public class TodoItemDaoImpl implements TodoItemDao{
	
	private AtomicLong idGenerator = new AtomicLong();
	
	private ConcurrentHashMap<Long, TodoItem> repository = new ConcurrentHashMap<>();

	@Override
	public void save(TodoItem todoItem) {
		long id = idGenerator.incrementAndGet();
		todoItem.setId(id);
		repository.put(id, todoItem);
	}

	@Override
	public List<TodoItem> get(Boolean finished) {
		
		List<TodoItem> list = new ArrayList<TodoItem>();
		Collection<TodoItem> allItems = repository.values();
		if (finished == null) {
			list.addAll(allItems);
			return list;
		}
		for (TodoItem todoItem : allItems) {
			if (todoItem.isFinished() == finished) {
				list.add(todoItem);
			}
		}
		return list;
	}

	@Override
	public void finish(long id) {
		TodoItem todoItem = repository.get(id);
		if (todoItem != null) {
			todoItem.setFinished(true);
		}
	}

}
