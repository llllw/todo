package com.kingdee.gradle.domain;

public class TodoItem {

	private long id;
	private String name;
	private boolean finished;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", name=" + name + ", finished=" + finished + "]";
	}
	
}
