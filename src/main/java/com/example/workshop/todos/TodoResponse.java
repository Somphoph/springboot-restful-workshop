package com.example.workshop.todos;

public class TodoResponse{
	private int id;
	private boolean completed;
	private String title;
	private int userId;

	public int getId(){
		return id;
	}

	public boolean isCompleted(){
		return completed;
	}

	public String getTitle(){
		return title;
	}

	public int getUserId(){
		return userId;
	}
}
