package com.example.todolist.model;

import java.time.LocalDate;

public class ToDoItem {

  public enum Priority {
    HIGH,
    MEDIUM,
    LOW
  }

  private Long id;
  private String description;
  private LocalDate dueDate;
  private Priority priority;
  private String category;
  private boolean completed;

  // Constructor as specified: accepts description, dueDate, priority, and category
  public ToDoItem(String description, LocalDate dueDate, Priority priority, String category) {
    this.description = description;
    this.dueDate = dueDate;
    this.priority = priority;
    this.category = category;
    this.completed = false;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
